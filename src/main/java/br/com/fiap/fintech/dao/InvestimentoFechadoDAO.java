package br.com.fiap.fintech.dao;

import java.util.List;

import br.com.fiap.fintech.bean.InvestimentoFechado;
import br.com.fiap.fintech.exception.DatabaseException;

public interface InvestimentoFechadoDAO {
	
	void fecharInvestimento(InvestimentoFechado investimentoFechado) throws DatabaseException;
	Double consultarLiquidezDeInvestimentoFechado(InvestimentoFechado investimentoFechado);
	List<InvestimentoFechado> listarInvestimentosFechadoss(Long numeroDoCPF);
}
