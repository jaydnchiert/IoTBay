<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@page import="ioTBay.Shipping"%>
<%@page import="ioTBay.ShippingDAO.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="./css/style.css" />
        <title>Delete Shipment</title>
        <header class="main-header">
            <nav>
                <h1 id="logo"><a href="./index.jsp">IoTBay</a></h1>
                <ul>
                    <li><a href="./register.jsp">Register</a></li>
                    <li><a href="./login.jsp">Login</a></li>
                    <li><a href="./Order.jsp">Order</a></li>
                    <li><a href="./Shipping.jsp">Shipping</a></li>
                </ul>
            </nav>
    </head>
        
    <body>
        <h1>Delete Shipment</h1>
        <form method="post" action="./DeleteShippingServlet"></form>
            <h2>Your shipment has been successfully deleted.</h2>
    </body>
</html>
