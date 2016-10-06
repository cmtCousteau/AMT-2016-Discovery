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
    <div class="table-responsive">
        <table class="table table-striped">
            <tr>
                <th>Username</th>
                <th>Passord</th>
                <th>Mod</th>
            </tr>

            <c:forEach items="${usersList}" var="item">
                <tr>
                    <td>${item.userName}</td>
                    <td>${item.password}</td>
                    <td>
                        <a href="#">
                            <img title="zettaMenu logo image"
                                 src="upload/glyphicons_free/glyphicons/png/glyphicons-208-remove.png">
                        </a>
                        <a href="#">
                            <img title="zettaMenu logo image"
                                 src="upload/glyphicons_free/glyphicons/png/glyphicons-151-edit.png">
                        </a>
                    </td>
                </tr>

            </c:forEach>
            </tr>
        </table>
    </div>
</div>

<!-- jQuery -->
<script src="../../assets/js/jquery.min.js"></script>
<!-- /jQuery -->
<!-- Zetta JS -->
<script type="text/javascript" src="assets/js/zetta.menu.jquery.js"></script>
<script>
    jQuery(".zetta-menu1").zettaMenu({"sticky": false, "showOn": "click"});
</script>
<!-- /Zetta JS -->
</body>

</html>
