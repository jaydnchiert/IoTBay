<%@page import="ioTBay.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Success</title>
    </head>
    <body>
        <%
            User user = (User) session.getAttribute("user");
        %>
        <h1>Login Success</h1>
        <h2>Hi ${user.firstName} ${user.lastName}</h2>
        <p>Redirecting you to home page.</p>


    </body>
</html>
