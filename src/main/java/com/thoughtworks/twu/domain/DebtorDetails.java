package com.thoughtworks.twu.domain;
//job : understands the people who have to pay the money
public class DebtorDetails {
    private String debtor;
    private double amount;

    private DebtorDetails(){

    }

    public DebtorDetails(String debtor, double amount) {
        this.debtor = debtor;
        this.amount = amount;
    }

    public String getDebtor() {
        return this.debtor;
    }

    public double getAmount() {
        return  this.amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DebtorDetails)) return false;

        DebtorDetails debtorDetails = (DebtorDetails) o;

        if (Double.compare(debtorDetails.amount, amount) != 0) return false;
        if (debtor != null ? !debtor.equals(debtorDetails.debtor) : debtorDetails.debtor != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = debtor != null ? debtor.hashCode() : 0;
        temp = amount != +0.0d ? Double.doubleToLongBits(amount) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
