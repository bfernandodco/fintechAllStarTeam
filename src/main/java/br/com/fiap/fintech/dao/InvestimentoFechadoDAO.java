package br.com.fiap.fintech.dao;

import java.util.List;

import br.com.fiap.fintech.bean.InvestimentoFechado;
import br.com.fiap.fintech.exception.DatabaseException;

public interface InvestimentoFechadoDAO {
	
	void registrarInvestimentoFechado(InvestimentoFechado investimentoFechado) throws DatabaseException;
	Double consultarLiquidezMensalDoInvestimentoFechado(InvestimentoFechado investimentoFechado);
	List<InvestimentoFechado> listarInvestimentosFechadoss(Long numeroDoCPF);

}
