package com.thoughtworks.twu.controller;


import com.thoughtworks.twu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DashboardController {

    public DashboardController() {
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView dashboardPage(String dashboard) {
        return new ModelAndView("/dashboard");
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.POST)
    public ModelAndView backToDashboard(@RequestParam(value = "Back", defaultValue = "") String back) {
        return new ModelAndView("/dashboard");
    }
}
