<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Register</h1>
        <form action="welcome.jsp" method="post">
            <label for="fname">First Name: </label>
            <input type="text" name="fname" id="fname"/>
            <label for="lname">Last Name: </label>
            <input type="text" name="lname" id="lname"/>
            <label for="email">Email: </label>
            <input type="email" name="email" id="email"/>
            <label for="password">Password: </label>
            <input type="password" name="pasword" id="password"/>
            <button type="submit">Submit</button>
        </form>
        
    </body>
</html>
