package br.com.fiap.fintech.util.tests;

import br.com.fiap.fintech.dao.LancamentoDAO;
import br.com.fiap.fintech.exception.DatabaseException;
import br.com.fiap.fintech.factory.DAOFactory;

public class TesteLancamentoDAO {

	public static void main(String[] args) throws DatabaseException {
		
		LancamentoDAO lancDAO;
		lancDAO = DAOFactory.getLancamentoDAO();
		
		System.out.println(lancDAO.saldoRecebimentos());
	}
}
