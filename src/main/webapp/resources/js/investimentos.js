
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
