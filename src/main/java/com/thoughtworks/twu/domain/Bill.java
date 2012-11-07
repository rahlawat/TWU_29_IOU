package com.thoughtworks.twu.domain;

import java.math.BigDecimal;

//job: understands the receipt
public class Bill {
    private String description;
    private double amount;

    private Bill()
    {

    }
    public Bill(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }
}
