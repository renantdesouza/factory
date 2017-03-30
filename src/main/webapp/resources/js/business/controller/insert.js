Upgrowth = Upgrowth || {}

Upgrowth.insert = function(type) {
    return function() {
        UpGrowth.http({
            method: 'POST',
            url: 'rest/' + type + '/insert',
            data: UpGrowth.util.buildObj()
        }).done(function() {
            //TODO COLOCAR MENSAGEM DE SUCESSO E ERRO, PENSANDO NO BUNDLE
            alert('Sucesso ao cadastrar cliente');
        }).fail(function() {
            alert('Erro ao cadastrar cliente');
        });
    }
}