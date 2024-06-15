package br.com.fiap.fintech.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fintech.bean.Investimento;
import br.com.fiap.fintech.dao.InvestimentoDAO;
import br.com.fiap.fintech.exception.DatabaseException;
import br.com.fiap.fintech.factory.DAOFactory;

@WebServlet("/investimento")
public class InvestimentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InvestimentoDAO investimentoDAO;
       
    public InvestimentoServlet() {
        super();
    }

    @Override
	public void init(ServletConfig config) throws ServletException {
    	investimentoDAO = DAOFactory.getInvestimentoDAO();
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("metodo post");
			String nomeDaAplicacao = request.getParameter("nome");
			System.out.println(nomeDaAplicacao);
			String bancoDaAplicacao = request.getParameter("banco");
			System.out.println(bancoDaAplicacao);
			String tipoDaAplicacao = request.getParameter("tipo");
			System.out.println(tipoDaAplicacao);
			Double valorDaAplicacao = Double.parseDouble(request.getParameter("valor"));
			System.out.println(valorDaAplicacao);
			Double valorDaRentabilidade = Double.parseDouble(request.getParameter("rentabilidade"));
			System.out.println(valorDaRentabilidade);
			Date dataHoraEntrada = Date.valueOf(request.getParameter("dataHoraEntrada"));
			System.out.println(dataHoraEntrada);
			Date dataHoraVencimento = Date.valueOf(request.getParameter("dataHoraVencimento"));
			System.out.println(dataHoraVencimento);
			//String objetivoDaAplicacao = request.getParameter("objetivo");
			
			String numeroDoCPF = "31176731050L";
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

}
