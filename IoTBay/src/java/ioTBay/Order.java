/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Order.model;

/**
 *
 * @author louistsou
 */
public class Order {
    private int OrderID;
    private int CustomerID;
    private int ProductID;
    private int ShippingPrice;
    private int TotalPrice;
    private String Date;

public Order(int OrderID, int CustomerID, int ProductID, String Date, int ShippingPrice, int TotalPrice) {
        this.OrderID = OrderID;
        this.CustomerID = CustomerID;
        this.ProductID = ProductID;
        this.Date = Date;
        this.ShippingPrice = ShippingPrice;
        this.TotalPrice = TotalPrice;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public int getShippingPrice() {
        return ShippingPrice;
    }

    public void setShippingPrice(int ShippingPrice) {
        this.ShippingPrice = ShippingPrice;
    }

    public int getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(int TotalPrice) {
        this.TotalPrice = TotalPrice;
    }

}
