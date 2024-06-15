package br.com.fiap.fintech.bean;

import java.sql.Date;
import java.util.List;

public class Lancamento {

	private Integer codigoDoLancamento;
	private String numeroDoCPF;
	private Date dataHoraDoLancamento;
	private Double valorDoLancamento;
	private String tipoDoLancamento;
	private String categoriaDoLancamento;
	private String descricaoDoLancamento;
	private List<Lancamento> lancamentos;
	
	public Lancamento() {
		
	}
	
	public Lancamento(String numeroDoCPF, Integer codigoDoLancamento, Date dataHoraDoLancamento, Double valorDoLancamento,
			String tipoDoLancamento, String categoriaDoLancamento, String descricaoDoLancamento) {
		super();
		this.numeroDoCPF = numeroDoCPF;
		this.codigoDoLancamento = codigoDoLancamento;
		this.dataHoraDoLancamento = dataHoraDoLancamento;
		this.valorDoLancamento = valorDoLancamento;
		this.tipoDoLancamento = tipoDoLancamento;
		this.categoriaDoLancamento = categoriaDoLancamento;
		this.descricaoDoLancamento = descricaoDoLancamento;
	}

	public Lancamento(String numeroDoCPF, Date dataHoraDoLancamento, Double valorDoLancamento, String tipoDoLancamento,
			String categoriaDoLancamento, String descricaoDoLancamento) {
		super();
		this.numeroDoCPF = numeroDoCPF;
		this.dataHoraDoLancamento = dataHoraDoLancamento;
		this.valorDoLancamento = valorDoLancamento;
		this.tipoDoLancamento = tipoDoLancamento;
		this.categoriaDoLancamento = categoriaDoLancamento;
		this.descricaoDoLancamento = descricaoDoLancamento;
	}
	
	public Integer getCodigoDoLancamento() {
		return codigoDoLancamento;
	}

	public void setCodigoDoLancamento(Integer codigoDoLancamento) {
		this.codigoDoLancamento = codigoDoLancamento;
	}

	public String getNumeroDoCPF() {
		return numeroDoCPF;
	}

	public void setNumeroDoCPF(String numeroDoCPF) {
		this.numeroDoCPF = numeroDoCPF;
	}

	public Date getDataHoraDoLancamento() {
		return dataHoraDoLancamento;
	}

	public void setDataHoraDoLancamento(Date dataHoraDoLancamento) {
		this.dataHoraDoLancamento = dataHoraDoLancamento;
	}

	public Double getValorDoLancamento() {
		return valorDoLancamento;
	}

	public void setValorDoLancamento(Double valorDoLancamento) {
		this.valorDoLancamento = valorDoLancamento;
	}

	public String getTipoDoLancamento() {
		return tipoDoLancamento;
	}

	public void setTipoDoLancamento(String tipoDoLancamento) {
		this.tipoDoLancamento = tipoDoLancamento;
	}

	public String getCategoriaDoLancamento() {
		return categoriaDoLancamento;
	}

	public void setCategoriaDoLancamento(String categoriaDoLancamento) {
		this.categoriaDoLancamento = categoriaDoLancamento;
	}

	public String getDescricaoDoLancamento() {
		return descricaoDoLancamento;
	}

	public void setDescricaoDoLancamento(String descricaoDoLancamento) {
		this.descricaoDoLancamento = descricaoDoLancamento;
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}

	@Override
	public String toString() {
		return "\nLancamento "
				+ "\nCodigo Do Lancamento: " + codigoDoLancamento 
				+ "\nNumero Do CPF: " + numeroDoCPF
				+ "\nData Do Lancamento: " + dataHoraDoLancamento
				+ "\nValor Do Lancamento: R$ " + valorDoLancamento 
				+ "\nTipo Do Lancamento: " + tipoDoLancamento
				+ "\nCategoria Do Lancamento: " + categoriaDoLancamento
				+ "\nDescricao Do Lancamento: " + descricaoDoLancamento;
	}
}
