package com.thoughtworks.twu.controller;

import com.thoughtworks.twu.service.UserService;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class BillControllerTest {
    @Test
    public void shouldDisplayBillPage() throws Exception {
        ModelAndView modelAndView = billPageModelAndView();

        View view = modelAndView.getView();

        ModelAndView modelAndViewTest = new ModelAndView("/add-bill");
        assertThat(view, equalTo(modelAndViewTest.getView()));
    }

    private ModelAndView billPageModelAndView() throws IOException {

        com.thoughtworks.twu.controller.BillController billController = new BillController();
        return billController.billPage("Bill");
    }

}
