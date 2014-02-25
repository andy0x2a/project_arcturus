package com.globex.arcturus.service.city;

import com.globex.arcturus.domain.City;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: anewman
 * Date: 2/20/14
 */
public interface CityService {

    City addCity (City city);
    List<City> listCities();
    void removeCity(Integer id);
    City findById(Integer id);
    City  updateCity(City city);
}
