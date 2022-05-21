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

public class AccessHistoryValidator implements Serializable{ 

    private String datePattern = "(([0-9]{4})([-]{1})([0-9]{2})([-]{1})([0-9]{2}))";     

    public AccessHistoryValidator(){
    }       

    public boolean validate(String pattern, String input){       
       Pattern regEx = Pattern.compile(pattern);       
       Matcher match = regEx.matcher(input);       
       return match.matches(); 
    }       

    public boolean validateDate(String date){                       
       return validate(datePattern,date);   
    }
    
    public void clear(HttpSession session) {
        session.setAttribute("dateErr", "");
        session.setAttribute("logErr", "");
    }
}