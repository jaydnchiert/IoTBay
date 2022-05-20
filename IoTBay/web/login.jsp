<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="./css/style.css" />
        <title>Login</title>
    </head>
    <body>
        <%
            String existErr = (String) session.getAttribute("existErr");
            String emailErr = (String) session.getAttribute("emailErr");
            String passErr = (String) session.getAttribute("passErr");
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
            <section id="login">
                <div class="form-wrapper">
                    <header class="form-head">
                        <h2>Log in</h2>
                    </header>
                    <form action="LoginServlet" method="post">
                        <table>
                            <tr>
                                <td>Username: </td>
                                <td><input type="text" name="email"/></td>
                            </tr>
                            <tr>
                                  <td>Password: </td>
                                  <td><input type="password" name="password"/></td>
                            </tr>
                        </table>
                        <div class="form-button">
                            <button type="submit">Login</button>
                        </div>
                        
                    </form>
                    <div class="error-message">
                        <p><%=(existErr!= null ? existErr: "")%></p>
                        <p><%=(emailErr != null ? emailErr : "")%></p>
                        <p><%=(passErr != null ? passErr : "")%></p>
                    </div>
                </div>
            </section>
        </main>
    </body>
</html>
