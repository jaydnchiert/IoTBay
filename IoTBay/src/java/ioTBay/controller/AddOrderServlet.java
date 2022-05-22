/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ioTBay.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ioTBay.Order;
import ioTBay.OrderDAO.OrderManager;
/**
 *
 * @author louistsou
 */
public class AddOrderServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int orderID = Integer.parseInt(request.getParameter("OrderID"));
        int userID = Integer.parseInt(request.getParameter("UserID"));
        int productID = Integer.parseInt(request.getParameter("ProductID"));
        int shippingPrice = 15;
        int totalPrice = 50;
        String date = request.getParameter("Date");
        OrderManager manager = (OrderManager) session.getAttribute("manager");
    try{
        Order exist = manager.findOrder(orderID,date);
        if(exist != null){
        session.setAttribute("existErr", "Order exists in database");
        request.getRequestDispatcher("AddOrder.jsp").include(request, response);
        }else{
        manager.addOrder(orderID,userID,productID,date,shippingPrice,totalPrice);
        Order order = new Order(orderID,userID,productID,date,shippingPrice,totalPrice);
        session.setAttribute("order",order);
        request.getRequestDispatcher("Order.jsp").include(request, response);
    }
        } catch (SQLException ex){
        Logger.getLogger(AddOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
    }


    }



}
