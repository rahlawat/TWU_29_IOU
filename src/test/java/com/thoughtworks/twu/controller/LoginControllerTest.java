package com.thoughtworks.twu.controller;


import com.thoughtworks.twu.controller.LoginController;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.core.Is.is;

public class LoginControllerTest {

    @Test
    public void shouldReturnModelViewForLogin() {
        LoginController loginController = new LoginController();
        Assert.assertTrue(loginController.login().getViewName() == "login" && loginController.login().getModel().equals(new HashMap<String, Object>()));
    }

    @Test
    public void shouldRedirectToLoginOnNoEmail() {
        LoginController loginController = new LoginController();
        Assert.assertThat(loginController.checkCredentials("", "pword"), is("redirect:/login"));
    }

    @Test
    public void shouldRedirectToLoginOnNoPassword() {
        LoginController loginController = new LoginController();
        Assert.assertThat(loginController.checkCredentials("email@email", ""), is("redirect:/login"));
    }

}