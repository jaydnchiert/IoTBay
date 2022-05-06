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
    private Integer AccessID;
    private Integer UserID;
    private Timestamp LoginTime;
    private Timestamp LogoutTime;
    
    //insert a constructor that initialises the field
    public AccessHistory(Integer AccessID, Integer UserID, Timestamp LoginTime, Timestamp LogoutTime) {
        this.AccessID = AccessID;
        this.UserID = UserID;
        this.LoginTime = LoginTime;
        this.LogoutTime = LogoutTime;
    }
    
    
    //insert getters/setters
    public Integer getAccessID() {
        return AccessID;
    }

    public void setAccessID(Integer AccessID) {
        this.AccessID = AccessID;
    }

    public Integer getUserID() {
        return UserID;
    }

    public void setUserID(Integer UserID) {
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
