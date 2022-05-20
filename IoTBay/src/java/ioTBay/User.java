/*
 * User is a JavaBean that stores UserID, FirstName, LastName, EmailAddress,
 * PhoneNumber, Password and UserType
 */
package ioTBay;

/**
 *
 * @author Jaydn
 */
public class User {
    
    private Integer UserID;
    private String FirstName;
    private String LastName;
    private String EmailAddress;
    private String PhoneNumber;
    private String Password;
    private Character UserType;
    
    //insert a constructor that initialises the fields
    public User(Integer UserID, String FirstName, String LastName, String EmailAddress, String PhoneNumber, String Password, Character UserType) {
        this.UserID = UserID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.EmailAddress = EmailAddress;
        this.PhoneNumber = PhoneNumber;
        this.Password = Password;
        this.UserType = UserType;
    }
    
    //insert getters/setters
    
    public Integer getUserID() {
        return UserID;
    }
    
    public void setUserID(Integer UserID) {
        this.UserID = UserID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String EmailAddress) {
        this.EmailAddress = EmailAddress;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public Character getUserType() {
        return UserType;
    }

    public void setUserType(Character UserType) {
        this.UserType = UserType;
    }



    
}
