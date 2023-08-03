package com.takeo.OrderApi.Service;

import com.takeo.OrderApi.Model.Customer;
import com.takeo.OrderApi.Model.CustomerOrder;
import com.takeo.OrderApi.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Long customerId){
        return customerRepository.findById(customerId);
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        Optional<Customer> existingCustomer = customerRepository.findById(id);
        if (existingCustomer.isPresent()) {
            Customer customerToUpdate = existingCustomer.get();
            customerToUpdate.setName(updatedCustomer.getName());
            customerToUpdate.setEmail(updatedCustomer.getEmail());
            return customerRepository.save(customerToUpdate);
        } else {
            throw new IllegalArgumentException("Customer with ID " + id + " not found");
        }
    }


    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

//    public void deleteCustomer(Long id) {
//    }

    //    public Customer updateCustomer(Long customerId, Customer updatedCustomer) {
//        return updatedCustomer;
//    }

    public List<Customer> getCustomer(Long customerId) {
        return null;
    }


}
