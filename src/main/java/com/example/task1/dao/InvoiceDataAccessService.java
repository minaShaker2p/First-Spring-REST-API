package com.example.task1.dao;

import com.example.task1.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
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
    public Invoice createInvoice(Invoice invoice) {
        String sql = "INSERT INTO invoice (invoiceId , total) VALUES (? ,? )";
        UUID id = UUID.randomUUID();
        Object[] params = {id, invoice.getTotal()};
        int create = jdbcTemplate.update(sql, params);
        return create == 1 ? new Invoice(id, invoice.getTotal()) : null;
    }

    @Override
    public List<Invoice> getInvoices() {
        String sql = "SELECT * FROM  invoice";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("invoiceId"));
            BigDecimal total = resultSet.getBigDecimal("total");
            return new Invoice(id, total);
        });
    }

    @Override
    public Optional<Invoice> getInvoice(UUID invoiceId) {
        String sql = "SELECT * FROM  invoice WHERE invoiceId = ?";
        Invoice invoice = jdbcTemplate.queryForObject(sql, new Object[]{invoiceId}, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("invoiceId"));
            BigDecimal total = resultSet.getBigDecimal("total");
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
    public Invoice updateInvoice(UUID invoiceId, Invoice invoice) {
        String sql = "UPDATE invoice SET total = ?  WHERE invoiceId = ?";
        Object[] params = {invoice.getTotal(), invoiceId};
        int update = jdbcTemplate.update(sql, params);

        return update == 1 ? new Invoice(invoiceId, invoice.getTotal()) : null;
    }
}
