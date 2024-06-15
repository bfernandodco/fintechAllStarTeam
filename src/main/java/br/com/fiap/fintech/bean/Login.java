package br.com.fiap.fintech.bean;

import br.com.fiap.fintech.util.criptography.CriptografiaUtils;

public class Login {

	private String numeroDoCpf;
	private String senha;
	
	public Login() {
		
	}

	public Login(String numeroDoCpf, String senha) {
		this.numeroDoCpf = numeroDoCpf;
		this.senha = senha;
	}

	public String getNumeroDoCPF() {
		return numeroDoCpf;
	}

	public void setNumeroDoCPF(String numeroDoCPF) {
		this.numeroDoCpf = numeroDoCPF;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		try {
			this.senha = CriptografiaUtils.criptografar(senha);
		} catch (Exception e) {
			System.err.println("Erro ao criptografar senha.");
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "\nLogin "
				+ "\nNumero Do CPF: " + numeroDoCpf 
				+ "\nSenha: " + senha;
	}
}
