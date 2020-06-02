package com.example.task1.dao;

import com.example.task1.model.Invoice;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface InvoiceDao {

    Invoice createInvoice(Invoice invoice);

    List<Invoice> getInvoices();

    Optional<Invoice> getInvoice(UUID invoiceId);

    int deleteInvoice(UUID invoiceId);

    Invoice updateInvoice(UUID invoiceId, Invoice invoice);

}
