package br.com.fiap.fintech.dao.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.bean.InvestimentoAberto;
import br.com.fiap.fintech.dao.InvestimentoAbertoDAO;
import br.com.fiap.fintech.exception.DatabaseException;
import br.com.fiap.fintech.singleton.ConnectionManager;

public class OracleInvestimentoAbertoDAO implements InvestimentoAbertoDAO{
	
	private Connection connection;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	@Override
	public void registrarInvestimentoAberto(InvestimentoAberto investimentoAberto) throws DatabaseException {
		String sqlQuery = "INSERT INTO T_FNT_INV_ABRTO("
				+ "nr_cpf, cd_investimento, dt_mes, vl_total_rend) "
				+ "VALUES(?, ?, ?, ?)";
		
		try {
			connection = ConnectionManager.getInstance().getConnection();
			pstmt = connection.prepareStatement(sqlQuery);
			pstmt.setLong(1, investimentoAberto.getNumeroDoCPF());
			pstmt.setInt(2, investimentoAberto.getCodigoDoInvestimento());
			pstmt.setString(3, String.valueOf(investimentoAberto.getMes().getMonth()));
			pstmt.setDouble(4, investimentoAberto.getValorTotalDoRendimento());		
			pstmt.executeQuery();			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DatabaseException("Erro ao registrar investimento aberto.");
		} finally {
			try {
				connection.close();
				pstmt.close();
			} catch (SQLException e) {
				System.err.println("Erro ao fechar conexão em registrarInvestimentoAberto()");
				e.printStackTrace();
			}
		}
	}
	
	
	@Override
	public Double consultarRendimentoMensalDoInvestimentoAberto(InvestimentoAberto investimentoAberto) {
		String sqlQuery = "SELECT tx_mes, SUM(vl_total_rend) AS total_mensal FROM T_FNT_INV_ABRTO "
				+ "WHERE nr_cpf = ? AND cd_investimento = ?";
		Double totalMensal = 0.0;
		
		try {
			connection = ConnectionManager.getInstance().getConnection();
			pstmt = connection.prepareStatement(sqlQuery);
			pstmt.setLong(1, investimentoAberto.getNumeroDoCPF());
			pstmt.setInt(2, investimentoAberto.getCodigoDoInvestimento());
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
	public void fecharInvestimentoAberto(Integer codigoDoInvestimento) throws DatabaseException {
		String sqlQuery = "DELETE FROM T_FNT_INV_ABRTO WHERE cd_investimento = ?";
		
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
				System.err.println("Erro ao fechar conexão em fecharInvestimentoAberto()");
				e.printStackTrace();
			}
		}
		
	}
	@Override
	public List<InvestimentoAberto> listarInvestimentosAbertos(Long numeroDoCPF) {
		String sqlQuery = "SELECT * FROM T_FNT_INV_ABRTO WHERE nr_cpf = ?";
		List<InvestimentoAberto> investimentosAbertos = new ArrayList<InvestimentoAberto>();
		InvestimentoAberto investimentoAberto;
				
		try {
			connection = ConnectionManager.getInstance().getConnection();
			pstmt = connection.prepareStatement(sqlQuery);
			pstmt.setLong(1, numeroDoCPF);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				investimentoAberto = new InvestimentoAberto();
				investimentoAberto.setCodigoDoInvestimento(rs.getInt("cd_investimento"));
				investimentoAberto.setValorTotalDoRendimento(rs.getDouble("vl_total_rend"));
				investimentosAbertos.add(investimentoAberto);
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
		return investimentosAbertos;
	}

}
