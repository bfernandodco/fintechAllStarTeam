package br.com.fiap.fintech.dao.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.fintech.bean.Extrato;
import br.com.fiap.fintech.dao.ExtratoDAO;
import br.com.fiap.fintech.exception.DatabaseException;
import br.com.fiap.fintech.singleton.ConnectionManager;

public class OracleExtratoDAO implements ExtratoDAO { 
	
	private Connection connection;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	@Override
	public void registrarExtratoDeNovoUsuario(Long numeroDoCPF) throws DatabaseException {
		String sqlQuery = "INSERT INTO T_FNT_EXTRTO("
				+ "nr_cpf, vl_saldo_total, vl_total_invest, vl_entradas, vl_saidas) "
				+ "VALUES(?, ?, ?, ?, ?)";
		
		try {
			connection = ConnectionManager.getInstance().getConnection();
			pstmt = connection.prepareStatement(sqlQuery);
			pstmt.setLong(1, numeroDoCPF);
			pstmt.setDouble(2, 0.0);
			pstmt.setDouble(3, 0.0);
			pstmt.setDouble(4, 0.0);
			pstmt.setDouble(5, 0.0);
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
			throw new DatabaseException("Erro ao registrar extrato de novo usuário.");
		} finally {
			try {
				connection.close();
				pstmt.close();
			} catch(SQLException e) {
				System.err.println("Erro ao fechar conexão em registrarExtratoDeNovoUsuario()");
				e.printStackTrace();
			}
		}	
	}

	@Override
	public Extrato consultarExtrato(Long numeroDeCPF) {
		String sqlQuery = "SELECT * FROM T_FNT_EXTRTO WHERE nr_cpf = ?";
		Extrato extrato = new Extrato();
		
		try {
			connection = ConnectionManager.getInstance().getConnection();
			pstmt = connection.prepareStatement(sqlQuery);
			pstmt.setLong(1, numeroDeCPF);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				extrato.setNumeroDoCPF(rs.getLong("nr_cpf"));
				extrato.setValorDoSaldoTotal(rs.getDouble("vl_saldo_total"));
				extrato.setValorTotalDoInvestimento(rs.getDouble("vl_total_invest"));
				extrato.setValorDeEntradas(rs.getDouble("vl_entradas"));
				extrato.setValorDeSaidas(rs.getDouble("vl_saidas"));
			}
			
		} catch(SQLException e) {
			System.err.println("Erro ao consultar extrato do usuário.");
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				pstmt.close();
				rs.close();
			} catch(SQLException e) {
				System.err.println("Erro ao fechar conexão em consultarExtrato()");
				e.printStackTrace();
			}
		}	
		return extrato;
	}

	@Override
	public void atualizarSaldoTotal(Double valorParaSomarAoSaldoTotal) throws DatabaseException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizarValorTotalDeInvestimentos(Double valorParaSomarAoTotalInvestido) throws DatabaseException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizarEntrada(Double valorDeEntrada) throws DatabaseException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizarSaida(Double valorDeSaída) throws DatabaseException {
		// TODO Auto-generated method stub
		
	}
}
