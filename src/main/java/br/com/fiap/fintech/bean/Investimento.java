package br.com.fiap.fintech.bean;

import java.time.LocalDate;
import java.util.List;

public class Investimento {

	private Integer codigoDoInvestimento;
	private Long numeroDoCPF;
	private Double valorDaRentabilidade;
	private LocalDate dataDeEntrada;
	private LocalDate dataDeVencimento;
	private Double valorDosInvestimentos;
	private String nomeDoInvestimento;
	private TipoDeInvestimento tipoDeInvestimento;
	private Banco banco;
	private Integer statusDoInvestimento;
	private List<Investimento> investimentos;

	public Investimento() {

	}

	public Investimento(Integer codigoDoInvestimento, Long numeroDoCPF, Double valorDaRentabilidade,
			LocalDate dataDeEntrada, LocalDate dataDeVencimento, Double valorDoInvestimento,
			String nomeDoInvestimento, TipoDeInvestimento tipoDeInvestimento, Banco banco,
			Integer statusDoInvestimento) {
		this.codigoDoInvestimento = codigoDoInvestimento;
		this.numeroDoCPF = numeroDoCPF;
		this.valorDaRentabilidade = valorDaRentabilidade;
		this.dataDeEntrada = dataDeEntrada;
		this.dataDeVencimento = dataDeVencimento;
		this.valorDosInvestimentos = valorDoInvestimento;
		this.nomeDoInvestimento = nomeDoInvestimento;
		this.tipoDeInvestimento = tipoDeInvestimento;
		this.banco = banco;
		this.statusDoInvestimento = statusDoInvestimento;
	}

	public Integer getCodigoDoInvestimento() {
		return codigoDoInvestimento;
	}

	public void setCodigoDoInvestimento(Integer codigoDoInvestimento) {
		this.codigoDoInvestimento = codigoDoInvestimento;
	}

	public Long getNumeroDoCPF() {
		return numeroDoCPF;
	}

	public void setNumeroDoCPF(Long numeroDoCPF) {
		this.numeroDoCPF = numeroDoCPF;
	}

	public Double getValorDaRentabilidade() {
		return valorDaRentabilidade;
	}

	public void setValorDaRentabilidade(Double valorDaRentabilidade) {
		this.valorDaRentabilidade = valorDaRentabilidade;
	}

	public LocalDate getDataDeEntrada() {
		return dataDeEntrada;
	}

	public void setDataDeEntrada(LocalDate dataDeEntrada) {
		this.dataDeEntrada = dataDeEntrada;
	}

	public LocalDate getDataDeVencimento() {
		return dataDeVencimento;
	}

	public void setDataDeVencimento(LocalDate dataDeVencimento) {
		this.dataDeVencimento = dataDeVencimento;
	}

	public Double getValorDoInvestimento() {
		return valorDosInvestimentos;
	}

	public void setValorDoInvestimento(Double valorDoInvestimento) {
		this.valorDosInvestimentos = valorDoInvestimento;
	}

	public String getNomeDoInvestimento() {
		return nomeDoInvestimento;
	}

	public void setNomeDoInvestimento(String nomeDoInvestimento) {
		this.nomeDoInvestimento = nomeDoInvestimento;
	}

	public TipoDeInvestimento getTipoDeInvestimento() {
		return tipoDeInvestimento;
	}

	public void setTipoDeInvestimento(TipoDeInvestimento tipoDeInvestimento) {
		this.tipoDeInvestimento = tipoDeInvestimento;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public Integer getStatusDoInvestimento() {
		return statusDoInvestimento;
	}

	public void setStatusDoInvestimento(Integer statusDoInvestimento) {
		this.statusDoInvestimento = statusDoInvestimento;
	}

	public List<Investimento> getInvestimentos() {
		return investimentos;
	}

	public void setInvestimentos(List<Investimento> investimentos) {
		this.investimentos = investimentos;
	}

	@Override
	public String toString() {
		return "\nInvestimento "
				+ "\nCodigo Do Investimento=" + codigoDoInvestimento 
				+ "\nNumero Do CPF: " + numeroDoCPF
				+ "\nValor Da Rentabilidade: R$ " + valorDaRentabilidade 
				+ "\nData De Entrada: " + dataDeEntrada.getDayOfMonth() + "/" + dataDeEntrada.getMonthValue() + "/" + dataDeEntrada.getYear()
				+ "\nData De Vencimento: " + dataDeVencimento.getDayOfMonth() + "/" + dataDeVencimento.getMonthValue() + "/" + dataDeVencimento.getYear()
				+ "\nValor De Investimento: R$ " + valorDosInvestimentos
				+ "\nNome Do Investimento: " + nomeDoInvestimento 
				+ "\nTipo De Investimento: " + tipoDeInvestimento
				+ "\nBanco: " + banco 
				+ "\nStatus Do Investimento: " + statusDoInvestimento;
	}
}
