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
        fec_naci: $('#input_nacimiento').val(),
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
