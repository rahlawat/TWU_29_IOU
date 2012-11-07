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
public class CreateAccountController {
    private UserService userService;

    @Autowired
    public CreateAccountController(UserService userService) {
        this.userService = userService;
    }

    public CreateAccountController() {

    }



    @RequestMapping("/createAccount")
    public ModelAndView createAccount() {
        ModelAndView modelAndView = new ModelAndView("createAccount");

        return modelAndView;
    }

    @RequestMapping(value = "/createAccount", method = RequestMethod.POST)
    public String checkFields(@RequestParam("email") String email,
                              @RequestParam("username") String username,
                              @RequestParam("password") String password,
                              @RequestParam("phoneNumber") String phoneNumber) {

        if (email.isEmpty() || username.isEmpty() || password.isEmpty())
            return "redirect:/createAccount";

        User user = new User(email, username, password, phoneNumber);

        if ((userService.getUserByEmail(email) == null) && saveAccount(user))
            return "redirect:/login";

        return "redirect:/createAccount";
    }

    private boolean saveAccount(User user){
        try{
            userService.insertUser(user);
            return true;
        } catch (Exception ex){
            return false;
        }
    }
}
