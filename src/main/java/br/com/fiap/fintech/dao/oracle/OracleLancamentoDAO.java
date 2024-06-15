package br.com.fiap.fintech.dao.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.bean.Lancamento;
import br.com.fiap.fintech.dao.LancamentoDAO;
import br.com.fiap.fintech.exception.DatabaseException;
import br.com.fiap.fintech.singleton.ConnectionManager;

public class OracleLancamentoDAO implements LancamentoDAO {
	
	private Connection connection;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	@Override
	public void cadastrarLancamento(Lancamento lancamento) throws DatabaseException {
		String sqlQuery = "INSERT INTO T_FNT_LANTO("
				+ "cd_lancamento, nr_cpf, dt_lancamento, vl_lancamento, tp_lancamento, ct_lancamento, ds_lancamento) "
				+ "VALUES(SQ_LANTO.NEXTVAL, ?, ?, ?, ?, ?, ?)";
		
		try {
			connection = ConnectionManager.getInstance().getConnection();
			pstmt = connection.prepareStatement(sqlQuery);
			pstmt.setLong(1, lancamento.getNumeroDoCPF());
			pstmt.setDate(2, lancamento.getDataHoraDoLancamento());
			pstmt.setDouble(3, lancamento.getValorDoLancamento());
			pstmt.setString(4, lancamento.getTipoDoLancamento());
			pstmt.setString(5, lancamento.getCategoriaDoLancamento());
			pstmt.setString(6, lancamento.getDescricaoDoLancamento());
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
			throw new DatabaseException("Erro ao cadastrar lançamento.");
		} finally {
			try {
				connection.close();
				pstmt.close();
			} catch(SQLException e) {
				System.err.println("Erro ao fechar conexão em OracleLancamentoDAO.atualizarLancamento()");
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void editarLancamento(Lancamento lancamento) throws DatabaseException {
		String sqlQuery = "UPDATE T_FNT_LANTO "
				+ "SET dt_lancamento = ?, vl_lancamento = ?, tp_lancamento = ?, "
				+ "ct_lancamento = ?, ds_lancamento = ?"
				+ "WHERE cd_lancamento = ? AND nr_cpf = ?";
		
		try {
			connection = ConnectionManager.getInstance().getConnection();
			pstmt = connection.prepareStatement(sqlQuery);
			pstmt.setDate(1, lancamento.getDataHoraDoLancamento());
			pstmt.setDouble(2, lancamento.getValorDoLancamento());
			pstmt.setString(3, lancamento.getTipoDoLancamento());
			pstmt.setString(5, lancamento.getCategoriaDoLancamento());
			pstmt.setString(6, lancamento.getDescricaoDoLancamento());
			pstmt.setInt(7, lancamento.getCodigoDoLancamento());
			pstmt.setLong(8, lancamento.getNumeroDoCPF());
			pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
			throw new DatabaseException("Erro ao atualizar lançamento.");
		} finally {
			try {
				connection.close();
				pstmt.close();
			} catch(SQLException e) {
				System.err.println("Erro ao fechar conexão em OracleLancamentoDAO.atualizarLancamento()");
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void removerLancamento(Integer codigoDoLancamento) throws DatabaseException {
		String sqlQuery = "DELETE FROM T_FNT_LANTO "
				+ "WHERE cd_lancamento = ?";

		try {
			connection = ConnectionManager.getInstance().getConnection();
			pstmt = connection.prepareStatement(sqlQuery);
			pstmt.setInt(1, codigoDoLancamento);
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
			throw new DatabaseException("Erro ao remover lançamento.");
		} finally {
			try {
				pstmt.close();
			} catch(SQLException e) {
				System.err.println("Erro ao fechar conexão em OracleLancamentoDAO.cadastrarLancamento()");
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Lancamento> listarLancamentos(Long numeroDoCPF) {
		String sqlQuery = "SELECT * FROM T_FNT_LANTO";
		List<Lancamento> lancamentos = new ArrayList<Lancamento>();	
		Lancamento lancamento;
		
		try {
			connection = ConnectionManager.getInstance().getConnection();
			pstmt = connection.prepareStatement(sqlQuery);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				lancamento = new Lancamento();
				lancamento.setCodigoDoLancamento(rs.getInt("cd_lancamento"));
				lancamento.setNumeroDoCPF(rs.getLong("nr_cpf"));
				lancamento.setDataHoraDoLancamento(rs.getDate("dt_lancamento"));
				lancamento.setValorDoLancamento(rs.getDouble("vl_lancamento"));
				lancamento.setTipoDoLancamento(rs.getString("tp_lancamento"));
				lancamento.setCategoriaDoLancamento(rs.getString("ct_lancamento"));
				lancamento.setDescricaoDoLancamento(rs.getString("ds_lancamento"));
				lancamentos.add(lancamento);
			}
			
			return lancamentos;
		} catch(SQLException e) {
			System.err.println("Erro ao listar lancamentos em OraclelancamentoDAO.listarlancamento()");
			e.printStackTrace();
			return null;
		} finally {
			try {
				pstmt.close();
				rs.close();
			} catch(SQLException e) {
				System.err.println("Erro ao fechar conexão em OraclelancamentoDAO.listarlancamento()");
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public Double saldoRecebimentos() throws DatabaseException {
		Double saldoTotal = 0.0;
		String sqlQuery = "SELECT SUM(vl_lancamento) AS saldo_total FROM t_fnt_lnto"
				+ "WHERE tp_lancamento = 'Recebimento' AND nr_cpf = 39637973800";
		System.out.println("1");
		try {
			System.out.println("1");
			connection = ConnectionManager.getInstance().getConnection();
			pstmt = connection.prepareStatement(sqlQuery);
			//pstmt.setLong(1, lancamento.getNumeroDoCPF());
			//pstmt.setLong(1, 39637973800L);
			System.out.println("1");
			rs = pstmt.executeQuery();
			System.out.println("1");
			
			if(rs.next()) {
				System.out.println("1");
				saldoTotal = rs.getDouble("saldo_total");
				System.out.println("Saldo total de recebimentos:" + saldoTotal);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			throw new DatabaseException("Erro ao buscar saldo.");
		} finally {
			try {
				pstmt.close();
				rs.close();
				connection.close();
			} catch(SQLException e) {
				System.err.println("Erro ao fechar conexão em OracleLancamentoDAO.saldoRecebimentos()");
				e.printStackTrace();
			}
		}
		return saldoTotal;
	}
	

}
