package com.thoughtworks.twu.controller;

import com.thoughtworks.twu.domain.User;
import com.thoughtworks.twu.persistence.UserMapper;
import com.thoughtworks.twu.service.UserService;
import org.h2.util.New;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.HashMap;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

    @Test
     public void shouldRedirectToDashBoardWhenSaveAccount() {
        CreateAccountController createAccountController = mockedCreateAccountController();
        Assert.assertThat(createAccountController.checkFields("yding@thoughtworks.com","Yue","yue123", ""),is("redirect:/dashboard"));
    }

    @Test
    public void shouldNotSaveAccountWhenEmailAlreadyExistInDatabase() {
        CreateAccountController createAccountController = mockedCreateAccountController();
        CreateAccountController createAccountControllerClone = mockedCreateAccountControllerClone();

        createAccountController.checkFields("yding@thoughtworks.com","Yue","yue123", "");

        Assert.assertThat(createAccountControllerClone.checkFields("yding@thoughtworks.com","YueClone","yueclone123", ""),is("redirect:/createAccount"));
    }


    private CreateAccountController mockedCreateAccountController(){
        UserService mockUserService = mock(UserService.class);
        when(mockUserService.getUserByEmail("yding@thoughtworks.com")).thenReturn(null);

        return new CreateAccountController(mockUserService);
    }

    private CreateAccountController mockedCreateAccountControllerClone(){
        User user= new User("yding@thoughtworks.com","YueClone","yueclone123", "");

        UserService mockUserService = mock(UserService.class);
        when(mockUserService.getUserByEmail(user.getEmail())).thenReturn(user);

        return new CreateAccountController(mockUserService);
    }


}
