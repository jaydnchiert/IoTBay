<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add New Shipment</title>
    </head>
    <body>
        <h1>Add Shipment</h1>
        <p>Add a new shipment with your existing Order ID.</p>
        <form method="post" action="AddShipmentServlet">
            <table>
                <tr><td>ShipmentID:</td><<td><input type="text" placeholder="Enter Shipment ID here..." name="ShipmentID" required></td></tr>
            <tr><td>UserID:</td><<td><input type="text" placeholder="Enter User ID here..." name="UserID" required></td></tr>
            <tr><td>ProductID:</td><<td><input type="text" placeholder="Enter ProductID here..." name="ProductID" required></td></tr>
            <<tr><<td></td>
                <<td><a href="Findorder.jsp" class="button"> Cancel</a>
                    <input type="submit" value="Add new shipment">
    </body>
</html>
