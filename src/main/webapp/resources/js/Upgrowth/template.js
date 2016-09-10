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
    removeController();
    
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
        
        addController(container);
        addDependency(container);
	});
	
	return deferred.promise();
};

// adiciona uma controller para executar javascript
var addController= function(container) {
    var controller = $(container).find('[controller]').attr('controller');
    if (controller) {
        var script = document.createElement('script'); 
        script.setAttribute('src', 'resources/js/business/controller/' + controller + '.js');

        var head = document.getElementsByTagName('head')[0];
        head.insertBefore(script, head.firstChild);   
    }
};

// remove a controller antiga, para que outra possa ser usada
var removeController = function() {
    var head = document.getElementsByTagName('head')[0];
    var first = head.firstChild;
    if (first.src && first.src.indexOf('controller') != -1) {
        head.removeChild(first);        
    }
}

// adiciona dependência na tela que será aberta
var addDependency = function(container) {
    var dependenciesAttr = $(container).find('[dependencies]').attr('dependencies');
    if (dependenciesAttr) {
        var dependencies = dependenciesAttr.split(',');
        for (var key in dependencies) {
            var dependency = dependencies[key];

            UpGrowth.http().get(UpGrowth.constants.getDependency(dependency))
            .done(function(data) {
                UpGrowth.cache[dependency] = data;
            }).fail(function() {
                //TODO RESOLVER COMO APLICAR ISSO.
                console.log('erro');
            });
        }
    }
};

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