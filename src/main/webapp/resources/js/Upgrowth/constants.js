var UpGrowth = UpGrowth || {};

UpGrowth.constants = {
    url: '/page',
    client: 'client'
};

// Retorna o valor a URL relativa a partir da dependência
UpGrowth.constants.getDependency = function(name) {
    return 'rest/' + UpGrowth.constants[name] + '/find-all';
};

UpGrowth.constants.addWatcher = function(name, fn) {
    // TODO CRIAR O ESQUEMA PARA EXECUTAR O WATCHER.
};
