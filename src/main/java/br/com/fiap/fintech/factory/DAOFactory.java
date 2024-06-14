package br.com.fiap.fintech.factory;

import br.com.fiap.fintech.dao.ExtratoDAO;
import br.com.fiap.fintech.dao.InvestimentoDAO;
import br.com.fiap.fintech.dao.LancamentoDAO;
import br.com.fiap.fintech.dao.LoginDAO;
import br.com.fiap.fintech.dao.ObjetivoDAO;
import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.dao.oracle.OracleExtratoDAO;
import br.com.fiap.fintech.dao.oracle.OracleInvestimentoDAO;
import br.com.fiap.fintech.dao.oracle.OracleLancamentoDAO;
import br.com.fiap.fintech.dao.oracle.OracleLoginDAO;
import br.com.fiap.fintech.dao.oracle.OracleObjetivoDAO;
import br.com.fiap.fintech.dao.oracle.OracleUsuarioDAO;

	public class DAOFactory {

	public static InvestimentoDAO getInvestimentoDAO() {
		return new OracleInvestimentoDAO();
	}

	public static ExtratoDAO getExtratoDAO() {
		return new OracleExtratoDAO();
	}
	
	public static UsuarioDAO getUsuarioDAO() {
		return new OracleUsuarioDAO();
	} 
	
	public static LoginDAO getLoginDAO() {
		return new OracleLoginDAO();
	} 
	
	public static ObjetivoDAO getObjetivoDAO() {
		return new OracleObjetivoDAO();
	}

	public static LancamentoDAO getLancamentoDAO() {
		return new OracleLancamentoDAO();
	}
}
