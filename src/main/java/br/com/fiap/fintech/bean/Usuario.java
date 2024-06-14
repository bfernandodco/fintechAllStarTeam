package br.com.fiap.fintech.bean;

import java.io.File;
import java.sql.Date;

import br.com.fiap.fintech.util.criptography.CriptografiaUtils;

public class Usuario {

	private Long numeroDoCPF;
	private String nomeCompleto;
	private Date dataDeNascimento;
	private String genero;
	private String email;
	private File fotoDoPerfil;
	private String senha;
	
	public Usuario() {
		
	}

	public Usuario(Long numeroDoCPF, String nomeCompleto, Date dataDeNascimento, String genero, 
			String email) {
		this.numeroDoCPF = numeroDoCPF;
		this.nomeCompleto = nomeCompleto;
		this.dataDeNascimento = dataDeNascimento;
		this.genero = genero;
		this.email = email;
	}

	public Long getNumeroDoCPF() {
		return numeroDoCPF;
	}

	public void setNumeroDoCPF(Long numeroDoCPF) {
		this.numeroDoCPF = numeroDoCPF;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public File getFotoDoPerfil() {
		return fotoDoPerfil;
	}

	public void setFotoDoPerfil(File FotoDoPerfil) {
		this.fotoDoPerfil = FotoDoPerfil;
	}

	public String getSenha() {
		return senha;
	}

	public Boolean isSenhaValida(String senha) {
		Boolean senhaValida = false;
		String regex = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$";
	    if (senha != null && senha.matches(regex)) {
	    	try { 
				this.senha = CriptografiaUtils.criptografar(senha);
				senhaValida = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
	    return senhaValida;
	}

	@Override
	public String toString() {
		return "\nUsuario"
				+ "\nNumero Do CPF: " + numeroDoCPF 
				+ "\nNome Completo: " + nomeCompleto 
				+ "\nData De Nascimento: "+ dataDeNascimento 
				+ "\nGenero: " + genero 
				+ "\nEmail: " + email;
	}
}
