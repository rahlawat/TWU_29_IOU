package com.thoughtworks.twu.controller;

import com.thoughtworks.twu.domain.User;
import com.thoughtworks.twu.service.UserService;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DashboardControllerTest {

    @Test
    public void shouldDisplayDashboardPage() throws Exception {
        ModelAndView modelAndView = dashboardPageModelAndView();

        ModelAndView modelAndViewTest = new ModelAndView("/dashboard").addObject("username", "Sam Jacobs");
        assertTrue(modelAndView.getViewName().equals(modelAndViewTest.getViewName()) && modelAndView.getModel().equals(modelAndViewTest.getModel()));
    }

    private ModelAndView dashboardPageModelAndView() throws IOException {
        UserService mockService = mock(UserService.class);
        when(mockService.getUserByEmail("sajacobs@thoughtworks.com")).thenReturn(new User("sajacobs@thoughtworks.com", "Sam Jacobs", "1234", "999-9999"));
        com.thoughtworks.twu.controller.DashboardController dashboardController = new DashboardController(mockService);
        MockHttpServletRequest servletRequest = new MockHttpServletRequest();
        servletRequest.getSession().setAttribute("user", "sajacobs@thoughtworks.com");
        return dashboardController.dashboardPage(servletRequest);
    }

}
