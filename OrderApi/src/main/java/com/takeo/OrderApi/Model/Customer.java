package com.takeo.OrderApi.Model;

import jakarta.persistence.*;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customer_id;
    private String name;
    private String email;

    private Customer(){

    }

    public Customer(Long customer_id, String name, String email) {
        this.customer_id = customer_id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return customer_id;
    }

    public void setId(Long customer_id) {
        this.customer_id = customer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
