package br.com.fiap.fintech.bean;

public class Login {

	private Long numeroDoCPF;
	private String senha;
	
	public Login() {
		
	}

	public Login(Long numeroDoCPF, String senha) {
		this.numeroDoCPF = numeroDoCPF;
		this.senha = senha;
	}

	public Long getNumeroDoCPF() {
		return numeroDoCPF;
	}

	public void setNumeroDoCPF(Long numeroDoCPF) {
		this.numeroDoCPF = numeroDoCPF;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "\nLogin "
				+ "\nNumero Do CPF: " + numeroDoCPF 
				+ "\nSenha: " + senha;
	}
}
