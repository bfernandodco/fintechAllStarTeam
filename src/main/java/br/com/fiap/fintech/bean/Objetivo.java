package br.com.fiap.fintech.bean;

import java.time.LocalDate;
import java.util.List;

public class Objetivo {

	private Integer codigoDoObjetivo;
	private Long numeroDoCPF;
	private String nomeDoObjetivo;
	private Double valorDoObjetivo;
	private Double valorAtual;
	private LocalDate dataDeCriacao;
	private LocalDate dataDeConclusao;
	private String descricaoDoObjetivo;
	private List<Objetivo> objetivos;
	
	public Objetivo() {

	}

	public Objetivo(Integer codigoDoObjetivo, Long numeroDoCPF, String nomeDoObjetivo, Double valorDoObjetivo,
			Double valorAtual, LocalDate dataDeCriacao, LocalDate dataDeConclusao, String descricaoDoObjetivo,
			List<Objetivo> objetivos) {
		this.codigoDoObjetivo = codigoDoObjetivo;
		this.numeroDoCPF = numeroDoCPF;
		this.nomeDoObjetivo = nomeDoObjetivo;
		this.valorDoObjetivo = valorDoObjetivo;
		this.valorAtual = valorAtual;
		this.dataDeCriacao = dataDeCriacao;
		this.dataDeConclusao = dataDeConclusao;
		this.descricaoDoObjetivo = descricaoDoObjetivo;
		this.objetivos = objetivos;
	}

	public Integer getCodigoDoObjetivo() {
		return codigoDoObjetivo;
	}

	public void setCodigoDoObjetivo(Integer codigoDoObjetivo) {
		this.codigoDoObjetivo = codigoDoObjetivo;
	}

	public Long getNumeroDoCPF() {
		return numeroDoCPF;
	}

	public void setNumeroDoCPF(Long numeroDoCPF) {
		this.numeroDoCPF = numeroDoCPF;
	}

	public String getNomeDoObjetivo() {
		return nomeDoObjetivo;
	}

	public void setNomeDoObjetivo(String nomeDoObjetivo) {
		this.nomeDoObjetivo = nomeDoObjetivo;
	}

	public Double getValorDoObjetivo() {
		return valorDoObjetivo;
	}

	public void setValorDoObjetivo(Double valorDoObjetivo) {
		this.valorDoObjetivo = valorDoObjetivo;
	}

	public Double getValorAtual() {
		return valorAtual;
	}

	public void setValorAtual(Double valorAtual) {
		this.valorAtual = valorAtual;
	}

	public LocalDate getDataDeCriacao() {
		return dataDeCriacao;
	}

	public void setDataDeCriacao(LocalDate dataDeCriacao) {
		this.dataDeCriacao = dataDeCriacao;
	}

	public LocalDate getDataDeConclusao() {
		return dataDeConclusao;
	}

	public void setDataDeConclusao(LocalDate dataDeConclusao) {
		this.dataDeConclusao = dataDeConclusao;
	}

	public String getDescricaoDoObjetivo() {
		return descricaoDoObjetivo;
	}

	public void setDescricaoDoObjetivo(String descricaoDoObjetivo) {
		this.descricaoDoObjetivo = descricaoDoObjetivo;
	}

	public List<Objetivo> getObjetivos() {
		return objetivos;
	}

	public void setObjetivos(List<Objetivo> objetivos) {
		this.objetivos = objetivos;
	}

	@Override
	public String toString() {
		return "Objetivo "
				+ "\nCodigo Do Objetivo: " + codigoDoObjetivo 
				+ "\nNumero Do CPF: " + numeroDoCPF 
				+ "\nNome Do Objetivo: " + nomeDoObjetivo 
				+ "\nValor Do Objetivo: R$ " + valorDoObjetivo 
				+ "\nValor Atual: R$ " + valorAtual
				+ "\nData De Criacao: " + dataDeCriacao.getDayOfMonth() + "/" + dataDeCriacao.getMonthValue() + "/" + dataDeCriacao.getYear()
				+ "\nData De Conclusao: " + dataDeConclusao.getDayOfMonth() + "/" + dataDeConclusao.getMonthValue() + "/" + dataDeConclusao.getYear()
				+ "\nDescricao Do Objetivo: " + descricaoDoObjetivo;
	}

}
