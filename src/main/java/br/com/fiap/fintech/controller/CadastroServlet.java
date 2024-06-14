package br.com.fiap.fintech.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fintech.bean.Usuario;
import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.factory.DAOFactory;

@WebServlet("/cadastro")
public class CadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private UsuarioDAO dao;   
	
    public CadastroServlet() {
    	dao = DAOFactory.getUsuarioDAO();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nomeCompleto");
		Long cpf = Long.valueOf(request.getParameter("numeroDeCPF"));
		LocalDate dataDeNascimento = LocalDate.parse(request.getParameter("dataDeNascimento"));
		String genero = request.getParameter("genero");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String confirmarSenha = request.getParameter("confirmar-senha");
        
		Usuario usuario = new Usuario();
		usuario.setNomeCompleto(nome);
		usuario.setNumeroDeCPF(cpf);
		usuario.setDataDeNascimento(dataDeNascimento);
		usuario.setGenero(genero);
		usuario.setEmail(email);
		
		if(senha.equals(confirmarSenha)) {
			usuario.isSenhaValida(senha);
		}
		
		
		try {
			dao.cadastrarNovoUsuario(usuario);
			response.sendRedirect("home.jsp");
		} catch(Exception e) {
			 e.printStackTrace();
	         response.sendRedirect("login.jsp");
		} 
	}

}
