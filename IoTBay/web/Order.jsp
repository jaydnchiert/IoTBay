<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ioTBay.OrderDAO.*"%>
<%@page import="ioTBay.Order"%>
<%@page import="java.util.ArrayList"%>

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
          ArrayList temp = (ArrayList) session.getAttribute("temp");
          Order order = (Order) session.getAttribute("order");
          String logoutLink = (String) session.getAttribute("logoutLink");
          String logoutText = (String) session.getAttribute("logoutText");
          String accountLink = (String) session.getAttribute("accountLink");
          String accountText = (String) session.getAttribute("accountText");
          String existErr = (String) session.getAttribute("existErr");
        %>
       <header class="main-header">
            <nav>
                <h1 id="logo"><a href="./index.jsp">IoTBay</a></h1>
                <ul>
                    <li><a href=<%=(accountLink!= null ? accountLink: "./register.jsp")%>><%=(accountText!= null ? accountText: "Register")%></a></li>
                    <li><a href=<%=(logoutLink!= null ? logoutLink: "./login.jsp")%>><%=(logoutText!= null ? logoutText: "Login")%></a></li>
                    <li><a href="./FindOrder.jsp">Order</a></li>
                    <li><a href="./Shipping.jsp">Shipping</a></li>
                </ul>
            </nav>
        </header>
        <main>
        <table border="1" cellpadding="5">
                    <thead>
                        <tr>
                            <th scope="col">OrderID</th>
                            <th scope="col">UserID</th>
                            <th scope="col">ProductID</th>
                            <th scope="col">ShippingPrice</th>
                            <th scope="col">TotalPrice</th>
                            <th scope="col">Date</th>
                            <th scope="col"> </th>
                            <th scope="col"> </th>
                        </tr>
                    </thead>
                    <tbody>
                    <%
                        if(temp != null) {
                        for(int i = 0; i < temp.size(); i++) {
                    %>
                    <tr>
                        <td>
                            <%OrderManager orderManager = (OrderManager) temp.get(i);%>
                            <%=order.getOrderID()%>
                        </td>
                        <td><%=order.getUserID()%></td>
                        <td><%=order.getProductID()%></td>
                        <td><%=order.getShippingPrice()%></td>
                        <td><%=order.getTotalPrice()%></td>
                        <td><%=order.getDate()%></td>
                        <td><form action="UpdateOrderServlet" method="post">
                                <button type="submit">Edit</button>
                            </form></td>
                        <td>
                            <form action="DeleteOrderServlet" method="post">
                                <button type="submit">Delete</button>
                            </form>
                        </td>
                    </tr>
                    <% }
                    %>
                    </tbody>
                    </table>
                </div>
                    <form action="./AddOrder.jsp" method="post" align="center">
                        <button type="submit">Add Order</button>
                    </form>
                </div>
        </main>
    </body>
</html>
