package com.globex.arcturus.dao.city;

import com.globex.arcturus.domain.City;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: anewman
 * Date: 2/20/14
 */
public interface CityDao {

    City addCity(City city);

    List<City> listCities();

    void removeCity(Integer id);

    City findById(Integer id);

    City updateCity(City city);
}
