package br.com.fiap.fintech.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.fintech.bean.Login;
import br.com.fiap.fintech.bean.Usuario;
import br.com.fiap.fintech.dao.LoginDAO;
import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.factory.DAOFactory;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDAO usuarioDAO;
	private LoginDAO loginDAO;
	
    public LoginServlet() {
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
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			
			Long numeroDoCPF = usuarioDAO.validarUsuario(email);
			Login login = new Login(numeroDoCPF, senha);
			
			if(loginDAO.validarLogin(login)) {
				Usuario usuario = usuarioDAO.buscarUsuario(numeroDoCPF);
				HttpSession session = request.getSession();
				session.setAttribute("user", usuario.getNomeCompleto());
			} else {
				request.setAttribute("erro", "Email e/ou Senha inválidos");
			}
			request.setAttribute("message", "Login realizado com sucesso!");
		} catch(Exception e) {
			request.setAttribute("error", "Email ou Senha incorretos.");
		}
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}
}
