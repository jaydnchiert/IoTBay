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
            String emailErr = (String) session.getAttribute("emailErr");
            String passErr = (String) session.getAttribute("passErr");
            String firstNameErr = (String) session.getAttribute("firstNameErr");
            String lastNameErr = (String) session.getAttribute("lastNameErr");
            String emptyErr = (String) session.getAttribute("emptyErr");
            String existErr = (String) session.getAttribute("existErr");
            String addErr = (String) session.getAttribute("addErr");
            String updateSucc = (String) session.getAttribute("updateSucc");
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
            <section id="account">
                <div class="form-wrapper">
                    <header class="form-head">
                        <h2>Edit Account Details</h2>
                    </header>
                    <form action="UpdateUserServlet" method ="post">
                        <table>
                            <tr>
                                <td>First Name: </td>
                                <td><input type="text" name="firstName" value=${user.firstName} /></td>
                            </tr>
                            <tr>
                                <td>Last Name: </td>
                                <td><input type="text" name="lastName" value=${user.lastName} /></td>
                            </tr>
                            <tr>
                                <td>Email Address: </td>
                                <td><input type="text" name="email"  value=${user.emailAddress} /></td>
                            </tr>
                            <tr>
                                <td>Phone Number: </td>
                                <td><input type="text" name="phoneNumber"  value=${user.phoneNumber} /></td>
                            </tr>
                            <tr>
                                <td>Password: </td>
                                <td><input type="password" name="password"  value=${user.password} /></td>
                            </tr>
                        </table>
                        <div class="form-button">
                            <button type="submit">Update Details</button>
                        </div>
                    </form>
                    <div class="error-message">
                        <p><%=(emailErr!= null ? emailErr: "")%></p>
                        <p><%=(passErr!= null ? passErr: "")%></p>
                        <p><%=(firstNameErr!= null ? firstNameErr: "")%></p>
                        <p><%=(lastNameErr!= null ? lastNameErr: "")%></p>
                        <p><%=(emptyErr!= null ? emptyErr: "")%></p>
                        <p><%=(existErr!= null ? existErr: "")%></p>
                        <p><%=(addErr!= null ? addErr: "")%></p>
                    </div>
                    <div class="success-message">
                        <p><%=(updateSucc!= null ? updateSucc: "")%></p>
                    </div>
                </div>
                <div id="access-button">
                    <form action="ShowAccessHistoryServlet" method="post">
                        <button type="submit">View Access History</button>
                    </form>           
                </div>
                    
            </section>
            
        </main>
    </<body>
</html>
