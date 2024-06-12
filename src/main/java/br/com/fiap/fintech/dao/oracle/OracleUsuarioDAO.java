package br.com.fiap.fintech.dao.oracle;

import java.io.File;  
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.fiap.fintech.bean.Usuario;
import br.com.fiap.fintech.dao.LoginDAO;
import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.exception.DatabaseException;
import br.com.fiap.fintech.singleton.ConnectionManager;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class OracleUsuarioDAO implements UsuarioDAO, LoginDAO{
	
	private Connection connection;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	@Override
	public void cadastrarUsuario(Usuario usuario) throws DatabaseException {
	    String sqlUsuario = "INSERT INTO T_FNT_USUARIO (nr_cpf, nm_completo, dt_nascimento, "
	    		+ "ds_genero, tx_email, im_foto) "
	    		+ "VALUES (?, ?, ?, ?, ?, ?)";
	    String sqlLogin = "INSERT INTO T_FNT_LOGIN (nr_cpf, tx_senha) "
	    		+ "VALUES (?, ?)";
	    
	    PreparedStatement pstmtUsuario = null;
	    PreparedStatement stmtLogin = null;
	    
	    try {
	    	connection = ConnectionManager.getInstance().getConnection();
	        pstmtUsuario = connection.prepareStatement(sqlUsuario);
	        pstmtUsuario.setLong(1, usuario.getNumeroDoCPF());
	        pstmtUsuario.setString(2, usuario.getNomeCompleto());
	        pstmtUsuario.setDate(3, Date.valueOf(usuario.getDataDeNascimento()));
	        pstmtUsuario.setString(4, usuario.getGenero());
	        pstmtUsuario.setString(5, usuario.getEmail());

	        File arquivoImagem = usuario.getImagemFoto();
	        if (arquivoImagem != null) {
	            try (InputStream inputStream = new FileInputStream(arquivoImagem)) {
	                pstmtUsuario.setBinaryStream(6, inputStream);
	            	//pstmtUsuario.setBinaryStream(6, inputStream, (int) arquivoImagem.length());
	            } catch (FileNotFoundException e) {
	                e.printStackTrace();
	                throw new DatabaseException("Erro ao carregar o arquivo de imagem.", e);
	            } catch (IOException e) {
	                e.printStackTrace();
	                throw new DatabaseException("Erro ao ler o arquivo de imagem.", e);
	            }
	        } else {
	            pstmtUsuario.setNull(6, java.sql.Types.BLOB);
	        }
	        
	        stmtLogin = connection.prepareStatement(sqlLogin);
	        stmtLogin.setLong(1, usuario.getNumeroDoCPF());
	        
	        if (isSenhaValida(usuario.getSenha())) {
	        	stmtLogin.setString(2, usuario.getSenha());
	        	
	        	pstmtUsuario.executeUpdate();
	        	stmtLogin.executeUpdate();
	        } else {
	        	throw new DatabaseException("Senha Invalida.");
	        }
	        connection.commit();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new DatabaseException("Erro ao criar novo Usuario.", e);
	    } finally {
	        if (pstmtUsuario != null) {
	            try {
	                pstmtUsuario.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        if (stmtLogin != null) {
	            try {
	                stmtLogin.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        try {
	            connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

	@Override
	public void editarCadastroDoUsuario(Usuario usuario) throws DatabaseException {
		String sql = "UPDATE T_FNT_USUARIO SET nm_completo = ?, dt_nascimento = ?, ds_genero = ?, "
				+ "tx_email = ?, im_foto = ? "
				+ "WHERE nr_cpf = ?";
	try {
		connection = ConnectionManager.getInstance().getConnection();
		pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, usuario.getNomeCompleto());
		pstmt.setDate(2, Date.valueOf(usuario.getDataDeNascimento()));
		pstmt.setString(3, usuario.getGenero());
		pstmt.setString(4, usuario.getEmail());
		
		File arquivoImagem = usuario.getImagemFoto();
        if (arquivoImagem != null) {
            try {
                InputStream inputStream = new FileInputStream(arquivoImagem);
                pstmt.setBinaryStream(5, inputStream);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                throw new DatabaseException("Erro ao carregar o arquivo de imagem.", e);
            }
        } else {
            pstmt.setNull(5, java.sql.Types.BLOB);
        }
        
        pstmt.setLong(6, usuario.getNumeroDoCPF());
		pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DatabaseException("Erro ao editar o Cadastro do Usuario.");
		} finally {
			if (pstmt != null) {
	            try {
	                pstmt.close();
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
	}
		
	@Override
	public boolean isSenhaValida(String senhaParaValidacao) {
		String regex = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$";
	    return senhaParaValidacao != null && senhaParaValidacao.matches(regex);
	    
	}
	
	@Override
	public void alterarSenhaDoUsuario(String novaSenha, Usuario usuario) throws DatabaseException {
		String sql = "UPDATE T_FNT_LOGIN SET tx_senha = ? WHERE nr_cpf = ?";
		
		if (isSenhaValida(novaSenha)) {
			try {
				connection = ConnectionManager.getInstance().getConnection();
				pstmt = connection.prepareStatement(sql);
				usuario.setSenha(novaSenha);
				pstmt.setString(1, usuario.getSenha());
				pstmt.setLong(2, usuario.getNumeroDoCPF());
				pstmt.executeUpdate();
			} catch (SQLException e) {
				
			} finally {
					if (pstmt != null) {
			            try {
			                pstmt.close();
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
			} else {
				throw new DatabaseException("Senha Invalida.");
			}
		}

//***************************************************************************************
	
public void salvarImagemDoBanco(String caminhoDestino, Usuario usuario) throws DatabaseException {
	 String sql = "SELECT im_foto FROM T_FNT_USUARIO WHERE nr_cpf = ?";
	       
	        try {
	            connection = ConnectionManager.getInstance().getConnection();
	            pstmt = connection.prepareStatement(sql);
	            pstmt.setLong(1, usuario.getNumeroDoCPF());
	            rs = pstmt.executeQuery();
	            
	            if (rs.next()) {
	                byte[] imagemBytes = rs.getBytes("im_foto");
	                if (imagemBytes != null) {
	                    File fileDestino = new File(caminhoDestino);
	                    try (OutputStream outputStream = new FileOutputStream(fileDestino)) {
	                        outputStream.write(imagemBytes);
	                        System.out.println("Imagem salva com sucesso em: " + caminhoDestino);
	                    }
	                } else {
	                    System.out.println("Nenhum imagem cadastrado no CPF: " + usuario.getNumeroDoCPF());
	                }
	            } else {
	                System.out.println("Usuário com CPF " + usuario.getNumeroDoCPF() + " não encontrado.");
	            }
	        } catch (SQLException | IOException e) {
	            e.printStackTrace();
	            throw new DatabaseException("Erro ao salvar imagem do banco.", e);
	        } finally {
	            if (rs != null) {
	                try {
	                    rs.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	            if (pstmt != null) {
	                try {
	                    pstmt.close();
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
	    }
	
	
//***************************************************************************************

	@Override
	public void validarLogin(String email, String senha) {
		// fazer uma verificacao no banco de email e senha 
		// e depois verificar se: email = email/ senha=senha???
		
	}

	@Override
	public void logarComGmail() {
		// estudar
		
	}

}
