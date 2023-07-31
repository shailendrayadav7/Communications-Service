package com.takeo.OrderApi.Service;

import com.takeo.OrderApi.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


}
