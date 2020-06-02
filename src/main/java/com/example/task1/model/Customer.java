package com.example.task1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
public class Customer {

    @Setter
    private String customerName;

    private final UUID customerId;
    private final UUID invoiceId;

    public UUID getCustomerId() {
        return customerId;
    }

    public Customer(@JsonProperty("customerId") UUID customerId,
                    @JsonProperty("customerName") String customerName,
                    @JsonProperty("invoiceId") UUID invoiceId) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.invoiceId = invoiceId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public UUID getInvoiceId() {
        return invoiceId;
    }


}
