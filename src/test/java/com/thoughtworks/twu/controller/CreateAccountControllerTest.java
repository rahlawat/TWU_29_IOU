package com.thoughtworks.twu.controller;

import com.thoughtworks.twu.domain.User;
import com.thoughtworks.twu.persistence.UserMapper;
import com.thoughtworks.twu.service.UserService;
import org.h2.util.New;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.HashMap;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CreateAccountControllerTest {

    User user= new User("yding@thoughtworks.com","Yue","yue123", "");
    
    @Test
    public void shouldReturnModelViewForLogin() {
        CreateAccountController createAccountController = new CreateAccountController();
        Assert.assertTrue(createAccountController.createAccount().getViewName() == "createAccount"
                && createAccountController.createAccount().getModel().equals(new HashMap<String, Object>()));
    }

    @Test
    public void shouldRedirectToCreateAccountOnNoEmail() {
        CreateAccountController createAccountController = new CreateAccountController();
        Assert.assertThat(createAccountController.checkFields("",user.getUsername(),user.getPassword(), ""),is("redirect:/createAccount"));
    }

    @Test
    public void shouldRedirectToCreateAccountOnNoName() {
        CreateAccountController createAccountController = new CreateAccountController();
        Assert.assertThat(createAccountController.checkFields(user.getEmail(),"",user.getPassword(), ""),is("redirect:/createAccount"));
    }

    @Test
    public void shouldRedirectToCreateAccountOnNoPassword() {
        CreateAccountController createAccountController = new CreateAccountController();
        Assert.assertThat(createAccountController.checkFields(user.getEmail(),user.getUsername(),"", ""),is("redirect:/createAccount"));
    }

    @Test
     public void shouldSaveAccountWhenEmailNotExistInDatabase() {
        CreateAccountController createAccountController = mockedCreateAccountController(user, false);
        Assert.assertThat(createAccountController.checkFields(user.getEmail(),user.getUsername(),user.getPassword(), ""),is("redirect:/login"));
    }

    @Test
    public void shouldNotSaveAccountWhenEmailAlreadyExistInDatabase() {
        CreateAccountController createAccountControllerForExistentUser = mockedCreateAccountController(user, true);
        Assert.assertThat(createAccountControllerForExistentUser.checkFields(user.getEmail(),user.getUsername(),user.getPassword(), ""),is("redirect:/createAccount"));
    }

    private CreateAccountController mockedCreateAccountController(User user, boolean userAlreadyExist){
        UserService mockUserService = mock(UserService.class);
        if (userAlreadyExist)
            when(mockUserService.getUserByEmail(user.getEmail())).thenReturn(user);
        else
            when(mockUserService.getUserByEmail(user.getEmail())).thenReturn(null);
        
        return new CreateAccountController(mockUserService);
    }


}
