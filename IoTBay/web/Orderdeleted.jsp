<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="./css/style.css" />
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
