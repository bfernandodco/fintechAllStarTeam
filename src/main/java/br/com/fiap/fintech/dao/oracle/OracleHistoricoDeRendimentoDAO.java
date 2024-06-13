package br.com.fiap.fintech.dao.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.bean.HistoricoDeRendimento;
import br.com.fiap.fintech.dao.HistoricoDeRendimentoDAO;
import br.com.fiap.fintech.singleton.ConnectionManager;

public class OracleHistoricoDeRendimentoDAO implements HistoricoDeRendimentoDAO {

	private Connection connection;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	@Override
	public List<HistoricoDeRendimento> listarHistoricoDeRendimentos(Long numeroDoCPF) {
		String sqlQuery = "SELECT * FROM T_FNT_HIST_REND WHERE nr_cpf = ?";
		List<HistoricoDeRendimento> historico = new ArrayList<HistoricoDeRendimento>();
		HistoricoDeRendimento rendimento = new HistoricoDeRendimento();
		
		try {
			connection = ConnectionManager.getInstance().getConnection();
			pstmt = connection.prepareStatement(sqlQuery);
			pstmt.setLong(1, numeroDoCPF);		
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				rendimento.setNumeroDoCPF(rs.getLong("nr_cpf"));
				rendimento.setCodigoDoInvestimento(rs.getInt("cd_investimento"));
				rendimento.setValorDoRendimento(rs.getDouble("vl_rendimento"));
				rendimento.setMes(rs.getDate("dt_mes").toLocalDate().getMonth());
				rendimento.setAno(rs.getDate("dt_ano").toLocalDate().getYear());
				historico.add(rendimento);
			}
		} catch (SQLException e) {
			System.err.println("Erro ao gerar histórico de rendimentos.");
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				pstmt.close();
				rs.close();
			} catch(SQLException e) {
				System.err.println("Erro ao fechar conexão em listarHistoricoDeRendimentos()");
				e.printStackTrace();
			}
		}
		return historico;
	}

}
