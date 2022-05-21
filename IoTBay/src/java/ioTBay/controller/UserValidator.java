/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ioTBay.controller;

/**
 *
 * @author Jaydn
 */
import jakarta.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator implements Serializable{ 

    private String emailPattern = "([a-zA-Z0-9]+)(([._-])([a-zA-Z0-9]+))*(@)([a-z]+)(.)([a-z]{3})((([.])[a-z]{0,2})*)";      
    private String namePattern = "([A-Za-z]{1,15})";       
    private String passwordPattern = "([a-z0-9]{8,32})";
    private String phonePattern = "(([+]{0,1})([0-9]{1,14}))";

    public UserValidator(){
    }       

    public boolean validate(String pattern, String input){       
       Pattern regEx = Pattern.compile(pattern);       
       Matcher match = regEx.matcher(input);       
       return match.matches(); 
    }     
    
    public boolean validatePhoneNumber(String phoneNumber) {
        return validate(phonePattern, phoneNumber);
    }

    public boolean checkEmptyLogin(String email, String password){       
       return  email.isEmpty() || password.isEmpty();   
    }
    
    public boolean checkEmptyRegister(String firstName, String lastName, String email, String phoneNumber, String password){
        return firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || phoneNumber.isEmpty() || password.isEmpty();
    }

    public boolean validateEmail(String email){                       
       return validate(emailPattern,email);   
    }

    public boolean validateName(String name){
       return validate(namePattern,name); 
    }       

    public boolean validatePassword(String password){
       return validate(passwordPattern,password); 
    }
    
    public void clear(HttpSession session) {
        session.setAttribute("emailErr", "");
        session.setAttribute("passErr", "");
        session.setAttribute("firstNameErr", "");
        session.setAttribute("lastNameErr", "");
        session.setAttribute("emptyErr", "");
        session.setAttribute("existErr", "");
        session.setAttribute("addErr", "");
        session.setAttribute("phoneErr", "");
    }
}