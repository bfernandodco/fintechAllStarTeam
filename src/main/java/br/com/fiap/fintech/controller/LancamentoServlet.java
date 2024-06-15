package br.com.fiap.fintech.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fintech.bean.Lancamento;
import br.com.fiap.fintech.dao.LancamentoDAO;
import br.com.fiap.fintech.exception.DatabaseException;
import br.com.fiap.fintech.factory.DAOFactory;

@WebServlet("/lancamento")
public class LancamentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LancamentoDAO lancamentoDAO;
       
    public LancamentoServlet() {
        super();
    }

    @Override
	public void init(ServletConfig config) throws ServletException {
		lancamentoDAO = DAOFactory.getLancamentoDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String tipoDeLancamento = request.getParameter("tipo");
			Date dataHoraLancamento = Date.valueOf(request.getParameter("dataHora"));
			String categoriaDoLancamento = request.getParameter("categoria");
			Double valorDoLancamento = Double.parseDouble(request.getParameter("valor"));
			String descricaoDoLancamento = request.getParameter("descricao");
			String numeroDoCPF = "12345678977";
			Lancamento lancamento = new Lancamento(numeroDoCPF, dataHoraLancamento, valorDoLancamento, tipoDeLancamento, categoriaDoLancamento, descricaoDoLancamento);
			lancamentoDAO.cadastrarLancamento(lancamento);
		} catch(DatabaseException e) {
			request.setAttribute("error", "Erro ao cadastrar usuário.");
		} catch(Exception e) {
			request.setAttribute("error", "Dados inválidos. Tente novamente.");
		}
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	
	public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Double saldoTotal = lancamentoDAO.saldoRecebimentos();
			request.setAttribute("saldoTotal", saldoTotal);
		} catch(DatabaseException e) {
			request.setAttribute("error", "Erro ao cadastrar usuário.");
		} catch(Exception e) {
			request.setAttribute("error", "Dados inválidos. Tente novamente.");
		}
	}
}
