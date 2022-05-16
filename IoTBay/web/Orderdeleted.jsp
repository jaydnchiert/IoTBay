<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IoTBay</title>
    </head>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*,java.util.*"%>
    <%
    int id=request.getParameter("OrderID");
    try
    {
    Class.forName("com.mysql.jdbc.Driver");
    conn = db.openConnection();
    Statement st=conn.createStatement();
    int i=st.executeUpdate("DELETE FROM CustomerOrder WHERE OrderID="+id);
    }
    %>
    <body>
      <h1>Order Deleted</h1>
    </body>
</html>
