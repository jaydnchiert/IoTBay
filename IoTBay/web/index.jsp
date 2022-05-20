<%@page import="ioTBay.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="./css/style.css" />
        <title>IoTBay</title>
    </head>
    <body>
        <%
            User user = (User) session.getAttribute("user");
            String logoutLink = (String) session.getAttribute("logoutLink");
            String logoutText = (String) session.getAttribute("logoutText");
            String accountLink = (String) session.getAttribute("accountLink");
            String accountText = (String) session.getAttribute("accountText");
        %>
        <header class="main-header">
            <nav>
                <h1 id="logo"><a href="./index.jsp">IoTBay</a></h1>
                <ul>
                    <li><a href=<%=(accountLink!= null ? accountLink: "./register.jsp")%>><%=(accountText!= null ? accountText: "Register")%></a></li>
                    <li><a href=<%=(logoutLink!= null ? logoutLink: "./login.jsp")%>><%=(logoutText!= null ? logoutText: "Login")%></a></li>
                    <li><a href="./Order.jsp">Order</a></li>
                    <li><a href="./Shipping.jsp">Shipping</a></li>
                </ul>
            </nav>
        </header>
        <main>
            
        </main>
        <jsp:include page="/UserServlet" flush="true" />
        <jsp:include page="/AccessHistoryServlet" flush="true" />
    </<body>
</html>
