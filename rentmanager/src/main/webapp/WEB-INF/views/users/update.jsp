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
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                Utilisateurs
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Horizontal Form -->
                    <div class="box">
                        <!-- form start -->
                        <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/users/update">
                            <div class="box-body">

                             <div class="form-group">
                                    <div class="col-sm-10">
                                        <input type="hidden" class="form-control" id="id" name="id" value="${client.id}" required>
                                    </div>
                            </div>

                                <div class="form-group">
                                    <label for="last_name" class="col-sm-2 control-label">Nom</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="last_name" name="last_name" value="${client.nom}" required>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="first_name" class="col-sm-2 control-label">Prenom</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="first_name" name="first_name" value="${client.prenom}" required pattern=".{3,}"required>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-sm-10">
                                        <input type="hidden" class="form-control" id="email" name="email" value="${client.email}" required pattern=".{3,}" required>
                                    </div>
                                </div>

                                 <div class="form-group">
                                    <label for="naissance" class="col-sm-2 control-label">Date de naissance</label>
                                    <div class="col-sm-10">
                                        <input type="date" class="form-control" id="naissance" value="${client.naissance}" name="naissance" onchange="isAdult()" required>
                                    </div>
                                </div>

                            </div>
                            <!-- /.box-body -->
                            <div class="box-footer">
                                <button type="submit" class="btn btn-info pull-right" id="addbn" >Modifier le client</button>
                            </div>
                            <!-- /.box-footer -->
                        </form>
                    </div>
                    <!-- /.box -->
                </div>
                <!-- /.col -->
            </div>
        </section>
        <!-- /.content -->
    </div>

    <%@ include file="/WEB-INF/views/common/footer.jsp" %>
</div>
<!-- ./wrapper -->

<script>

function isAdult() {
     let birthday = new Date($('#naissance').val());
     let eighteenYearsAgo = new Date();
     eighteenYearsAgo.setFullYear(eighteenYearsAgo.getFullYear() - 18);
     if (birthday <= eighteenYearsAgo) {
        $('#addbtn').prop('disabled', false);
     }
     else {
        $('#addbtn').prop('disabled', true);
        alert('Le client doit etre majeur');
      }
}


</script>

<%@ include file="/WEB-INF/views/common/js_imports.jsp" %>
</body>
</html>
