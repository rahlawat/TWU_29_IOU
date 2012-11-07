package com.thoughtworks.twu.domain;

import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BillTest {

    @Test
    public void shouldHaveDescription() throws Exception {
        Bill bill = new Bill("Dinner",2000.0);
        String expectedDescription = "Dinner";
        double expectedAmount = 2000.0;
        assertThat(bill.getDescription(),is(expectedDescription));
        assertThat(bill.getAmount(),is(expectedAmount));
    }
}
