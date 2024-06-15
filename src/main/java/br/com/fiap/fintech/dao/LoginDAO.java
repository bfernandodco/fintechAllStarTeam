package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.bean.Login;
import br.com.fiap.fintech.exception.DatabaseException;

public interface LoginDAO {

	void cadastrarLogin(Login login) throws DatabaseException;
	void removerLogin(String numeroDoCPF) throws DatabaseException;
	Boolean validarLogin(Login login);

}
