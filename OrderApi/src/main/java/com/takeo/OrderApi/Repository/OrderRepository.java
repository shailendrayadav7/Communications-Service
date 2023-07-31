package com.takeo.OrderApi.Repository;

import com.takeo.OrderApi.Model.Customer;
import com.takeo.OrderApi.Model.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<CustomerOrder, Long> {
        List<CustomerOrder> findByCustomer(Customer customer);
        CustomerOrder findByIdAndCustomer(Long orderId, Customer customer);

}
