package br.com.fiap.fintech.bean;

public class Extrato {

	private String numeroDoCPF;
	private Double valorDoSaldoTotal;
	private Double valorTotalDoInvestimento;
	private Double valorDeEntradas;
	private Double valorDeSaidas;
	
	public Extrato() {
		
	}

	public Extrato(String numeroDoCPF, Double valorDoSaldoTotal, Double valorTotalDoInvestimento,
			Double valorDeEntradas, Double valorDeSaidas) {
		this.numeroDoCPF = numeroDoCPF;
		this.valorDoSaldoTotal = valorDoSaldoTotal;
		this.valorTotalDoInvestimento = valorTotalDoInvestimento;
		this.valorDeEntradas = valorDeEntradas;
		this.valorDeSaidas = valorDeSaidas;
	}

	public String getNumeroDoCPF() {
		return numeroDoCPF;
	}

	public void setNumeroDoCPF(String numeroDoCPF) {
		this.numeroDoCPF = numeroDoCPF;
	}

	public Double getValorDoSaldoTotal() {
		return valorDoSaldoTotal;
	}

	public void setValorDoSaldoTotal(Double valorDoSaldoTotal) {
		this.valorDoSaldoTotal = valorDoSaldoTotal;
	}

	public Double getValorTotalDoInvestimento() {
		return valorTotalDoInvestimento;
	}

	public void setValorTotalDoInvestimento(Double valorTotalDoInvestimento) {
		this.valorTotalDoInvestimento = valorTotalDoInvestimento;
	}

	public Double getValorDeEntradas() {
		return valorDeEntradas;
	}

	public void setValorDeEntradas(Double valorDeEntradas) {
		this.valorDeEntradas = valorDeEntradas;
	}

	public Double getValorDeSaidas() {
		return valorDeSaidas;
	}

	public void setValorDeSaidas(Double valorDeSaidas) {
		this.valorDeSaidas = valorDeSaidas;
	}

	@Override
	public String toString() {
		return "\nExtrato "
				+ "nNumero do CPF: " + numeroDoCPF
				+ "\nValor Do Saldo Total: R$ " + valorDoSaldoTotal 
				+ "\nValor Total Dos Investimentos: R$ "+ valorTotalDoInvestimento 
				+ "\nValor De Entradas: R$ " + valorDeEntradas 
				+ "\nValor De Saídas: R$ " + valorDeSaidas;
	}
}
