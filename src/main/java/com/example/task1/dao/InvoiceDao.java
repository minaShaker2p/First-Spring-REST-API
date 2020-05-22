package com.example.task1.dao;

import com.example.task1.model.Customer;
import com.example.task1.model.Invoice;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface InvoiceDao {

    int createInvoice(Invoice invoice);

    List<Invoice> getInvoices();

    Optional<Invoice> getInvoice(UUID invoiceId);

    int deleteInvoice(UUID invoiceId);

    int updateInvoice(UUID invoiceId, Invoice invoice);

}
