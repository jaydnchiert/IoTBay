<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Register</h1>
        <%
            String emailErr = (String) session.getAttribute("emailErr");
            String passErr = (String) session.getAttribute("passErr");
            String firstNameErr = (String) session.getAttribute("firstNameErr");
            String lastNameErr = (String) session.getAttribute("lastNameErr");
            String emptyErr = (String) session.getAttribute("emptyErr");
            String existErr = (String) session.getAttribute("existErr");
            String addErr = (String) session.getAttribute("addErr");
        %>
        <p><%=(emailErr!= null ? emailErr: "")%></p>
        <p><%=(passErr!= null ? passErr: "")%></p>
        <p><%=(firstNameErr!= null ? firstNameErr: "")%></p>
        <p><%=(lastNameErr!= null ? lastNameErr: "")%></p>
        <p><%=(emptyErr!= null ? emptyErr: "")%></p>
        <p><%=(existErr!= null ? existErr: "")%></p>
        <p><%=(addErr!= null ? addErr: "")%></p>
        <form action="RegisterServlet" method="post">
            <table style = "width: 50%">
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
            <input type="submit" value="Register" />
        </form>
        
    </body>
</html>
