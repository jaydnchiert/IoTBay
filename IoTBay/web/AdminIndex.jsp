
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ioTBay.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ioTBay.dao.*"%>

<!DOCTYPE html>

<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Admin index</title>
        <link rel="stylesheet" href="./css/style.css" />
    </head>
    <body>
        <%
            ArrayList temp = (ArrayList) session.getAttribute("temp");
            User user = (User) session.getAttribute("user");
            String phoneErr = (String) session.getAttribute("phoneErr");
            String logErr = (String) session.getAttribute("logErr");
        %>
        <header>
            <a herf="index.jsp" align="right"> logout </a>
            <h1 align="center"> You are in admin mode </h1>
            <br>
            <br>
        </header>
        <main>
            <section id="admin">
                <div class="form-wrapper">
                    <div id="search-form">
                        <form action="SearchUserServlet" method="post">
                            <div id="search-label">
                                <label>Search User (Phone Number): </label>
                                <input type="text" name="phonenumber" />
                            </div>
                            <div id="search-button">
                                <button type="submit">Search</button>
                            </div>
                        </form>
                    </div>
                    <div id="access-form">
                        <form action="ShowUserListServlet" method="post">
                        <button type="submit">Show All Users</button>
                    </form>
                    </div>
                    <div class="error-message">
                        <p><%=(phoneErr!= null ? phoneErr: "")%></p>
                        <p><%=(logErr != null ? logErr : "")%></p>
                    </div>
                    <table border="1" cellpadding="5">
                    <thead>
                        <tr>
                            <th scope="col">UserID</th>
                            <th scope="col">User First Name</th>
                            <th scope="col">User Last Name</th>
                            <th scope="col">Email Address</th>
                            <th scope="col">Phone Number</th>
                            <th scope="col">Password</th>
                            <th scope="col">User Type</th>
                            <th scope="col">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                    <%
                        if(temp != null) {
                        for(int i = 0; i < temp.size(); i++) {
                    %>
                    <tr>
                        <td>
                            <%UserManager userManager = (UserManager) temp.get(i);%>
                            <%=user.getUserID()%>
                        </td>
                        <td><%=user.getFirstName()%></td>
                        <td><%=user.getLastName()%></td>
                        <td><%=user.getEmailAddress()%></td>
                        <td><%=user.getPhoneNumber()%></td>
                        <td><%=user.getPassword()%></td>
                        <td><%=user.getUserType()%></td>
                        <td>
                            <form action="DeleteUserAdminServlet" method="post">
                                <button type="submit">Delete user</button>
                            </form>                    
                        </td>
                    </tr>
                    <% } 
                    %>
                    </tbody>
                    </table>
                </div>
                    <form action="./AddUserAdmin.jsp" method="post" align="center">
                        <button type="submit">Add User</button>
                    </form>           
                </div>
            </section>
        </main>
    </body>
</html>
