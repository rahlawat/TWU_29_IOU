package com.thoughtworks.twu.service;

import com.thoughtworks.twu.domain.LoginUser;
import com.thoughtworks.twu.persistence.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginService {
    private LoginMapper loginMapper;

    @Autowired
    public LoginService(LoginMapper loginMapper) {
        this.loginMapper = loginMapper;
    }

    public LoginUser getUser(String email) {
        return loginMapper.getUser(email);
    }


}