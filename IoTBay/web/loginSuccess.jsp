<%@page import="ioTBay.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="./css/style.css" />
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
