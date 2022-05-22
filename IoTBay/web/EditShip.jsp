<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="./css/style.css" />
        <title>Edit Shipment</title>
        <header class="main-header">
            <nav>
                <h1 id="logo"><a href="./index.jsp">IoTBay</a></h1>
                <ul>
                    <li><a href="./register.jsp">Register</a></li>
                    <li><a href="./login.jsp">Login</a></li>
                    <li><a href="./FindOrder.jsp">Order</a></li>
                    <li><a href="./Shipping.jsp">Shipping</a></li>
                </ul>
            </nav>
    </head>
    <body>
        <%
            String shipped = (String) session.getAttribute("shipped");
        %>
        <h1>Edit Existing Shipment</h1>
        <p>You can edit your shipment details here.</p>
        <form method="post" action="./EditShippingServlet">
            <table>
            <tr><td>ShippingID:</td><<td><input type="text" name="shippingID" required></td></tr>
            <tr><td>OrderID:</td><<td><input type="text" name="orderID" required><</td></tr>
            <tr><td>UserID:</td><<td><input type="text" name="userID" required></td></tr>
            <tr><td>ProductID:</td><<td><input type="text" name="productID" required></td></tr>
            <tr><td>Date:</td><<td><input type="date" name="date" required></td></tr>
            <tr><td>Address:</td><<td><input type="text" name="address" required></td></tr>
            <<td><a href="Shipping.jsp" class="button"> Submit</a>
            <<td><a href="Shipping.jsp" class="button"> Cancel</a>     
            </table>
        </form>
    </body>
</html>
