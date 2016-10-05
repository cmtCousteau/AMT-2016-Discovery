<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <!-- Always force latest IE rendering engine (even in intranet) & Chrome Frame -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Zetta Menu generated in Z Menu Maker</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <!-- Font Awesome -->
    <link rel="stylesheet" type="text/css" media="screen" href="assets/css/font-awesome.min.css"
    />
    <!-- /Font Awesome -->
    <!-- Zetta Menu CSS -->
    <link rel="stylesheet" type="text/css" media="screen" href="assets/css/zetta.menu.css"
    />

    <link rel="stylesheet" type="text/css" media="screen" href="assets/css/bootstrap.css"
    />
    <link rel="stylesheet" type="text/css" media="screen" href="assets/css/custom.css"
    />
    <!-- /Zetta Menu CSS -->
</head>

<body>
<!-- Zetta Menu -->
<nav class="zetta-menu1 zm-css">
    <input type="checkbox" id="zm-switchzetta-menu1"/>
    <ul onclick="">
        <li class=" zm-img">
            <a href="#">
                <img title="zettaMenu logo image" src="upload/logo.png">
            </a>
        </li>
        <li class=" zm-active"><a href="#">Home</a>
        </li>
        <li><a href="#">My Account</a>
        </li>
        <li class=" zm-right-item zm-search"><a><i class="zm-icon fa fa-search"></i></a>
            <div>
                <form action="">
                    <input type="text" class="zm-search-place" name="search" placeholder="Search">
                    <button type="submit" class="zm-search-button"><i class="zm-icon fa fa-search"></i>
                    </button>
                </form>
            </div>
        </li>
        <li class="zm-switch">
            <a>
                <label for="zm-switchzetta-menu1"><i class="fa fa-bars"></i>
                </label>
            </a>
        </li>
    </ul>
</nav>
<!-- /Zetta Menu -->
<div class="container">
    <div class="login-card">
        <div class="login-top">
            <h1>CreateAccount</h1>
        </div>
        <div class="login-bot">
            <form method="post" action="CreateAccount">
                <p>
                    <label for="userName">User name :</label>
                    <input type="text" name="userName" id="userName" />

                    <br />
                    <label for="password">Password :</label>
                    <input type="password" name="password" id="password" />

                    <input type="submit" class="login login-submit" value="Submit"/>
                    <br />
                    <a href="index.html"> return </a>
                </p>
            </form>

            <div class="login-help">
                <a href="index.html">Forgot Password</a>
            </div>
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
