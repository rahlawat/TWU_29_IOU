package com.thoughtworks.twu.domain;

import com.thoughtworks.twu.persistence.BillMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class BillMapperIntegrationTest {

    //@Autowired
   // private BillMapper billMapper;


    /*@Test
    public  void shouldSaveBillToTheDatabase() {
        String description = "Lunch";
        addBillToRepository(description);
        Bill expectedBill = billMapper.getBill(description);
        assertThat(expectedBill.getDescription(), equalTo("Lunch"));
    }

    private void addBillToRepository(String description) {
        billMapper.insertBill(new Bill(description, 200));
    }      */

}
