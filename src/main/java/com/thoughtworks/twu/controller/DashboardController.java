package com.thoughtworks.twu.controller;


import com.thoughtworks.twu.domain.User;
import com.thoughtworks.twu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class DashboardController {

    public DashboardController() {
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView dashboardPage(HttpServletRequest request) {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        return new ModelAndView("/dashboard").addObject("user",user);
    }

    @RequestMapping(value = "/add-bill", method = RequestMethod.GET)
    public ModelAndView responseWithBillPageOnGet() {
        return new ModelAndView("/add-bill");
    }
}
