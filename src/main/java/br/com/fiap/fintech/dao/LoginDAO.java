package br.com.fiap.fintech.dao;

public interface LoginDAO {

	boolean validarLogin(String email, String senha) throws Exception;
	void logarComGmail();
		
}
