/*
 * AccessHistory is a JavaBean that stores AccessID, UserID, LoginTime and
 * LogoutTime
 */
package ioTBay;

import java.sql.Timestamp;

/**
 *
 * @author Jaydn
 */
public class AccessHistory {
    private String AccessID;
    private String UserID;
    private Timestamp LoginTime;
    private Timestamp LogoutTime;
    
    //insert a constructor that initialises the field
    public AccessHistory(String AccessID, String UserID, Timestamp LoginTime, Timestamp LogoutTime) {
        this.AccessID = AccessID;
        this.UserID = UserID;
        this.LoginTime = LoginTime;
        this.LogoutTime = LogoutTime;
    }
    
    //insert getters/setters

    public String getAccessID() {
        return AccessID;
    }

    public void setAccessID(String AccessID) {
        this.AccessID = AccessID;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public Timestamp getLoginTime() {
        return LoginTime;
    }

    public void setLoginTime(Timestamp LoginTime) {
        this.LoginTime = LoginTime;
    }

    public Timestamp getLogoutTime() {
        return LogoutTime;
    }

    public void setLogoutTime(Timestamp LogoutTime) {
        this.LogoutTime = LogoutTime;
    }
    
}
