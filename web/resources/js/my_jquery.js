/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



function generatePizza() {
    var price = document.getElementById('priceInput').value;
    var name = document.getElementById('nameInput').value;
    var description = document.getElementById('descriptionInput').value;

    const pizza = {
        name: name,
        price: price,
        description: description
    };
    const httpRequest = {
        headers: {
            "content-type": "application/json"
        },
        body: JSON.stringify(pizza),
        method: "POST"
    };
    fetch(url, httpRequest);
    //sendPizza(pizza);
}

console.log("in jQuery");
const url = 'http://localhost:8080/rest/add/';

function sendPizza(pizza) {
    jQuery.ajax({
        url: url,
        type: "POST",
        data: JSON.stringify(pizza),
        contentType: "application/json",
        success: function () {
            //
        }
    });
}
;





