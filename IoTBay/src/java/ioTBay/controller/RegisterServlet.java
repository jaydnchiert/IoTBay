/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ioTBay.controller;

import ioTBay.User;
import ioTBay.dao.UserManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Jaydn
 */
public class RegisterServlet {
    
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
        UserManager manager = (UserManager) session.getAttribute("manager");
        User user = null;      
        validator.clear(session);
        
        //7- validate email
        if (!validator.validateEmail(email)) {           
                 //8-set incorrect email error to the session
                 session.setAttribute("emailErr", "Error: Email format incorrect");
                 //9- redirect user back to the login.jsp     
                 request.getRequestDispatcher("login.jsp").include(request, response);
         //10- validate password
        } else if (!validator.validatePassword(password)) {                  
                 //11-set incorrect password error to the session
                 session.setAttribute("passErr", "Error: Password format incorrect");
                 //12- redirect user back to the login.jsp          
                 request.getRequestDispatcher("login.jsp").include(request, response);
        } else {
            try {
                //6- find user by email and password
                user = manager.findUser(email, password);
                if (user != null) {                     
                 //13-save the logged in user object to the session
                 session.setAttribute("user", user);
                 //14- redirect user to the main.jsp
                 request.getRequestDispatcher("main.jsp").include(request, response);
                } else {                       
                 //15-set user does not exist error to the session           
                 session.setAttribute("existErr", "User does not exist in the Database.");
                 //16- redirect user back to the login.jsp
                 request.getRequestDispatcher("login.jsp").include(request, response);
                } 
            } catch (SQLException | NullPointerException ex) {
                System.out.println(ex.getMessage() == null ? "User does not exist" : "welcome");
            }
        }
    }
 }

