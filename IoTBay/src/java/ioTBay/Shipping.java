/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ioTBay;

/**
 *
 * @author fernr
 */
public class Shipping {
    private int ShipmentID;
    private int OrderID;
    private int UserID;
    private String Status;
    
    public Shipping(int ShipmentID, int OrderID, int UserID, String Status) {
        this.ShipmentID = ShipmentID;
        this.OrderID = OrderID;
        this.UserID = UserID;
        this.Status = Status;
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

}
