/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ioTBay.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servelt.http.HttpSession;
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
        int orderID = request.getParameter("OrderID");
        int userID = request.getParameter("UserID");
        int productID = request.getParameter("ProductID");
        int shippingPrice = 15;
        int totalPrice = 50;
        String date = request.getParameter("Date");
        OrderManager manager = (OrderManager) session.getAttribute("manager");
    try{
        Order exist = manager.findOrder(orderID,date);
        } catch (SQLException ex){
        Logger.getLogger(AddOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
        if(exist != null){
        session.setAttribute("existErr", "Order exists in database");
        request.getRequestDispatcher("AddOrder.jsp").include(request, response);
    }else{
        manager.addOrder(orderID,userID,productID,date,shippingPrice,totalPrice);
        Order order = new Order(orderID,userID,productID,date,shippingPrice,totalPrice);
        session.setAttribute("order",order);
        request.getRequestDispatcher("Order.jsp").include(request, response);
    }

    }



}
