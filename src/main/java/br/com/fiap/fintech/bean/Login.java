package br.com.fiap.fintech.bean;

import br.com.fiap.fintech.util.criptography.CriptografiaUtils;

public class Login {

	private Long numeroDoCpf;
	private String senha;
	
	public Login() {
		
	}

	public Login(Long numeroDoCpf, String senha) {
		this.numeroDoCpf = numeroDoCpf;
		this.senha = senha;
	}

	public Long getNumeroDoCPF() {
		return numeroDoCpf;
	}

	public void setNumeroDoCPF(Long numeroDoCPF) {
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
