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
import java.util.Optional;

@RestController
@RequestMapping("/api/consumer/customers")
@CrossOrigin(origins = "http://localhost:5173/") // frontend URL
public class OrderController {
    private final CustomerService customerService;
    private final OrderService orderService;

    @Autowired
    public OrderController(CustomerService customerService, OrderService orderService) {
        this.customerService = customerService;
        this.orderService = orderService;
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping("/{customerId}/orders/create")
    public ResponseEntity<CustomerOrder> createOrderForCustomer(@PathVariable Long customerId, @RequestBody CustomerOrder customerOrder) {
        // Check if the customer exists
        Optional<Customer> customerOptional = customerService.getCustomerById(customerId);
        if (customerOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Set the customer for the order based on the customerId
        Customer customer = customerOptional.get();
        customerOrder.setCustomer(customer);

        // Create the order for the customer
        CustomerOrder createdCustomerOrder = orderService.createOrderForCustomer(customerOrder);

        return new ResponseEntity<>(createdCustomerOrder, HttpStatus.CREATED);
    }


    @PutMapping("/{customerId}/orders/{orderId}")
    public ResponseEntity<CustomerOrder> updateOrder(@PathVariable Long customerId, @PathVariable Long orderId, @RequestBody CustomerOrder updatedCustomerOrder) {
        // Check if the order exists and belongs to the specified customer
        CustomerOrder existingCustomerOrder = orderService.getOrderByIdAndCustomerId(orderId, customerId);
        if (existingCustomerOrder == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Retrieve the customer from the database using the provided customerId
        Customer customer = customerService.getCustomerById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("Customer with ID " + customerId + " not found"));

        // Set the customer for the order based on the retrieved customer
        updatedCustomerOrder.setId(orderId);
        updatedCustomerOrder.setCustomer(customer);

        // Update the order
        CustomerOrder updatedOrder = orderService.updateOrder(updatedCustomerOrder);
        return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
    }

    @DeleteMapping("/{customerId}/orders/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long customerId, @PathVariable Long orderId) {
        // Check if the order exists and belongs to the specified customer
        CustomerOrder existingCustomerOrder = orderService.getOrderByIdAndCustomerId(orderId, customerId);
        if (existingCustomerOrder == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        orderService.deleteOrder(orderId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{customerId}/orders")
    public ResponseEntity<List<CustomerOrder>> getOrdersForCustomer(@PathVariable Long customerId) {
        // Retrieve the customer from the database using the provided customerId
        Customer customer = customerService.getCustomerById(customerId)
                .orElse(null); // Set customer to null if not found

        // Check if the customer exists
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Get all orders for the customer
        List<CustomerOrder> customerOrders = orderService.getOrdersForCustomer(customerId);
        return new ResponseEntity<>(customerOrders, HttpStatus.OK);
    }

}
