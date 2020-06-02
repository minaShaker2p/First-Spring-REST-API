package com.example.task1.dao;

import com.example.task1.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CustomerDataAccessService implements CustomerDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CustomerDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Customer createCustomer(Customer customer) {
        UUID id = UUID.randomUUID();
        String sql = "INSERT INTO customer (customerId,customerName ) VALUES (?,?)";
        Object[] params = {id, customer.getCustomerName()};
        int create = jdbcTemplate.update(sql, params);
        if (create == 1)
            return new Customer(id, customer.getCustomerName(), customer.getInvoiceId());
        else
            return null;
    }

    @Override
    public List<Customer> getCustomers() {
        String sql = "SELECT customerId, customerName, invoiceId FROM customer";

        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("customerId"));
            String name = resultSet.getString("customerName");
            String invoiceUUID = resultSet.getString("invoiceId");
            UUID invoiceId = invoiceUUID != null ? UUID.fromString(invoiceUUID) : null;
            return new Customer(id, name, invoiceId);
        });
    }

    @Override
    public Optional<Customer> getCustomer(UUID customerId) {
        String sql = "SELECT customerId, customerName FROM customer WHERE customerId = ?";
        Customer customer = jdbcTemplate.queryForObject(sql, new Object[]{customerId}, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("customerId"));
            String name = resultSet.getString("customerName");
            return new Customer(id, name, null);
        });
        return Optional.ofNullable(customer);
    }

    @Override
    public int deleteCustomer(UUID customerId) {
        String sql = "DELETE FROM  customer WHERE customerId = ?";
        Object[] params = {customerId};
        return jdbcTemplate.update(sql, params);
    }

    @Override
    public Customer updateCustomer(UUID customerId, Customer customer) {
        String sql = "UPDATE customer SET customerName = ? , invoiceId = ? WHERE customerId = ?";
        Object[] params = {customer.getCustomerName(), customer.getInvoiceId(), customerId};
        int update = jdbcTemplate.update(sql, params);
        if (update == 1)
            return new Customer(customerId, customer.getCustomerName(), customer.getInvoiceId());
        else
            return null;
    }
}
