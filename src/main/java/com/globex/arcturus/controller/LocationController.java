package com.globex.arcturus.controller;

import com.globex.arcturus.domain.Location;
import com.globex.arcturus.service.location.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: anewman
 * Date: 2/24/14
 */

@Controller
@RequestMapping("/location")
public class LocationController {


    @Autowired
    private LocationService locationService;


    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Location> getLocations() {
        return locationService.listLocations();
    }

    @RequestMapping(value = "/{locationId} ", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Location getLocation(@PathVariable String locationId) {
        Location result = null;
        try {

            Integer locationIdInt = Integer.parseInt(locationId);
            result = locationService.findById(locationIdInt);
        } catch (NumberFormatException e) {

        }

        return result;
    }
}
