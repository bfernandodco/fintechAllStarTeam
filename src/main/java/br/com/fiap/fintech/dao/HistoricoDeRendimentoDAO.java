package br.com.fiap.fintech.dao;

import java.util.List;

import br.com.fiap.fintech.bean.HistoricoDeRendimento;

public interface HistoricoDeRendimentoDAO {

	List<HistoricoDeRendimento> listarHistoricoDeRendimentos(Long numeroDoCPF);
}
