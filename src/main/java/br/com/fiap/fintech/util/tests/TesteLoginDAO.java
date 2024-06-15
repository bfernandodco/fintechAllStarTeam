package br.com.fiap.fintech.util.tests;

import br.com.fiap.fintech.bean.Login;
import br.com.fiap.fintech.dao.LoginDAO;
import br.com.fiap.fintech.dao.oracle.OracleLoginDAO;
import br.com.fiap.fintech.exception.DatabaseException;

@SuppressWarnings("unused")
public class TesteLoginDAO {

	public static void main(String[] args) throws DatabaseException {
		
		Login login = new Login("16887351862", "123456");
		LoginDAO loginDAO = new OracleLoginDAO();
		
		/* CADASTRAR LOGIN
		try {
			loginDAO.cadastrarLogin(login);
			System.out.println("Login cadastrado com sucesso!");
		} catch (DatabaseException e) {
			e.printStackTrace();
			throw new DatabaseException("Erro ao testar cadastramento de login");
		}
		*/
		
		/* REMOVER LOGIN
		try {
			loginDAO.removerLogin(login.getNumeroDoCPF());
			System.out.println("Login removido com sucesso!");
		} catch(DatabaseException e) {
			System.err.println("Erro ao testar remoção de login.");
		}
		*/
		
	}
}
