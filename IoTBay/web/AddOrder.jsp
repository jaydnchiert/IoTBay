<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="./css/style.css" />
        <title>Add Order</title>
    </head>
    <body>
      <%
          String existErr = (String) session.getAttribute("existErr");
      %>
      <span class="message"> <%=(existErr != null ? existErr : "")%></span>
      <form method="post" action="AddOrderServlet">
        <table>
            <tr><td>OrderID:</td><<td><input type="text" placeholder="Enter OrderID" name="OrderID" required></td></tr>
            <tr><td>UserID:</td><<td><input type="text" placeholder="Enter UserID" name="UserID" required></td></tr>
            <tr><td>ProductID:</td><<td><input type="text" placeholder="Enter ProductID" name="ProductID" required></td></tr>
            <tr><td>Date:</td><<td><input type="date" name="Date" required></td></tr>
            </table>
                <a href="Findorder.jsp" class="button"> Cancel</a>
                <div class="form-button">
                    <button type="submit">Add Order</button>
                </div>
    </form>
    </body>
</html>
