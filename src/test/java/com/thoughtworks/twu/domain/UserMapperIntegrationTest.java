package com.thoughtworks.twu.domain;


import com.thoughtworks.twu.persistence.UserMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserMapperIntegrationTest extends IntegrationTest {

    @Autowired
    private UserMapper userMapper;



    @Before
    public void setUp()
    {

    }

    @Test
    public  void shouldChooseUserByUserEmail() {
        String email = "yding@thoughtworks.com";
        User expectedUser = new User("yding@thoughtworks.com", "Yue", "yue123","13991871507");


        User receivedUser = userMapper.getUserByEmail(email);

        assertThat(receivedUser, equalTo(expectedUser));
    }


    @Test
    public  void shouldReturnNullIfGetUserByEmailDontFoundAnyUser() {
        String email = "rcoelho@thoughtworks.com";

        assertThat(userMapper.getUserByEmail(email), equalTo(null));
    }

    @Test
    public void shouldReturnTheListOfDebtorDetail() {

        String userEmail = "sajacobs@thoughtworks.com";
        DebtorDetails raji = new DebtorDetails("rahlawat@thoughtworks.com", 100);
        DebtorDetails yue = new DebtorDetails("yding@thoughtworks.com", 100);
        DebtorDetails mengqiu = new DebtorDetails("mqpeng@thoughtworks.com", 100);
        ArrayList<DebtorDetails> expectedDebtors = new ArrayList<DebtorDetails>();
        expectedDebtors.add(raji);
        expectedDebtors.add(yue);
        expectedDebtors.add(mengqiu);

        ArrayList<DebtorDetails> debtors = userMapper.getPeopleWhoOweMe(userEmail);

        assertThat(debtors.contains(expectedDebtors.get(0)), is(true));
        assertThat(debtors.contains(expectedDebtors.get(1)), is(true));
        assertThat(debtors.contains(expectedDebtors.get(2)), is(true));
    }
    
}
