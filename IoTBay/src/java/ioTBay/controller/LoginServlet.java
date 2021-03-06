/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ioTBay.controller;

/**
 *
 * @author Jaydn
 */
import ioTBay.AccessHistory;
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
import ioTBay.dao.UserManager;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    @Override   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {       

        //1- retrieve the current session
        HttpSession session = request.getSession();
        //2- create an instance of the Validator class
        UserValidator validator = new UserValidator();
        //3- capture the posted email      
        String email = request.getParameter("email");
        //4- capture the posted password    
        String password = request.getParameter("password");
        //5- retrieve the userManager instance from session    
        UserManager userManager = (UserManager) session.getAttribute("userManager");
        AccessHistoryManager accessManager = (AccessHistoryManager) session.getAttribute("accessHistoryManager");
        
        User user = null;
        AccessHistory accessHistory = null;
        Character utype = null;

        try {
            //6- find user by email and password
                user = userManager.findUser(email, password);
                
        }catch (SQLException ex) {
            
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (validator.checkEmptyLogin(email, password)) {
            validator.clear(session);
            session.setAttribute("emptyErr", "Error: Please fill in all fields.");
            request.getRequestDispatcher("login.jsp").include(request, response);
        
        } else if (user != null) {
            //13-save the logged in user object to the session
            session.setAttribute("user", user);
            
            //Add access record
            try {
                utype = userManager.findUserType(email);
                accessManager.addAccessHistory(user.getUserID());
                accessHistory = accessManager.findAccessHistory(user.getUserID());
                session.setAttribute("accessHistory", accessHistory);
            
            }catch(SQLException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            validator.clear(session);
            
            session.setAttribute("logoutLink", "./logout.jsp");
            session.setAttribute("logoutText", "Logout");
            session.setAttribute("accountLink", "./account.jsp");
            session.setAttribute("accountText", "Account");
            //14- redirect user to the main.jsp
            if(utype.equals('a')){
                request.getRequestDispatcher("AdminIndex.jsp").include(request, response);
            }
            else request.getRequestDispatcher("loginSuccess.jsp").include(request, response);
            
        } else {
            validator.clear(session);
            //15-set user does not exist error to the session
            session.setAttribute("existErr", "Error: Incorrect login details.");
            //16- redirect user back to the login.jsp
            request.getRequestDispatcher("login.jsp").include(request, response);
        }
    }
 }