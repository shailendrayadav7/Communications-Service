package com.takeo.OrderApi.Controller;

import com.takeo.OrderApi.Model.Customer;
import com.takeo.OrderApi.Model.CustomerOrder;
import com.takeo.OrderApi.Service.CustomerService;
import com.takeo.OrderApi.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consumer/customers")
@CrossOrigin(origins = "http://localhost:5173/") // frontend URL
public class OrderController {
    private final CustomerService customerService;

    @Autowired
    public OrderController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllProducts() {
        return customerService.getAllCustomers();
    }

    @PostMapping("/create")
    public ResponseEntity<Customer> createOrder(Long customerId, @RequestBody Customer customer) {
        // Implement logic to create an order for the given customer
        // Set the customer for the order based on the customerId
        Customer createdCustomer = customer.createCustomer(customerId);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long customerId, @RequestBody Customer updatedCustomer) {
        // Implement logic to update the order with the provided orderId for the given customer
        updatedCustomer = customerService.updateCustomer(customerId, updatedCustomer);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }

    @DeleteMapping("/{orderId}")
    public void deleteCustomer(@PathVariable Long orderId) {
        customerService.deleteCustomer(orderId);
    }
}
