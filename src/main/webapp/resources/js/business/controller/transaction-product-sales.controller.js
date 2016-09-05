var adicionar = function() {
    UpGrowth.http({
        method: 'POST',
        url: 'factory/rest/product/sale/add',
        data: UpGrowth.util.buildObj()
    }).done(function() {
        alert('Sucesso ao vender produto');
    }).fail(function() {
        alert('Erro ao vender produto');
    });
};

$('#datepicker').datepicker();

$('#clients').chosen({no_result_text: 'Não encontrado'});