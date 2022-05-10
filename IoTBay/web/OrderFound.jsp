<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Result</title>
    </head>
    <body>
      <center>
        <%
          Order order = (Order(session.getAttribute("CurrentSessionOrder")));
        %>
        <table border="1">
          <tr>
              <th>OrderID</th>
              <th>ProductID</th>
              <th>CustomerID</th>
              <th>ShippingPrice</th>
              <th>TotalPrice</th>
              <th>Date</th>
          </tr>
          <tr>
            <td><%order.getOrderID()%></td>
            <td><%order.getProductID()%></td>
            <td><%order.getCustomerID()%></td>
            <td>$15</td>
            <td>$50</td>
            <td><%order.getDate()%></td>
        </table>
      </center>

    </body>
</html>
