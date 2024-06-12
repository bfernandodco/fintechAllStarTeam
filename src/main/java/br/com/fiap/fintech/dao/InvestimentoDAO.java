package br.com.fiap.fintech.dao;

import java.util.List;

import br.com.fiap.fintech.bean.Investimento;
import br.com.fiap.fintech.bean.InvestimentoAberto;
import br.com.fiap.fintech.exception.DatabaseException;

public interface InvestimentoDAO {
	
	void cadastrarInvestimento(Investimento investimento) throws DatabaseException;
	void editarInvestimento(Investimento investimento) throws DatabaseException;
	void excluirInvestimento(String nomeDoInvestimento) throws DatabaseException;
	void registrarFechamentoDeInvestimento(InvestimentoAberto investimentoAberto) throws DatabaseException;
	void fecharInvestimento(Integer codigoDoInvestimento) throws DatabaseException;
	void lancarNovoInvestimentoAberto(Investimento investimento) throws DatabaseException;
	void excluirInvestimentoAberto(String nomeDoInvestimento) throws DatabaseException;
	void excluirInvestimentoFechado(String nomeDoInvestimento) throws DatabaseException;
	List<Investimento> listarInvestimentos();
	List<InvestimentoAberto> listarInvestimentosAbertos(Integer codigoDoinvestimento);
}
