<%-- 
    Document   : logout
    Created on : 30 Mar 2022, 5:18:53 pm
    Author     : Jaydn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        session.invalidate();
    %>
    if loggedin = true;
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Logout</title>
        </head>
        <body>
            <h1>You have been logged out.</h1>
        </body>
    </html>
