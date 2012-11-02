
package com.thoughtworks.twu.controller;

import com.thoughtworks.twu.service.UserService;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class DashboardControllerTest {
    @Test
    public void shouldDisplayDashboardPage() throws Exception {
        ModelAndView modelAndView = dashBoardPageModelAndView();

        View view =  modelAndView.getView();

        ModelAndView modelAndViewTest = new ModelAndView("/dashboard");
        assertThat(view, equalTo(modelAndViewTest.getView()));
    }

    private ModelAndView dashBoardPageModelAndView() throws IOException {
        UserService mockUserService = mock(UserService.class);

        com.thoughtworks.twu.controller.DashboardController dashboardController = new DashboardController(mockUserService);
        return dashboardController.dashboardPage("Dashboard");
    }
}
