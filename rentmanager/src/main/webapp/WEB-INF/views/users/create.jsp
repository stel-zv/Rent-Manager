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
                        <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/users/create">

                            <div class="box-body">
                                <div class="form-group">
                                    <label for="last_name" class="col-sm-2 control-label">Nom</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="last_name" name="last_name" placeholder="Nom" required pattern=".{3,}" required>
                                    </div>

                                </div>
                                <div class="form-group">
                                    <label for="first_name" class="col-sm-2 control-label">Prenom</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="first_name" name="first_name" placeholder="Prenom"required pattern=".{3,}" required>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="email" class="col-sm-2 control-label">Email</label>
                                    <div class="col-sm-10">
                                        <input type="email" class="form-control" id="email" name="email" placeholder="Email" onchange="checkEmail()" required>
                                    </div>
                                </div>

                                 <div class="form-group">
                                    <label for="naissance" class="col-sm-2 control-label">Date de naissance</label>
                                    <div class="col-sm-10">
                                        <input type="date" class="form-control" id="naissance" name="naissance" onchange="isAdult()" required>
                                    </div>
                                </div>

                            </div>
                            <!-- /.box-body -->
                            <div class="box-footer">
                                <button type="submit" class="btn btn-info pull-right" id="addbtn">Ajouter</button>
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

<%@ include file="/WEB-INF/views/common/js_imports.jsp" %>

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

function checkEmail(){
    const listEmail = [
            <c:forEach items="${clients}" var="client" >
                '${client.email}',
            </c:forEach>
                        ];
    let email = $('#email').val();
    if (listEmail.includes(email)) {
        $('#addbtn').prop('disabled', true);
        alert('Cette adresse e-mail est deja utilisee');}
    else{
        $('#addbtn').prop('disabled', false);
       }
    }

</script>
</body>
</html>
