package com.thoughtworks.twu.controller;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class CreateAccountControllerTest {

    @Test
    public void shouldReturnModelViewForLogin() {
        CreateAccountController createAccountController = new CreateAccountController();
        Assert.assertTrue(createAccountController.createAccount().getViewName() == "createAccount"
                && createAccountController.createAccount().getModel().equals(new HashMap<String, Object>()));
    }
}
