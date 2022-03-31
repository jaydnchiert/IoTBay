/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IoTBay;
        
import javax.sql.DataSource;
import java sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author Fernrico
 */
public class IoTBay {
    String Username = "";
    String Password = "";
    boolean loggedIn = false;
    
    public IoTBay()
    {
        
    }
    
    public boolean loggedIn() 
    {
    return loggedIn;
    }
    
    public void setUsername(String N)
    {
        Username = N;
    }
    
    public void setPassword(String P)
    {
        Password = P;
    }
    
    public String getUsername()
    {
        return Username;
    }
    
    public String getPassword()
    {
        return Password;
    }




}
