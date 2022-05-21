<%@page import="ioTBay.User" %>
<%@page import="ioTBay.AccessHistory" %>
<%@page import="java.util.ArrayList" %>
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
            ArrayList accessLogs = (ArrayList) session.getAttribute("accessLogs");
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
            <section>
                <h2>View Access History</h2>
                <table>
                    <%
                        for(int i = 0; i < accessLogs.size(); i++) { %>
                        </tr>
                        <tr>
                            <td>
                                Login Time: 
                                <%AccessHistory accessHistory = (AccessHistory) accessLogs.get(i);%>
                                <%= accessHistory.getLoginTime()%>
                            </td>
                            <td>
                                Logout Time:
                                <%= accessHistory.getLogoutTime()%>
                            </td>
                        </tr>


                    <% } %>
                </table>
                <form action="SearchAccessHistoryServlet" method="post">
                    <label>Search Access History (yyyy-mm-dd): </label>
                    <input type="text" name="searchAccessHistory" />
                    <button type="submit">Search</button>
                </form>
            </section>
        </main>
    </<body>
</html>
