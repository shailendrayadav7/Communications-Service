package com.takeo.OrderApi.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class ConsumerCustomer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long customerID;
    private String customerFname;
    private String customerLname;
    private String customerEmail;
    private String customerAddress;
    private String customerPhone;

    @JsonManagedReference
    @OneToMany(mappedBy = "consumerCustomer", cascade = CascadeType.ALL)
    private List<ConsumerOrder> consumerOrders;

    public ConsumerCustomer() {

    }

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    public String getCustomerFname() {
        return customerFname;
    }

    public void setCustomerFname(String customerFname) {
        this.customerFname = customerFname;
    }

    public String getCustomerLname() {
        return customerLname;
    }

    public void setCustomerLname(String customerLname) {
        this.customerLname = customerLname;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public List<ConsumerOrder> getConsumerOrders() {
        return consumerOrders;
    }

    public void setConsumerOrders(List<ConsumerOrder> consumerOrders) {
        this.consumerOrders = consumerOrders;
    }

}
