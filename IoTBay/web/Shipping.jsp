<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="./css/style.css" />
        <title>Shipping</title>
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
        </header>
    </head>
    <body>
        <h1>Shipment Management</h1>
        <p>IoTBay allows you to create new shipping details, view and edit existing details.</p>
        <form method="post" action="./SearchShippingServlet">
            <li><a href ="./AddShip.jsp">Add New Shipment</a></li>
            <li><a href ="./EditShip.jsp">Edit Shipment</a></li>
            <li><a href="./DeleteShip.jsp">Delete Shipment</a></li>
        <p>Check Shipment with your tracking number below:</p>
        <table>
            <tr><td>shippingID:</td><input type="text" placeholder="Enter tracking number..." name="shippingID" required></tr>
        </table>
            <div class="form-button">
                <button type="submit">Search</button>
    </body>
</html>
