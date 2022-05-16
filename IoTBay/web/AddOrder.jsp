<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Order</title>
    </head>
    <body>
      <form action="Order.jsp" method="post">
        <table>
            <tr><td>OrderID:</td><<td><input type="text" placeholder="Enter OrderID" name="OrderID" required></td></tr>
            <tr><td>CustomerID:</td><<td><input type="text" placeholder="Enter UserID" name="UserID" required></td></tr>
            <tr><td>ProductID:</td><<td><input type="password" placeholder="Enter ProductID" name="ProductID" required></td></tr>
            <tr><td>Date:</td><<td><input type="date" name="Date" required></td></tr>
            <<tr><<td></td>
                <<td><a href="index.jsp" class="button"> Cancel</a>
                    <input type="submit" value="Add order">
                </td>
            </tr>
        </table>
    </form>
    </body>
</html>
