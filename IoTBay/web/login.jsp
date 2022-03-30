<%--
    Document   : login
    Created on : 30 Mar 2022, 5:17:51 pm
    Author     : Jaydn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="Login Page" method="post">
          <table style ="with: 50%">
            <tr>
                <td>UserName</td>
                <td><input type="text" name="username"/></td>
            </tr>
            <tr>
                  <td>Password</td>
                  <td><input type="password" name="password" /></td>
            </tr>
          </table>
          <input type="submit" value="Login" /></form>
    </body>
</html>
