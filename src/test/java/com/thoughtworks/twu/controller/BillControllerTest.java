package com.thoughtworks.twu.controller;

import com.thoughtworks.twu.domain.Bill;
import com.thoughtworks.twu.domain.User;
import com.thoughtworks.twu.persistence.BillMapper;
import com.thoughtworks.twu.service.BillService;
import com.thoughtworks.twu.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BillControllerTest {
    @Autowired
    private BillMapper billMapper;


    @Test
    public void shouldDisplayBillPage() {
        BillController billController = mockedBillController();
        ModelAndView modelAndView = billController.billPage("Bill", "98237.00");
        View view = modelAndView.getView();

        ModelAndView modelAndViewTest = new ModelAndView("/add-bill");
        assertThat(view, equalTo(modelAndViewTest.getView()));
    }

    private BillController mockedBillController() {

        BillService mockBillService = mock(BillService.class);
        when(mockBillService.getBill("Dinner")).thenReturn(null);

        return new BillController(mockBillService);

    }

    private BillController mockedBillControllerClone() {
        Bill bill = new Bill("Dinner", 45.21);
        BillService mockBillService = mock(BillService.class);
        when(mockBillService.getBill(bill.getDescription())).thenReturn(bill);
        return new BillController(mockBillService);
    }


    @Test
    public void shouldRedirectToAddBillOnNoDescription() {
        BillController billController = mockedBillController();
        ModelAndView modelAndView = billController.billPage("", "0.0");
        View view = modelAndView.getView();
        ModelAndView modelAndViewTest = new ModelAndView("/add-bill");


        assertThat(view, equalTo(modelAndViewTest.getView()));
    }

    @Test
    public void shouldSaveBillToTheDatabase() {
        String description = "Lunch";
        String amount = "2000.00";
        BillController billController = mockedBillController();
        BillController billControllerClone = mockedBillControllerClone();
        billControllerClone.billPage(description, amount);
        assertThat(billControllerClone.billPage(description, amount).getView(), equalTo(new ModelAndView("/add-bill").getView()));
    }


}
