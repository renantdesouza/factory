var adicionar = function() {
    UpGrowth.http({
        method: 'POST',
        url: 'rest/spending/add',
        data: UpGrowth.util.buildObj()
    }).done(function() {
        alert('Sucesso ao comprar produto');
    }).fail(function() {
        alert('Erro ao comprar produto');
    });
};