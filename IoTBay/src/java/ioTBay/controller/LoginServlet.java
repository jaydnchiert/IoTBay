/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ioTBay.controller;

/**
 *
 * @author Jaydn
 */
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ioTBay.User;
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
        //5- retrieve the manager instance from session    
        UserManager manager = (UserManager) session.getAttribute("userManager");
        
        User user = null;
        
        try {
            //6- find user by email and password
                user = manager.findUser(email, password);
                
        }catch (SQLException ex) {
            
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (validator.checkEmptyLogin(email, password)) {
            session.setAttribute("emptyErr", "Error: Please fill in all fields.");
            request.getRequestDispatcher("login.jsp").include(request, response);
        
        } else if (user != null) {
            //13-save the logged in user object to the session
            session.setAttribute("user", user);
            session.setAttribute("logoutLink", "./logout.jsp");
            session.setAttribute("logoutText", "Logout");
            session.setAttribute("accountLink", "./account.jsp");
            session.setAttribute("accountText", "Account");
            //14- redirect user to the main.jsp
            request.getRequestDispatcher("loginSuccess.jsp").include(request, response);
            
        } else {
            //15-set user does not exist error to the session
            session.setAttribute("existErr", "Error: Incorrect login details.");
            //16- redirect user back to the login.jsp
            request.getRequestDispatcher("login.jsp").include(request, response);
        }
    }
 }