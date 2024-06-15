package br.com.fiap.fintech.dao.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.bean.Investimento;
import br.com.fiap.fintech.dao.InvestimentoDAO;
import br.com.fiap.fintech.exception.DatabaseException;
import br.com.fiap.fintech.singleton.ConnectionManager;

public class OracleInvestimentoDAO implements InvestimentoDAO {
	
	private Connection connection;
	private PreparedStatement pstmt;
	private ResultSet rs;

	@Override
	public void cadastrarInvestimento(Investimento investimento) throws DatabaseException {
		String sqlQuery = "INSERT INTO T_FNT_INVST ("
				+ "cd_investimento, nr_cpf, vl_rentabilidade, dt_entrada, dt_vencimento, "
				+ "vl_investimento, nm_investimento, tp_investimento, nm_banco, st_investimento) "
				+ "VALUES (SQ_TB_INVST.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {	
			connection = ConnectionManager.getInstance().getConnection();
			pstmt = connection.prepareStatement(sqlQuery);			
			pstmt.setLong(1, investimento.getNumeroDoCPF());
			pstmt.setDouble(2, investimento.getValorDaRentabilidade());
			pstmt.setDate(3, investimento.getDataDeEntrada());
			pstmt.setDate(4, investimento.getDataDeVencimento());
			pstmt.setDouble(5, investimento.getValorDoInvestimento());
			pstmt.setString(6, investimento.getNomeDoInvestimento());
			pstmt.setString(7, investimento.getTipoDeInvestimento());
			pstmt.setString(8, investimento.getBanco());	
			pstmt.setInt(9, investimento.getStatusDoInvestimento());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DatabaseException("Erro ao cadastrar investimento.");
		} finally {
			try {
				pstmt.close();
				connection.close();
			} catch (SQLException e) {
				System.err.println("Erro ao fechar conexão em cadastrarInvestimento()");
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void editarInvestimento(Investimento investimento) throws DatabaseException {
		String sqlQuery = "UPDATE T_FNT_INVST SET vl_rentabilidade = ?, dt_entrada = ?, "
				+ "dt_vencimento = ?, + vl_investimento = ?, nm_aplicacao = ?, tp_investimento = ?, nm_banco = ? "
				+ "WHERE cd_investimento = ? AND nr_cpf = ?";
		
		try {
			connection = ConnectionManager.getInstance().getConnection();
			pstmt = connection.prepareStatement(sqlQuery);
			pstmt.setDouble(1, investimento.getValorDaRentabilidade());
			pstmt.setDate(2, investimento.getDataDeEntrada());
			pstmt.setDate(3, investimento.getDataDeVencimento());
			pstmt.setDouble(4, investimento.getValorDoInvestimento());
			pstmt.setString(5, investimento.getNomeDoInvestimento());
			pstmt.setString(6, investimento.getTipoDeInvestimento());
			pstmt.setString(7, investimento.getBanco());
			pstmt.setInt(8, investimento.getCodigoDoInvestimento());
			pstmt.setLong(9, investimento.getNumeroDoCPF());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DatabaseException("Erro ao editar investimento.");
		} finally {
			try {
				pstmt.close();
				connection.close();
			} catch (SQLException e) {
				System.err.println("Erro ao fechar conexão em editarInvestimento()");
				e.printStackTrace();
			}
		}
	}

	@Override
	public void removerInvestimento(Integer codigoDoInvestimento) throws DatabaseException {
		String sqlQuery = "DELETE FROM T_FNT_INVST "
				+ "WHERE cd_investimento = ?";
		
		try {
			connection = ConnectionManager.getInstance().getConnection();
			pstmt = connection.prepareStatement(sqlQuery);
			pstmt.setInt(1, codigoDoInvestimento);
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
			throw new DatabaseException("Erro ao remover investimento.");
		} finally {
			try {
				pstmt.close();
				connection.close();
			} catch(SQLException e) {
				System.err.println("Erro ao fechar conexão em removerInvestimento()");
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public List<Investimento> listarInvestimentos(Long numeroDoCPF) {
		String sqlQuery = "SELECT * FROM T_FNT_INVST WHERE nr_cpf = ?";
		List<Investimento> investimentos = new ArrayList<Investimento>();
		Investimento investimento;
		
		try {
			connection = ConnectionManager.getInstance().getConnection();
			pstmt = connection.prepareStatement(sqlQuery);
			pstmt.setLong(1, numeroDoCPF);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				investimento = new Investimento();
				investimento.setCodigoDoInvestimento(rs.getInt("cd_investimento"));
				investimento.setValorDaRentabilidade(rs.getDouble("vl_rentabilidade"));
				investimento.setDataDeEntrada(rs.getDate("dt_entrada"));
				investimento.setDataDeVencimento(rs.getDate("dt_vencimento"));
				investimento.setValorDoInvestimento(rs.getDouble("vl_investimento"));
				investimento.setNomeDoInvestimento(rs.getString("nm_aplicacao"));
				investimentos.add(investimento);
			}
			
			return investimentos;
		} catch(SQLException e) {
			System.err.println("Erro ao listar investimentos.");
			e.printStackTrace();
			return null;
		} finally {
			try {
				connection.close();
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				System.err.println("Erro ao fechar conexão em listarInvestimentos()");
				e.printStackTrace();
			}
		}
	}
}