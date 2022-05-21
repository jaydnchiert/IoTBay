<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ioTBay.User"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ioTBay.dao.*"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin index</title>
        <style>
            
        </style>
    </head>
    <body>
        <a herf="logout.jsp" align="right"> logout </a>
        <h1 align="center"> You are in admin mode </h1>
        
        <table border="1" cellpadding="5">
            <thead>
                <tr>
                    <th scope="col">UserID</th>
                    <th scope="col">User First Name</th>
                    <th scope="col">User Last Name</th>
                    <th scope="col">Email Address</th>
                    <th scope="col">Phone Number</th>
                    <th scope="col">Password</th>
                    <th scope="col">User Type</th>
                    <th scope="col">Action</th>
                </tr>
            </thead>
            <tbody>
                         <%
                    int index=1;
                    
                    List list = UserManager.fetchUsers();
                    Iterator it=list.iterator();
                    while(it.hasNext()){
                    User user=(User)it.next();
                %>
                <tr>
                    <td><%=user.getUserID()%></td>
                    <td><%=user.getFirstName()%></td>
                    <td><%=user.getLastName()%></td>
                    <td><%=user.getEmailAddress()%></td>
                    <td><%=user.getPhoneNumber()%></td>
                    <td><%=user.getPassword()%></td>
                    <td><%=user.getUserType()%></td>
                    <td>
                        <a href="">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="">Delete</a>                     
                    </td>
                </tr>
                <% } 
                %>
            </tbody>
        </table>
        
    </body>
</html>
