package com.thoughtworks.twu.persistence;

import com.thoughtworks.twu.domain.Bill;
import com.thoughtworks.twu.domain.IntegrationTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;


@TestExecutionListeners({TransactionalTestExecutionListener.class})
public class BillMapperTest extends IntegrationTest {
    @Autowired
    private BillMapper billMapper;

    @Test
    @Transactional
    public void shouldSaveBillToTheDatabase() {
        String description = "Dinner";
        double amount = 2000;
        Bill bill = new Bill(description, amount);
        billMapper.insertBill(bill);
        Bill expectedBill = billMapper.getBillByDescription(description);
        assertThat(expectedBill.getAmount(), equalTo(amount));

    }
}
