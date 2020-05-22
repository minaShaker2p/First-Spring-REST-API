package com.example.task1.service;

import com.example.task1.dao.InvoiceDao;
import com.example.task1.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("InvoiceService")
public class InvoiceService {
    private final InvoiceDao invoiceDao;

    @Autowired
    public InvoiceService(@Qualifier("InvoiceDao") InvoiceDao invoiceDao) {
        this.invoiceDao = invoiceDao;
    }

    public List<Invoice> getInvoices() {
        return invoiceDao.getInvoices();
    }

    public Optional<Invoice> getInvoice(UUID invoiceId) {
        return invoiceDao.getInvoice(invoiceId);
    }

    public int createInvoice(Invoice invoice) {
        return invoiceDao.createInvoice(invoice);
    }

    public int deleteInvoice(UUID invoiceId) {
        return invoiceDao.deleteInvoice(invoiceId);
    }

    public int updateInvoice(UUID invoiceId, Invoice invoice) {
        return invoiceDao.updateInvoice(invoiceId, invoice);
    }


}
