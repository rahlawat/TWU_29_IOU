package com.thoughtworks.twu.controller;

import com.thoughtworks.twu.service.ConnectionService;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;

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
