package com.takeo.OrderApi.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class ConsumerOrder {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long orderID;
    private String orderName;
    private double orderPrice;
    private String orderStatus;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="customerID")
    private ConsumerCustomer consumerCustomer;

    public ConsumerOrder() {

    }

    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public ConsumerCustomer getConsumerCustomer() {
        return consumerCustomer;
    }

    public void setConsumerCustomer(ConsumerCustomer consumerCustomer) {
        this.consumerCustomer = consumerCustomer;
    }

}
