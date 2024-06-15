package br.com.fiap.fintech.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fintech.bean.Investimento;
import br.com.fiap.fintech.bean.Usuario;
import br.com.fiap.fintech.dao.InvestimentoDAO;
import br.com.fiap.fintech.exception.DatabaseException;
import br.com.fiap.fintech.factory.DAOFactory;

@WebServlet("/investimento")
public class InvestimentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InvestimentoDAO investimentoDAO;
	Usuario usuario;
       
    public InvestimentoServlet() {
        super();
    }

    @Override
	public void init(ServletConfig config) throws ServletException {
    	investimentoDAO = DAOFactory.getInvestimentoDAO();
    	usuario = new Usuario();
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("metodo post");
			String nomeDaAplicacao = request.getParameter("nome");
			String bancoDaAplicacao = request.getParameter("banco");
			String tipoDaAplicacao = request.getParameter("tipo");
			Double valorDaAplicacao = Double.parseDouble(request.getParameter("valor"));
			Double valorDaRentabilidade = Double.parseDouble(request.getParameter("rentabilidade"));
			Date dataHoraEntrada = Date.valueOf(request.getParameter("dataHoraEntrada"));
			Date dataHoraVencimento = Date.valueOf(request.getParameter("dataHoraVencimento"));
			
			String numeroDoCPF = usuario.getNumeroDoCPF();
			Investimento investimento = new Investimento(numeroDoCPF, valorDaRentabilidade, dataHoraEntrada, dataHoraVencimento, valorDaAplicacao, nomeDaAplicacao, tipoDaAplicacao, bancoDaAplicacao, 1);
			System.out.println("Investimento criado");
			investimentoDAO.cadastrarInvestimento(investimento);
			System.out.println("Investimento enviado para DAO");
			
		} catch(DatabaseException e) {
			request.setAttribute("error", "Erro ao cadastrar usuário.");
		} catch(Exception e) {
			request.setAttribute("error", "Dados inválidos. Tente novamente.");
		}
	request.getRequestDispatcher("home.jsp").forward(request, response);
	}
    
    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Investimento> investimentos = investimentoDAO.listarInvestimentos(usuario.getNumeroDoCPF());
			request.setAttribute("investimentos", investimentos);
		} catch(Exception e) {
			request.setAttribute("error", "Dados inválidos. Tente novamente.");
		}
	}

}
