package com.globex.arcturus.controller;

import com.globex.arcturus.domain.City;
import com.globex.arcturus.domain.Location;
import com.globex.arcturus.service.city.CityService;
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
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @Autowired
    private LocationService locationService;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<City> getCities() {
        return cityService.listCities();
    }


    @RequestMapping(value = "/{cityId} ", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public City getCity(@PathVariable Integer cityId) {

        return cityService.findById(cityId);
    }

    @RequestMapping(value = "/{cityId}/locations ", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Location> getCityLocations(@PathVariable Integer cityId) {
        return locationService.listLocationsForCity(cityId);
    }


    @RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public City add(@RequestBody City city, HttpServletRequest request) {
        System.out.println("ADDING City");
        City result = null;
        if (city != null) {

            result = cityService.addCity(city);
        }
        return result;

    }

    @RequestMapping(value = "/{cityId}", method = RequestMethod.PUT, produces = "application/json")
    public
    @ResponseBody
    City update(@RequestBody City city, @PathVariable Integer cityId,
                HttpServletRequest request) {
        System.out.println("UPDATING " + cityId);
        City result = null;
        if (city != null) {
            System.out.println("CITY ID: " + city.getId() + " " + cityId);
            if (city.getId() != null && city.getId().equals(cityId)) {

                result = cityService.updateCity(city);
            } else {
                System.out.println("ID PROBLEM");
                return null;
            }
        }

        return result;

    }
}
