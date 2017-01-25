<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <!-- Always force latest IE rendering engine (even in intranet) & Chrome Frame -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Users Manager</title>   
    <jsp:include page="includes/head.jsp"/>
    <!-- /Zetta Menu CSS -->
</head>

<body>
<!-- Zetta Menu -->
<nav class="zetta-menu1 zm-css">
    <jsp:include page="includes/topbar.jsp"/>
</nav>
<!-- /Zetta Menu -->
<div class="container"> 
    
    <form method="post" action="goodKarma">
           <input type="submit" name="login" class="login login-submit hvr-icon-float" value="create good karma">
    </form>
    
    <form method="post" action="giveSomeKarma">
           <input type="submit" name="login" class="login login-submit hvr-icon-float" value="give some good karma">
    </form>
    
    
    <!-- /.box-header -->
    <div class="box-body">

        <div class="box">
            <div class="box-header">
                <h3 class="box-title">Hover Data Table</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
                <table id="example2" class="table table-bordered table-hover">
                    <thead>
                    <tr>
                        <th>username</th>
                    </tr>
                    </thead>
                    <tbody>

                    </tbody>
                    <tfoot>
                    <tr>
                        <th>username</th>
                    </tr>
                    </tfoot>
                </table>
            </div>
            <!-- /.box-body -->
        </div>
        <!-- /.box -->
    </div>
</div>

<!-- jQuery -->
<script src="assets/js/jquery-3.1.1.js"></script>
<script src="assets/js/bootstrap.min.js"></script>

<script src="plugins/datatables/jquery.dataTables.min.js"></script>
<script src="plugins/datatables/dataTables.bootstrap.min.js"></script>
<!-- SlimScroll -->
<script src="plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="plugins/fastclick/fastclick.js"></script>
<!-- /jQuery -->
<!-- Zetta JS -->
<script type="text/javascript" src="assets/js/zetta.menu.jquery.js"></script>
<script type="text/javascript" src="assets/js/app.js"></script>
<script type="text/javascript" src="assets/js/demo.js"></script>

<script>
    jQuery(".zetta-menu1").zettaMenu({"sticky": false, "showOn": "click"});
</script>
<script>
    $(function () {
        $('#example2').DataTable({
            ajax: {
                headers: { "Accept": "*/*",
                            "token": "MyTest" },
                url: 'http://localhost:8090/api/users',
                dataSrc: "",
                'type': 'GET',
                'beforeSend': function (request) {
                            request.setRequestHeader(token, "MyTest");
                }
            },
            columns: [ {data: "id"}],
            "paging": true,
            "lengthChange": false,
            "searching": true,
            "ordering": true,
            "info": true,
            "autoWidth": false
        });
    });
</script>





</body>

</html>
