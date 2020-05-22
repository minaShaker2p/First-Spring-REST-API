package com.example.task1.model;

import java.util.UUID;

public class Invoice {
    private UUID invoiceId;
    private Double total;

    public Invoice(UUID invoiceId, Double total) {
        this.invoiceId = invoiceId;

        this.total = total;
    }

    public UUID getInvoiceId() {
        return invoiceId;
    }

    public Double getTotal() {
        return total;
    }
}

