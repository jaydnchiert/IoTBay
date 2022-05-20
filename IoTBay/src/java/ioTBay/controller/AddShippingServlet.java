/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ioTBay.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ioTBay.Shipping;

/**
 *
 * @author fernr
 */

public class AddShippingServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
                HttpSession session = request.getSession();
                int ShipmentID = request.getParameter("ShipmentID");
                int OrderID = request.getParameter("OrderID");
                int UserID = request.getParameter("UserID");
                String Status = request.getParameter("UserID");
                
    try {
        
        }
    }
    
}
