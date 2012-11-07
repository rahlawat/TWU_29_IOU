package com.thoughtworks.twu.controller;


import com.thoughtworks.twu.domain.LoginUser;
import com.thoughtworks.twu.service.LoginService;
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
    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    public LoginController() {

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/checkLogin", method = RequestMethod.POST)

    public ModelAndView checkCredentials(@RequestParam("email") String email,
                                         @RequestParam("password") String password, HttpServletRequest request) {

        if (email.isEmpty() || password.isEmpty())
            return new ModelAndView("redirect:/login");

        HashSet<GrantedAuthority> grantedAuthority = new HashSet<GrantedAuthority>();



        Authentication authentication = new UsernamePasswordAuthenticationToken(email,password,grantedAuthority);
        SecurityContextHolder.getContext().setAuthentication(authentication);


        if (validUser(email, password)) {

            HttpSession session = request.getSession(true);
            session.setAttribute("email",email);
            LoginUser user= loginService.getUserByEmail(email);
            return new ModelAndView("redirect:/dashboard");
       }

        return new ModelAndView("redirect:/login");

    }

    private boolean validUser(String email, String password) {
        LoginUser loginUser = loginService.getUserByEmail(email);
        return loginUser != null && loginUser.getPassword().equals(password);

    }


}
