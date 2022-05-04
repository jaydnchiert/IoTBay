package ioTBay;

public class Order {
    private int OrderID;
    private int CustomerID;
    private int ProductID;
    private int ShippingPrice;
    private int TotalPrice;

public Order(int OrderID, int CustomerID, int ProductID, int ShippingPrice, int TotalPrice) {
        this.OrderID = OrderID;
        this.CustomerID = CustomerID;
        this.ProductID = ProductID;
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
