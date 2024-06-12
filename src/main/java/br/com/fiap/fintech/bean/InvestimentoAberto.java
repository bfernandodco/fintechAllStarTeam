package br.com.fiap.fintech.bean;

import java.time.LocalDate;
import java.util.List;

public class InvestimentoAberto {
	
	private Integer codigoDoInvestimento;
	private Long numeroDoCPF;
	private LocalDate mes;
	private Double valorTotalDoRendimento;
	private List<InvestimentoAberto> investimentosAbertos;
	
	public InvestimentoAberto() {
		
	}

	public InvestimentoAberto(Integer codigoDoInvestimento, Long numeroDoCPF, LocalDate mes, 
			Double valorTotalDoRendimento) {
		this.codigoDoInvestimento = codigoDoInvestimento;
		this.numeroDoCPF = numeroDoCPF;
		this.mes = mes;
		this.valorTotalDoRendimento = valorTotalDoRendimento;
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

	public LocalDate getMes() {
		return mes;
	}

	public void setMes(LocalDate mes) {
		this.mes = mes;
	}

	public Double getValorTotalDoRendimento() {
		return valorTotalDoRendimento;
	}

	public void setValorTotalDoRendimento(Double valorTotalDoRendimento) {
		this.valorTotalDoRendimento = valorTotalDoRendimento;
	}

	public List<InvestimentoAberto> getInvestimentosAbertos() {
		return investimentosAbertos;
	}

	public void setInvestimentosAbertos(List<InvestimentoAberto> investimentosAbertos) {
		this.investimentosAbertos = investimentosAbertos;
	}
	
	@Override
	public String toString() {
		return "\nInvestimento Aberto"
				+ "\nCodigo Do Investimento: " + codigoDoInvestimento 
				+ "\nNumero do CPF: " + numeroDoCPF
				+ "\nMes=" + mes.getMonth()
				+ "\nValor Total Do Rendimento: R$ " + valorTotalDoRendimento;
	}

}
