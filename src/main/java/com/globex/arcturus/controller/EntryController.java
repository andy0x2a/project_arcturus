package com.globex.arcturus.controller;

import com.globex.arcturus.domain.Entry;
import com.globex.arcturus.service.entry.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: anewman
 * Date: 2/20/14
 */
@Controller
@RequestMapping("/entries")
public class EntryController {


    @Autowired
    private EntryService entryService;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Entry> findAll() {
        return entryService.listEntries();
    }

    @RequestMapping(value = "/{entryId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Entry getEntry(@PathVariable Integer entryId) {
        return entryService.findById(entryId);
    }


    @RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Entry add(@RequestBody Entry entry, HttpServletRequest request) {
        System.out.println(" ADDING ENTRY!!!");
        Entry result = null;
        if (entry != null) {

            if (entry.getUserId() != null && entry.getRating() != null) {
                result = entryService.addEntry(entry);
            }
        }

        return result;

    }

    @RequestMapping(value = "/{entryId}", method = RequestMethod.PUT, produces = "application/json")
    public
    @ResponseBody
    Entry update(@RequestBody Entry entry, @PathVariable Integer entryId,
                 HttpServletRequest request) {
        System.out.println("UPDATING " + entryId);
        Entry result = null;
        if (entry != null) {
            if (entry.getId() != null && entry.getId().equals(entryId)) {

                result = entryService.updateEntry(entry);
            } else {
                System.out.println("ID PROBLEM");
                return null;
            }
        }

        return result;

    }


}
