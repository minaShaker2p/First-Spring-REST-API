package com.example.task1.dao;

import com.example.task1.model.Customer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerDao {

    Customer createCustomer(Customer customer);

    List<Customer> getCustomers();

    Optional<Customer> getCustomer(UUID customerId);

    int deleteCustomer(UUID customerId);

    Customer updateCustomer(UUID customerId, Customer customer);

}
