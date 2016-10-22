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
<div class="container">
    Hello

    <div class="row">
        <ul class="gridder">


            <div class="image-cont">
                <li class="gridder-list gridder-list-first" data-griddercontent="#content1">
                    <div class="image"
                         style="background-image: url('http://ddragon.leagueoflegends.com/cdn/img/champion/splash/Jax_0.jpg');">
                        <div class="overlay">
                            <span class="title">Jax</span>
                            <br>
                            <span class="description">Grandmaster at Arms</span>
                        </div>
                    </div>
                </li>
                <li class="gridder-list" data-griddercontent="#content2">
                    <div class="image"
                         style="background-image: url('http://ddragon.leagueoflegends.com/cdn/img/champion/splash/Jax_0.jpg');">
                        <div class="overlay">
                            <span class="title">Jax</span>
                            <br>
                            <span class="description">Grandmaster at Arms</span>
                        </div>
                    </div>
                </li>
                <li class="gridder-list" data-griddercontent="#content3">
                    <div class="image"
                         style="background-image: url('http://ddragon.leagueoflegends.com/cdn/img/champion/splash/Jax_0.jpg');">
                        <div class="overlay">
                            <span class="title">Jax</span>
                            <br>
                            <span class="description">Grandmaster at Arms</span>
                        </div>
                    </div>
                </li>
            </div>
        </ul>
    </div>

    <!-- Gridder content -->
    <div id="content1" class="gridder-content">
        <div class="gridder-show" style="display: block; padding: 0px;">
            <div class="gridder-padding">
                <div class="gridder-expanded-content">
                    <img class="resize" title="zettaMenu logo image" src="upload/jax.png">
                    <div class="description animated fadeInUpC">
                        <h2>Jax</h2>
                        <br>
                        <h3>Grandmaster at Arms</h3>
                    </div>
                    <div class="description">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div id="content2" class="gridder-content">
        <div class="gridder-show" style="display: block; padding: 0px;">
            <div class="gridder-padding">
                <div class="gridder-expanded-content">
                    <img class="resize" title="zettaMenu logo image" src="upload/jax.png">
                    <div class="description animated fadeInUpC">
                        <h2>Jax</h2>
                        <br>
                        <h3>Grandmaster at Arms</h3>
                    </div>
                    <div class="description">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div id="content3" class="gridder-content">
        <div class="gridder-show" style="display: block; padding: 0px;">
            <div class="gridder-padding">
                <div class="gridder-expanded-content">
                    <img class="resize" title="zettaMenu logo image" src="upload/jax.png">
                    <div class="description animated fadeInUpC">
                        <h2>Jax</h2>
                        <br>
                        <h3>Grandmaster at Arms</h3>
                    </div>
                    <div class="description">
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- jQuery -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<script src="assets/js/jquery.min.js"></script>
<!-- /jQuery -->
<!-- Zetta JS -->
<script type="text/javascript" src="assets/js/zetta.menu.jquery.js"></script>
<script>
    jQuery(".zetta-menu1").zettaMenu({"sticky": false, "showOn": "click"});
</script>

<script src="plugins/gridder-master/dist/js/jquery.gridder.js"></script>

<script>
    $(function () {
        // Call Gridder
        $('.gridder').gridderExpander({
            scroll: true,
            scrollOffset: 30,
            scrollTo: "panel",                  // panel or listitem
            animationSpeed: 000,
            animationEasing: "easeInOutExpo",
            showNav: false,                      // Show Navigation
            nextText: "Next",                   // Next button text
            prevText: "Previous",               // Previous button text
            closeText: "Close",                 // Close button text
            onStart: function () {
                //Gridder Inititialized
            },
            onContent: function () {
                //Gridder Content Loaded
            },
            onClosed: function () {
                //Gridder Closed
            }
        });
    });
</script>
<!-- /Zetta JS -->
</body>

</html>
