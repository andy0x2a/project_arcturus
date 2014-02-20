package com.globex.arcturus.controller;

import com.globex.arcturus.domain.User;
import com.globex.arcturus.service.user.UserService;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: anewman
 * Date: 2/20/14
 */
@Controller
public class SampleController {


    @Autowired
    private UserService userService;

    @RequestMapping(value="test", method= RequestMethod.GET, produces = "application/JSON")
    @ResponseBody
    public String control(Model model, HttpServletRequest request) {
//        SampleModel response = new SampleModel();
//        response.setId("11111");
//        response.setDateAdded(new Date());
//        response.setLocation("8575 Heather St, Vancouver BC");
//        response.setNotes("Too Loud");
//        response.setRating(1);
//        response.setLatitude("49.208589");
//        response.setLongitude("-123.124713");
//
        List<User> users = userService.listUsers();
        return new GsonBuilder().disableHtmlEscaping().create().toJson(users);

    }

    @RequestMapping(value="test", method= RequestMethod.POST, produces = "application/JSON")
    public void add(HttpServletRequest request) {
//        SampleModel response = new SampleModel();
//        response.setId("11111");
//        response.setDateAdded(new Date());
//        response.setLocation("8575 Heather St, Vancouver BC");
//        response.setNotes("Too Loud");
//        response.setRating(1);
//        response.setLatitude("49.208589");
//        response.setLongitude("-123.124713");


        User user = new User();
        user.setEmail("anewman@qtrade.ca");
        user.setFirstname("Andy!");
        user.setLastname("Newman!");
        user.setJoinDate(new Date());

        userService.addUser(user);
//


    }



}
