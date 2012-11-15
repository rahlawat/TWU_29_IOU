package com.thoughtworks.twu.domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DebtorDetailsTest {
    @Test
    public void shouldHavePersonName() throws Exception {
        DebtorDetails debtorDetails = new DebtorDetails("Mengqiu",2000.0);
        String expectedPersonName = "Mengqiu";
        double expectedAmount = 2000.0;
        assertThat(debtorDetails.getDebtor(),is(expectedPersonName));
        assertThat(debtorDetails.getAmount(),is(expectedAmount));
    }
}
