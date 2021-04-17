/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function loaded(event) {
    events(event);
}

function events(event) {
   
    cargar_Destinos();
    

}

{
var destinos = [];
function cargar_Destinos() {
    $.ajax({
        type: "GET",
        url: "/aerolinea/api/cliente/verDestinos",
        contentType: "application/json"
    }).then((destinoRest) => {
        destinos = destinoRest;
        
        cargarDestinos(destinoRest);
    },
            (error) => {
        alert(error.status);
    }
    );
}

function cargarDestinos(destinoRest) {
    $("#lista-destinos").html("");
    console.log(destinoRest);
    destinoRest.forEach((destinoRest) => {
        llenarDestinos(destinoRest);
    });
}

function llenarDestinos(destinoRest) {
    let idDestinos= destinoRest.codigo;
    let nombreDestinos = destinoRest.nombre;
            $("#lista-destinos").append(
            "<tr>" +
            "<td>" +
            idDestinos +
            " </td>" +
            "<td>" +
            nombreDestinos +
            " </td>" +
            "</tr>"
            );
}
}

ocument.addEventListener("DOMContentLoaded", loaded);

