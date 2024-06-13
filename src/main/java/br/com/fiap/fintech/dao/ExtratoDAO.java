package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.bean.Extrato;
import br.com.fiap.fintech.exception.DatabaseException;

public interface ExtratoDAO {

	void registrarExtratoDeNovoUsuario(Long numeroDoCPF) throws DatabaseException;
	Extrato consultarExtrato(Long numeroDeCPF);
	void atualizarSaldoTotal(Double valorParaSomarAoSaldoTotal) throws DatabaseException;
	void atualizarValorTotalDeInvestimentos(Double valorParaSomarAoTotalInvestido) throws DatabaseException;
	void atualizarEntrada(Double valorDeEntrada) throws DatabaseException;
	void atualizarSaida(Double valorDeSaída) throws DatabaseException;
}
