package br.com.fiap.fintech.dao;

import java.util.List; 

import br.com.fiap.fintech.bean.Objetivo;
import br.com.fiap.fintech.exception.DatabaseException;

public interface ObjetivoDAO {

	public void cadastrarObjetivo(Objetivo objetivo) throws DatabaseException;
	public void editarObjetivo(Objetivo objetivo) throws DatabaseException;
	public void removerObjetivo(Integer codigoDoObjetivo) throws DatabaseException;
	public List<Objetivo> listarObjetivos(Long numeroDeCPF);
}
