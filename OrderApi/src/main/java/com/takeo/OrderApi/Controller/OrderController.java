package com.takeo.OrderApi.Controller;

import com.takeo.OrderApi.Model.CustomerOrder;
import com.takeo.OrderApi.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consumer/customers/{customerId}/orders")
@CrossOrigin(origins = "http://localhost:5173/") // frontend URL
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/allorder")
    public List<CustomerOrder> getAllProducts(){
        return orderService.getAllOrders();
    }



    @PostMapping("/create")
    public ResponseEntity<CustomerOrder> createOrder(@PathVariable Long customerId, @RequestBody CustomerOrder customerOrder) {

        // Implement logic to create an order for the given customer

        // Set the customer for the order based on the customerId



        CustomerOrder createdCustomerOrder = orderService.createOrderForCustomer(customerId, customerOrder);

        return new ResponseEntity<>(createdCustomerOrder, HttpStatus.CREATED);

    }

    @PutMapping("/{orderId}")
    public ResponseEntity<CustomerOrder> updateOrder(@PathVariable Long customerId, @PathVariable Long orderId, @RequestBody CustomerOrder updatedCustomerOrder) {
        // Implement logic to update the order with the provided orderId for the given customer


        updatedCustomerOrder = orderService.updateOrderForCustomer(customerId, orderId, updatedCustomerOrder);

        return new ResponseEntity<>(updatedCustomerOrder, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }

    @GetMapping

    public ResponseEntity<List<CustomerOrder>> getOrdersForCustomer(@PathVariable Long customerId) {

        // Implement logic to get all orders for the given customer



        List<CustomerOrder> customerOrders = orderService.getOrdersForCustomer(customerId);

        return new ResponseEntity<>(customerOrders, HttpStatus.OK);

    }

}
