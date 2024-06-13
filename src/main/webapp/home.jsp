<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>

		<meta charset="UTF-8">
		<title>Fintech</title>

		<link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/heroes/">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
		<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/css/home.css" rel="stylesheet">
		<%@ include file="header.jsp" %>
	</head>

	<body class="bg-light">
		<div class="p-3">
			<h2>Olá ${usuario.getNomeCompleto()}</h2>
		</div>

		<div class="d-flex justify-content-around pb-3">
			<div class="lancamentos boxes p-5">
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
					<button type="button" class="btn btn-primary btn-sm px-4 mt-4" data-bs-toggle="modal"
						data-bs-target="#modalLançamento">+ Novo Lançamento</button>
				</div>
			</div>

			<div class="modal" id="modalLançamento" tabindex="-1" aria-labelledby="modalLançamento" aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered">
					<div class="modal-content">
						<div class="modal-header">
							<h4 class="modal-title text-primary" id="staticBackdropLabel">Novo Lançamento</h4>
							<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
						</div>
						<!-- Corpo da modal -->
						<div class="modal-body">
							<form>
								<!-- Radio buttons de entrada e saída -->
								<div class="mb-3">
									<label class="form-check-label">
										<input type="radio" class="form-check-input" name="tipo" value="entrada">
										Entrada
									</label>
									<label class="form-check-label ms-3">
										<input type="radio" class="form-check-input" name="tipo" value="saida">
										Saída
									</label>
								</div>

								<!-- Dropdowns -->
								<div class="mb-3">
									<label for="dataHora" class="form-label">Data e Hora</label>
									<input type="datetime-local" class="form-control" id="dataHora">
								</div>
								
								<div class="mb-3">
									<label for="categoria" class="form-label">Categoria</label>
									<select class="form-select" id="categoria">
										<option value="">Selecione...</option>
										<option value="1">Aluguel</option>
										<option value="2">Condomínio</option>
										<option value="3">Mercado</option>
										<option value="4">Combustível</option>
										<option value="5">Medicamentos</option>
									</select>
								</div>

								<!-- Input de valor e descrição -->
								<div class="mb-3">
									<label for="valor" class="form-label">Valor</label>
									<input type="text" class="form-control" id="valor">
								</div>
								<div class="mb-3">
									<label for="descricao" class="form-label">Descrição</label>
									<textarea class="form-control" id="descricao" rows="3"></textarea>
								</div>

								<!-- Checkbox -->
								<div class="mb-3 form-check">
									<input type="checkbox" class="form-check-input" id="checkbox">
									<label class="form-check-label" for="checkbox">Checkbox</label>
								</div>

								<!-- Outro dropdown -->
								<div class="mb-3">
									<label for="outroDropdown" class="form-label">Outro Dropdown</label>
									<select class="form-select" id="outroDropdown">
										<option value="">Selecione...</option>
										<option value="opcao1">Opção 1</option>
										<option value="opcao2">Opção 2</option>
									</select>
								</div>
							</form>
						</div>

						<!-- Rodapé da modal com botões -->
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fechar</button>
							<button type="button" class="btn btn-primary">Salvar</button>
						</div>
					</div>
				</div>
			</div>

			<div class="investimentos boxes p-5">
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
					<button type="button" class="btn btn-primary btn-sm px-4 mt-4" data-bs-toggle="modal"
						data-bs-target="#staticBackdrop">+ Novo Investimento</button>
				</div>
			</div>

			<div class="objetivos boxes p-5">
				<div>
					<h3>Objetivos</h3>
					<div class="d-flex">
						<h5>${objtivo.getNomeDoObjetivo()}</h5>
						<p>${objetivo.getDataDeVencimento()}</p>
					</div>
					<figure>
						<img src="resources/images/image 1.png" alt="imagem disney">
					</figure>
					<div class="d-flex">
						<h6 class="text-primary">Valor Atual: ${objtivo.getValorAtual()}</h6>
						<h6>Valor do Objetivo: ${objtivo.get.ValorDoObjetivo()}</h6>
					</div>
				</div>
				<hr>
				<div>
					<div class="d-flex">
						<h5>${objtivo.getNomeDoObjetivo()}</h5>
						<p>${objetivo.getDataDeVencimento()}</p>
					</div>
					<figure>
						<img src="resources/images/image 2.png" alt="imagem carro preto">
					</figure>
					<div class="d-flex">
						<h6 class="text-primary">Valor Atual: ${objtivo.getValorAtual()}</h6>
						<h6>Valor do Objetivo: ${objtivo.get.ValorDoObjetivo()}</h6>
					</div>
				</div>
				<div class="d-flex justify-content-center">
					<button type="button" class="btn btn-primary btn-sm px-4 mt-4" data-bs-toggle="modal"
						data-bs-target="#staticBackdrop">+ Novo Objetivo</button>
				</div>
			</div>
		</div>

		<%@ include file="footer.jsp" %>
	</body>

	</html>