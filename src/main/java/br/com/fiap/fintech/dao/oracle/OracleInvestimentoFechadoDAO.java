package br.com.fiap.fintech.dao.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.bean.InvestimentoFechado;
import br.com.fiap.fintech.dao.InvestimentoFechadoDAO;
import br.com.fiap.fintech.exception.DatabaseException;
import br.com.fiap.fintech.singleton.ConnectionManager;

public class OracleInvestimentoFechadoDAO implements InvestimentoFechadoDAO{
	
	private Connection connection;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	@Override
	public void registrarInvestimentoFechado(InvestimentoFechado investimentoFechado) throws DatabaseException {
		String sqlQuery = "INSERT INTO T_FNT_INV_FCHDO("
				+ "cd_investimento, dt_fechamento, vl_liquidez) "
				+ "VALUES(?, ?, ?)";
		
		try {
			connection = ConnectionManager.getInstance().getConnection();
			pstmt = connection.prepareStatement(sqlQuery);
			pstmt.setInt(1, investimentoFechado.getCodigoDoInvestimento());
			pstmt.setString(2, String.valueOf(investimentoFechado.getDataDeFechamento().getMonth()));
			pstmt.setDouble(3, investimentoFechado.getValorDaLiquidez());		
			pstmt.executeQuery();			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DatabaseException("Erro ao registrar investimento fechado.");
		} finally {
			try {
				connection.close();
				pstmt.close();
			} catch (SQLException e) {
				System.err.println("Erro ao fechar conexão em registrarInvestimentoFechado()");
				e.printStackTrace();
			}
		}	
	}

	//VERIFICAR ESSE METODO
	@Override
	public Double consultarLiquidezMensalDoInvestimentoFechado(InvestimentoFechado investimentoFechado) {
		String sqlQuery = "SELECT SUM(vl_liquidez) AS total_mensal FROM T_FNT_INV_FCHADO "
		        + "WHERE cd_investimento = ? AND EXTRACT(MONTH FROM dt_fechamento) = EXTRACT("
		        + "MONTH FROM CURRENT_DATE)AND EXTRACT(YEAR FROM dt_fechamento) = EXTRACT("
		        + "YEAR FROM CURRENT_DATE)";

		Double totalMensal = 0.0;
		
		try {
			connection = ConnectionManager.getInstance().getConnection();
			pstmt = connection.prepareStatement(sqlQuery);
			pstmt.setInt(1, investimentoFechado.getCodigoDoInvestimento());
			rs = pstmt.executeQuery();
					
			if(rs.next()){
				totalMensal = rs.getDouble("total_mensal");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				System.err.println("Erro ao fechar conexão em consultarRendimentoMensalDoInvestimentoAberto()");
				e.printStackTrace();
			}
		}
		return totalMensal;
	}

	@Override
	public void fecharInvestimentoFechado(Integer codigoDoInvestimento) throws DatabaseException {
String sqlQuery = "DELETE FROM T_FNT_INV_FCHDO WHERE cd_investimento = ?";
		
		try {
			connection = ConnectionManager.getInstance().getConnection();
			pstmt = connection.prepareStatement(sqlQuery);
			pstmt.setInt(1, codigoDoInvestimento);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				pstmt.close();
			} catch (SQLException e) {
				System.err.println("Erro ao fechar conexão em fecharInvestimentoFechado()");
				e.printStackTrace();
			}
		}	
	}

	@Override
	public List<InvestimentoFechado> listarInvestimentosFechadoss(Long numeroDoCPF) {
		String sqlQuery = "SELECT * FROM T_FNT_INV_ABRTO WHERE nr_cpf = ?";
		List<InvestimentoFechado> investimentosFechados = new ArrayList<InvestimentoFechado>();
		InvestimentoFechado investimentoFechado;
				
		try {
			connection = ConnectionManager.getInstance().getConnection();
			pstmt = connection.prepareStatement(sqlQuery);
			pstmt.setLong(1, numeroDoCPF);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				investimentoFechado = new InvestimentoFechado();
				investimentoFechado.setCodigoDoInvestimento(rs.getInt("cd_investimento"));
				investimentoFechado.setDataDeFechamento(rs.getDate("dt_fechamento").toLocalDate());;
				investimentoFechado.setValorDaLiquidez(rs.getDouble("vl_liquidez"));
				investimentosFechados.add(investimentoFechado);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				System.err.println("Erro ao fechar conexão em listarInvestimentosAbertos()");
				e.printStackTrace();
			}
		}
		return investimentosFechados;
	}

}
