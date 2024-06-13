package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.bean.Usuario;
import br.com.fiap.fintech.exception.DatabaseException;

public interface UsuarioDAO {

	void cadastrarUsuario(Usuario usuario) throws DatabaseException;
	void editarUsuario(Usuario usuario) throws DatabaseException;
	Usuario buscarUsuario(Long numeroDoCPF);
	void removerUsuario(Long numeroDoCPF) throws DatabaseException;
	void alterarSenhaDoUsuario(String novaSenha, Usuario usuario) throws DatabaseException;
	boolean isSenhaValida(String senhaParaValidacao);
	void validarLogin(String email, String senha);
	
}
