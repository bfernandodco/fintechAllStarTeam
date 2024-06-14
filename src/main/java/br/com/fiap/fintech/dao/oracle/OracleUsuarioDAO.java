package br.com.fiap.fintech.dao.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.fiap.fintech.bean.Usuario;
import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.exception.DatabaseException;
import br.com.fiap.fintech.singleton.ConnectionManager;

public class OracleUsuarioDAO implements UsuarioDAO{
	
	private Connection connection;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	@Override
	public void cadastrarUsuario(Usuario usuario) throws DatabaseException {
	    String sqlQuery = "INSERT INTO T_FNT_USUARIO (nr_cpf, nm_completo, dt_nascimento, "
	    		+ "ds_genero, tx_email) "
	    		+ "VALUES (?, ?, ?, ?, ?)";
	    
	    try {
	    	connection = ConnectionManager.getInstance().getConnection();
	    	pstmt = connection.prepareStatement(sqlQuery);
	    	pstmt.setLong(1, usuario.getNumeroDoCPF());
	    	pstmt.setString(2, usuario.getNomeCompleto());
	    	pstmt.setDate(3, usuario.getDataDeNascimento());
	    	pstmt.setString(4, usuario.getGenero());
	    	pstmt.setString(5, usuario.getEmail());
	    	pstmt.executeUpdate();
	    } catch(SQLException e) {
			e.printStackTrace();
			throw new DatabaseException("Erro ao cadastrar usuario.");
		} finally {
			try {
				connection.close();
				pstmt.close();
			} catch(SQLException e) {
				System.err.println("Erro ao fechar conexão em cadastrarUsuario()");
				e.printStackTrace();
			}
		}	
	}

	@Override
	public void editarUsuario(Usuario usuario) throws DatabaseException {
		String sqlQuery = "UPDATE T_FNT_USUARIO SET "
				+ "nm_completo = ?, dt_nascimento = ?, ds_genero = ?, tx_email = ? "
				+ "WHERE nr_cpf = ?";
		try {
			connection = ConnectionManager.getInstance().getConnection();
			pstmt = connection.prepareStatement(sqlQuery);
			pstmt.setString(1, usuario.getNomeCompleto());
			pstmt.setDate(2, usuario.getDataDeNascimento());
			pstmt.setString(3, usuario.getGenero());
			pstmt.setString(4, usuario.getEmail());
			pstmt.setLong(5, usuario.getNumeroDoCPF());
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
			throw new DatabaseException("Erro ao editar usuario.");
		} finally {
			try {
				connection.close();
				pstmt.close();
			} catch(SQLException e) {
				System.err.println("Erro ao fechar conexão em editarUsuario()");
				e.printStackTrace();
			}
		}	
	}
	
	@Override
	public Usuario buscarUsuario(Long numeroDoCPF) {
		String sqlQuery = "SELECT * FROM T_FNT_USUARIO "
				+ "WHERE nr_cpf = ?";
		Usuario usuario = new Usuario();
		
		try {
			connection = ConnectionManager.getInstance().getConnection();
			pstmt = connection.prepareStatement(sqlQuery);
			pstmt.setLong(1, numeroDoCPF);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				usuario.setNomeCompleto(rs.getString("nm_completo"));
				usuario.setDataDeNascimento(rs.getDate("dt_nascimento"));
				usuario.setGenero(rs.getString("ds_genero"));
				usuario.setEmail(rs.getString("tx_email"));
				usuario.setNumeroDoCPF(numeroDoCPF);
				return usuario;
			}

		} catch(SQLException e) {
			e.printStackTrace();
			System.err.println("Erro ao buscar usuario.");
		} finally {
			try {
				connection.close();
				pstmt.close();
				rs.close();
			} catch(SQLException e) {
				System.err.println("Erro ao fechar conexão em buscarUsuario()");
				e.printStackTrace();
			}
		}
		return null;
	}
		
	@Override
	public void removerUsuario(Long numeroDoCPF) throws DatabaseException {
		String sqlQuery = "DELETE FROM T_FNT_USUARIO WHERE nr_cpf = ? ";
		
		try {
			connection = ConnectionManager.getInstance().getConnection();
			pstmt = connection.prepareStatement(sqlQuery);
			pstmt.setLong(1, numeroDoCPF);
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
			throw new DatabaseException("Erro ao remover usuario.");
		} finally {
			try {
				connection.close();
				pstmt.close();
			} catch(SQLException e) {
				System.err.println("Erro ao fechar conexão em removerUsuario()");
				e.printStackTrace();
			}
		}	
	}

	@Override
	public void alterarSenhaDoUsuario(String novaSenha, Usuario usuario) throws DatabaseException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isSenhaValida(String senhaParaValidacao) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Long validarUsuario(String email) {
		String sqlQuery = "SELECT nr_cpf FROM T_FNT_USUARIO "
				+ "WHERE tx_email = ?";
		Long numeroDoCPF = null;
		
		try {
			connection = ConnectionManager.getInstance().getConnection();
			pstmt = connection.prepareStatement(sqlQuery);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return numeroDoCPF = rs.getLong("nr_cpf");
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			System.err.println("Erro ao validar usuario.");
		} finally {
			try {
				connection.close();
				pstmt.close();
				rs.close();
			} catch(SQLException e) {
				System.err.println("Erro ao fechar conexão em validarUsuario()");
				e.printStackTrace();
			}
		}
		return numeroDoCPF;
	}

	
	@Override
	public boolean isCPFValido(Long numeroDoCPF) {
        String cpf = numeroDoCPF.toString();
        
        if (cpf.length() != 11) {
            return false;
        }

        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        int[] pesos1 = {10, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] pesos2 = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
        
        try {
            int soma1 = 0;
            for (int i = 0; i < 9; i++) {
                soma1 += Character.getNumericValue(cpf.charAt(i)) * pesos1[i];
            }
            int digito1 = 11 - (soma1 % 11);
            System.out.println(digito1);
            digito1 = (digito1 > 9) ? 0 : digito1;

            int soma2 = 0;
            for (int i = 0; i < 10; i++) {
                soma2 += Character.getNumericValue(cpf.charAt(i)) * pesos2[i];
            }
            int digito2 = 11 - (soma2 % 11);
            System.out.println(digito2);
            digito2 = (digito2 > 9) ? 0 : digito2;

            return cpf.charAt(9) == Character.forDigit(digito1, 10) &&
                   cpf.charAt(10) == Character.forDigit(digito2, 10);
        } catch (NumberFormatException e) {
            return false; // 
        }
    }
}
