package com.thoughtworks.twu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FriendsController {

    public FriendsController() {
    }

    @RequestMapping(value = "/my-friends-list")
    public ModelAndView listPage() {
        return new ModelAndView("/my-friends-list");
    }

}
