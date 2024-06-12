package br.com.fiap.fintech.bean;

import java.time.LocalDate;
import java.util.List;

public class InvestimentoFechado {
	
	private Integer codigoDoInvestimento;
	private LocalDate dataDeSaida;
	private Double valorDaLiquidez;
	private List<InvestimentoFechado> investimentosFechados;
	
	public InvestimentoFechado() {
		
	}

	public InvestimentoFechado(Integer codigoDoInvestimento, LocalDate dataDeSaida, Double valorDaLiquidez) {
		this.codigoDoInvestimento = codigoDoInvestimento;
		this.dataDeSaida = dataDeSaida;
		this.valorDaLiquidez = valorDaLiquidez;
	}

	public Integer getCodigoDoInvestimento() {
		return codigoDoInvestimento;
	}

	public void setCodigoDoInvestimento(Integer codigoDoInvestimento) {
		this.codigoDoInvestimento = codigoDoInvestimento;
	}

	public LocalDate getDataDeSaida() {
		return dataDeSaida;
	}

	public void setDataDeSaida(LocalDate dataDeSaida) {
		this.dataDeSaida = dataDeSaida;
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
				+ "\nData De Saida: " + dataDeSaida.getDayOfMonth() + "/" + dataDeSaida.getMonthValue() + "/" + dataDeSaida.getYear()
				+ "\nValor Da Liquidez: R$ " + valorDaLiquidez;
	}

}
