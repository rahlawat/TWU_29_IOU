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

@Controller
public class BillController {

    private BillService billService;
    private DashboardController dashboard;

    @Autowired
    public BillController(BillService billService) {
        this.billService = billService;
    }


    @RequestMapping(value = "/add-bill", method = RequestMethod.POST)
    public ModelAndView billPage(@RequestParam(value = "descriptionItem") String description,
                                         @RequestParam(value = "amountItem") String amount) {

        return new ModelAndView("/add-bill");

    }
}

