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
            success: function (clienteRe) {
                console.log(clienteRe);
                if (clienteRe === "puto") {
                    window.location.href = "https://youtu.be/Pz2wEeM-SJ4";
                } else {
                    window.location.href = "https://youtu.be/Pz2wEeM-SJ4";
                }
            },
            statusCode: {
                404: function () {
                    console.log("Estamos mamando");
                },
                500: function () {
                    console.log("El servidor esta mamando");
                }
            }
        });
    
}