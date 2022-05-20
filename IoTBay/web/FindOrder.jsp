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
        <div><span class="time" id="time" ></span></div>
        <p><%=(existErr!= null ? existErr: "")%></p>
        <form action="FindOrderServlet" method="post">
            <table id="form_table">
                <tr>
                    <td>Please enter your OrderID</td>
                    <td><input type="text" placeholder="Enter OrderID" name="OrderID" required/></td>
                </tr>
                <tr>
                    <td>Please enter your Date</td>
                    <td><input type="text" placeholder="Enter Date" name="Date" required/></td>
                </tr>
            </table>
            <div class="form-button">
            <input type="submit" value="FindOrder" />
          </div>
        </form>
    </body>
</html>
