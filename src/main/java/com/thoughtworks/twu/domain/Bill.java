package com.thoughtworks.twu.domain;
 //job: understands the receipt
public class Bill {
    private String description;
    private Integer amount;

    public Bill(String description, int amount) {
        this.description = description;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public int getAmount() {
        return amount;
    }
}
