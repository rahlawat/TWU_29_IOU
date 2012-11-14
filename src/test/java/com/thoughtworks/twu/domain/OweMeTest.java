package com.thoughtworks.twu.domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class OweMeTest {
    @Test
    public void shouldHavePersonName() throws Exception {
        OweMe oweMe = new OweMe("Mengqiu",2000.0);
        String expectedPersonName = "Mengqiu";
        double expectedAmount = 2000.0;
        assertThat(oweMe.getPersonName(),is(expectedPersonName));
        assertThat(oweMe.getAmount(),is(expectedAmount));
    }
}
