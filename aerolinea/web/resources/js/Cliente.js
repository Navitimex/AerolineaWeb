
function loaded(event) {
    events(event);
}

function events(event) {
    cargar_Vuelos();
    cargar_Destinos();
    cargar_Rutas();
    //cargar_Aviones();
    //cargar_Horarios();
}

//------------------------Cargar todos los estudiantes matriculados en al menos un curso-----------------------------Inicio---
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
            "<td>" +
            precioRuta +
            " </td>" +
             "<td>" +
            descuentoRuta +
            " </td>" +
            "</tr>"
            );
}
}



function login() {
    var cliente = {
        id: $("#idLogin").val(),
        contrasena: $("#password").val()
    };
    $.ajax({
        url: "/aerolinea/api/cliente/login",
        type: "post",
        contentType: "application/json",
        data: JSON.stringify(cliente),
        success: function (clienteRest) {
            console.log(clienteRest);
            console.log(cliente);
            if (clienteRest.id === parseInt(cliente.id, 16) && clienteRest.contrasena === cliente.contrasena) {
                window.location.href = "/aerolinea/Vistas/Cliente/ClienteIndex.jsp";
            } else {
                $("#estadoLogin").append('<div class="alert alert-danger" role="alert">Usuario o contraseña incorrectos, favor intente nuevamente</div>');
            }
            if (clienteRest.id === parseInt(cliente.id, 16) && clienteRest.contrasena === cliente.contrasena && clienteRest.rol === 1) {
                window.location.href = "/aerolinea/Vistas/Administrador/AdministradorIndex.jsp";
            } else {
                $("#estadoLogin").append('<div class="alert alert-danger" role="alert">Usuario o contraseña incorrectos, favor intente nuevamente</div>');
            }
        },
        statusCode: {
            404: function () {
                console.log("Estamos mamando");
                window.location.href = "/aerolinea/Vistas/Cliente/500.jsp";
            },
            500: function () {
                console.log("El servidor esta mamando");
                window.location.href = "/aerolinea/Vistas/Cliente/404.jsp";
            }
        }
    });

}

function registrar() {


    // $('#spinnerWaiter').show();
    let cliente = {
        id: 1,
        contrasena: ($("#input_contrasena").val()),
        rol: 1,
        nombre: $('#input_nombre').val(),
        apellidos: $('#input_apellios').val(),
        correo: $('#input_email').val(),
        fec_naci: $('#input_nacimiento').val().toLocaleDateString(),
        direccion: $('#input_direccion').val(),
        tel_trabajo: $('#input_tel_trabajo').val(),
        tel_cel: $('#input_celular').val()
                // contrasena1: $('#input_contrasena1').val()
    };
    console.log(cliente);
    $.ajax({
        url: "/aerolinea/api/cliente/registrar",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(cliente),

        success: function (clienteRest) {
            console.log("Todo bien si se insertó");
            console.log(clienteRest);
            console.log(cliente);
            // $('html').scrollTop(0);
            // $('#spinnerWaiter').hide();
            //$('#alertasuccess').show();

        }, statusCode: {
            404: function () {
                console.log("Estamos mamando");
                window.location.href = "/aerolinea/Vistas/Cliente/500.jsp";
            },
            500: function () {
                console.log("No se pudo insertar el horario");
                window.location.href = "/aerolinea/Vistas/Cliente/404.jsp";
            }
        }

    });

}

function limpiarCampos() {
    $('#input_contrasena').val('');
    $('#input_nombre').val('');
    $('#input_apellios').val('');
    $('#input_email').val('');
    $('#input_nacimiento').val('');
    $('#clave_registro').val('');
    $("#input_direccion").text('');
    $("#input_tel_trabajo").val('');
    $('#email').val('');
    $('#input_celular').val('');
}


document.addEventListener("DOMContentLoaded", loaded);