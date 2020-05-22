package com.example.task1.service;

import com.example.task1.dao.CustomerDao;
import com.example.task1.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("CustomerService")
public class CustomerService {

    private final CustomerDao customerDao;

    @Autowired
    public CustomerService(@Qualifier("CustomerDao") CustomerDao customerDao) {
        this.customerDao = customerDao;
    }


    public int createCustomer(Customer customer) {
        return customerDao.createCustomer(customer);
    }

    public List<Customer> getCustomers() {
        return customerDao.getCustomers();
    }

    public Optional<Customer> getCustomer(UUID customerId) {
        return customerDao.getCustomer(customerId);
    }

    public int deleteCustomer(UUID customerId) {
        return customerDao.deleteCustomer(customerId);
    }

    public int updateCustomer(UUID customerId, Customer customer) {
        return customerDao.updateCustomer(customerId, customer);
    }
}
