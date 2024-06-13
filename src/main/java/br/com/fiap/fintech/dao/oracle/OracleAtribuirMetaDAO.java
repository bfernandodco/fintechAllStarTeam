package br.com.fiap.fintech.dao.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fiap.fintech.dao.AtribuirMetaDAO;
import br.com.fiap.fintech.exception.DatabaseException;
import br.com.fiap.fintech.singleton.ConnectionManager;

public class OracleAtribuirMetaDAO implements AtribuirMetaDAO{

	private Connection connection;
	private PreparedStatement pstmt;
	
	@Override
	public void atribuirMetaAoObjetivoPorLancamento(Integer codigoDoObjetivo, Integer codigoDoLancamento)
			throws DatabaseException {
		String sqlQuery = "INSERT INTO T_META_OBJ("
				+ "cd_objetivo, cd_lancamento)"
				+ "VALUES(?, ?)";
		
		try {
			connection = ConnectionManager.getInstance().getConnection();
			pstmt = connection.prepareStatement(sqlQuery);
			pstmt.setInt(1, codigoDoObjetivo);
			pstmt.setInt(2, codigoDoLancamento);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DatabaseException("Erro ao atribuir meta a lançamento.");
		} finally {
			try {
				connection.close();
				pstmt.close();
			} catch(SQLException e) {
				System.err.println("Erro ao fechar conexão em atribuirMetaAoObjetivoPorLancamento()");
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void atribuirMetaAoObjetivoPorInvestimento(Integer codigoDoObjetivo, Integer codigoDoInvestimento)
			throws DatabaseException {
		String sqlQuery = "INSERT INTO T_META_OBJ("
				+ "cd_objetivo, cd_investimento)"
				+ "VALUES(?, ?)";
		
		try {
			connection = ConnectionManager.getInstance().getConnection();
			pstmt = connection.prepareStatement(sqlQuery);
			pstmt.setInt(1, codigoDoObjetivo);
			pstmt.setInt(2, codigoDoInvestimento);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DatabaseException("Erro ao atribuir meta a investimento.");
		} finally {
			try {
				connection.close();
				pstmt.close();
			} catch(SQLException e) {
				System.err.println("Erro ao fechar conexão em atribuirMetaAoObjetivoPorInvestimento()");
				e.printStackTrace();
			}
		}
	}
}
