package br.com.fiap.fintech.bean;

import java.time.LocalDate;
import java.util.List;

public class InvestimentoFechado {
	
	private Integer codigoDoInvestimento;
	private LocalDate dataDeFechamento;
	private Double valorDaLiquidez;
	private List<InvestimentoFechado> investimentosFechados;
	
	public InvestimentoFechado() {
		
	}

	public InvestimentoFechado(Integer codigoDoInvestimento, LocalDate dataDeFechamento, Double valorDaLiquidez) {
		this.codigoDoInvestimento = codigoDoInvestimento;
		this.dataDeFechamento = dataDeFechamento;
		this.valorDaLiquidez = valorDaLiquidez;
	}

	public Integer getCodigoDoInvestimento() {
		return codigoDoInvestimento;
	}

	public void setCodigoDoInvestimento(Integer codigoDoInvestimento) {
		this.codigoDoInvestimento = codigoDoInvestimento;
	}

	public LocalDate getDataDeFechamento() {
		return dataDeFechamento;
	}

	public void setDataDeFechamento(LocalDate dataDeFechamento) {
		this.dataDeFechamento = dataDeFechamento;
	}

	public Double getValorDaLiquidez() {
		return valorDaLiquidez;
	}

	public void setValorDaLiquidez(Double valorDaLiquidez) {
		this.valorDaLiquidez = valorDaLiquidez;
	}

	public List<InvestimentoFechado> getInvestimentosFechados() {
		return investimentosFechados;
	}

	public void setInvestimentosFechados(List<InvestimentoFechado> investimentosFechados) {
		this.investimentosFechados = investimentosFechados;
	}

	@Override
	public String toString() {
		return "\nInvestimento Fechado "
				+ "\nCodigo Do Investimento: " + codigoDoInvestimento 
				+ "\nData De Saida: " + dataDeFechamento.getDayOfMonth() + "/" + dataDeFechamento.getMonthValue() + "/" + dataDeFechamento.getYear()
				+ "\nValor Da Liquidez: R$ " + valorDaLiquidez;
	}

}
