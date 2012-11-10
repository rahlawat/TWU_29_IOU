package com.thoughtworks.twu.controller;

import com.thoughtworks.twu.domain.User;
import com.thoughtworks.twu.service.ConnectionService;
import com.thoughtworks.twu.service.UserService;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.io.IOException;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ConnectionControllerTest {
    ConnectionService mockConnectionService = mock(ConnectionService.class);

    private ConnectionController friends = new ConnectionController(mockConnectionService);

    @Test
    public void shouldNavigateToFriendsListPage() throws Exception {


        ModelAndView expectedModelAndView = new ModelAndView("/my-friends-list").addObject("user", "sajacobs@thoughtworks.com");
        MockHttpServletRequest servletRequest = new MockHttpServletRequest();
        servletRequest.getSession().setAttribute("user", "sajacobs@thoughtworks.com");
        ModelAndView actualModelAndView = friends.listPage(servletRequest);

        assertEquals(expectedModelAndView.getViewName(), actualModelAndView.getViewName());
        assertEquals(expectedModelAndView.getModel(), actualModelAndView.getModel());
    }


}
