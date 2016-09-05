var adicionar = function() {
    UpGrowth.http({
        method: 'POST',
        url: 'factory/rest/product/buy/add',
        data: UpGrowth.util.buildObj()
    }).done(function() {
        alert('Sucesso ao comprar produto');
    }).fail(function() {
        alert('Erro ao comprar produto');
    });
};

$('#datepicker').datepicker();