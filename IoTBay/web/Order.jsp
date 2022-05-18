<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="iotBay.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order</title>
    </head>
    <body onload="startTime(); resetSearch();">
    <div><span class="time" id="time" ></span></div>
        <%
          Order order = (Order) session.getAttribute("order");
        %>
        <center>
        <table border="1">
          <tr>
              <th>OrderID</th>
              <th>ProductID</th>
              <th>UserID</th>
              <th>ShippingPrice</th>
              <th>TotalPrice</th>
              <th>Date</th>
              <th>    </th>
          </tr>
          <tr>
            <td><%order.getOrderID()%></td>
            <td><%order.getProductID()%></td>
            <td><%order.getUserID()%></td>
            <td>15</td>
            <td>50</td>
            <td><%order.getDate()%></td>
            <td><a href="./Orderdeleted.jspid=<%=order.getOrderID("OrderID") %>"><button type="button"  class="delete">Delete</button></a>
        </table>
      </center>

    </body>
</html>
