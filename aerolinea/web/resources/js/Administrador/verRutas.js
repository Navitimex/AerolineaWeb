/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function loaded(event) {
    events(event);
}

function events(event) {
 
    cargar_Rutas();

}


{
var rutas = [];
function cargar_Rutas() {
    $.ajax({
        type: "GET",
        url: "/aerolinea/api/cliente/verRutas",
        contentType: "application/json"
    }).then((rutaRest) => {
        rutas = rutaRest;
        cargarRutas(rutaRest);
    },
            (error) => {
        alert(error.status);
    }
    );
}

function cargarRutas(rutaRest) {
    $("#lista-rutas").html("");
   console.log("Hola mundo");
    console.log(rutaRest);
    rutaRest.forEach((rutaRest) => {
        llenarRutas(rutaRest);
    });
}

function llenarRutas(rutaRest) {
    let idRuta = rutaRest.codigo; 
    let destinoRuta = rutaRest.destino.nombre;
    let origenRuta = rutaRest.origen.nombre;
    let duracionRuta = rutaRest.duracionMin;
    let precioRuta = rutaRest.precio;
    let descuentoRuta = rutaRest.descuento;
            $("#lista-rutas").append(
            "<tr>" +
            "<td>" +
            idRuta +
            " </td>" +
            "<td>" +
            origenRuta +
            " </td>" +
             "<td>" +
            destinoRuta +
            " </td>" +
             "<td>" +
            duracionRuta +
            " </td>" +
            "<td>" + "&#x20a1;" +
            precioRuta +
            " </td>" +
             "<td>" + "&#x20a1;" +
            descuentoRuta +
            " </td>" +
            "</tr>"
            );
}
}


document.addEventListener("DOMContentLoaded", loaded);
