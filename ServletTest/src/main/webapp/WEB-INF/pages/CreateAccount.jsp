<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <!-- Always force latest IE rendering engine (even in intranet) & Chrome Frame -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Create account</title>

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
            <h1>Create Account</h1>
        </div>
        <div class="login-bot">

                <c:if test="${error == null && OK != null}">
                    <div class="alert alert-success alert-dismissible" role="alert">
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <strong>Well done!</strong> ${OK}
                    </div>
                </c:if>
                <c:if test="${error != null && OK == null}">
                    <div class="alert alert-warning alert-dismissible" role="alert">
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <strong>Warning!</strong> ${error}
                    </div>
                </c:if>


            <form method="post" action="CreateAccount">
                <p>
                    <input type="text" name="name" placeholder="name" id="name" />
                    <input type="text" name="surname" placeholder="surname" id="surname" />

                    <input type="text" name="userName" placeholder="Username" id="userName" />
                    <input type="password" name="password" placeholder="Password" id="password" />
                    <input type="password" name="passwordRep" placeholder="Password bis" id="passwordRep" />
                    <input type="text" name="email" placeholder="E-mail" id="email" />

                    <input type="submit" class="login login-submit hvr-icon-float" value="Submit"/>
                </p>
            </form>
        </div>
    </div>
</div>

<!-- jQuery -->
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/bootstrap.js"></script>
<!-- /jQuery -->
<!-- Zetta JS -->
<script type="text/javascript" src="assets/js/zetta.menu.jquery.js"></script>
<script>
    jQuery(".zetta-menu1").zettaMenu({"sticky": false, "showOn": "click"});
</script>
<!-- /Zetta JS -->
</body>

</html>
