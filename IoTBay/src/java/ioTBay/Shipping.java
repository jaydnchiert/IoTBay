package ioTBay;

import java.util.Date;

public class Shipping {
    private int ShipmentID;
    private int OrderID;
    private int UserID;
    private String Status;
    private String Date;
    private String Address;
    
    public Shipping(int ShipmentID, int OrderID, int UserID, String Status, String Date, String Address) {
        this.ShipmentID = ShipmentID;
        this.OrderID = OrderID;
        this.UserID = UserID;
        this.Status = Status;
        this.Date = Date;
        this.Address = Address;
    }   

    public int getShipmentID() {
        return ShipmentID;
    }
    
    public void setShipmentID(int ShipmentID) {
        this.ShipmentID = ShipmentID;
    }

    public int getOrderID() {
        return OrderID;
    }
    
    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }
    
    public int getUserID() {
        return UserID;
    }
    
    public void setUserID(int UserID) {
        this.UserID = UserID;
    }
    
    public String getStatus() {
        return Status;
    }
    
    public void setStatus(String Status) {
        this.Status = Status;
    }
    
    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }
    
    public String getAddress() {
        return Address;
    }
    
    public void setAddress() {
        this.Address = Address;
    }
}
