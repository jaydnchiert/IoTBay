<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Register</h1>
        <form action="RegisterServlet" method="post">
            <table style = "width: 50%">
            <tr>
                <td>First Name: </td>
                <td><input type="text" name="firstName" required/></td>
            </tr>
            <tr>
                <td>Last Name: </td>
                <td><input type="text" name="lastName" required/></td>
            </tr>
            <tr>
                <td>Email Address: </td>
                <td><input type="text" name="email" required/></td>
            </tr>
            <tr>
                <td>Phone Number: </td>
                <td><input type="text" name="phoneNumber" required/></td>
            </tr>
            <tr>
                <td>Password: </td>
                <td><input type="text" name="password" required/></td>
            </tr>
            <tr>
                <td><input type="hidden" name="userType" value="c"/></td>
            </tr>
            </table>
            <input type="submit" value="Register" />
        </form>
        
    </body>
</html>
