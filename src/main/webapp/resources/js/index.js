$(document).ready(function() {

    var previous = document.getElementById('previous');
    var lastPage = [];

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
    
    document.getElementById('home').onclick = function() {
        //  TODO COLOCAR UM FUNDO DE TELA
        document.getElementsByClassName('template')[0].innerHTML = '';
        lastPage = [];
    };
    
    document.getElementById('insert-client').onclick = function() {
        UpGrowth.page.open('insert-client');
    };

    document.getElementById('insert-ingredient').onclick = function() {
        UpGrowth.page.open('insert-ingredient');
    };

    document.getElementById('insert-recipe').onclick = function() {
        UpGrowth.page.open('insert-recipe');
    };

    document.getElementById('insert-supplier').onclick = function() {
        UpGrowth.page.open('insert-supplier');
    };

    document.getElementById('search-client').onclick = function() {
        UpGrowth.page.open('search-client');
    };

    document.getElementById('search-ingredient').onclick = function() {
        UpGrowth.page.open('search-ingredient');
    };

    document.getElementById('search-recipe').onclick = function() {
        UpGrowth.page.open('search-recipe');
    };

    document.getElementById('search-supplier').onclick = function() {
        UpGrowth.page.open('search-supplier');
    };

    document.getElementById('search-buy').onclick = function() {
        UpGrowth.page.open('search-buy');
    };

    document.getElementById('search-sales').onclick = function() {
        UpGrowth.page.open('search-sales');
    };

    document.getElementById('transaction-product-buy').onclick = function() {
        UpGrowth.page.open('transaction-product-buy');
    };

    document.getElementById('transaction-product-sales').onclick = function() {
        UpGrowth.page.open('transaction-product-sales');
    };
    
    document.getElementById('transaction-spending').onclick = function() {
        UpGrowth.page.open('transaction-spending');
    };

});