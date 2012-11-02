package com.thoughtworks.twu.controller;


import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView("login");
    }



    @RequestMapping(value = "/checkLogin", method = RequestMethod.POST)

    public String checkCredentials(@RequestParam("email") String email,
                                   @RequestParam("password") String password) {

        if(email.isEmpty() || password.isEmpty())
            return "redirect:/login";
        return "";


    }
}
