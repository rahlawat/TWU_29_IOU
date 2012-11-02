package com.thoughtworks.twu.domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BillTest {

    @Test
    public void shouldHaveDescription() throws Exception {
        Bill bill = new Bill("Dinner",2000);
        String expectedDescription = "Dinner";
        int expectedAmount = 2000;
        assertThat(bill.getDescription(),is(expectedDescription));
        assertThat(bill.getAmount(),is(expectedAmount));
    }
}
