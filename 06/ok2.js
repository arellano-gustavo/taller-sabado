            var tradesCount        = 0,
                ordersCount        = 0,
                trades_output      = document.getElementById('trades-output'),
                //diff_orders_output = document.getElementById('diff-orders-output');
                orders_output      = document.getElementById('orders-output');

            websocket = new WebSocket('wss://ws.bitso.com');
            websocket.onopen = function() {
                websocket.send(JSON.stringify({ action: 'subscribe', book: 'eth_usd', type: 'trades' }));
                //websocket.send(JSON.stringify({ action: 'subscribe', book: 'btc_mxn', type: 'diff-orders' }));
                websocket.send(JSON.stringify({ action: 'subscribe', book: 'eth_usd', type: 'orders' }));
                console.log("inicio " + tiempo());
            };
            websocket.onclose = function() {
            	console.log("fin " + tiempo());
            };

            websocket.onmessage = function(message){
                console.log("tick: " + tiempo());
                var data = JSON.parse(message.data);

                /*if (data.type != 'ka')
                    console.log(data);*/

                if (data.type == 'trades' && data.payload) {
                    if (tradesCount == 0)
                        trades_output.innerHTML = '';

                    tradesCount++;

                    for (var i in data.payload) {
                        var trade = data.payload[i];

                        var child = document.createElement("div");
                        child.innerHTML = '[' + trade['i'] + '] ' + trade['a'] + ' ETH @ ' + trade['r'] + ' MXN = ' + trade['v'] + ' MXN';
                        trades_output.appendChild(child);
                    }
                }
                /*
                else if (data.type == 'diff-orders' && data.payload) {
                    if (ordersCount == 0)
                        diff_orders_output.innerHTML = '';

                    ordersCount++;

                    for (var j in data.payload) {
                        var order = data.payload[j];

                        var child = document.createElement("div");
                        var str = '[' + order['d'] + '] ';
                        str += (order['t'] == 0 ? 'buy' : 'sell') + ' order';
                        str += order['a'] ? ': ' + order['a'] + ' BTC @ ' + order['r'] + ' MXN = ' + order['v'] + ' MXN' : ' removed';
                        child.innerHTML = str;
                        diff_orders_output.appendChild(child);
                    }
                }*/
                else if (data.type == 'orders' && data.payload) {
                    orders_output.innerHTML = '';

                    for (var k in data.payload) {
                        var orders = data.payload[k];

                        var child = document.createElement("div");
                        child.innerHTML = '<h3>' + k + '</h3>';

                        for (var l in orders) {
                            var order = orders[l];

                            child.innerHTML += '[' + order['d'] + '] ' + order['a'] + ' ETH @ ' + order['r'] + ' MXN = ' + order['v'] + ' MXN<br/>';
                        }

                        orders_output.appendChild(child);
                    }
                }
            };
            
            function tiempo() {
                var current = new Date();
                return current.toLocaleTimeString();
            }


