<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@page import="ioTBay.Shipping"%>
<%@page import="ioTBay.ShippingDAO.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="./css/style.css" />
        <title>Add New Shipment</title>
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
        <%
            String duplicate = (String) session.getAttribute("duplicate");
        %>
        <h1>Add Shipment</h1>
        <p>Add a new shipment with your existing Order ID.<br></p>
        <form method="post" action="./AddShippingServlet">
            <table>
            <tr><td>ShippingID:</td><<td><input type="text" name="shippingID" required></td></tr>
            <tr><td>OrderID:</td><<td><input type="text" name="orderID" required><</td></tr>
            <tr><td>UserID:</td><<td><input type="text" name="userID" required></td></tr>
            <tr><td>ProductID:</td><<td><input type="text" name="productID" required></td></tr>
            <tr><td>Date:</td><<td><input type="date" name="date" required></td></tr>
            <tr><td>Address:</td><<td><input type="text" name="address" required></td></tr>
            <<td><a href="AddShipSuccess.jsp" class="button"> Submit</a>
            <<td><a href="Shipping.jsp" class="button"> Cancel</a>     
            </table>
        </form>
                    
        <%
        int id = Integer.parseInt(request.getParameter("ShippingID"));
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Connection con = db.openConnection();
            Statement st = con.createStatement();
            int ID = st.executeUpdate("INSERT INTO SHIPPING VALUES (");
            pstatement = connection.prepareStatement(queryString);
              pstatement.setString(1, shippingID);
			  pstatement.setInt(2, orderID);
			  pstatement.setInt(3, userID);
                          setInt(4, productID);
                          setString(5, Date);
                          setString(6, Address);
              updateQuery = pstatement.executeUpdate();
        }
        catch (Exception ex) {
        out.println("Cannot connect to IoTBay database.");
            }
        %>
        <div class ="error-message">
            <p><%=(duplicate!= null ? duplicate: "")%></p>
        </div>
    </body>
</html>
