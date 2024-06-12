package br.com.fiap.fintech.testes;

import java.io.File;
import java.time.LocalDate;

import br.com.fiap.fintech.bean.Usuario;
import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.dao.oracle.OracleUsuarioDAO;

public class UsuarioDAOTeste {

	public static void main(String[] args) throws Exception {
		
		String caminhoImg = "C:\\Users\\andre\\OneDrive\\Área de Trabalho\\NovaImagemBanco2.jpg";
		File imagem = new File (caminhoImg);
		
		Usuario usuario = new Usuario(99999999980L, "Testes", LocalDate.of(1991, 03, 28), "Masculino", "email22@email.com", null, "11234a2");
		Usuario usuarioTesteEditado = new Usuario(33344466681L, "Novo contato", LocalDate.of(1991, 9, 10), "Feminino", "mel@email.com", null, "12X3456");
		
		UsuarioDAO dao = new OracleUsuarioDAO();
		
		/*
		System.out.println("Criando DAO de cadastro");
		dao.cadastrarNovoUsuario(usuario);
		System.out.println("Usuario Cadastrado");
		System.out.println("Criando DAO de edicao");
		dao.editarCadastroDoUsuario(usuarioTesteEditado);
		System.out.println("Edicao Concluida");
		
		System.out.println("Criando Alteracao Senha");
		dao.alterarSenhaDoUsuario("11111a", usuarioTesteEditado);
		System.out.println("Alteracao Concluida");
		
		 */
		dao.validarLogin("email22@email.com", "11234a2");
	}

}
