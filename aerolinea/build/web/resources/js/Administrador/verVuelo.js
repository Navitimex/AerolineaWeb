/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function loaded(event) {
    events(event);
}

function events(event) {
    cargar_Vuelos();

}


{
    
var vuelos = [];
function cargar_Vuelos() {

    $.ajax({
        type: "GET",
        url: "/aerolinea/api/cliente/verVuelos",
        contentType: "application/json"
    }).then((vueloRest) => {
        vuelos = vueloRest;
        console.log(vuelos);
        cargarVuelos(vueloRest);
    },
            (error) => {
        alert(error.status);
    }
    );
}

function cargarVuelos(vueloRest) {
    $("#lista-vuelos").html("");
    console.log(vueloRest);
    vueloRest.forEach((vueloRest) => {
        llenarVuelos(vueloRest);

    });
}

function llenarVuelos(vueloRest) {
    let idVuelo = vueloRest.id;
    let horarioVuelo = vueloRest.Horario_id.dia_semana + " de " + vueloRest.Horario_id.hora_salida + " a " + vueloRest.Horario_id.hora_llegada;
    let rutaVuelo = vueloRest.Horario_id.ruta_codigo.origen.nombre + " - " + vueloRest.Horario_id.ruta_codigo.destino.nombre;
    let avionVuelo = vueloRest.Avion_id.id + " - " + vueloRest.Avion_id.marca + " " + vueloRest.Avion_id.modelo;
    let precioVuelo = vueloRest.Horario_id.ruta_codigo.precio;
    $("#lista-vuelos").append(
            "<tr>" +
            "<td>" +
            idVuelo +
            " </td>" +
            "<td>" +
            horarioVuelo +
            " </td>" +
            "<td>" +
            rutaVuelo +
            "</td>" +
            "<td>" +
            avionVuelo +
            "</td>" +
            "<td>" + "&#x20a1;" +
            precioVuelo +
            "</td>" +
            "</tr>"
            );
}
}


ocument.addEventListener("DOMContentLoaded", loaded);