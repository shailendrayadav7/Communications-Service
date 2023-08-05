package com.takeo.OrderApi.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.takeo.OrderApi.Repository.ConsumerCustomerRepo;
import com.takeo.OrderApi.Model.ConsumerCustomer;

@Service
public class ConsumerCustomerService {

    private final ConsumerCustomerRepo consumerRepo;

    @Autowired
    public ConsumerCustomerService(ConsumerCustomerRepo consumerRepo) {
        this.consumerRepo = consumerRepo;
    }

    public List<ConsumerCustomer> getAllCustomer() {

        return consumerRepo.findAll();
    }

    public ConsumerCustomer createCustomer(ConsumerCustomer createCustomer) {
        return consumerRepo.save(createCustomer);
    }

    public ConsumerCustomer getCustomerById(Long customerID) {
        return consumerRepo.findById(customerID).orElse(null);
    }

    public ConsumerCustomer updateCustomer(Long customerID, ConsumerCustomer updateConsumer) {
        ConsumerCustomer exisitingCustomer = consumerRepo.findById(customerID).orElse(null);

        if (exisitingCustomer != null) {
            exisitingCustomer.setCustomerFname(updateConsumer.getCustomerFname());
            exisitingCustomer.setCustomerLname(updateConsumer.getCustomerLname());
            exisitingCustomer.setCustomerAddress(updateConsumer.getCustomerAddress());
            exisitingCustomer.setCustomerEmail(updateConsumer.getCustomerEmail());
            exisitingCustomer.setCustomerPhone(updateConsumer.getCustomerPhone());
            exisitingCustomer.setConsumerOrders(updateConsumer.getConsumerOrders());
            return consumerRepo.save(exisitingCustomer);
        }
        return null;
    }

}
