<%-- 
    Document   : login
    Created on : Oct 8, 2020, 2:39:26 PM
    Author     : 815138
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="post" action="login">
            Username: <input type="text" name="username" value="${username}"><br>
            Password: <input type="text" name="password" value="${password}"}><br>
            <input type="submit" valuue="Log in">
        </form>
        <p>${message}</p>
    </body>
</html>
