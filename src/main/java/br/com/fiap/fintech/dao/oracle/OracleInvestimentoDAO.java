package br.com.fiap.fintech.dao.oracle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.bean.Banco;
import br.com.fiap.fintech.bean.Investimento;
import br.com.fiap.fintech.bean.InvestimentoAberto;
import br.com.fiap.fintech.bean.TipoDeInvestimento;
import br.com.fiap.fintech.dao.InvestimentoDAO;
import br.com.fiap.fintech.exception.DatabaseException;
import br.com.fiap.fintech.singleton.ConnectionManager;

@SuppressWarnings("unused")
public class OracleInvestimentoDAO implements InvestimentoDAO {
	
	private Connection connection;
	private PreparedStatement pstmt;
	private ResultSet rs;

	@Override
	public void cadastrarInvestimento(Investimento investimento) throws DatabaseException {
		String sqlQuery = "INSERT INTO T_FNT_INVST ("
				+ "cd_investimento, nr_cpf, vl_rentabilidade, dt_entrada, dt_vencimento, "
				+ "vl_investimento, nm_aplicacao, tp_investimento, nm_banco) "
				+ "VALUES (SQ_TB_INVST.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {	
			connection = ConnectionManager.getInstance().getConnection();
			pstmt = connection.prepareStatement(sqlQuery);			
			//pstmt.setLong(1, usuario.getNumeroDoCPF);
			pstmt.setLong(1, 41300);
			pstmt.setDouble(2, investimento.getValorDaRentabilidade());
			pstmt.setDate(3, Date.valueOf(investimento.getDataDeEntrada()));
			pstmt.setDate(4, Date.valueOf(investimento.getDataDeVencimento()));
			pstmt.setDouble(5, investimento.getValorDeInvestimento());
			pstmt.setString(6, investimento.getNomeDoInvestimento());
			pstmt.setString(7, investimento.getTipoDeInvestimento().getTipoDeInvestimento());
			pstmt.setString(8, investimento.getBanco().getBanco());			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DatabaseException("Erro ao cadastrar investimento.");
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				System.err.println();
				e.printStackTrace();
			}
		}
	}
	

	@Override
	public void lancarNovoInvestimentoAberto(Investimento investimento) throws DatabaseException {
		
		/*
		String sqlConsultaCodigo = "SELECT cd_investimento FROM T_FNT_INVST WHERE nm_aplicacao = ?";
		String sqlInvestimentoAberto = "INSERT INTO T_FNT_INV_ABRTO (cd_investimento, dt_mes, vl_total_rent) VALUES (?, ?, ?)";
		
		
		try {
			
			stmtBuscaCodigo = connection.prepareStatement(sqlConsultaCodigo);

			stmtBuscaCodigo.setString(1, investimento.getNomeDoInvestimento());
			rsBuscaCodigo = stmtBuscaCodigo.executeQuery();
			
			if(rsBuscaCodigo.next()) {
				System.out.println("2");
				codigo = rsBuscaCodigo.getInt("cd_investimento");
				System.out.println("2");
			}
			
					
			stmtInvestimentoAberto = connection.prepareStatement(sqlInvestimentoAberto);
			stmtInvestimentoAberto.setInt(1, codigo);
			//VERIFICAR FUNCIONAMENTO DA SERVLET
			stmtInvestimentoAberto.setDate(2, Date.valueOf(investimento.getDataDeEntrada()));
			stmtInvestimentoAberto.setDouble(3, 0.0);
			
			
			stmtInvestimentoAberto.executeUpdate();
			connection.commit();
			
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
			throw new DatabaseException("Erro ao cadastrar investimento.");
		} finally {
			try {
				if(stmtBuscaCodigo!= null) stmtBuscaCodigo.close();
				if (stmtInvestimentoAberto!= null) stmtInvestimentoAberto.close();
				if(rsBuscaCodigo!= null) rsBuscaCodigo.close();
				if (connection != null) connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		*/
	}
	
		
	@Override
	public List<Investimento> listarInvestimentos() {
		String sqlQuery = "SELECT * FROM T_FNT_INVST WHERE nr_cpf = ?";
		List<Investimento> lista = new ArrayList<Investimento>();
		Investimento investimento;
		
		/*
		try {
			connection = ConnectionManager.getInstance().getConnection();
			pstmt = connection.prepareStatement(sqlQuery);
			//pstmt.setLong(1, usuario.getNumeroDoCPF);
			pstmt.setLong(1, 41300);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				investimento = new Investimento();
				investimento.setCodigoDoInvestimento(rs.getInt("cd_investimento"));
				investimento.setValorDaRentabilidade(rs.getDouble("vl_rentabilidade"));
				investimento.setDataDeEntrada(rs.getDate("dt_entrada").toLocalDate());
				investimento.setDataDeVencimento(rs.getDate("dt_vencimento").toLocalDate());
				investimento.setValorDeInvestimento(rs.getDouble("vl_investimento"));
				investimento.setNomeDoInvestimento(rs.getString("nm_aplicacao"));
				
				String tipoInvestimentoString = rs.getString("tp_investimento");
				TipoDeInvestimento tipoInvestimento = TipoDeInvestimento.valueOf(tipoInvestimentoString.toUpperCase().replace(" ", "_"));
				investimento.setTipoDeInvestimento(tipoInvestimento);
				
				String tipoBancoString = rs.getString("BANCO").toUpperCase().replace(" ", "_");
				Banco banco = Banco.valueOf(tipoBancoString);
				investimento.setBanco(banco);
				
				lista.add(investimento);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		*/
		return lista;
		
	}
	

	@Override
	public void editarInvestimento(Investimento investimento) throws DatabaseException {
		String sqlQuery = "UPDATE T_FNT_INVST SET vl_rentabilidade = ?, dt_entrada = ?, "
				+ "dt_vencimento = ?, + vl_investimento = ?, nm_aplicacao = ?, tp_investimento = ?, nm_banco = ? "
				+ "WHERE cd_investimento = ? AND nr_cpf = ?";
		
		try {
			connection = ConnectionManager.getInstance().getConnection();
			pstmt = connection.prepareStatement(sqlQuery);
			pstmt.setDouble(1, investimento.getValorDaRentabilidade());
			pstmt.setDate(2, Date.valueOf(investimento.getDataDeEntrada()));
			pstmt.setDate(3, Date.valueOf(investimento.getDataDeVencimento()));
			pstmt.setDouble(4, investimento.getValorDeInvestimento());
			pstmt.setString(5, investimento.getNomeDoInvestimento());
			pstmt.setString(6, investimento.getTipoDeInvestimento().getTipoDeInvestimento());
			pstmt.setString(7, investimento.getBanco().getBanco());
			pstmt.setInt(8, investimento.getCodigoDoInvestimento());
			//pstmt.setLong(9, usuario.getNumeroDoCPF);
			pstmt.setLong(9, 41300);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DatabaseException("Erro ao editar investimento.");
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				System.err.println();
				e.printStackTrace();
			}
		}
	}

	@Override
	public void excluirInvestimento(String nomeDoInvestimento) {
		
		connection = ConnectionManager.getInstance().getConnection();
		
		PreparedStatement stmtAberto = null;
		PreparedStatement stmtFechado = null;
		/*
		try {
			String sqlInvAberto = "DELETE FROM T_FNT_INV_ABRTO WHERE cd_investimento IN (SELECT cd_investimento FROM T_FNT_INVST WHERE nm_aplicacao = ? AND nr_cpf = ?)";
			stmtAberto = connection.prepareStatement(sqlInvAberto);
			
			stmtAberto.setString(1, nomeDoInvestimento);
			//stmtAberto.setLong(2, usuario.getNumeroDoCPF);
			stmtAberto.setLong(2, 41300);
			
			stmtAberto.executeUpdate();
			
			String sqlFechado = "DELETE FROM T_FNT_INV_FCHDO WHERE cd_investimento IN (SELECT cd_investimento FROM T_FNT_INVST WHERE nm_aplicacao = ? AND nr_cpf = ?)";
			
			stmtFechado = connection.prepareStatement(sqlFechado);
			
			stmtFechado.setString(1, nomeDoInvestimento);
			//stmtFechado.setLong(2, usuario.getNumeroDoCPF);
			stmtFechado.setLong(2, 41300);
			
			stmtFechado.executeUpdate();
			
			
			String sql = "DELETE FROM T_FNT_INVST WHERE nm_aplicacao = ? AND nr_cpf = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, nomeDoInvestimento);
			//pstmt.setLong(2, usuario.getNumeroDoCPF);
			pstmt.setLong(2, 41300);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmtAberto != null) {
				try {
					stmtAberto.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmtFechado != null) {
				try {
					stmtFechado.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		*/
	}
	
	
	@Override
	public void excluirInvestimentoAberto(String nomeDoInvestimento) {
		/*
		connection = ConnectionManager.getInstance().getConnection();
		
		PreparedStatement stmtAberto = null;

		try {
			String sqlInvAberto = "DELETE FROM T_FNT_INV_ABRTO WHERE cd_investimento IN (SELECT cd_investimento FROM T_FNT_INVST WHERE nm_aplicacao = ? AND nr_cpf = ?)";
			stmtAberto = connection.prepareStatement(sqlInvAberto);
			
			stmtAberto.setString(1, nomeDoInvestimento);
			//stmtAberto.setLong(2, usuario.getNumeroDoCPF);
			stmtAberto.setLong(2, 41300);
			
			stmtAberto.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmtAberto != null) {
				try {
					stmtAberto.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		*/
	}
	
		
	@Override
	public void excluirInvestimentoFechado(String nomeDoInvestimento) {
		
		/*
		connection = ConnectionManager.getInstance().getConnection();
		
		PreparedStatement stmtFechado = null;

		try {			
			String sqlFechado = "DELETE FROM T_FNT_INV_FCHDO WHERE cd_investimento IN (SELECT cd_investimento FROM T_FNT_INVST WHERE nm_aplicacao = ? AND nr_cpf = ?)";
			
			stmtFechado = connection.prepareStatement(sqlFechado);
			
			stmtFechado.setString(1, nomeDoInvestimento);
			//stmtFechado.setLong(2, usuario.getNumeroDoCPF);
			stmtFechado.setLong(2, 41300);
			
			stmtFechado.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmtFechado != null) {
				try {
					stmtFechado.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		*/
	}
	
	
	@Override
	public List<InvestimentoAberto> listarInvestimentosAbertos(Integer codigoDoinvestimento) {
		List<InvestimentoAberto> investimentosAbertos = new ArrayList<InvestimentoAberto>();
		InvestimentoAberto investimentoAberto;
		String sqlQuery = "SELECT * FROM T_FNT_INV_ABRTO "
				+ "AS ABERTO INNER JOIN T_FNT_INVST AS INV "
				+ "WHERE ABERTO.cd_investimento = INV.cd_investimento";
		
		/*
		try {
			pstmt = connection.prepareStatement(sqlQuery);
			pstmt.setLong(1, codigoDoinvestimento);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				investimentoAberto = new InvestimentoAberto();
				investimentoAberto.setChavePrimariaEstrantrangeira(rs.getInt("cd_investimento"));
				investimentoAberto.setValorTotalDoRendimento(rs.getDouble("vl_total_rent"));
				investimentosAbertos.add(investimentoAberto);
			}
		} catch(SQLException e) {
			System.err.println("ERRO AO LISTAR INVESTIMENTOS ABERTOS");
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		*/
		return investimentosAbertos;
		
	}
	
		
	@Override
	public void registrarFechamentoDeInvestimento(InvestimentoAberto investimentoAberto)  {
		
		/*
		connection = ConnectionManager.getInstance().getConnection();
		PreparedStatement stmt = null;
		
		String sqlQuery = "INSERT INTO T_FNT_INV_FCHDO("
				+ "cd_investimento, dt_saida, vl_liquidez) "
				+ "VALUES(?, ?, ?) ";
		
		try {
			stmt = connection.prepareStatement(sqlQuery);
			stmt.setInt(1, investimentoAberto.getChavePrimariaEstrantrangeira());
			stmt.setDate(2, Date.valueOf(LocalDate.now()));
			stmt.setDouble(3, 1000.0);
						
			stmt.executeUpdate();
		} catch(SQLException e) {
			System.err.println("ERRO AO REGISTRAR FECHAMENTO");
			e.printStackTrace();
		} finally {
			if(stmt!= null) {
				stmt.close();
			}
			if(connection!= null) {
				connection.close();
			}
		}
		*/
	}
	
	
	public void fecharInvestimento(Integer codigoDoInvestimento) {
		String sqlQuery = "DELETE FROM T_FNT_INV_ABRTO "
				+ "WHERE cd_investimento = ?";
		
		/*
		try {
			pstmt = connection.prepareStatement(sqlQuery);
			pstmt.setInt(1, codigoDoInvestimento);
			pstmt.executeUpdate();
		} catch(SQLException e) {
			System.err.println("ERRO AO EXCLUIR INVESTIMENTO PARA FECHAMENTO");
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				pstmt.close();
			}
			if(connection != null) {
				connection.close();
			}
		}
		 */
	}
}
