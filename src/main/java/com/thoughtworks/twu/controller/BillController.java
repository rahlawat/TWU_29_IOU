package com.thoughtworks.twu.controller;

import com.thoughtworks.twu.domain.Bill;
import com.thoughtworks.twu.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.math.BigDecimal;

@Controller
public class BillController {

    private BillService billService;
    private DashboardController dashboard;

    @Autowired
    public BillController(BillService billService) {
        this.billService = billService;
    }


    @RequestMapping(value = "/add-bill", method = RequestMethod.POST)
    public ModelAndView billPage(@RequestParam(value = "descriptionItem",required = false) String description,
                                 @RequestParam(value = "amountItem",required = false) String amount) {
        String message;
        ModelAndView modelAndView = new ModelAndView("/add-bill");
        if (!(description.isEmpty() || amount.isEmpty())) {

          double billAmount =  Double.parseDouble(amount);
            Bill bill = new Bill(description, billAmount);
            saveBill(bill);
             message = "Bill Saved Successfully.";
            modelAndView.addObject("notification",message);
        }
        else
        {
            message = "Incorrect Information";
            modelAndView.addObject("notification",message);
        }
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

}

