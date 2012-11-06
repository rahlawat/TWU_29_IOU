package com.thoughtworks.twu.controller;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.core.Is.is;

public class CreateAccountControllerTest {

    @Test
    public void shouldReturnModelViewForLogin() {
        CreateAccountController createAccountController = new CreateAccountController();
        Assert.assertTrue(createAccountController.createAccount().getViewName() == "createAccount"
                && createAccountController.createAccount().getModel().equals(new HashMap<String, Object>()));
    }

    @Test
    public void shouldRedirectToCreateAccountOnNoEmail() {
        CreateAccountController createAccountController = new CreateAccountController();
        Assert.assertThat(createAccountController.checkFields("","Yue","yue123", ""),is("redirect:/createAccount"));
    }

    @Test
    public void shouldRedirectToCreateAccountOnNoName() {
        CreateAccountController createAccountController = new CreateAccountController();
        Assert.assertThat(createAccountController.checkFields("yding@thoughtworks.com","","yue123", ""),is("redirect:/createAccount"));
    }

    @Test
    public void shouldRedirectToCreateAccountOnNoPassword() {
        CreateAccountController createAccountController = new CreateAccountController();
        Assert.assertThat(createAccountController.checkFields("yding@thoughtworks.com","Yue","", ""),is("redirect:/createAccount"));
    }



}
