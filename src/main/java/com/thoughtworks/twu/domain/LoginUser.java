package com.thoughtworks.twu.domain;

import java.io.Serializable;

public class LoginUser implements Serializable {
    private String email;
    private String username;
    private String password;
    private String phoneNumber;

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    private LoginUser()
    {

    }




}
