package com.thoughtworks.twu.controller;

import com.thoughtworks.twu.domain.Bill;
import com.thoughtworks.twu.service.BillService;
import com.thoughtworks.twu.service.ConnectionService;
import org.junit.Test;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BillControllerTest {
    private static final String USER_EMAIL = "yding@thoughtworks.com";


    @Test
    public void shouldDisplayBillPage() {
        BillController billController = mockedBillController();
        MockHttpSession mockedSession = new MockHttpSession();
        mockedSession.setAttribute("user", "yding@thoughtworks.com");
        ModelAndView modelAndView = billController.billPage("Bill", "98237.00",mockedSession);
        View view = modelAndView.getView();

        ModelAndView modelAndViewTest = new ModelAndView("/add-bill");
        assertThat(view, equalTo(modelAndViewTest.getView()));
    }

    private BillController mockedBillController() {

        ArrayList<String> expectedList = new ArrayList<String>();
        expectedList.add("faris@thoughtworks.com");
        expectedList.add("renu@thoughtworks.com");
        expectedList.add("sam@thoughtworks.com");

        BillService mockBillService = mock(BillService.class);
        when(mockBillService.getBill("Dinner")).thenReturn(null);

        ConnectionService mockConnectionService = mock(ConnectionService.class);
        when(mockConnectionService.getAllConnections(USER_EMAIL)).thenReturn(expectedList);

        return new BillController(mockBillService, mockConnectionService);

    }

    private BillController mockedBillControllerClone() {
        Bill bill = new Bill("Dinner", 45.21);
        BillService mockBillService = mock(BillService.class);
        when(mockBillService.getBill(bill.getDescription())).thenReturn(bill);

        ConnectionService mockConnectionService = mock(ConnectionService.class);
        when(mockConnectionService.getAllConnections(USER_EMAIL)).thenReturn(null);

        return new BillController(mockBillService, mockConnectionService);
    }


    @Test
    public void shouldRedirectToAddBillOnNoDescription() {
        BillController billController = mockedBillController();
        MockHttpSession mockedSession = new MockHttpSession();
        mockedSession.setAttribute("user", "yding@thoughtworks.com");
        ModelAndView modelAndView = billController.billPage("", "0.0",mockedSession);
        View view = modelAndView.getView();
        ModelAndView modelAndViewTest = new ModelAndView("/add-bill");


        assertThat(view, equalTo(modelAndViewTest.getView()));
    }

    @Test
    public void shouldSaveBillToTheDatabase() {
        String description = "Lunch";
        String amount = "2000.00";
        BillController billControllerClone = mockedBillControllerClone();
        MockHttpSession mockedSession = new MockHttpSession();
        mockedSession.setAttribute("user", "yding@thoughtworks.com");
        billControllerClone.billPage(description, amount,mockedSession);
        assertThat(billControllerClone.billPage(description, amount,mockedSession).getView(), equalTo(new ModelAndView("/add-bill").getView()));
    }

    @Test
    public void shouldAddListOfAllConnectionsToTheView() throws Exception {
        ArrayList<String> expectedObject = new ArrayList<String>();
        expectedObject.add("faris@thoughtworks.com");
        expectedObject.add("renu@thoughtworks.com");
        expectedObject.add("sam@thoughtworks.com");

        BillController billController = mockedBillController();

        MockHttpSession mockedSession = new MockHttpSession();
        mockedSession.setAttribute("user", "yding@thoughtworks.com");
        ArrayList<String> actualObject = (ArrayList<String>) billController.listOfAllConnections(mockedSession).getModel().get("userConnections");

        assertThat(actualObject, is(expectedObject));
    }
}
