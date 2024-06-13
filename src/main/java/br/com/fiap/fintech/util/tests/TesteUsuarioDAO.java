package br.com.fiap.fintech.util.tests;

import java.time.LocalDate;

import br.com.fiap.fintech.bean.Usuario;
import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.dao.oracle.OracleUsuarioDAO;
import br.com.fiap.fintech.exception.DatabaseException;

@SuppressWarnings("unused")
public class TesteUsuarioDAO {

	public static void main(String[] args) throws DatabaseException {
		Usuario usuario = new Usuario(16887351862L, "Harry Potter", LocalDate.now(), "Masculino", "harry@potter.com", "123456");
		UsuarioDAO usuarioDAO = new OracleUsuarioDAO();
		
		/* CADASTRAR USUARIO
		try {
			usuarioDAO.cadastrarUsuario(usuario);
			System.out.println("Usuário cadastrado com sucesso!");
		} catch (DatabaseException e) {
			e.printStackTrace();
			throw new DatabaseException("Erro ao testar cadastro do usuário");
		}
		*/
		
		/* EDITAR USUARIO
		try {
			usuarioDAO.editarUsuario(usuario);
			System.out.println("Usuário editado com sucesso!");
		} catch (DatabaseException e) {
			e.printStackTrace();
			throw new DatabaseException("Erro ao testar edição do usuário");
		}
		*/
		
		/* BUSCAR USUARIO
		usuario = usuarioDAO.buscarUsuario(usuario.getNumeroDoCPF());
		System.out.println(usuario);
		*/
		
		/*
		try {
			usuarioDAO.removerUsuario(usuario.getNumeroDoCPF());
			System.out.println("Usuário removido com sucesso!");
		} catch (DatabaseException e) {
			e.printStackTrace();
			throw new DatabaseException("Erro ao testar a remoção do usuário.");
		}
		*/
	}

}
