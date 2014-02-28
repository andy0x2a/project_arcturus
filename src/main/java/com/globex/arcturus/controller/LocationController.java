package com.globex.arcturus.controller;

import com.globex.arcturus.domain.Entry;
import com.globex.arcturus.domain.Location;
import com.globex.arcturus.service.location.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    public Location getLocation(@PathVariable Integer locationId) {

        return locationService.findById(locationId);
    }

     @RequestMapping(value = "/{locationId}/entries", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Entry> getLocationEntries(@PathVariable Integer locationId) {

        return locationService.getEntries(locationId);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Location add(@RequestBody Location location, HttpServletRequest request) {
        System.out.println("ADDING LOCATION");
        Location result = null;
        if (location != null) {

            result = locationService.addLocation(location);

        }
        return result;

    }

    @RequestMapping(value = "/{locationId}", method = RequestMethod.PUT, produces = "application/json")
    public
    @ResponseBody
    Location update(@RequestBody Location location, @PathVariable Integer locationId,
                    HttpServletRequest request) {
        System.out.println("UPDATING " + locationId);
        Location result = null;
        if (location != null) {
            if (location.getId() != null && location.getId().equals(locationId)) {

                result = locationService.updateLocation(location);
            } else {
                System.out.println("ID PROBLEM");
                return null;
            }
        }

        return result;

    }
}
