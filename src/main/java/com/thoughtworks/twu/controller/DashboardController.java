package com.thoughtworks.twu.controller;

import com.thoughtworks.twu.domain.User;
import com.thoughtworks.twu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DashboardController {
    private UserService userService;



    @RequestMapping(value= "/dashboard", method=RequestMethod.POST)
    public ModelAndView dashboardpage() {
        ModelAndView modelAndView = new ModelAndView("dashboard");


        return modelAndView;
    }
}
