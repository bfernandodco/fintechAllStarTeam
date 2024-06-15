package br.com.fiap.fintech.dao;

import java.util.List;

import br.com.fiap.fintech.bean.Investimento;
import br.com.fiap.fintech.exception.DatabaseException;

public interface InvestimentoDAO {
	
	void cadastrarInvestimento(Investimento investimento) throws DatabaseException;
	void editarInvestimento(Investimento investimento) throws DatabaseException;
	void removerInvestimento(Integer codigoDoInvestimento) throws DatabaseException;
	List<Investimento> listarInvestimentos(String numeroDoCpf);
}
