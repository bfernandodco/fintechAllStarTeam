package br.com.fiap.fintech.util.tests;

import java.sql.Date;
import java.time.LocalDate;

import br.com.fiap.fintech.bean.Usuario;
import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.dao.oracle.OracleUsuarioDAO;
import br.com.fiap.fintech.exception.DatabaseException;

@SuppressWarnings("unused")
public class TesteUsuarioDAO {

	public static void main(String[] args) throws DatabaseException {
		Date dataDeEntrada = new Date(2024, 06, 06);
		Usuario usuario = new Usuario("31176731050", "André Soares", dataDeEntrada, "Masculino", "andre@mail.com");
		OracleUsuarioDAO dao = new OracleUsuarioDAO();
		UsuarioDAO usuarioDAO = new OracleUsuarioDAO();
		
		/*
		try {
			usuarioDAO.cadastrarUsuario(usuario);
			System.out.println("Usuário cadastrado com sucesso!");
		} catch (DatabaseException e) {
			e.printStackTrace();
			throw new DatabaseException("Erro ao testar cadastro do usuário");
		}

		
		/* EDITAR USUARIO
		try {
			usuarioDAO.editarUsuario(usuario);
			System.out.println("Usuário editado com sucesso!");
		} catch (DatabaseException e) {
			e.printStackTrace();
			throw new DatabaseException("Erro ao testar edição do usuário");
		}
		*/
		

		usuario = usuarioDAO.buscarUsuario("43841829023");
		System.out.println(usuario);
		System.out.println(usuario.getNomeCompleto());

		
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
