package br.com.fiap.fintech.util.tests;

import br.com.fiap.fintech.bean.Extrato;
import br.com.fiap.fintech.dao.ExtratoDAO;
import br.com.fiap.fintech.dao.oracle.OracleExtratoDAO;
import br.com.fiap.fintech.exception.DatabaseException;

@SuppressWarnings("unused")
public class TesteExtratoDAO {

	public static void main(String[] args) throws DatabaseException {
		ExtratoDAO extratoDAO = new OracleExtratoDAO();
		Extrato extrato = new Extrato();
		
		/*
		try {
			extratoDAO.registrarExtratoDeNovoUsuario(16887351862L);
			System.out.println("Extrato criado com sucesso!");
		} catch (DatabaseException e) {
			e.printStackTrace();
			throw new DatabaseException("Erro ao criar extrato para novo usuário");
		}
		*/
		
		/*
		extrato = extratoDAO.consultarExtrato(16887351862L);
		System.out.println(extrato);
		*/
	}
}
