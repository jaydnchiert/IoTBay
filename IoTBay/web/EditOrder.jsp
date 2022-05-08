<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Order</title>
    </head>
    <body>
        <%
            Order order = (Order)session.getAttribute("order");
            String updated = request.getParameter("updated");
        %>
        <h1>Edit Order <span> <%= (updated !=null) ? "Update was successful":""%></span></h1>
        <form action="EditOrder.jsp" method="post">
            <table>
                <tr><td>OrderID:</td><<td><input type="text" name="OrderID" value="${order.OrderID}"></td></tr>
                <tr><td>CustomerID:</td><<td><input type="text" name="CustomerID" value="${order.CustomerID}"></td></tr>
                <tr><td>ProductID:</td><<td><input type="text" name="ProductID" value="${order.ProductID}"></td></tr>
                <tr><td>Date:</td><<td><input type="date"name="Date" value="${Order.Date}"></td></tr>
                <<tr><<td></td>
                    <<td><a href="main.jsp" class="button"> Main</a>
                        <input type="submit" value="Update">
                        <input type="hidden" name="updated" value="updated">
                    </td>
                </tr>
            </table>
        </form>
                <%
                    int OrderID = request.getParameter("OrderID");
                    int CustomerID = request.getParameter("CustomerID");
                    int ProductID = request.getParameter("ProductID");
                    int ShippingPrice = 0;
                    int TotalPrice = 0;
                    String Date = request.getParameter("Date");
                    order = new Order(OrderID, CustomerID, ProductID, Date, ShippingPrice, TotalPrice);
                    session.setAttribute("order", order);
                %>
    </body>
</html>
