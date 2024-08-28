package com.CustomerMgmt.repository;

import com.CustomerMgmt.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository  extends JpaRepository<Customer, Long> {
}
