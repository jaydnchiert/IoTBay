<%@page import="ioTBay.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
        <head>
            <meta charset="UTF-8" />
            <meta http-equiv="X-UA-Compatible" content="IE=edge" />
            <meta name="viewport" content="width=device-width, initial-scale=1.0" />
            <link rel="stylesheet" href="./css/style.css" />
            <title>Logout</title>
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
                <section id="logout">
                    <header class="header-wrapper">
                        <h2>Are you sure you want to logout?</h2>
                    </header>
                    <div class="content">
                        <p><a href="./index.jsp">Continue browsing</a></p>
                        <form action="LogoutServlet" method="post">
                            <button type="submit">Logout</button>
                        </form>
                    </div>
                </section>
            </main>
        </body>
    </html>
