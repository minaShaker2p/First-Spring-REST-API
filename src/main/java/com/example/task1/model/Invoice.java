package com.example.task1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;


@Getter
public class Invoice {
    private final UUID invoiceId;
    private final BigDecimal total;

    public Invoice(@JsonProperty("invoiceId") UUID invoiceId,
                   @JsonProperty("total") BigDecimal total) {
        this.invoiceId = invoiceId;
        this.total = total;
    }
}

