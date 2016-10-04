<%-- 
    Document   : CreateAccount
    Created on : Sep 27, 2016, 1:39:39 PM
    Author     : marco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register account</title>
    </head>
    <body>
        <form method="post" action="CreateAccount">
            <p>
                <label for="userName">User name :</label>
                <input type="text" name="userName" id="userName" />

                <br />
                <label for="password">Password :</label>
                <input type="password" name="password" id="password" />

                <input type="submit" value="Submit"/>
            </p>
        </form>
    </body>
</html>
