package com.thoughtworks.twu.domain;
//job : understands the people who have to pay the money
public class OweMe {
    private String personName;
    private double amount;

    private OweMe(){

    }

    public OweMe(String personName, double amount) {
        this.personName = personName;
        this.amount = amount;
    }

    public String getPersonName() {
        return this.personName;
    }

    public double getAmount() {
        return  this.amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OweMe)) return false;

        OweMe oweMe = (OweMe) o;

        if (Double.compare(oweMe.amount, amount) != 0) return false;
        if (personName != null ? !personName.equals(oweMe.personName) : oweMe.personName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = personName != null ? personName.hashCode() : 0;
        temp = amount != +0.0d ? Double.doubleToLongBits(amount) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
