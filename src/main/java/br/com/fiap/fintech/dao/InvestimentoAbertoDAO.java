package br.com.fiap.fintech.dao;

import java.util.List;

import br.com.fiap.fintech.bean.InvestimentoAberto;
import br.com.fiap.fintech.exception.DatabaseException;

public interface InvestimentoAbertoDAO {
	
	void registrarInvestimentoAberto(InvestimentoAberto investimentoAberto) throws DatabaseException;
	Double consultarRendimentoMensalDoInvestimentoAberto(InvestimentoAberto investimentoAberto);
	void fecharInvestimentoAberto(Integer codigoDoInvestimento) throws DatabaseException;
	List<InvestimentoAberto> listarInvestimentosAbertos(Long numeroDoCPF);
}
