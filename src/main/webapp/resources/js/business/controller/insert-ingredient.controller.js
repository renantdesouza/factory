var enviar = function() {
    UpGrowth.http({
        method: 'POST',
        url: 'rest/ingredient/insert',
        data: UpGrowth.util.buildObj()
    }).done(function() {
        alert('Sucesso ao cadastrar cliente');
    }).fail(function() {
        alert('Erro ao cadastrar cliente');
    });
};