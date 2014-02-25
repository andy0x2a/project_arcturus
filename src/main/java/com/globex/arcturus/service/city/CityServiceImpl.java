package com.globex.arcturus.service.city;

import com.globex.arcturus.dao.city.CityDao;
import com.globex.arcturus.domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletContext;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: anewman
 * Date: 2/20/14
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    @Autowired
    ServletContext context;


    @Transactional
    public City addCity(City city) {
        return cityDao.addCity(city);
    }

    @Transactional
    public List<City> listCities() {
        List<City> cities = cityDao.listCities();
        if (cities != null) {
            for (City city : cities) {
                addLinks(city);
            }
        }
        return cities;
    }

    @Transactional
    public void removeCity(Integer id) {
        cityDao.removeCity(id);
    }

    @Transactional
    public City findById(Integer id) {
        City city= cityDao.findById(id);
        addLinks(city);
        return city;
    }


    @Transactional
    public City updateCity(City city) {
        City updatedCity = cityDao.updateCity(city);
        addLinks(updatedCity);
        return updatedCity;
    }

    private void addLinks(City city) {
    }

}
