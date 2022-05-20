/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ioTBay.controller;

import ioTBay.AccessHistory;
import ioTBay.User;
import ioTBay.dao.AccessHistoryManager;
import ioTBay.dao.UserManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jaydn
 */
public class LogoutServlet extends HttpServlet {
   
    @Override   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {       

        //1- retrieve the current session
        HttpSession session = request.getSession();
        AccessHistory accessHistory = (AccessHistory) session.getAttribute("accessHistory");
        AccessHistoryManager accessManager = (AccessHistoryManager) session.getAttribute("accessHistoryManager");
        
        try {
                accessManager.addLogoutHistory(accessHistory.getAccessID());
        }catch(SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        session.invalidate();
        request.getRequestDispatcher("logoutSuccess.jsp").include(request, response);
  
    }
}
