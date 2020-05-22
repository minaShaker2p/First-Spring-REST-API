package com.example.task1.dao;

import com.example.task1.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository("InvoiceDao")
public class InvoiceDataAccessService implements InvoiceDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public InvoiceDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int createInvoice(Invoice invoice) {
        String sql = "INSERT INTO invoice (invoiceId , total) VALUES (? ,? )";
        Object[] params = new Object[]{UUID.randomUUID(), invoice.getTotal()};
        return jdbcTemplate.update(sql, params);
    }

    @Override
    public List<Invoice> getInvoices() {
        String sql = "SELECT * FROM  invoice";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("invoiceId"));
            Double total = resultSet.getDouble("total");
            return new Invoice(id, total);
        });
    }

    @Override
    public Optional<Invoice> getInvoice(UUID invoiceId) {
        String sql = "SELECT * FROM  invoice WHERE invoiceId = ?";
        Invoice invoice = jdbcTemplate.queryForObject(sql, new Object[]{invoiceId}, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("invoiceId"));
            Double total = resultSet.getDouble("total");
            return new Invoice(id, total);
        });
        return Optional.ofNullable(invoice);
    }

    @Override
    public int deleteInvoice(UUID invoiceId) {
        String sql = "DELETE FROM invoice WHERE invoiceId = ?";
        Object[] params = new Object[]{invoiceId};
        return jdbcTemplate.update(sql, params);
    }

    @Override
    public int updateInvoice(UUID invoiceId, Invoice invoice) {
        String sql = "UPDATE invoice SET total = ?  WHERE invoiceId = ?";
        Object[] params = new Object[]{invoice.getTotal(), invoiceId};
        return jdbcTemplate.update(sql, params);
    }
}
