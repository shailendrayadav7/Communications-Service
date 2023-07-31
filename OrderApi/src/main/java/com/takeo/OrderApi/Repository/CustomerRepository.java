package com.takeo.OrderApi.Repository;

import com.takeo.OrderApi.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

