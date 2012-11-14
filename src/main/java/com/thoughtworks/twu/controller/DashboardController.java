package com.thoughtworks.twu.controller;


import com.thoughtworks.twu.domain.User;
import com.thoughtworks.twu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class DashboardController {

    UserService userService;

    @Autowired
    public DashboardController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView dashboardPage(HttpServletRequest request) {

        HttpSession session = request.getSession();
        String userEmail = (String) session.getAttribute("user");
        User user = userService.getUserByEmail(userEmail);
        String userName = user.getUsername();
        ModelAndView modelAndView =  new ModelAndView("/dashboard").addObject("username",userName);
        List<String> peopleWhoOweMe=  userService.getPeopleWhoOweMe();
        modelAndView.addObject("peopleWhoOweMe",peopleWhoOweMe);
        return modelAndView;
    }
}
