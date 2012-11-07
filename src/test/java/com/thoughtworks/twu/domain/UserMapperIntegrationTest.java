package com.thoughtworks.twu.domain;


import com.thoughtworks.twu.persistence.UserMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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

        userMapper.insertUser(expectedUser);

        User receivedUser = userMapper.getUserByEmail(email);

        assertThat(receivedUser, equalTo(expectedUser));
    }

    @Test
    public  void shouldReturnNullIfGetUserByEmailDontFoundAnyUser() {
        String email = "rcoelho@thoughtworks.com";

        assertThat( userMapper.getUserByEmail(email), equalTo(null));
    }
    
}
