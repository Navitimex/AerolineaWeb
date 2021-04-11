<!doctype html>
<html class="h-100" lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Registro</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="shortcut icon" type="image/png" href="assets/images/icon/favicon.ico">
        <link rel="stylesheet" href="/aerolinea/assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="/aerolinea/assets/css/font-awesome.min.css">
        <link rel="stylesheet" href="/aerolinea/assets/css/themify-icons.css">
        <link rel="stylesheet" href="/aerolinea/assets/css/metisMenu.css">
        <link rel="stylesheet" href="/aerolinea/assets/css/owl.carousel.min.css">
        <link rel="stylesheet" href="/aerolinea/assets/css/slicknav.min.css">
        <!-- amchart css -->
        <link rel="stylesheet" href="https://www.amcharts.com/lib/3/plugins/export/export.css" type="text/css" media="all" />
        <!-- others css -->
        <link rel="stylesheet" href="/aerolinea/assets/css/typography.css">
        <link rel="stylesheet" href="/aerolinea/assets/css/default-css.css">
        <link rel="stylesheet" href="/aerolinea/assets/css/styles.css">
        <link rel="stylesheet" href="/aerolinea/assets/css/responsive.css">
        <!-- modernizr css -->
        <script src="/aerolinea/assets/js/vendor/modernizr-2.8.3.min.js"></script>
    </head>

    <body>

        <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
        <!-- preloader area start -->
        <div id="preloader">
            <div class="loader"></div>
        </div>
        <!-- preloader area end -->
        <!-- login area start -->
        <div class="login-area login-bg">
            <div class="container">
                <div class="login-box ptb--100">
                    <div class="alert alert-success alert-dismissible mt-4 mb-0" role="alert" style="display: none;" id="alertasuccess">
                        <h4 class="alert-heading">Registrado Correctamente!</h4>
                        <p>Usted ha sido registrado exitosamente en el sistema.</p>
                        <hr>
                        <p class="mb-0">Eventualmente se le avisará mediante el correo ingresado cuando tenga acceso al sistema 
                            y pueda matricular cursos una vez que un administrador de la piscina lo haya confirmado.</p>
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="alert alert-danger alert-dismissible mt-4 mb-0" role="alert" 
                         style="display: none; position: sticky; top: 0; z-index: 999;" id="alerta_error_registro">
                        <h4 class="alert-heading">Datos Incorrectos!</h4>
                        <hr>
                        <p class="mb-0" id="text_incorrect"></p>
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <form>
                        <div class="login-form-head">
                            <h4>Registro</h4>
                            <p>Estamos felices que te unas a nosotros</p>
                        </div>
                        <div class="login-form-body">
                            <div class="form-gp">
                                <label for="input_nombre">Nombre</label>
                                <input type="text" id="input_nombre" required>
                                <i class="ti-user"></i>
                            </div>
                            <div class="form-gp">
                                <label for="input_apellios">Apellidos</label>
                                <input type="text" id="input_apellios" required>
                                <i class="ti-user"></i>
                            </div>

                            <div class="form-gp">
                                <label for="input_email">Email address</label>
                                <input type="email" id="input_email" required>
                                <i class="ti-email"></i>
                            </div>

                            <div class="form-gp">
                                <label for="input_direccion">Dirección de residencia</label>
                                <input type="text" id="input_direccion" required>
                                <i class="ti-direction"></i>
                            </div>
                            <div class="form-gp">
                                <label for="input_tel_trabajo">Teléfono del trabajo</label>
                                <input type="tel" id="input_tel_trabajo" pattern="[0-9]{8}" title="Debe ser un número de 8 dígitos" required>
                                <i class="ti-headphone"></i>
                            </div>

                            <div class="form-gp">
                                <label for="input_celular">Teléfono celular</label>
                                <input type="tel" id="input_celular"  pattern="[0-9]{8}" title="Debe ser un número de 8 dígitos" required>
                                <i class="ti-headphone"></i>
                            </div>

                            <div class="form-gp">
                                <label for="input_nacimiento">Fecha de nacimiento</label>
                                <input type="date" id="input_nacimiento" required>
                                <i class="ti-calendar"></i>
                            </div>

                            <div class="form-gp">
                                <label for="input_contrasena">Password</label>
                                <input type="password" id="input_contrasena" required>
                                <i class="ti-lock"></i>
                            </div>
                            <div class="form-gp">
                                <label for="input_contrasena1">Confirm Password</label>
                                <input type="password" id="input_contrasena1" required>
                                <i class="ti-lock"></i>
                            </div>


                            <div class="submit-btn-area">
                                <button  type="button" onclick=" registrar()" >Enviar <i class="ti-arrow-right"></i></button>
                                <div class="spinner-border spinner-border-sm" id="spinnerWaiter" role="status" style="display: none;">
                                    <span class="sr-only">Cargando...</span>
                                </div>
                                <div class="login-other row mt-4">

                                </div>
                            </div>
                            <div class="form-footer text-center mt-1">
                                <p class="text-muted">Datos protegidos bajo la ley No.15483</p>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>






        <script src="/aerolinea/assets/js/vendor/jquery-2.2.4.min.js"></script>
        <!-- bootstrap 4 js -->
        <script src="/aerolinea/assets/js/popper.min.js"></script>
        <script src="/aerolinea/resources/js/Cliente.js"></script>
        <script src="/aerolinea/assets/js/bootstrap.min.js"></script>
        <script src="/aerolinea/assets/js/owl.carousel.min.js"></script>
        <script src="/aerolinea/assets/js/metisMenu.min.js"></script>
        <script src="/aerolinea/assets/js/jquery.slimscroll.min.js"></script>
        <script src="/aerolinea/assets/js/jquery.slicknav.min.js"></script>

        <!-- others plugins -->
        <script src="/aerolinea/assets/js/plugins.js"></script>
        <script src="/aerolinea/assets/js/scripts.js"></script>
    </body>

</html>
