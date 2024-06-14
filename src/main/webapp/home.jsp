<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Fintech</title>
<link rel="canonical"
	href="https://getbootstrap.com/docs/5.3/examples/heroes/">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/home.css"
	rel="stylesheet">
<%@ include file="header.jsp"%>
</head>

<body class="bg-light">
	<div>
		<h2 class=" margin-left">Olá ${usuario.getNomeCompleto()}</h2>
	</div>
	<div
		class="conteudo p-3 d-flex flex-wrap container-fluid justify-content-around">
		<section class="lancamento">
			<article class="p-3">
				<h3>Resumo de Lançamentos</h3>
				<div class="d-flex justify-content-around mb-3">
					<p class="text-primary text-decoration-underline">No dia</p>
					<p>Na semana</p>
					<p>No mês</p>
				</div>
				<div class="p-2 mb-3 b-box">
					<h5>Saldo Atual</h5>
					<h4 class="text-primary">SALDO DOS LANÇAMENTOS</h4>
				</div>
				<div class="p-2 mb-3 b-box">
					<h5>Total de Recebimentos</h5>
					<h4>TOTAL RECEBIMENTOS</h4>
				</div>
				<div class="p-2 mb-3 b-box">
					<h5>Total de Gastos</h5>
					<h4>TOTAL GASTOS</h4>
				</div>
				<div class="p-2 mb-3 b-box">
					<h5>Último Valor Gasto</h5>
					<h4>ULTIMO VALOR GASTO</h4>
				</div>
				<div class="d-flex justify-content-center">
					<button type="button" class="btn btn-primary btn-sm px-4 mt-4"
						data-bs-toggle="modal" data-bs-target="#modalLancamento">+
						Novo Lançamento</button>
				</div>

				<div class="modal" id="modalLancamento" tabindex="-1"
					aria-labelledby="modalLancamentoLabel" aria-hidden="true">
					<div class="modal-dialog modal-dialog-centered">
						<div class="modal-content">
							<div class="modal-header">
								<h4 class="modal-title text-primary" id="modalLancamentoLabel">Novo
									Lançamento</h4>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div class="modal-body">
								<form>
									<div class="d-flex justify-content-around mb-3">
										<label class="form-check-label"> <input type="radio"
											class="form-check-input" name="tipo" value="entrada">
											Entrada
										</label> <label class="form-check-label ms-3"> <input
											type="radio" class="form-check-input" name="tipo"
											value="saida"> Saída
										</label>
									</div>
									<div class="mb-3">
										<label for="dataHora" class="form-label">Data e Hora</label> <input
											type="datetime-local" class="form-control" id="dataHora">
									</div>
									<div class="mb-3">
										<label for="categoria" class="form-label">Categoria</label> <select
											class="form-select" id="categoria">
											<option value="">Selecione uma categoria</option>
											<option value="1">Aluguel</option>
											<option value="2">Condomínio</option>
											<option value="3">Mercado</option>
											<option value="4">Combustível</option>
											<option value="5">Medicamentos</option>
										</select>
									</div>
									<div class="mb-3">
										<label for="valor" class="form-label">Valor</label> <input
											type="text" class="form-control" id="valor">
									</div>
									<div class="mb-3">
										<label for="descricao" class="form-label">Descrição</label>
										<textarea class="form-control" id="descricao" rows="3"></textarea>
									</div>
									<div class="mb-3 form-check">
										<input type="checkbox" class="form-check-input" id="checkbox">
										<label class="form-check-label" for="checkbox">Vincular
											este lançamento a um objetivo</label>
									</div>
									<div class="mb-3">
										<label for="objetivo" class="form-label">Objetivo</label> <select
											class="form-select" id="objetivo">
											<option value="">Selecione um objetivo</option>
											<option value="opcao1">Viagem Disney</option>
											<option value="opcao2">Carro novo</option>
										</select>
									</div>
								</form>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-bs-dismiss="modal">Fechar</button>
								<button type="button" class="btn btn-primary">Adicionar</button>
							</div>
						</div>
					</div>
				</div>


			</article>
		</section>
		<section class="investimento">
			<article class="p-3">
				<h3>Resumo de Investimentos</h3>
				<div class="d-flex justify-content-around mb-3">
					<p class="text-primary text-decoration-underline">No dia</p>
					<p>Na semana</p>
					<p>No mês</p>
				</div>
				<div class="p-2 mb-3 b-box">
					<h5>Total de Investimentos</h5>
					<h4 class="text-primary">TOTAL DE INVESTIMENTOS</h4>
				</div>
				<div class="p-2 mb-3 b-box">
					<h5>Último Investimento</h5>
					<h4>TOTAL DE INVESTIMENTOS</h4>
				</div>
				<div class="p-2 mb-3 b-box">
					<h5>Montante Rentabilizado</h5>
					<h4>MONTANTE</h4>
				</div>
				<div class="p-2 mb-3 b-box">
					<h5>Último Invest. Realizado</h5>
					<h4>MONTANTE</h4>
					<p>Nome: ${investimento.getNomeDoInvestimento()}</p>
					<p>Data liquidação: ${investimento.getDataDeVencimento()}</p>
				</div>
				<div class="d-flex justify-content-center">
					<button type="button" class="btn btn-primary btn-sm px-4 mt-4"
						data-bs-toggle="modal" data-bs-target="#modalInvestimento">+
						Novo Investimento</button>
				</div>

				<div class="modal" id="modalInvestimento" tabindex="-1"
					aria-labelledby="modalInvestimentoLabel" aria-hidden="true">
					<div class="modal-dialog modal-dialog-centered">
						<div class="modal-content">
							<div class="modal-header">
								<h4 class="modal-title text-primary" id="modalInvestimentoLabel">Novo
									Investimento</h4>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div class="modal-body">
								<form action="investimento" method="post">
									<div class="mb-3">
										<label for="nomeAplicacao" class="form-label">Nome da
											Aplicação</label> 
											<input type="text" class="form-control"
											id="nomeAplicacao" name="nome">
									</div>
									<div class="mb-3">
										<label for="banco" class="form-label">Banco</label> <select
											class="form-select" id="banco" name="banco">
											<option value="">Selecione um banco</option>
											<option value="bradesco">Bradesco</option>
											<option value="itau">Itau</option>
											<option value="santander">Santander</option>
											<option value="nubank">Nubank</option>
											<option value="next">Next</option>
										</select>
									</div>
									<div class="mb-3">
										<label for="tipoInvestimento" class="form-label">Tipo
											de Investimento</label> 
											<select class="form-select"
											id="tipoInvestimento" name="tipo">
											<option value="">Selecione um tipo</option>
											<option value="poupanca">Poupança</option>
											<option value="tesouroDireto">Tesouro Direto</option>
											<option value="CDB">CDB</option>
											<option value="CRI">CRI</option>
											<option value="LCA">LCA</option>
											<option value="LCI">LCI</option>
										</select>
									</div>
									<div class="mb-3">
										<label for="valorInvestimento" class="form-label">Valor
											do investimento</label> 
											<input type="text" class="form-control"
											id="valorInvestimento" name="valor">
									</div>
									<div class="mb-3">
										<label for="rentabilidade" class="form-label">Rentabilidade</label>
										<input type="text" class="form-control" id="rentabilidade" name="rentabilidade">
									</div>
									<div class="mb-3">
										<label for="dataEntrada" class="form-label">Data de
											entrada</label> 
											<input type="date" class="form-control"
											id="dataEntrada" name="dataHoraEntrada">
									</div>
									<div class="mb-3">
										<label for="dataVencimento" class="form-label">Data de
											vencimento</label> 
											<input type="date" class="form-control"
											id="dataVencimento" name="dataHoraVencimento">
									</div>
									<div class="mb-3 form-check">
										<input type="checkbox" class="form-check-input"
											id="vinculoInvestimentoObjetivo"> <label
											class="form-check-label" for="vinculoInvestimentoObjetivo">Vincular
											este lançamento a um objetivo</label>
									</div>
									<div class="mb-3">
										<label for="objetivoInvestimento" class="form-label">Objetivo</label>
										<select class="form-select" id="objetivoInvestimento" name="objetivo">
											<option value="">Selecione um objetivo</option>
											<option value="opcao1">Viagem Disney</option>
											<option value="opcao2">Carro novo</option>
										</select>
									</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-bs-dismiss="modal">Fechar</button>
								<button type="submit" class="btn btn-primary">Adicionar</button>
							</div>
								</form>
							</div>
						</div>
					</div>
				</div>

			</article>
		</section>
		<section class="objetivo">
			<article class="p-3">
				<h3>Objetivos</h3>
				<div class="d-flex">
					<h5>${objetivo.getNomeDoObjetivo()}</h5>
					<p>${objetivo.getDataDeVencimento()}</p>
				</div>

				<figure class="custom-figure">
					<img src="resources/images/image 1.png" alt="imagem disney"
						class="img-fluid">
				</figure>

				<div class="d-flex">
					<h6 class="text-primary">Valor Atual:
						${objetivo.getValorAtual()}</h6>
					<h6>Valor do Objetivo: ${objetivo.getValorDoObjetivo()}</h6>
				</div>

				<hr>
				<div>
					<div class="d-flex">
						<h5>${objetivo.getNomeDoObjetivo()}</h5>
						<p>${objetivo.getDataDeVencimento()}</p>
					</div>
					<figure class="custom-figure">
						<img src="resources/images/image 2.png" alt="imagem carro preto">
					</figure>
					<div class="d-flex">
						<h6 class="text-primary">Valor Atual:
							${objetivo.getValorAtual()}</h6>
						<h6>Valor do Objetivo: ${objetivo.getValorDoObjetivo()}</h6>
					</div>
				</div>
				<div class="d-flex justify-content-center">
					<button type="button" class="btn btn-primary btn-sm px-4 mt-4"
						data-bs-toggle="modal" data-bs-target="#modalObjetivo">+
						Novo Objetivo</button>
				</div>

				<div class="modal" id="modalObjetivo" tabindex="-1"
					aria-labelledby="modalObjetivoLabel" aria-hidden="true">
					<div class="modal-dialog modal-dialog-centered">
						<div class="modal-content">
							<div class="modal-header">
								<h4 class="modal-title text-primary" id="modalObjetivoLabel">Novo
									Objetivo</h4>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div class="modal-body">
								<form>
									<div class="mb-3">
										<label for="nomeObjetivo" class="form-label">Nome do
											Objetivo</label> <input type="text" class="form-control"
											id="nomeObjetivo">
									</div>
									<div class="mb-3">
										<label for="dataVencimentoObjetivo" class="form-label">Data
											de Vencimento</label> <input type="date" class="form-control"
											id="dataVencimentoObjetivo">
									</div>
									<div class="mb-3">
										<label for="valorObjetivo" class="form-label">Valor do
											Objetivo</label> <input type="text" class="form-control"
											id="valorObjetivo">
									</div>
									<div class="mb-3">
										<label for="descricaoObjetivo" class="form-label">Descrição</label>
										<textarea class="form-control" id="descricaoObjetivo" rows="3"></textarea>
									</div>
									<div class="mb-3 form-check">
										<input type="checkbox" class="form-check-input"
											id="vinculoObjetivoObjetivo"> <label
											class="form-check-label" for="vinculoObjetivoObjetivo">Vincular
											este objetivo a um investimento</label>
									</div>
									<div class="mb-3">
										<label for="investimentoObjetivo" class="form-label">Investimento</label>
										<select class="form-select" id="investimentoObjetivo">
											<option value="">Selecione um investimento</option>
											<option value="opcao1">Viagem Disney</option>
											<option value="opcao2">Carro novo</option>
										</select>
									</div>
								</form>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-bs-dismiss="modal">Fechar</button>
								<button type="button" class="btn btn-primary">Adicionar</button>
							</div>
						</div>
					</div>
				</div>
			</article>
		</section>
	</div>

	<div class="modal" id="modalObjetivo" tabindex="-1"
		aria-labelledby="modalObjetivoLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title text-primary" id="modalObjetivoLabel">Novo
						Objetivo</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form>
						<div class="mb-3">
							<label for="nomeObjetivo" class="form-label">Nome do
								Objetivo</label> <input type="text" class="form-control"
								id="nomeObjetivo">
						</div>
						<div class="mb-3">
							<label for="dataVencimentoObjetivo" class="form-label">Data
								de Vencimento</label> <input type="date" class="form-control"
								id="dataVencimentoObjetivo">
						</div>
						<div class="mb-3">
							<label for="valorObjetivo" class="form-label">Valor do
								Objetivo</label> <input type="text" class="form-control"
								id="valorObjetivo">
						</div>
						<div class="mb-3">
							<label for="descricaoObjetivo" class="form-label">Descrição</label>
							<textarea class="form-control" id="descricaoObjetivo" rows="3"></textarea>
						</div>
						<div class="mb-3 form-check">
							<input type="checkbox" class="form-check-input"
								id="vinculoObjetivoObjetivo"> <label
								class="form-check-label" for="vinculoObjetivoObjetivo">Vincular
								este objetivo a um investimento</label>
						</div>
						<div class="mb-3">
							<label for="investimentoObjetivo" class="form-label">Investimento</label>
							<select class="form-select" id="investimentoObjetivo">
								<option value="">Selecione um investimento</option>
								<option value="opcao1">Viagem Disney</option>
								<option value="opcao2">Carro novo</option>
							</select>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Fechar</button>
					<button type="button" class="btn btn-primary">Adicionar</button>
				</div>
			</div>
		</div>
	</div>
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>

	<%@ include file="footer.jsp"%>
</body>

</html>