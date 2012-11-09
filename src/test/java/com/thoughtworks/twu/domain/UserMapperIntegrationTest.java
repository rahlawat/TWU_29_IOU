package com.thoughtworks.twu.domain;


import com.thoughtworks.twu.persistence.UserMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@TestExecutionListeners({TransactionalTestExecutionListener.class})
public class UserMapperIntegrationTest extends IntegrationTest {

    @Autowired
    private UserMapper userMapper;


    @Before
    public void setUp()
    {

    }

    @Transactional
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
    
}
