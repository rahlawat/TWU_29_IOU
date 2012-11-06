package com.thoughtworks.twu.controller;

import com.thoughtworks.twu.service.BillService;
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
        ModelAndView modelAndView = dashboardPageModelAndView();

        View view = modelAndView.getView();

        ModelAndView modelAndViewTest = new ModelAndView("/dashboard");
        assertThat(view, equalTo(modelAndViewTest.getView()));
    }

    private ModelAndView dashboardPageModelAndView() throws IOException {
        com.thoughtworks.twu.controller.DashboardController dashboardController = new DashboardController();
        return dashboardController.dashboardPage();
    }

    @Test
    public void shouldDisplayBillPageOnGet() throws Exception {
        DashboardController dashboardController = new DashboardController();
        ModelAndView modelAndView = dashboardController.responseWithBillPageOnGet();
        View view = modelAndView.getView();

        ModelAndView modelAndViewTest = new ModelAndView("/add-bill");
        assertThat(view, equalTo(modelAndViewTest.getView()));
    }

}
