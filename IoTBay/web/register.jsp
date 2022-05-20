<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="./css/style.css" />
        <title>Register</title>
    </head>
    <body>
        <%
            String emailErr = (String) session.getAttribute("emailErr");
            String passErr = (String) session.getAttribute("passErr");
            String firstNameErr = (String) session.getAttribute("firstNameErr");
            String lastNameErr = (String) session.getAttribute("lastNameErr");
            String emptyErr = (String) session.getAttribute("emptyErr");
            String existErr = (String) session.getAttribute("existErr");
            String addErr = (String) session.getAttribute("addErr");
        %>
        <header class="main-header">
            <nav>
                <h1 id="logo"><a href="./index.jsp">IoTBay</a></h1>
                <ul>
                    <li><a href="./register.jsp">Register</a></li>
                    <li><a href="./login.jsp">Login</a></li>
                    <li><a href="./Order.jsp">Order</a></li>
                    <li><a href="./Shipping.jsp">Shipping</a></li>
                </ul>
            </nav>
        </header>
        <main>
            <section id="register">
                <div class="form-wrapper">
                    <header class="form-head">
                        <h2>Register an account</h2>
                    </header>
                    <form action="RegisterServlet" method="post">
                        <table>
                            <tr>
                                <td>First Name: </td>
                                <td><input type="text" name="firstName" /></td>
                            </tr>
                            <tr>
                                <td>Last Name: </td>
                                <td><input type="text" name="lastName" /></td>
                            </tr>
                            <tr>
                                <td>Email Address: </td>
                                <td><input type="text" name="email" /></td>
                            </tr>
                            <tr>
                                <td>Phone Number: </td>
                                <td><input type="text" name="phoneNumber" /></td>
                            </tr>
                            <tr>
                                <td>Password: </td>
                                <td><input type="password" name="password" /></td>
                            </tr>
                            <tr>
                                <td><input type="hidden" name="userType" value="c"/></td>
                            </tr>
                        </table>
                        <div class="form-button">
                            <button type="submit">Register</button>
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
                </div>
            </section>
        </main>
    
    </body>
</html>
