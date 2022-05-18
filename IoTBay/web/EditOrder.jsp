<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Order</title>
    </head>
    <body>
        <%
            Order order = (Order)session.getAttribute("Order");
            String updated = request.getParameter("updated");
        %>
        <div>
            <a href="OrderServlet?orderid='<%= order.getOrderID()%>'&date='<%= order.getDate()%>'"> Order Page</a>
            <a href="index.jsp">Main</a>
        </div>
        <h1>Edit Order <span class="message"> <%= (updated !=null ? updated : "")%></span></h1>
        <form method="post" action="UpdateOrderServlet">
            <table>
                <tr><td>OrderID:</td><<td><input type="text" name="OrderID" value="${order.OrderID}"></td></tr>
                <tr><td>UserID:</td><<td><input type="text" name="UserID" value="${order.UserID}"></td></tr>
                <tr><td>ProductID:</td><<td><input type="text" name="ProductID" value="${order.ProductID}"></td></tr>
                <tr><td>Date:</td><<td><input type="date"name="Date" value="${Order.Date}"></td></tr>
                <<tr><<td></td>
                    <<td>
                        <input type="submit" value="Update">
                        <input type="hidden" name="updated" value="updated">
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
