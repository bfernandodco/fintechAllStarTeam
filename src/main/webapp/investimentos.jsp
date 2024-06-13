<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fintech</title>
    <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/heroes/">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/investimento.css" rel="stylesheet">
    
    <%@ include file="header.jsp" %>
</head>

<body class="bg-light">

    <div class="boxes p-5 m-5" id="infoTabela">
        <div class="d-flex">
            <p><strong>Nome: </strong></p> <span id="nomeInvestimento"></span>
        </div>
        <div class="d-flex">
            <p><strong>Banco: </strong></p> <span id="banco"></span>
        </div>
        <div class="d-flex">
            <p><strong>Tipo:</strong></p> <span id="tipoInvestimento"></span>
        </div>
    </div>
    <div class="boxes d-flex justify-content-around p-5 m-5">
        <div class="b-box p-5 align-items-center justify-content-center">
            <h5>Valor Investimento</h5>
            <h3 class="text-primary" id="valorInvestimento"></h3>
        </div>
        <div class="b-box p-5 align-items-center justify-content-center">
            <h5>Rentabilidade ao mês</h5>
            <h3 class="text-primary" id="rentabilidade"></h3>
        </div>
        <div class="b-box p-5 align-items-center justify-content-center">
            <h5>Data de Entrada</h5>
            <h3 class="text-primary" id="dtEntrada"></h3>
        </div>
        <div class="b-box p-5 align-items-center justify-content-center">
            <h5>Vencimento</h5>
            <h3 class="text-primary" id="dtVencimento"></h3>
        </div>
    </div>

    <div class="boxes p-5 m-5">
        <h4>Últimos Lançamentos</h4>
        <table id="tabela" class="table table-striped mt-4 table-hover">
            <thead class="thead-light">
                <tr>
                    <th>Nome</th>
                    <th>Tipo</th>
                    <th>Banco</th>
                    <th>Valor Investimento</th>
                    <th>Entrada</th>
                    <th>Rentabilidade</th>
                    <th>Vencimento</th>
                    <th>Ação</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Fundo A</td>
                    <td>Renda Fixa</td>
                    <td>Banco X</td>
                    <td>R$ 50.000,00</td>
                    <td>01/01/2023</td>
                    <td>5%</td>
                    <td>01/01/2024</td>
                    <td><button class="btn btn-primary">Editar</button></td>
                    <td><button class="btn btn-danger">Excluir</button></td>
                </tr>
                <tr>
                    <td>Tesouro Direto B</td>
                    <td>Renda Fixa</td>
                    <td>Tesouro Nacional</td>
                    <td>R$ 20.000,00</td>
                    <td>15/02/2023</td>
                    <td>3.5%</td>
                    <td>15/02/2025</td>
                    <td><button class="btn btn-primary">Editar</button></td>
                    <td><button class="btn btn-danger">Excluir</button></td>
                </tr>
                <tr>
                    <td>Ações C</td>
                    <td>Renda Variável</td>
                    <td>Corretora Y</td>
                    <td>R$ 30.000,00</td>
                    <td>20/03/2023</td>
                    <td>10%</td>
                    <td>N/A</td>
                    <td><button class="btn btn-primary">Editar</button></td>
                    <td><button class="btn btn-danger">Excluir</button></td>
                </tr>
                <tr>
                    <td>CDB D</td>
                    <td>Renda Fixa</td>
                    <td>Banco Z</td>
                    <td>R$ 40.000,00</td>
                    <td>10/04/2023</td>
                    <td>4.5%</td>
                    <td>10/04/2024</td>
                    <td><button class="btn btn-primary">Editar</button></td>
                    <td><button class="btn btn-danger">Excluir</button></td>
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

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <script>
        // Função para exibir informações do investimento ao clicar na tabela
        $(document).ready(function () {
            $('#tabela tbody').on('click', 'tr', function () {
                // Obter os dados da linha clicada
                var nomeInvestimento = $(this).find('td:eq(0)').text();
                var tipoInvestimento = $(this).find('td:eq(1)').text();
                var banco = $(this).find('td:eq(2)').text();
                var valorInvestimento = $(this).find('td:eq(3)').text();
                var dataEntrada = $(this).find('td:eq(4)').text();
                var rentabilidade = $(this).find('td:eq(5)').text();
                var vencimento = $(this).find('td:eq(6)').text();

                // Exibir os dados na div de informações
                $('#nomeInvestimento').text(nomeInvestimento);
                $('#tipoInvestimento').text(tipoInvestimento);
                $('#banco').text(banco);
                $('#valorInvestimento').text(valorInvestimento);
                $('#dtEntrada').text(dataEntrada);
                $('#rentabilidade').text(rentabilidade);
                $('#dtVencimento').text(vencimento);
            });
        });
    </script>
    <%@ include file="footer.jsp" %>
</body>

</html>
