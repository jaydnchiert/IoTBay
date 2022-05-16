<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        
        <%
            String existErr = (String) session.getAttribute("existErr");
            String emailErr = (String) session.getAttribute("emailErr");
            String passErr = (String) session.getAttribute("passErr");
        %>
        
        <h1>Log in</h1>
        <p><%=(existErr!= null ? existErr: "")%></p>
        <p><%=(emailErr != null ? emailErr : "")%></p>
        <p><%=(passErr != null ? passErr : "")%></p>
        <form action="LoginServlet" method="post">
          <table style ="width: 50%">
            <tr>
                <td>Username: </td>
                <td><input type="text" placeholder="Enter email" name="email" required/></td>
            </tr>
            <tr>
                  <td>Password: </td>
                  <td><input type="password" placeholder="Enter password" name="password" required/></td>
            </tr>
          </table>
          <input type="submit" value="Login" /></form>
    </body>
</html>
