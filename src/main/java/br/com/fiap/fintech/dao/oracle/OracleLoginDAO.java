package br.com.fiap.fintech.dao.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fiap.fintech.bean.Login;
import br.com.fiap.fintech.dao.LoginDAO;
import br.com.fiap.fintech.exception.DatabaseException;
import br.com.fiap.fintech.singleton.ConnectionManager;

public class OracleLoginDAO implements LoginDAO {

	private Connection connection;
	private PreparedStatement pstmt;
	
	@Override
	public void cadastrarLogin(Login login) throws DatabaseException {
		String sqlQuery = "INSERT INTO T_FNT_LOGIN("
				+ "nr_cpf, tx_senha) "
				+ "VALUES(?, ?)";
		
		try {
			connection = ConnectionManager.getInstance().getConnection();
			pstmt = connection.prepareStatement(sqlQuery);
			pstmt.setLong(1, login.getNumeroDoCPF());
			pstmt.setString(2, login.getSenha());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DatabaseException("Erro ao cadastrar login.");
		} finally {
			try {
				connection.close();
				pstmt.close();
			} catch (SQLException e) {
				System.err.println("Erro ao fechar conexão em cadastrarLogin()");
				e.printStackTrace();
			}
		}
		
	}
	
	@Override
	public void removerLogin(Long numeroDoCPF) throws DatabaseException {
		String sqlQuery = "DELETE FROM T_FNT_LOGIN WHERE nr_cpf = ?";
		
		try {
			connection = ConnectionManager.getInstance().getConnection();
			pstmt = connection.prepareStatement(sqlQuery);
			pstmt.setLong(1, numeroDoCPF);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DatabaseException("Erro ao remover login.");
		} finally {
			try {
				connection.close();
				pstmt.close();
			} catch (SQLException e) {
				System.err.println("Erro ao fechar conexão em removerLogin()");
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public Boolean validarLogin(String email, String senha) {
		return null;
	}

}
