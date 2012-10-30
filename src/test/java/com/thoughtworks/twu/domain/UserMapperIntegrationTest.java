package com.thoughtworks.twu.domain;


import com.thoughtworks.twu.persistence.UserMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class UserMapperIntegrationTest extends IntegrationTest {

    @Autowired
    private UserMapper userMapper;


    @Test
    public  void shouldChooseUserByUserEmail() {
        String email = "yding@thoughtworks.com";
        addUserToRepository();
        User user = userMapper.getUser(email);
        assertThat(user.getName(), equalTo("Yue"));
    }

    private void addUserToRepository() {
        userMapper.insertUser(new User("Yue","yding@thoughtworks.com","123","13991871507"));
    }

}
