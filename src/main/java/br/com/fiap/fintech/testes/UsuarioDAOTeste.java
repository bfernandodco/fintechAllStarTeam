package br.com.fiap.fintech.testes;

import java.io.File;
import java.sql.Date;
import java.time.LocalDate;

import br.com.fiap.fintech.bean.Investimento;
import br.com.fiap.fintech.bean.Usuario;
import br.com.fiap.fintech.dao.InvestimentoDAO;
import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.dao.oracle.OracleUsuarioDAO;
import br.com.fiap.fintech.factory.DAOFactory;

public class UsuarioDAOTeste {

	public static void main(String[] args) throws Exception {
		
		/*
		String caminhoImg = "C:\\Users\\andre\\OneDrive\\Área de Trabalho\\NovaImagemBanco2.jpg";
		File imagem = new File (caminhoImg);
		
		String cpfValido = "41300703806";
		String cpfInvalido = "12345678900";
		
		Usuario usuario = new Usuario(cpfValido, "RenatASoares", new Date(91, 2, 28), "Masculino", "RenatASoares@email.com");
		
		//Usuario usuarioTesteEditado = new Usuario(33344466681L, "Novo contato", LocalDate.of(1991, 9, 10), "Feminino", "mel@email.com", null, "12X3456");
		
		UsuarioDAO dao = new OracleUsuarioDAO();
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
		System.out.println("CPF " + cpfValido + " é válido? " + dao.isCPFValido(cpfValido));
		System.out.println("CPF " + cpfInvalido + " é válido? " + dao.isCPFValido(cpfInvalido));
		 */
		

	        
	        
	        Long numeroDoCPF = 12345678901L;
	        Double valorDaRentabilidade = 0.05; 
	        @SuppressWarnings("deprecation")
			Date dataDeEntrada = new Date(2024, 06, 06); 
	        Date dataDeVencimento = new Date(dataDeEntrada.getTime() + (1000L * 60 * 60 * 24 * 365)); 
	        Double valorDoInvestimento = 10000.00; // R$ 10.000,00
	        String nomeDoInvestimento = "Investimento em Ações";
	        String tipoDeInvestimento = "Ações";
	        String banco = "Banco XYZ";
	        Integer statusDoInvestimento = 1; 

	     
	        Investimento investimento = new Investimento(
	                numeroDoCPF, 
	                valorDaRentabilidade, 
	                dataDeEntrada, 
	                dataDeVencimento, 
	                valorDoInvestimento, 
	                nomeDoInvestimento, 
	                tipoDeInvestimento, 
	                banco, 
	                statusDoInvestimento
	        );

	        System.out.println("Detalhes do Investimento:");
	        System.out.println("CPF: " + numeroDoCPF);
	        System.out.println("Valor da Rentabilidade: " + valorDaRentabilidade);
	        System.out.println("Data de Entrada: " + dataDeEntrada);
	        System.out.println("Data de Vencimento: " + dataDeVencimento);
	        System.out.println("Valor do Investimento: " + valorDoInvestimento);
	        System.out.println("Nome do Investimento: " + nomeDoInvestimento);
	        System.out.println("Tipo de Investimento: " + tipoDeInvestimento);
	        System.out.println("Banco: " + banco);
	        System.out.println("Status do Investimento: " + statusDoInvestimento);
	        
	        InvestimentoDAO investimentoDAO;
	        System.out.println("factory");
	        investimentoDAO = DAOFactory.getInvestimentoDAO();
	        System.out.println("enviando dao");
	        investimentoDAO.cadastrarInvestimento(investimento);
	        System.out.println("fim");
	        
	}

}
