<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="iotBay.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="./css/style.css" />
        <title>Order</title>
    </head>
    <body>
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
              <th>    </th>
          </tr>
          <tr>
            <td>${order.OrderID}</td>
            <td>${order.ProductID}</td>
            <td>${order.UserID}</td>
            <td>15</td>
            <td>50</td>
            <td>${order.Date}</td>
            <td><a href="EditOrderServlet?orderid='<%= order.getOrderID()%>'&date='<%= order.getDate()%>'">Edit</button></a>
            <td><a href="DeleteOrderServlet?orderid='<%= order.getOrderID()%>'&date='<%= order.getDate()%>'">Delete</button></a>
        </table>
        <a href="./AddOrder.jsp">Add Order</a>
        <a href="./index.jsp">Main page</a>
      </center>

    </body>
</html>
