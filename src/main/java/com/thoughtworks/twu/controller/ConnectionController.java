package com.thoughtworks.twu.controller;

import com.thoughtworks.twu.domain.ConnectionDetails;
import com.thoughtworks.twu.service.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ConnectionController {

    ConnectionService connectionService;

    @Autowired
    public ConnectionController(ConnectionService connectionService) {
        this.connectionService = connectionService;
    }

    @RequestMapping(value = "/my-friends-list")
    public ModelAndView listPage(HttpServletRequest request) {
        String currentUser = (String) request.getSession().getAttribute("user");

        return new ModelAndView("/my-friends-list").addObject("email", currentUser);
    }

    @RequestMapping(value = "storeConnections", method = RequestMethod.POST)
    public void insertToDB(HttpServletRequest request,
                           @RequestParam("emails") String emails) {
        String[] emailTokens = emails.split(",");
        for(String email : emailTokens) {
            String currentUser = (String) request.getSession().getAttribute("user");

            ConnectionDetails connectionDetails = new ConnectionDetails(currentUser , email);
            connectionService.insertConnection(connectionDetails);

        }
    }

}
