package com.example.task1.api;

import com.example.task1.model.Customer;
import com.example.task1.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/customer")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping(path = "{customerId}")
    public Optional<Customer> getCustomer(@PathVariable("customerId") UUID customerId) {
        return customerService.getCustomer(customerId);
    }

    @DeleteMapping(path = "{customerId}")
    public int deleteCustomer(@PathVariable("customerId") UUID customerId) {
        return customerService.deleteCustomer(customerId);
    }

    @PutMapping(path = "{customerId}")
    public Customer updateCustomer(@PathVariable("customerId") UUID customerId, @RequestBody Customer customer) {
        return customerService.updateCustomer(customerId, customer);
    }
}
