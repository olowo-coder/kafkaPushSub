package com.example.kafademo.model;

import java.math.BigDecimal;

public class Order {

    private String orderId;
    private String description;
    private BigDecimal price;

    public Order() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
            "orderId='" + orderId + '\'' +
            ", description='" + description + '\'' +
            ", price=" + price +
            '}';
    }
}
