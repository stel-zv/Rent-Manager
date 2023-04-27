<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<%@include file="/WEB-INF/views/common/head.jsp"%>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <%@ include file="/WEB-INF/views/common/header.jsp" %>
    <!-- Left side column. contains the logo and sidebar -->
    <%@ include file="/WEB-INF/views/common/sidebar.jsp" %>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Main content -->
        <section class="content">

            <div class="row">
                <div class="col-md-3">

                    <!-- Profile Image -->
                    <div class="box box-primary">
                        <div class="box-body box-profile">
                            <h3 class="profile-username text-center">Reservation numero ${reservation.id} </h3>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
                <!-- /.col -->
                <div class="col-md-9">
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <div class="active tab-pane" id="rent">
                                <div class="box-body no-padding">
                                 <div class="box-body no-padding">
                                    <li class="list-group-item">
                                        <b>Informations generales</b>
                                    </li>
                                    <table class="table table-striped">
                                        <tr>
                                            <th style="width: 10px">#</th>
                                            <th>Date de debut</th>
                                            <th>Date de fin</th>
                                        </tr>
                                        <tr>
                                            <td>${reservation.id}.</td>
                                            <td>${reservation.debut}</td>
                                            <td>${reservation.fin}</td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                            <!-- /.tab-pane -->
                            <div class="tab-pane" id="car">
                                <!-- /.box-header -->

                                <div class="box-body no-padding"> <br>
                                    <li class="list-group-item">
                                        <b>Voiture</b>
                                    </li>
                                    <table class="table table-striped">
                                        <tr>
                                            <th style="width: 10px">#</th>
                                            <th>Constructeur</th>
                                            <th style=>Nombre de places</th>
                                        </tr>
                                         <tr>
                                             <td>${reservation.vehicle.id}.</td>
                                             <td>${reservation.vehicle.constructeur}</td>
                                             <td>${reservation.vehicle.nb_places}</td>
                                         </tr>
                                    </table>
                                </div>
                            </div>
                            <!-- /.tab-pane -->
                            <div class="tab-pane" id="user">
                                <!-- /.box-header -->
                                <div class="box-body no-padding"><br>
                                    <li class="list-group-item">
                                        <b>Client</b>
                                    </li>
                                    <table class="table table-striped">
                                        <tr>
                                            <th style="width: 10px">#</th>
                                            <th>Nom</th>
                                            <th>Prenom</th>
                                            <th>Email</th>
                                            <th>Date de naissance</th>
                                        </tr>
                                        <tr>
                                            <td>${reservation.client.id}.</td>
                                            <td>${reservation.client.nom}</td>
                                            <td>${reservation.client.prenom}</td>
                                            <td>${reservation.client.email}</td>
                                            <td>${reservation.client.naissance}</td>
                                         </tr>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <!-- /.tab-content -->
                    </div>
                    <!-- /.nav-tabs-custom -->
                </div>
                <!-- /.col -->
            </div>
            <!-- /.row -->

        </section>
        <!-- /.content -->
    </div>

    <%@ include file="/WEB-INF/views/common/footer.jsp" %>
</div>
<!-- ./wrapper -->

<%@ include file="/WEB-INF/views/common/js_imports.jsp" %>
</body>
</html>
