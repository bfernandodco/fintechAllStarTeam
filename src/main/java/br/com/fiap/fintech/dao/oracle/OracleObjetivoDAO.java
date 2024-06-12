package br.com.fiap.fintech.dao.oracle;

import java.sql.Connection; 
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.bean.Objetivo;
import br.com.fiap.fintech.dao.ObjetivoDAO;
import br.com.fiap.fintech.exception.DatabaseException;
import br.com.fiap.fintech.singleton.ConnectionManager;

public class OracleObjetivoDAO implements ObjetivoDAO {

	private Connection connection;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	@Override
	public void cadastrarObjetivo(Objetivo objetivo) throws DatabaseException {
		String sql = "INSERT INTO T_FNT_OBJTVO ("
				+ "cd_objetivo, nr_cpf, nm_objetivo, vl_objetivo, vl_atual, dt_criacao, "
				+ "dt_conclusao, ds_objetivo) "
				+ "VALUES (SQ_TB_OBJTVO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			connection = ConnectionManager.getInstance().getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, objetivo.getNumeroDeCPF());
			pstmt.setString(2, objetivo.getNomeDoObjetivo());
			pstmt.setDouble(3, objetivo.getValorDoObjetivo());
			pstmt.setDouble(4, objetivo.getValorAtual());
			pstmt.setDate(5, Date.valueOf(objetivo.getDataDeCriacao()));
			pstmt.setDate(6, Date.valueOf(objetivo.getDataDeConclusao()));
			pstmt.setString(7, objetivo.getDescricaoDoObjetivo());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DatabaseException("Erro ao criar novo Objetivo.");
		} finally {
			try {
				connection.close();
				pstmt.close();
			} catch(SQLException e) {
				System.err.println("Erro ao fechar conexão em OracleObjetivoDAO.cadastrarObjetivo()");
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Objetivo> listarObjetivos(Long numeroDeCPF) {
		String sqlQuery = "SELECT * FROM T_FNT_OBJTVO WHERE nr_cpf = ?";
		List<Objetivo> objetivos = new ArrayList<Objetivo>();
		Objetivo objetivo;
		
		try {
			connection = ConnectionManager.getInstance().getConnection();
			pstmt = connection.prepareStatement(sqlQuery);
			pstmt.setLong(1, numeroDeCPF);		
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				objetivo = new Objetivo();
				objetivo.setCodigoDoObjetivo(rs.getInt("cd_objetivo")); 
				objetivo.setNomeDoObjetivo(rs.getString("nm_objetivo"));
				objetivo.setValorDoObjetivo(rs.getDouble("vl_objetivo"));
				objetivo.setValorAtual(rs.getDouble("vl_atual"));
				objetivo.setDataDeCriacao(rs.getDate("dt_criacao").toLocalDate());
				objetivo.setDataDeConclusao(rs.getDate("dt_conclusao").toLocalDate());
				objetivo.setDescricaoDoObjetivo(rs.getString("ds_objetivo"));
				objetivos.add(objetivo);
			}
			
			return objetivos;
		} catch(SQLException e) {
			System.err.println("Erro ao listar objetivos em OracleObjetivoDAO.listarObjetivos()");
			e.printStackTrace();
			return null;
		} finally {
			try {
				connection.close();
				pstmt.close();
				rs.close();
			} catch(SQLException e) {
				System.err.println("Erro ao fechar conexão em OracleObjetivoDAO.listarObjetivos()");
				e.printStackTrace();
			}
		}
	}

	@Override
	public void editarObjetivo(Objetivo objetivo) throws DatabaseException {
		String sqlQuery = "UPDATE T_FNT_OBJTVO SET nm_objetivo = ?, vl_objetivo = ?, "
				+ "vl_atual = ?, dt_criacao = ?, dt_conclusao = ?, ds_objetivo = ? "
				+ "WHERE cd_objetivo = ? AND nr_cpf = ?";
		
		try {
			connection = ConnectionManager.getInstance().getConnection();
			pstmt = connection.prepareStatement(sqlQuery);
			pstmt.setString(1, objetivo.getNomeDoObjetivo());
			pstmt.setDouble(2, objetivo.getValorDoObjetivo());
			pstmt.setDouble(3, objetivo.getValorAtual());
			pstmt.setDate(4, Date.valueOf(objetivo.getDataDeCriacao()));
			pstmt.setDate(5, Date.valueOf(objetivo.getDataDeConclusao()));
			pstmt.setString(6, objetivo.getDescricaoDoObjetivo());
			pstmt.setInt(7, objetivo.getCodigoDoObjetivo());
			pstmt.setLong(8, objetivo.getNumeroDeCPF());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DatabaseException("Erro ao editar o Objetivo.");
		} finally {
			try {
				connection.close();
				pstmt.close();
			} catch(SQLException e) {
				System.err.println("Erro ao fechar conexão em OracleObjetivoDAO.editarObjetivos()");
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void removerObjetivo(Integer codigoDoObjetivo) throws DatabaseException {
		String sqlQuery = "DELETE FROM T_FNT_OBJTVO WHERE cd_objetivo = ?";
		
		try {
			connection = ConnectionManager.getInstance().getConnection();
			pstmt = connection.prepareStatement(sqlQuery);
			pstmt.setInt(1, codigoDoObjetivo);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DatabaseException("Erro ao remover Objetivo.");
		} finally {
			try {
				connection.close();
				pstmt.close();
			} catch(SQLException e) {
				System.err.println("Erro ao fechar conexão em OracleObjetivoDAO.removerObjetivos()");
				e.printStackTrace();
			}
		}
	}
}
