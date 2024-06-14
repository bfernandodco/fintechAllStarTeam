package br.com.fiap.fintech.util.tests;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import br.com.fiap.fintech.bean.Investimento;
import br.com.fiap.fintech.bean.InvestimentoFechado;
import br.com.fiap.fintech.dao.InvestimentoDAO;
import br.com.fiap.fintech.factory.DAOFactory;

@SuppressWarnings("unused")
public class TesteInvestimentoDAO {

	public static void main(String[] args) {
		
		/*
		InvestimentoDAO dao = DAOFactory.getInvestimentoDAO();
		Investimento investimento = new Investimento(
				1,
				"Investimento C",
				TipoDeInvestimento.LCA,
				Banco.CAIXA_ECONOMICA,
				1.,
				LocalDate.now(),
				LocalDate.of(2028, 06, 30),
				2500.0);
		try {
			  dao.cadastrarNovoInvestimento(investimento);
			System.out.println("1");
			dao.lancarNovoInvestimentoAberto(investimento);
			System.out.println("Investimento cadastrado!");
		} catch (DBException e) {
			e.printStackTrace();
		}
		
		
		  Buscar um produto pelo codigo e editar
  		Investimento investimento = new Investimento(39,
  				"Investimento Ka",
  				TipoDeInvestimento.LCI,
  				Banco.INTER,
  				5.,
  				LocalDate.now(),
  				LocalDate.of(2028, 06, 30),
  				2500.0);
  		
  		dao.editarInvestimento(investimento);
  		System.out.println("Invetimento Editado.");
		
  		List<Investimento> lista = dao.listarInvestimentos();
  		for(Investimento item : lista) {
  			System.out.println(item.getNomeDoInvestimento() + " " 
  					+ item.getTipoDeInvestimento() + " " 
  					+ item.getBanco() + " " 
  					+ item.getValorDaRentabilidade() + " " 
  					+ item.getDataDeEntrada() + " " 
  					+ item.getDataDeVencimento() + " " 
  					+ item.getValorDeInvestimento());
  		}

		
		  Remover um investimento
  		try {
  			dao.excluirInvestimento("Investimento Ka");
  			System.out.println("Investimento Excluido.");
  		} catch(DBException e) {
  			e.printStackTrace();
  		}

  		InvestimentoAberto investimentoAberto = new InvestimentoAberto();
  		investimentoAberto.setChavePrimariaEstrantrangeira(41);
  		investimentoAberto.setMes(LocalDate.of(2023, 03, 15));
  		investimentoAberto.setValorTotalDoRendimento(0.0);
  		
  		dao.registrarFechamentoDeInvestimento(investimentoAberto);
  		System.out.println("Registrado");
  		dao.fecharInvestimento(investimentoAberto.getChavePrimariaEstrantrangeira());
  		System.out.println("Apagado");
		*/
	}
}
