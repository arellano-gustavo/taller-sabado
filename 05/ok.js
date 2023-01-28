// https://es.javascript.info/xmlhttprequest

function httpGet2(url) {
    var req = new XMLHttpRequest();
    req.responseType = 'json';
    req.open('GET', url, true);
    var jsonResponse;

    req.onload  = function() {
      jsonResponse = req.response;
      console.log(jsonResponse);
      //alert("Abre tu consola bebé");
    
    let llaves = Object.keys(jsonResponse);
    let valores = Object.values(jsonResponse);
      
    for (var i = 0; i < llaves.length; i++) {
      var el = document.createElement('option');
      el.innerHTML = llaves[i];
      el.value = i;
      selector.appendChild(el);
    }

    var e = document.getElementById("selector");
    e.onchange=show;
    show();
    function show() {
      var index = e.options[e.selectedIndex].value;
      console.log('Se ha seleccionado: ' + llaves[index] + ' = ' + valores[index]);
      document.getElementById("info").innerHTML = valores[index];
    }
  };

  req.send(null);
}

var edo = false;

function state() {
  edo = !edo;
  if (edo) {
    httpGet2("https://api.binance.com/api/v1/ticker/24hr?symbol=XRPBTC");
    return;
  }
  removeOptions(document.getElementById('selector'));
  document.getElementById("info").innerHTML = "";
}

function removeOptions(selectElement) {
  var i, L = selectElement.options.length - 1;
  for(i = L; i >= 0; i--) {
     selectElement.remove(i);
  }
}

