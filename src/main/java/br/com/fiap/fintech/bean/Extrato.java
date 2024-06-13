package br.com.fiap.fintech.bean;

public class Extrato {

	private Long numeroDoCPF;
	private Double valorDoSaldoTotal;
	private Double valorTotalDosInvestimentos;
	private Double valorDeEntradas;
	private Double valorDeSaidas;
	
	public Extrato() {
		
	}

	public Extrato(Long numeroDoCPF, Double valorDoSaldoTotal, Double valorTotalDosInvestimentos,
			Double valorDeEntradas, Double valorDeSaidas) {
		this.numeroDoCPF = numeroDoCPF;
		this.valorDoSaldoTotal = valorDoSaldoTotal;
		this.valorTotalDosInvestimentos = valorTotalDosInvestimentos;
		this.valorDeEntradas = valorDeEntradas;
		this.valorDeSaidas = valorDeSaidas;
	}

	public Long getNumeroDoCPF() {
		return numeroDoCPF;
	}

	public void setNumeroDoCPF(Long numeroDoCPF) {
		this.numeroDoCPF = numeroDoCPF;
	}

	public Double getValorDoSaldoTotal() {
		return valorDoSaldoTotal;
	}

	public void setValorDoSaldoTotal(Double valorDoSaldoTotal) {
		this.valorDoSaldoTotal = valorDoSaldoTotal;
	}

	public Double getValorTotalDosInvestimentos() {
		return valorTotalDosInvestimentos;
	}

	public void setValorTotalDoInvestimento(Double valorTotalDosInvestimentos) {
		this.valorTotalDosInvestimentos = valorTotalDosInvestimentos;
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
				+ "\nNumero do CPF: " + numeroDoCPF
				+ "\nValor Do Saldo Total: R$ " + valorDoSaldoTotal 
				+ "\nValor Total Dos Investimentos: R$ "+ valorTotalDosInvestimentos 
				+ "\nValor De Entradas: R$ " + valorDeEntradas 
				+ "\nValor De Saídas: R$ " + valorDeSaidas;
	}
}
