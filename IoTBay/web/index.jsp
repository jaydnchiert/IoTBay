<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="./css/style.css" />
        <title>IoTBay</title>
    </head>
    <body>
        <h1>IoTBay<h1>
        <p style="font-size:20px;">A Place to buy tech</p>
        <a href="./register.jsp">Register</a>
        <a href="./login.jsp">Login</a>
        <a href="./Order.jsp">Order</a>
        <a href="./Shipping.jsp">Shipping</a>
        
        <jsp:include page="/UserServlet" flush="true" />
</html>
