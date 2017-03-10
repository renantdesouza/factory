/* *
 * Grid para um tipo escificíco.
 *
 * @author renantdesouza.
 * @since 22/09/2015.
 **/
var UpGrowth = UpGrowth || {};

UpGrowth.grid = {};

UpGrowth.grid.items = [];

var _fields = []; 

UpGrowth.constants = UpGrowth.constants || {};
UpGrowth.constants.crescent = 'crescent';
UpGrowth.constants.decrescent = 'decrescent';

// inicializa o grid
UpGrowth.grid.init = function(items) {
    this.items = items;
    for(var i in items) {
        // define os fields que serão o cabeçalho do grid
        var item = items[i];
        for(var key in item) {
            _fields = key;
        }
        break;
    }
}; 

// ordena um array de objetos
UpGrowth.grid.order = function(param) {
    return UpGrowth.util.array[_order](this.items, param);
};

// caso a ordem seja crescente vira decrescente, caso decrescente vira crescente
UpGrowth.grid.changeOrder = function() {
    _order = (_order == UpGrowth.constants.crescent) ? UpGrowth.constants.decrescent : UpGrowth.constants.crescent;
};

// altera a ordem
UpGrowth.grid.setOrder = function(order) {
    _order = order;
};

// define qual o tipo de ordenação cria.
var _order = UpGrowth.grid.setOrder(UpGrowth.constants.crescent);