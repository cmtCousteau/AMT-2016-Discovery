<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <!-- Always force latest IE rendering engine (even in intranet) & Chrome Frame -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Login</title>
    <jsp:include page="includes/head.jsp" />
    <!-- /Zetta Menu CSS -->
</head>

<body>
<!-- Zetta Menu -->
<nav class="zetta-menu1 zm-css">
    <jsp:include page="includes/topbar.jsp" />
</nav>
<!-- /Zetta Menu -->
<div class="container">
    <div class="login-card">
        <div class="login-top">
            <h1>Login</h1>
        </div>
        <div class="login-bot">

            <c:choose>
                <c:when test="${error == null}">
                </c:when>
                <c:otherwise>
                    <div class="alert alert-warning alert-dismissible" role="alert">
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <strong>Warning!</strong> ${error}
                    </div>
                </c:otherwise>
            </c:choose>



            <form method="post" action="Login">
                <input type="text" name="userName" placeholder="Username">
                <input type="password" name="password" placeholder="Password">
                <input type="submit" name="login" class="login login-submit" value="login">
            </form>

            <form method="post" action="CreateAccount">
                <input type="submit" class="login login-submit" value="Register"/>
            </form>

            <div class="login-help">
                <a href="#">Forgot Password</a>
            </div>
        </div>
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
