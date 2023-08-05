package com.takeo.OrderApi.Repository;

import com.takeo.OrderApi.Model.ConsumerCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.takeo.OrderApi.Model.ConsumerCustomer;

@Repository
public interface ConsumerCustomerRepo extends JpaRepository<ConsumerCustomer, Long>{

}
