package br.com.fiap.fintech.bean;

import java.time.Month;
import java.util.List;

public class HistoricoDeRendimento {

	private Long numeroDoCPF;
	private Integer codigoDoInvestimento;
	private Double valorDoRendimento;
	private Month mes;
	private Integer ano;
	private List<HistoricoDeRendimento> rendimentos;
	
	public HistoricoDeRendimento() {
		
	}

	public HistoricoDeRendimento(Long numeroDoCPF, Integer codigoDoInvestimento, Double valorDoRendimento,
			Month mes, Integer ano) {
		this.numeroDoCPF = numeroDoCPF;
		this.codigoDoInvestimento = codigoDoInvestimento;
		this.valorDoRendimento = valorDoRendimento;
		this.mes = mes;
		this.ano = ano;
	}

	public Long getNumeroDoCPF() {
		return numeroDoCPF;
	}

	public void setNumeroDoCPF(Long numeroDoCPF) {
		this.numeroDoCPF = numeroDoCPF;
	}

	public Integer getCodigoDoInvestimento() {
		return codigoDoInvestimento;
	}

	public void setCodigoDoInvestimento(Integer codigoDoInvestimento) {
		this.codigoDoInvestimento = codigoDoInvestimento;
	}

	public Double getValorDoRendimento() {
		return valorDoRendimento;
	}

	public void setValorDoRendimento(Double valorDoRendimento) {
		this.valorDoRendimento = valorDoRendimento;
	}

	public Month getMes() {
		return mes;
	}

	public void setMes(Month mes) {
		this.mes = mes;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public List<HistoricoDeRendimento> getRendimentos() {
		return rendimentos;
	}

	public void setRendimentos(List<HistoricoDeRendimento> rendimentos) {
		this.rendimentos = rendimentos;
	}

	@Override
	public String toString() {
		return "\nHistoricoDeRendimento "
				+ "\nNumero Do CPF: " + numeroDoCPF 
				+ "\nCodigo Do Investimento: " + codigoDoInvestimento
				+ "\nValor Do Rendimento: R$ " + valorDoRendimento 
				+ "\nMes: " + mes 
				+ "\nAno: " + ano;
	}
}
