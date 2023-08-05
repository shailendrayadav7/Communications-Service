package com.takeo.OrderApi.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.takeo.OrderApi.Model.ConsumerOrder;

@Repository
public interface ConsumerOrderRepo extends JpaRepository<ConsumerOrder, Long>{

    List<ConsumerOrder> findByConsumerCustomerCustomerID(Long customerID);

}
