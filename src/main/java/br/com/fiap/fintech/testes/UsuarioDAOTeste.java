package br.com.fiap.fintech.testes;

import java.io.File;
import java.sql.Date;
import java.time.LocalDate;

import br.com.fiap.fintech.bean.Usuario;
import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.dao.oracle.OracleUsuarioDAO;

public class UsuarioDAOTeste {

	public static void main(String[] args) throws Exception {
		
		String caminhoImg = "C:\\Users\\andre\\OneDrive\\Área de Trabalho\\NovaImagemBanco2.jpg";
		File imagem = new File (caminhoImg);
		
		Long cpfValido = 41300703806L;
		Long cpfInvalido = 12345678900L;
		
		Usuario usuario = new Usuario(cpfValido, "RenatASoares", new Date(91, 2, 28), "Masculino", "RenatASoares@email.com");
		
		//Usuario usuarioTesteEditado = new Usuario(33344466681L, "Novo contato", LocalDate.of(1991, 9, 10), "Feminino", "mel@email.com", null, "12X3456");
		
		UsuarioDAO dao = new OracleUsuarioDAO();
		/*
		dao.isCPFValido(usuario.getNumeroDoCPF());
		System.out.println("Criando DAO de cadastro");
		dao.cadastrarNovoUsuario(usuario);
		System.out.println("Usuario Cadastrado");
		System.out.println("Criando DAO de edicao");
		dao.editarCadastroDoUsuario(usuarioTesteEditado);
		System.out.println("Edicao Concluida");
		
		System.out.println("Criando Alteracao Senha");
		dao.alterarSenhaDoUsuario("11111a", usuarioTesteEditado);
		System.out.println("Alteracao Concluida");
		
		dao.validarLogin("RenatASoares@email.com", "jk5689");
		 */
		

	        System.out.println("CPF " + cpfValido + " é válido? " + dao.isCPFValido(cpfValido));
	        System.out.println("CPF " + cpfInvalido + " é válido? " + dao.isCPFValido(cpfInvalido));
	}

}
