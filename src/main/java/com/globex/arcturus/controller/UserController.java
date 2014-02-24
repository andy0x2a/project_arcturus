package com.globex.arcturus.controller;

import com.globex.arcturus.domain.Entry;
import com.globex.arcturus.domain.User;
import com.globex.arcturus.service.entry.EntryService;
import com.globex.arcturus.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: anewman
 * Date: 2/20/14
 */
@Controller
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserService userService;


    @Autowired
    private EntryService entryService;


    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<User> findAll() {
        List<User> users = userService.listUsers();
        return users;
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public User getUser(@PathVariable Integer userId) {
        return userService.findById(userId);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT, produces = "application/json")
    public
    @ResponseBody
    User update(@RequestBody User user, @PathVariable Integer userId,
                HttpServletRequest request) {

        System.out.println("UPDATING " + userId);
        User result = null;
        if (user != null) {
            if (user.getId() != null || user.getId().equals(userId)) {

                result = userService.updateUser(user);
            } else {
                System.out.println("ID PROBLEM");
                return null;
            }
        }

        return result;

    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public User add(@RequestBody User user, HttpServletRequest request) {
        System.out.println("ADDING USER");
                User result = null;
        if (user != null) {
            if (user.getId() != null && user.getEmail() != null) {
                user.setJoinDate(new Date());
                result = userService.addUser(user);
            }
        }

        return  result;
    }

    @RequestMapping(value = "/{userId}/entries/", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Entry> getEntriesForUser(@PathVariable String userId) {
        List<Entry> entries = new ArrayList<Entry>(6);

        entries.addAll(entryService.listEntriesForUser(userId));

        return entries;
    }


}
