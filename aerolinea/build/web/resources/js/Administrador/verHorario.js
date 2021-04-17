/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function loaded(event) {
    events(event);
}

function events(event) {
   
    cargar_Horario();
 
}


{
    
var horarios = [];
function cargar_Horario() {

    $.ajax({
        type: "GET",
        url: "/aerolinea/api/cliente/verHorarios",
        contentType: "application/json"
    }).then((horarioRest) => {
        horarios = horarioRest;
        console.log(horarios);
        cargarHorarios(horarioRest);
    },
            (error) => {
        alert(error.status);
    }
    );
}

function cargarHorarios(horarioRest) {
    $("#lista-horarios").html("");
    console.log(horarioRest);
    horarioRest.forEach((horarioRest) => {
        llenarHoraios(horarioRest);

    });
}

function llenarHoraios(horarioRest) {
    let idHoraios = horarioRest.id;
    let diaSemanaHoraios = horarioRest.dia_semana;
    let horaSalidaHoraios = horarioRest.hora_salida;
    let horaLlegadaHoraios = horarioRest.hora_llegada;
    let trayectoHoraios = horarioRest.ruta_codigo.origen.nombre + " - " +horarioRest.ruta_codigo.destino.nombre; 
    $("#lista-horarios").append(
            "<tr>" +
            "<td>" +
            idHoraios +
            " </td>" +
            "<td>" +
            diaSemanaHoraios +
            " </td>" +
            "<td>" +
            horaSalidaHoraios  +
            "</td>" +
            "<td>" +
             horaLlegadaHoraios+
            "</td>" +
            "<td>" +
            trayectoHoraios +
            "</td>" +
            "</tr>"
            );
}
}















document.addEventListener("DOMContentLoaded", loaded);

