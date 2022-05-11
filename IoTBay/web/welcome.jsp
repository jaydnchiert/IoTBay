<%@page import="ioTBay.Customer" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>
        <h1>Welcome!</h1>
        
        <%
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
        %>
        
        <p>Your name is <%= fname + " " + lname %></p>
        <p>Your email is <%= email %></p>
        <a href="./main.jsp"> Main</a>
        
        <%
            Customer customer = new Customer(fname, lname, email, password);
            session.setAttribute("customer", customer);
        %>
    </body>
</html>