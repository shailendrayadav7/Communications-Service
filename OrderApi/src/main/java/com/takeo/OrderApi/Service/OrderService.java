package com.takeo.OrderApi.Service;

import com.takeo.OrderApi.Model.CustomerOrder;
import com.takeo.OrderApi.Repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Transactional
@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<CustomerOrder> getAllOrders(){
        return orderRepository.findAll();
    }

    public Optional<CustomerOrder> getOrderById(Long id){
        return orderRepository.findById(id);
    }

    public CustomerOrder createOrder(CustomerOrder customerOrder) {
        return orderRepository.save(customerOrder);
    }

    public CustomerOrder updateOrder(Long id, CustomerOrder updatedCustomerOrder) {
        Optional<CustomerOrder> existingOrder = orderRepository.findById(id);
        if (existingOrder.isPresent()) {
            CustomerOrder customerOrderToUpdate = existingOrder.get();
            customerOrderToUpdate.setStatus(updatedCustomerOrder.getStatus());
            customerOrderToUpdate.setCreatedDate(updatedCustomerOrder.getCreatedDate());

            return orderRepository.save(customerOrderToUpdate);
        } else {
            throw new IllegalArgumentException("Order with ID " + id + " not found");
        }
    }


    public void deleteProduct(Long id) {
        orderRepository.deleteById(id);
    }

    public void deleteOrder(Long id) {
    }

    public CustomerOrder createOrderForCustomer(CustomerOrder customerOrder) {
        return orderRepository.save(customerOrder);
    }

    public CustomerOrder updateOrderForCustomer(Long customerId, Long orderId, CustomerOrder updatedCustomerOrder) {
        return updatedCustomerOrder;
    }

    public List<CustomerOrder> getOrdersForCustomer(Long customerId) {
        return null;
    }

    public CustomerOrder getOrderByIdAndCustomerId(Long orderId, Long customerId) {
        return null;
    }

    public CustomerOrder updateOrder(CustomerOrder updatedCustomerOrder) {
        return updatedCustomerOrder;
    }
}
