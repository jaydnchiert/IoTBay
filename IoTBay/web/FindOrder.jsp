<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="./css/style.css" />
        <title>Find Order</title>
    </head>
    <body>
      <%
          String existErr = (String) session.getAttribute("existErr");
      %>
      <header class="main-header">
            <nav>
                <h1 id="logo"><a href="./index.jsp">IoTBay</a></h1>
                <ul>
                    <li><a href="./register.jsp">Register</a></li>
                    <li><a href="./login.jsp">Login</a></li>
                    <li><a href="./FindOrder.jsp">Order</a></li>
                    <li><a href="./Shipping.jsp">Shipping</a></li>
                </ul>
            </nav>
        </header>
    <center>
        <p><%=(existErr!= null ? existErr: "")%></p>
        <div class="form-wrapper">
                    <header class="form-head">
                        <h2>Find Order</h2>
                    </header>
                    <form action="FindOrderServlet" method="post">
                        <table>
                            <tr>
                                <td>Order ID: </td>
                                <td><input type="text" name="OrderID"/></td>
                            </tr>
                            <tr>
                                  <td>Date: </td>
                                  <td><input type="text" name="Date"/></td>
                            </tr>
                        </table>
                        <div class="form-button">
                            <button type="submit">Find Order</button>
                        </div>

                    </form>
            </center>
    </body>
</html>
