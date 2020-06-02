package com.example.task1.api;

import com.example.task1.model.Invoice;
import com.example.task1.service.InvoiceService;
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

@RequestMapping("api/v1/invoice")
@RestController
public class InvoiceController {
    private final InvoiceService invoiceService;

    @Autowired
    public InvoiceController( InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping()
    List<Invoice> getInvoices() {
        return invoiceService.getInvoices();
    }

    @GetMapping(path = "{invoiceId}")
    public Optional<Invoice> getInvoice(@PathVariable("invoiceId") UUID invoiceId) {
        return invoiceService.getInvoice(invoiceId);
    }

    @PostMapping
    public Invoice createInvoice(@RequestBody Invoice invoice) {
        return invoiceService.createInvoice(invoice);
    }

    @DeleteMapping(path = "{invoiceId}")
    public int deleteInvoice(@PathVariable("invoiceId") UUID invoiceId) {
        return invoiceService.deleteInvoice(invoiceId);
    }

    @PutMapping(path = "{invoiceId}")
    public Invoice updateInvoice(@PathVariable("invoiceId") UUID invoiceId, @RequestBody Invoice invoice) {
        return invoiceService.updateInvoice(invoiceId, invoice);
    }
}
