package com.core.customeraccount.service;

import com.core.customeraccount.dto.CustomerDTO;

import java.util.List;

/**
 * Customer services
 *
 */
public interface CustomerService {

    /**
     * Service to fetch customer info
     *
     * @param id The customer ID
     * @return the customer info
     */
    CustomerDTO fetchCustomerInfo(Long id);

    /**
     * Service to fetch all customers
     *
     * @return the list of customers
     */
    List<CustomerDTO> fetchAllCustomers();
}
