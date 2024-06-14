package br.com.fiap.fintech.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fintech.bean.Login;
import br.com.fiap.fintech.bean.Usuario;
import br.com.fiap.fintech.dao.LoginDAO;
import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.exception.DatabaseException;
import br.com.fiap.fintech.factory.DAOFactory;

@WebServlet("/cadastro")
public class CadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UsuarioDAO usuarioDAO;
    private LoginDAO loginDAO;
	
    public CadastroServlet() {
        super();
    }

    @Override
	public void init(ServletConfig config) throws ServletException {
		super.init();
		usuarioDAO = DAOFactory.getUsuarioDAO();
		loginDAO = DAOFactory.getLoginDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String nomeCompleto = request.getParameter("nome");
			Long numeroDoCPF = Long.parseLong(request.getParameter("cpf"));
			Date dataNascimento = Date.valueOf(request.getParameter("dataNascimento"));
			String genero = request.getParameter("genero");
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			
			Usuario usuario = new Usuario(numeroDoCPF, nomeCompleto, dataNascimento, genero, email);
			Login login = new Login(numeroDoCPF, senha);
			
			usuarioDAO.cadastrarUsuario(usuario);
			loginDAO.cadastrarLogin(login);
			
			request.setAttribute("message", "Cadastro realizado com sucesso!");
		} catch(DatabaseException e) {
			request.setAttribute("error", "Erro ao cadastrar usuário.");
		} catch(Exception e) {
			request.setAttribute("error", "Dados inválidos. Tente novamente.");
		}
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
}
