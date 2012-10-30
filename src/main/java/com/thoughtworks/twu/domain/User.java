package com.thoughtworks.twu.domain;

import java.io.Serializable;


public class User implements Serializable {


    private String name;
    private String email;
    private String password;
    private String phoneNumber;


    private User() {}

    public User(String name) {
        this.name = name;
    }

    public User(String name, String email,String password,String phoneNumber) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
