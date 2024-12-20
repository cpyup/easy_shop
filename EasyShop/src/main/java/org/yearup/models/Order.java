package org.yearup.models;


import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Order {
    private ArrayList<OrderLineItem> lineItems = new ArrayList<>();
    private int orderId;
    private int userId;
    private Timestamp date;
    private String address;
    private String city;
    private String state;
    private String zip;
    private BigDecimal shippingAmount;
    public ArrayList<OrderLineItem> getLineItems()
    {
        return lineItems;
    }

    public void setLineItems(ArrayList<OrderLineItem> lineItems)
    {
        this.lineItems = lineItems;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void add(OrderLineItem item)
    {
        lineItems.add(item);
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public BigDecimal getShippingAmount() {
        return shippingAmount;
    }

    public void setShippingAmount(BigDecimal shippingAmount) {
        this.shippingAmount = shippingAmount;
    }
}
