package com.thoughtworks.twu.controller;


import com.thoughtworks.twu.domain.LoginUser;
import com.thoughtworks.twu.domain.User;
import com.thoughtworks.twu.service.LoginService;
import com.thoughtworks.twu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashSet;


@Controller
public class LoginController {
    private UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    public LoginController() {

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
//        HttpSession session = request.getSession();
//        String userEmail = (String) session.getAttribute("user");
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/checkLogin", method = RequestMethod.POST)

    public ModelAndView checkCredentials(@RequestParam("email") String email,
                                         @RequestParam("password") String password, HttpServletRequest request) {

        if (email.isEmpty() || password.isEmpty())
            return new ModelAndView("redirect:/login").addObject("userEmail",email);

        HashSet<GrantedAuthority> grantedAuthority = new HashSet<GrantedAuthority>();



        Authentication authentication = new UsernamePasswordAuthenticationToken(email,password,grantedAuthority);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        HttpSession session = request.getSession(true);
        session.setAttribute("user", email);
        if (validUser(email, password)) {

//            HttpSession session = request.getSession(true);
//            session.setAttribute("user", email);
            return new ModelAndView("redirect:/dashboard");
       }
        ModelAndView redirectedView = new ModelAndView("login");
        redirectedView.addObject("userEmail", email);
        return redirectedView;

    }

    private boolean validUser(String email, String password) {
        User user = userService.getUserByEmail(email);
        return user != null && user.getPassword().equals(password);

    }


}
