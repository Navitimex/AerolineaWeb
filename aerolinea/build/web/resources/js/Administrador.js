
function insertarAvion() {
    let avion = {
        id:  1,
        anio: ($("#input_anio").val()),
        modelo: ($("#input_modelo").val()),
        marca: $('#input_marca').val(),
        can_asientos: $('#input_canasientos').val(),
    };
    console.log(avion);
    $.ajax({
        url: "/aerolinea/api/administrador/insertarAvion",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(avion),

        success: function (avionRest) {
            console.log("Todo bien si se inserto el avion");
            console.log(avionRest);
            console.log(avion);
            window.location.href = "/aerolinea/Vistas/Administrador/AdministradorIndex.jsp";

        }, statusCode: {
            404: function () {
                console.log("Estamos mamando");
                window.location.href = "/aerolinea/Vistas/Administrador/500.jsp";
            },
            500: function () {
                console.log("No se pudo insertar el horario");
                window.location.href = "/aerolinea/Vistas/Administrador/404.jsp";
            }
        }

    });

}

function logout() {

    sessionStorage.clear();
    sessionStorage.removeItem("cliente");
    window.location.href = "/aerolinea/Vistas/Cliente/Login.jsp";

}

function insertarDestino() {
    let destino = {
        id:  1,
        nombre: ($("#input_nombre").val()),
    };
    console.log(destino);
    $.ajax({
        url: "/aerolinea/api/administrador/insertarDestino",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(destino),

        success: function (destinoRest) {
            console.log("Todo bien si se inserto el Destino");
            console.log(destinoRest);
            console.log(destino);
            window.location.href = "/aerolinea/Vistas/Administrador/AdministradorIndex.jsp";

        }, statusCode: {
            404: function () {
                console.log("Estamos mamando");
                window.location.href = "/aerolinea/Vistas/Administrador/500.jsp";
            },
            500: function () {
                console.log("No se pudo insertar el horario");
                window.location.href = "/aerolinea/Vistas/Administrador/404.jsp";
            }
        }

    });

}