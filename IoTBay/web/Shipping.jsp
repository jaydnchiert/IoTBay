<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shipping</title>
    </head>
    <body>
        <h1>Shipping</h1>
        <p>IoTBay allows you to create new shipping details and view and edit existing details.</p>
        <a href ="AddShip.jsp">Add New Shipment</a>
        <a href ="EditShip.jsp">Edit Shipment</a>
        <br>
        <p>Check Shipment with your tracking number below:</p>
        <table>
            <tr><td>OrderID:</td><input type="text" placeholder="Enter tracking number..." name="ShipmentID" required></tr>
        </table>
    </body>
</html>
