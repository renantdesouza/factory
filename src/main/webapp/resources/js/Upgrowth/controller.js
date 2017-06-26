/* *
 * Controlador para inserção de objetos.
 *
 * @author renantdesouza.
 * @since 30/03/2017.
 */
Upgrowth = Upgrowth || {};

Upgrowth.controller = Upgrowth.controller || {};

// insert é o método utilizado para os modelos
Upgrowth.controller.insert = function(type) {
    return post('rest/' + type + '/insert');
};

// add é o método utilizado nas transactions
Upgrowth.controller.add = function(type) {
    return post('rest/' + type + '/add');
}

Upgrowth.controller.get = function(type) {
    return get('rest/' + type + '/find-all');
}

// usado para adicionar objeto com uma chamada http
var post(url) {
    return function() {
        Upgrowth.http({
            method: 'POST',
            url: url,
            data: UpGrowth.util.buildObj()
        }).done(function() {
            //TODO COLOCAR MENSAGEM DE SUCESSO E ERRO, PENSANDO NO BUNDLE

            UpGrowth.
            alert('Sucesso ao cadastrar cliente');
        }).fail(function() {
            alert('Erro ao cadastrar cliente');
        });
    }
}

var get(url) {
    return function() {
        Upgrowth.http.get(url)
        .done(function() {
        }).fail(function() {
        });
    }
}

