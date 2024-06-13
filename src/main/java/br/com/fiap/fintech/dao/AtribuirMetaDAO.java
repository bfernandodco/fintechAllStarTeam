package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.exception.DatabaseException;

public interface AtribuirMetaDAO {

	void atribuirMetaAoObjetivoPorLancamento(Integer codigoDoObjetivo, Integer codigoDoLancamento) throws DatabaseException;;
	void atribuirMetaAoObjetivoPorInvestimento(Integer codigoDoObjetivo, Integer codigoDoInvestimento) throws DatabaseException;;
}
