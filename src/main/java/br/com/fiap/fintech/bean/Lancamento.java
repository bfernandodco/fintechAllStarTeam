package br.com.fiap.fintech.bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Lancamento {

	private Integer codigoDoLancamento;
	private Long numeroDoCPF;
	private LocalDate dataDoLancamento;
	private LocalDateTime horaDoLancamento;
	private Double valorDoLancamento;
	private TipoDoLancamento tipoDoLancamento;
	private CategoriaDoLancamento categoriaDoLancamento;
	private String descricaoDoLancamento;
	private List<Lancamento> lancamentos;
	
	public Lancamento() {
		
	}

	public Lancamento(Integer codigoDoLancamento, Long numeroDoCPF, LocalDate dataDoLancamento,
			LocalDateTime horaDoLancamento, Double valorDoLancamento, TipoDoLancamento tipoDoLancamento,
			CategoriaDoLancamento categoriaDoLancamento, String descricaoDoLancamento) {
		this.codigoDoLancamento = codigoDoLancamento;
		this.numeroDoCPF = numeroDoCPF;
		this.dataDoLancamento = dataDoLancamento;
		this.horaDoLancamento = horaDoLancamento;
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

	public Long getNumeroDoCPF() {
		return numeroDoCPF;
	}

	public void setNumeroDoCPF(Long numeroDoCPF) {
		this.numeroDoCPF = numeroDoCPF;
	}

	public LocalDate getDataDoLancamento() {
		return dataDoLancamento;
	}

	public void setDataDoLancamento(LocalDate dataDoLancamento) {
		this.dataDoLancamento = dataDoLancamento;
	}

	public LocalDateTime getHoraDoLancamento() {
		return horaDoLancamento;
	}

	public void setHoraDoLancamento(LocalDateTime horaDoLancamento) {
		this.horaDoLancamento = horaDoLancamento;
	}

	public Double getValorDoLancamento() {
		return valorDoLancamento;
	}

	public void setValorDoLancamento(Double valorDoLancamento) {
		this.valorDoLancamento = valorDoLancamento;
	}

	public TipoDoLancamento getTipoDoLancamento() {
		return tipoDoLancamento;
	}

	public void setTipoDoLancamento(TipoDoLancamento tipoDoLancamento) {
		this.tipoDoLancamento = tipoDoLancamento;
	}

	public CategoriaDoLancamento getCategoriaDoLancamento() {
		return categoriaDoLancamento;
	}

	public void setCategoriaDoLancamento(CategoriaDoLancamento categoriaDoLancamento) {
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
				+ "\nData Do Lancamento: " + dataDoLancamento.getDayOfMonth() + "/" + dataDoLancamento.getMonthValue() + "/" + dataDoLancamento.getYear()
				+ "\nHora Do Lancamento: " + horaDoLancamento.getHour() + "h:" + horaDoLancamento.getMinute() + "min"
				+ "\nValor Do Lancamento: R$ " + valorDoLancamento 
				+ "\nTipo Do Lancamento: " + tipoDoLancamento.getTipoDoLancamento()
				+ "\nCategoria Do Lancamento: " + categoriaDoLancamento.getCategoriaDoLancamento() 
				+ "\nDescricao Do Lancamento: " + descricaoDoLancamento;
	}
}
