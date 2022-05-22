<%@page import="ioTBay.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="./css/style.css" />
        <title>Login Success</title>
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
                    <li><a href="./FindOrder.jsp">Order</a></li>
                    <li><a href="./Shipping.jsp">Shipping</a></li>
                </ul>
            </nav>
        </header>
        <main>
            <section id="login-success">
                <header class="head-wrapper">
                    <h2>Login Successful</h2>
                </header>
                <div class="content">
                    <p>Hi ${user.firstName} ${user.lastName}</p>
                    <p><a href="./index.jsp">Go back to home page</a></p>
                </div>
            </section>
        </main>
    </body>
</html>
