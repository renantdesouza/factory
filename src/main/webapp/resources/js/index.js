$(document).ready(function() {
    
    var menu = document.getElementById('menu');
    var previous = document.getElementById('previous-img');
    var lastPage = [];
   
    // mostra o menu
    document.getElementById('header').onmouseover = function() {
        if (classie.toggle(menu, 'cbp-spmenu-open')) {
            $(previous).removeClass('fadeOut');
            $(previous).addClass('fadeIn');
        } else {
            $(previous).removeClass('fadeIn');
            $(previous).addClass('fadeOut');
        }
    };
    
    document.getElementById('insert').onclick = function() {
        open('insert');
    };

    document.getElementById('search').onclick = function() {
        open('search');
    };
    
    document.getElementById('transactions').onclick = function() {
        open('transactions');  
    };
    
    var open = function(template, dontPush) {
        UpGrowth.page.open(template, dontPush, template);
    }
 
    UpGrowth.page.open = function(template, dontPush, js) {
        if (!dontPush) {
            if (lastPage[lastPage.length - 1] !== template) {
                lastPage.push(template);
            }
        }
        UpGrowth.page.init(template + ".html");
        
        setTimeout(function() {
            if (js) {
                var script = document.createElement('script'); 
                script.setAttribute('src', 'resources/js/business/' + js + '.js');

                var head = document.getElementsByTagName('head')[0];
                head.insertBefore(script, head.firstChild);   
            }
        }, 100);
    }
    
    previous.onclick = function() {
        var page = lastPage[lastPage.length - 2];
        if (page) {
            open(page, false);    
            lastPage.pop();
            lastPage.pop();
        } else {
            if (confirm("Deseja mesmo sair do sistema?")) {
                window.history.back();    
            }
        }
    };

});