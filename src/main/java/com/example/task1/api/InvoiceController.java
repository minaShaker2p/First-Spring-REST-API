package com.example.task1.api;

import com.example.task1.model.Invoice;
import com.example.task1.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/invoice")
@RestController
public class InvoiceController {
    private final InvoiceService invoiceService;

    @Autowired
    public InvoiceController(@Qualifier("InvoiceService") InvoiceService invoiceService) {
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
    public int createInvoice(@RequestBody Invoice invoice) {
        return invoiceService.createInvoice(invoice);
    }

    @DeleteMapping(path = "{invoiceId}")
    public int deleteInvoice(@PathVariable("invoiceId") UUID invoiceId) {
        return invoiceService.deleteInvoice(invoiceId);
    }

    @PutMapping(path = "{invoiceId}")
    public int updateInvoice(@PathVariable("invoiceId") UUID invoiceId, @RequestBody Invoice invoice) {
        return invoiceService.updateInvoice(invoiceId, invoice);
    }
}
