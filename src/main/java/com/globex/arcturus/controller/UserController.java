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
    public User getUser(@PathVariable String userId) {
        User user = null;
        try {
            int userIdInteger = Integer.parseInt(userId);
            user = userService.findById(userIdInteger);
        } catch (NumberFormatException e) {

        }
        return user;
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT, produces = "application/json")
 public @ResponseBody User update(@RequestBody User user , @PathVariable Integer userId,
                                   HttpServletRequest request) {

        System.out.println("UPDATING " + userId);


        User result= null;
     if (user != null) {
         System.out.println("user.id " + user.getId());
         System.out.println("user.email " + user.getEmail());
         System.out.println("user.firstname " + user.getFirstname());
         System.out.println("user.lastname " + user.getLastname());


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
    public void add(HttpServletRequest request) {
        User user = new User();
        user.setEmail("anewman@qtrade.ca");
        user.setFirstname("Andy!");
        user.setLastname("Newman!");
        user.setJoinDate(new Date());

        userService.addUser(user);
    }

    @RequestMapping(value = "/{userId}/entries/", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Entry> getEntriesForUser(@PathVariable String userId) {
        List<Entry> entries = new ArrayList<Entry>(6);

        entries.addAll(entryService.listEntriesForUser(userId));

        return entries;
    }


}
