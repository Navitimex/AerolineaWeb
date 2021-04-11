<!doctype html>
<html class="h-100" lang="en">

    <head>
       <meta charset="UTF-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Login</title>
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

    <body >

        <div id="preloader">
            <div class="loader"></div>
        </div>

        <div class="login-area " id="loginArea">
            <div class="container">
                <div class="login-box ptb--100">
                    <form>
                        <div class="login-form-head">
                            <h4>Login</h4>
                            <p>Hello there, Sign in and start managing your Admin Template</p>
                        </div>
                        <div class="login-form-body">
                            <div class="form-gp">
                                <label for="exampleInputEmail1">Cedula</label>
                                <input type="id" id="idLogin" name="idLogin">
                                <i class="ti-email"></i>
                            </div>
                            <div class="form-gp">
                                <label for="exampleInputPassword1">Contrasena</label>
                                <input type="password" id="password" name="password" >
                                <i class="ti-lock"></i>
                            </div>
                            <div class="row mb-4 rmber-area">
                                <div class="col-6">
                                    <div class="custom-control custom-checkbox mr-sm-2">
                                        <input type="checkbox" class="custom-control-input" id="customControlAutosizing">
                                        <label class="custom-control-label" for="customControlAutosizing">Remember Me</label>
                                    </div>
                                </div>
                                
                            </div>
                            <div class="submit-btn-area">
                                <button type="button" onclick="login()"  >Ingresar <i class="ti-arrow-right"></i></button>
                                <div id="estadoLogin"> 

                                </div>
                            </div>
                            <div class="form-footer text-center mt-5">
                                <p class="text-muted">Don't have an account? <a href="/aerolinea/Vistas/Cliente/SingIn.jsp">Sign up</a></p>
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
