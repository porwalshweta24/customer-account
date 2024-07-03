package com.core.customeraccount.repository;

import com.core.customeraccount.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The customer repository used to interact with the related DB table
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}