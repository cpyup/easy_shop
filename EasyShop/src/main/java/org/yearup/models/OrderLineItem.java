package org.yearup.models;

import java.math.BigDecimal;

public class OrderLineItem {
    private int lineItemId;
    private int orderId;
    private int productId;
    private BigDecimal price;
    private int quantity;
    private BigDecimal discount;

    public OrderLineItem(int orderId, int productId, BigDecimal price, int quantity, BigDecimal discount) {
        this.orderId = orderId;
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
    }

    public OrderLineItem() {
    }

    public int getLineItemId() {
        return lineItemId;
    }

    public void setLineItemId(int lineItemId) {
        this.lineItemId = lineItemId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
}
