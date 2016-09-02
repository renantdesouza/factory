/* *
 * Controlador para templates.
 * 
 * @author renantdesouza
 * @since 22/09/2015
 **/
var UpGrowth = UpGrowth || {};

UpGrowth.template = {};

// Carrega página dentro de um container (data não é necessário).
UpGrowth.template.load = function(url, container, data) {
    removerController();
    
    var deferred = $.Deferred();
	
    getTemplate(url)    
    .done(function(template) {
        // Coloca no cache o objeto para ser apresentado na tela.
        var html = template(data);
		$(container).html(html);
		
       /* UpGrowth.bundle.apply(container, UpGrowth.bundle._language)
        .done(function() {
			deferred.resolve();
		});*/
        
        adicionarController(container);
	});
	
	return deferred.promise();
};

// adiciona uma controller para executar javascript
var adicionarController = function(container) {
    var controller = $(container).find('[controller]').attr('controller');
    if (controller) {
        var script = document.createElement('script'); 
        script.setAttribute('src', 'resources/js/business/controller/' + controller + '.js');

        var head = document.getElementsByTagName('head')[0];
        head.insertBefore(script, head.firstChild);   
    }
};

// remove a controller antiga, para que outra possa ser usada
var removerController = function() {
    var head = document.getElementsByTagName('head')[0];
    var first = head.firstChild;
    if (first.src && first.src.indexOf('controller') != -1) {
        head.removeChild(first);        
    }
}

// Mantém o objeto em cache.
var _cache = {};

// Captura o template pela url.
var getTemplate = function(url) {
	var deferred = $.Deferred();
	if(_cache[url]) {
		deferred.resolve(_cache[url]);
	} else {
		$.get(url).done(function(result) {
			var compiled = Handlebars.compile(result);
			deferred.resolve(_cache[url] = compiled);
		});
	}
	
	return deferred.promise();
};