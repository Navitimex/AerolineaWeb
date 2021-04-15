<!doctype html>
<html class="h-100" lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Ver detinos</title>
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
        <!-- page container area start -->
        <div class="page-container">
            <!-- sidebar menu area start -->
            <div class="sidebar-menu">
                <div class="sidebar-header">
                    <div class="logo">
                        <a href="/aerolinea/Vistas/Cliente/ClienteIndex.jsp"><h3>Aerolinea Keed</h3></a>
                    </div>
                    <br>
                    <h6 class="text-center" style="color: aliceblue"> <strong>Secci�n de destinos</strong></h6>
                </div>
                <div class="main-menu">
                    <div class="menu-inner">
                        <nav>
                            <ul class="metismenu" id="menu">
                                <li class="active"><a href="/aerolinea/Vistas/Cliente/ClienteIndex.jsp"><i class="fa fa-home"></i> <span>Inicio</span></a></li>
                                <li>
                                    <a href="javascript:void(0)"><i class="fa fa-align-justify"></i><span>Servicios</span></a>
                                    <ul class="collapse">
                                        <li><a href="/aerolinea/Vistas/Cliente/VerVuelos.jsp"><i class="fa fa-plane"></i> Ver Vuelos Disponibles</a></li>
                                        <li><a href="/aerolinea/Vistas/Cliente/VerDestinos.jsp"><i class="fa fa-flag"></i> Ver Destinos Disponibles</a></li>


                                    </ul>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
            <!-- sidebar menu area end -->
            <!-- main content area start -->
            <div class="container-fluid">
                <h3 class="text-dark mb-4" style="margin-top: 40px;">Vuelos disponibles</h3>
                <div class="card shadow">
                    <div class="card-header py-3">
                        <p class="text-primary m-0 font-weight-bold">Ac� pondremos algo</p>
                    </div>
                    <div class="card-body">
                        <div class="row">

                        </div>
                        <div class="table-responsive table mt-2" id="dataTable" role="grid" aria-describedby="dataTable_info">
                            <table class="table my-0" id="dataTable">
                                <thead>
                                    <tr>
                                        <th>Id</th>
                                        <th>Horario</th>
                                        <th>Ruta</th>
                                        <th>Avion</th>

                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        
                                        <td>Tokyo</td>
                                        <td>33</td>
                                        <td>2008/11/28</td>
                                        <td>$162,700</td>
                                    </tr>

                                </tbody>
                                <tfoot>
                                    <tr>
                                        <th>Id</th>
                                        <th>Horario</th>
                                        <th>Ruta</th>
                                        <th>Avion</th>

                                    </tr>
                                </tfoot>
                            </table>
                        </div>
                        <div class="row">
                            <div class="col-md-6 align-self-center">
                                <p id="dataTable_info" class="dataTables_info" role="status" aria-live="polite">Showing 1 to 10 of 27</p>
                            </div>
                            <div class="col-md-6">
                                <nav class="d-lg-flex justify-content-lg-end dataTables_paginate paging_simple_numbers">
                                    <ul class="pagination">
                                        <li class="page-item disabled"><a class="page-link" href="#" aria-label="Previous"><span aria-hidden="true">�</span></a></li>
                                        <li class="page-item active"><a class="page-link" href="#">1</a></li>
                                        <li class="page-item"><a class="page-link" href="#">2</a></li>
                                        <li class="page-item"><a class="page-link" href="#">3</a></li>
                                        <li class="page-item"><a class="page-link" href="#" aria-label="Next"><span aria-hidden="true">�</span></a></li>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- main content area end -->
            <!-- footer area start-->
            <footer>
                <div class="footer-area">
                    <p>� Copyright Aerolinea Keed.</p>
                </div>
            </footer>
            <!-- footer area end-->
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
