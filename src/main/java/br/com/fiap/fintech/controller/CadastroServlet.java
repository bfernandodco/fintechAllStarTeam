package br.com.fiap.fintech.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.factory.DAOFactory;

@WebServlet("/cadastro")
public class CadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UsuarioDAO usuarioDAO;
	
    public CadastroServlet() {
        super();
    }

    @Override
	public void init(ServletConfig config) throws ServletException {
		super.init();
		usuarioDAO = DAOFactory.getUsuarioDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
