package com.thoughtworks.twu.persistence;

import com.thoughtworks.twu.domain.IntegrationTest;
import com.thoughtworks.twu.domain.LoginUser;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;


public class LoginMapperTest extends IntegrationTest {

    @Autowired
    private LoginMapper loginMapper;

    @Test
    public void shouldReturnUserGivenEmail() {
        String email="sajacobs@thoughtworks.com";
        LoginUser user = loginMapper.getUserByEmail(email);
        assertThat(user.getUsername(), equalTo("Sam Jacobs"));
    }
}
