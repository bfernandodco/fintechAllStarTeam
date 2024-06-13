<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fintech</title>
    <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/heroes/">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/home.css" rel="stylesheet">
    <%@ include file="header.jsp" %>
</head>
<body class="bg-light">

    <div class="container">
        <div class="d-flex gap-3">
            <div class="d-flex flex-column flex-grow-1">
                <div class="d-flex justify-content-between boxes p-5 mb-4">
                    <div class="d-flex align-items-center">
                        <h4>Saldo</h4>
                    </div>
                    <div>
                        <div class="d-flex justify-content-between mb-3">
                        <p class="me-3">No dia</p>
                        <p class="me-3">Na semana</p>
                        <p class="text-primary text-decoration-underline">Último mês</p>
                        </div>
                        <h4 class="text-primary">VALOR SALDO</h4>
                    </div>
                </div>
                <div class="d-flex justify-content-between boxes p-5 mb-4">
                    <div>
                        <h4>Recebimentos</h4>
                    </div>
                    <div>
                        <div class="d-flex justify-content-between mb-3">
                            <p class="me-3">No dia</p>
                            <p class="me-3">Na semana</p>
                            <p class="text-primary text-decoration-underline">Último mês</p>
                            </div>
                        <h4 class="text-primary">RECEBIMENTOS</h4>
                    </div>
                </div>
                <div class="d-flex justify-content-between boxes p-5 mb-3">
                    <div>
                        <h4>Gastos</h4>
                    </div>
                    <div>
                        <div class="d-flex justify-content-between mb-3">
                            <p class="me-3">No dia</p>
                            <p class="me-3">Na semana</p>
                            <p class="text-primary text-decoration-underline">Último mês</p>
                        </div>
                        <h4 class="text-primary">GASTOS</h4>
                    </div>
                </div>
            </div>
            <div class="boxes p-4 flex-grow-1">
                <h4 class="mb-3">Novo Lançamento</h4>
                <form>
                    <div class="d-flex justify-content-around mb-3">
                        <label class="form-check-label">
                            <input type="radio" class="form-check-input" name="tipo" value="entrada">
                            Entrada
                        </label>
                        <label class="form-check-label ms-3">
                            <input type="radio" class="form-check-input" name="tipo" value="saida">
                            Saída
                        </label>
                    </div>
                    <div class="mb-3">
                        <label for="dataHora" class="form-label">Data e Hora</label>
                        <input type="datetime-local" class="form-control" id="dataHora">
                    </div>
                    <div class="mb-3">
                        <label for="categoria" class="form-label">Categoria</label>
                        <select class="form-select" id="categoria">
                            <option value="">Selecione uma categoria</option>
                            <option value="1">Aluguel</option>
                            <option value="2">Condomínio</option>
                            <option value="3">Mercado</option>
                            <option value="4">Combustível</option>
                            <option value="5">Medicamentos</option>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="valor" class="form-label">Valor</label>
                        <input type="text" class="form-control" id="valor">
                    </div>
                    <div class="mb-3">
                        <label for="descricao" class="form-label">Descrição</label>
                        <textarea class="form-control" id="descricao" rows="3"></textarea>
                    </div>
                    <div class="d-flex justify-content-between">
                        <div class="mb-3 form-check">
                            <input type="checkbox" class="form-check-input" id="checkbox" onclick="toggleObjectiveDropdown()">
                            <label class="form-check-label" for="checkbox">Vincular este lançamento a um objetivo</label>
                        </div>
                        <button type="button" class="btn btn-primary btn-sm px-4 mt-4">Adicionar</button>
                    </div>
                    <div class="mb-3 d-none" id="objectiveDropdown">
                        <label for="objetivo" class="form-label">Objetivo</label>
                        <select class="form-select" id="objetivo">
                            <option value="">Selecione um objetivo</option>
                            <option value="opcao1">Viagem Disney</option>
                            <option value="opcao2">Carro novo</option>
                        </select>
                    </div>
                </form>
            </div>
        </div>
        <div class="boxes p-5 mt-3">
            <h4>Últimos Lançamentos</h4>
            <table class="table table-striped mt-4">
                <thead>
                    <tr>
                        <th>Data</th>
                        <th>Hora</th>
                        <th>Categoria</th>
                        <th>Valor</th>
                        <th>Descrição</th>
                        <th>Ação</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>10/06/2024</td>
                        <td>10:00</td>
                        <td>Mercado</td>
                        <td>R$ 150,00</td>
                        <td>Compra de alimentos</td>
                        <td><button class="btn btn-primary btn-sm">Editar</button></td>
                        <td><button class="btn btn-danger btn-sm">Excluir</button></td>
                    </tr>
                    <tr>
                        <td>09/06/2024</td>
                        <td>14:30</td>
                        <td>Combustível</td>
                        <td>R$ 200,00</td>
                        <td>Abastecimento do carro</td>
                        <td><button class="btn btn-primary btn-sm">Editar</button></td>
                        <td><button class="btn btn-danger btn-sm">Excluir</button></td>
                    </tr>
                    <tr>
                        <td>08/06/2024</td>
                        <td>09:15</td>
                        <td>Aluguel</td>
                        <td>R$ 1.500,00</td>
                        <td>Pagamento do aluguel</td>
                        <td><button class="btn btn-primary btn-sm">Editar</button></td>
                        <td><button class="btn btn-danger btn-sm">Excluir</button></td>
                    </tr>
                    <tr>
                        <td>07/06/2024</td>
                        <td>13:45</td>
                        <td>Condomínio</td>
                        <td>R$ 400,00</td>
                        <td>Pagamento do condomínio</td>
                        <td><button class="btn btn-primary btn-sm">Editar</button></td>
                        <td><button class="btn btn-danger btn-sm">Excluir</button></td>
                    </tr>
                </tbody>
            </table>

            <div class="container mt-2">
                <div class="d-flex justify-content-center">
                    <nav aria-label="Page navigation example">
                        <ul class="pagination">
                            <li class="page-item">
                                <a class="page-link" href="#" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                            <li class="page-item"><a class="page-link" href="#">1</a></li>
                            <li class="page-item"><a class="page-link" href="#">2</a></li>
                            <li class="page-item"><a class="page-link" href="#">3</a></li>
                            <li class="page-item">
                                <a class="page-link" href="#" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>

        </div>
    </div>
    <script src="resources/js/lancamentos.js"></script>
    <%@ include file="footer.jsp" %>
</body>
</html>