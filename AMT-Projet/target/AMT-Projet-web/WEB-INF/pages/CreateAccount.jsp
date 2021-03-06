<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <!-- Always force latest IE rendering engine (even in intranet) & Chrome Frame -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Create account</title>

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
    <div class="login-card">
        <div class="login-top">
            <h1>Create Account</h1>
        </div>
        <div class="login-bot">

            <c:if test="${error == null && OK != null}">
                <div class="alert alert-success alert-dismissible" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <strong>Well done!</strong> ${OK}
                </div>
            </c:if>
            <c:if test="${error != null && OK == null}">
                <div class="alert alert-warning alert-dismissible" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <strong>Warning!</strong> ${error} ${PasswordNotSimilar} ${badUserName} ${badPassword} ${badEmail} ${UserNameAlreadyUsed}
                </div>
            </c:if>


            <form method="post" action="CreateAccount">
                <p>
                    ${first_name}
                    <input type="text" name="firt_name" placeholder="firstname" id="first_name" <c:if test="${first_name != null && error != null}">value="${first_name}" </c:if>/>
                    <input type="text" name="last_name" placeholder="lastname" id="last_name"  <c:if test="${last_name != null && error != null}">value="${last_name}" </c:if>/>
                <p>
                    <input type="text" name="userName" placeholder="Username" id="userName" <c:if test="${UserNameAlreadyUsed != null && badUserName != null}">value="${userName}" </c:if>/>
                    <input type="password" name="password" placeholder="Password" id="password"/>
                    <input type="password" name="passwordRep" placeholder="Password bis" id="passwordRep"/>
                    <input type="text" name="email" placeholder="E-mail" id="email" <c:if test="${badEmail == null && error != null}">value="${email}" </c:if>/>

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
