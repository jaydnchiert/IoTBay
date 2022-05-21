/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
import ioTBay.User;
import ioTBay.dao.AccessHistoryManager;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;


/**
 *
 * @author Jaydn
 */
public class ShowAccessHistoryServlet extends HttpServlet{
    
    @Override   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {       

        //1- retrieve the current session
        HttpSession session = request.getSession();
        //5- retrieve the userManager instance from session    
        AccessHistoryManager accessManager = (AccessHistoryManager) session.getAttribute("accessHistoryManager");
        
        
        User user = (User) session.getAttribute("user");
        ArrayList accessLogs = null;
        
        try {
            accessLogs = accessManager.findAllAccessHistory(user.getUserID());
            session.setAttribute("accessLogs", accessLogs);
            request.getRequestDispatcher("./accessHistory.jsp").include(request, response);
                
        }catch (SQLException ex) {
            
            Logger.getLogger(ShowAccessHistoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}