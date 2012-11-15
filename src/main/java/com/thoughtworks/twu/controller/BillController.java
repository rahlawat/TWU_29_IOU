package com.thoughtworks.twu.controller;

import com.thoughtworks.twu.domain.Bill;
import com.thoughtworks.twu.persistence.ConnectionMapper;
import com.thoughtworks.twu.service.BillService;
import com.thoughtworks.twu.service.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BillController {

    private BillService billService;

    ConnectionService connectionService;
    public List<String> allConnections = new ArrayList<String>();

    @Autowired
    ConnectionMapper connectionMapper;

    @Autowired
    public BillController(BillService billService, ConnectionService connectionService) {
        this.billService = billService;
        this.connectionService = connectionService;
    }

    public BillController() {

    }

    @RequestMapping(value = "/add-bill", method = RequestMethod.POST)
    public ModelAndView billPage(@RequestParam(value = "descriptionItem",required = false) String description,
                                 @RequestParam(value = "amountItem",required = false) String amount,HttpSession session) {
        String notificationMessage;
        String descriptionMessage;
        String amountMessage;
        ModelAndView modelAndView = new ModelAndView("/add-bill");
        if (!(description.isEmpty() || amount.isEmpty())) {

          double billAmount =  Double.parseDouble(amount);
            Bill bill = new Bill(description, billAmount);
            saveBill(bill);
             descriptionMessage = "Description: "+description;
            amountMessage = "Amount: "+amount;
            notificationMessage = " Saved Successfully.";
            modelAndView.addObject("descriptionMessage",descriptionMessage).addObject("amountMessage",amountMessage).addObject("notificationMessage", notificationMessage);
        }
        else
        {
            notificationMessage = "Incorrect Information";
            modelAndView.addObject("notificationMessage",notificationMessage);
        }
        String userEmail = (String) session.getAttribute("user");
        List<String> allConnections= connectionService.getAllConnections(userEmail);
        modelAndView.addObject("userConnections", allConnections);
        return modelAndView;
    }


    private boolean saveBill(Bill bill) {
        try{
            billService.insertBill(bill);
            return true;
        } catch (Exception ex){
            return false;
        }
    }

    @RequestMapping(value = "/add-bill", method = RequestMethod.GET)
    public ModelAndView listOfAllConnections(HttpSession session) {
        String userEmail = (String) session.getAttribute("user");
        ModelAndView modelAndView = new ModelAndView("/add-bill");
        allConnections = connectionService.getAllConnections(userEmail);
        modelAndView.addObject("userConnections", allConnections);
        return modelAndView;
    }

}

