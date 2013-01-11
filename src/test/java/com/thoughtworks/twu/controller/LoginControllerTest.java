package com.thoughtworks.twu.controller;


import com.thoughtworks.twu.domain.LoginUser;
import com.thoughtworks.twu.domain.User;
import com.thoughtworks.twu.service.LoginService;
import com.thoughtworks.twu.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LoginControllerTest {

    @Test
    public void shouldReturnModelViewForLogin() {

        LoginController loginController = new LoginController();

        Assert.assertTrue(loginController.login().getViewName() == "login" && loginController.login().getModel().equals(new HashMap<String, Object>()));
    }

//    @Test
//    public void shouldRedirectToLoginOnNoEmail() {
//        LoginController loginController = new LoginController();
//        Assert.assertThat(loginController.checkCredentials("", "pword"), is("redirect:/login"));
//    }
//
//    @Test
//    public void shouldRedirectToLoginOnNoPassword() {
//        LoginController loginController = new LoginController();
//        Assert.assertThat(loginController.checkCredentials("email@email", ""), is("redirect:/login"));
//    }

//    @Test
//    public void shouldAddSessionAndEmailToPageModelWhereUserExists() throws Exception {
//        ModelAndView modelAndView = loginModelAndView("user@gmail.com","user","1234","111-1111", true);
//
//        String email = (String) modelAndView.getModel().get("email");
//       // HttpSession session =  (HttpSession) modelAndView.getModel().get("session");
//        //String sessionID =  (String) modelAndView.getModel().get("sessionID");
//
//        System.out.print(email + " " + sessionID);
//        //assertThat(email, equalTo("user@gmail.com"));
//        assertNotNull(sessionID);
//
//    }

//    @Test
//    public void shouldAddRedirectViewToPageModelWhereUserNotFound() throws Exception {
//        ModelAndView modelAndView = loginModelAndView("invaliduser@gmail.com","invalid","1234","123-4567", false);
//
//        String username = (String) modelAndView.getModel().get("username");
//        User user = (User) modelAndView.getModel().get("user");
//
//        assertThat(username, equalTo("invalid-user"));
//        assertThat(user, is(nullValue()));
//    }

    private ModelAndView loginModelAndView(String email, String username, String password, String phone, boolean validUser) throws IOException {
        UserService mockUserService = mock(UserService.class);
        User user = (validUser) ? new User(email, username, password, phone) : null;
        when(mockUserService.getUserByEmail(email)).thenReturn(user);


        LoginController loginController = new LoginController(mockUserService);
        return loginController.checkCredentials(email, password, new MockHttpServletRequest());
    }
}