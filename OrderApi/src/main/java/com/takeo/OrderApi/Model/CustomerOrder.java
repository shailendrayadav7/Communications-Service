package com.takeo.OrderApi.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //private Long customerId;
    private String status;
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public CustomerOrder(){

    }

    public CustomerOrder(Long id, Long customerId, String status, Date createdDate) {
        this.id = id;
        //this.customerId = customerId;
        this.status = status;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

}
