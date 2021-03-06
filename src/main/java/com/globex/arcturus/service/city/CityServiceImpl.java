package com.globex.arcturus.service.city;

import com.globex.arcturus.dao.city.CityDao;
import com.globex.arcturus.domain.City;
import com.globex.arcturus.domain.Location;
import com.globex.arcturus.domain.helper.Link;
import com.globex.arcturus.domain.helper.Linkable;
import com.globex.arcturus.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: anewman
 * Date: 2/20/14
 */
@Service
public class CityServiceImpl extends AbstractService implements CityService {

    @Autowired
    private CityDao cityDao;

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
       String urlTemplate = getContext().getContextPath() + "/city/{cityId}/locations";
         if (city.getId() != null) {
             String url = urlTemplate.replace("{cityId}", city.getId().toString());
             Link link = new Link().setUrl(url).setRel("locations").setType(Location.TYPE);
             city.addLink(link);
         }

        addSelf(city);
    }
     @Override
    public String getSelfURL(Linkable entity) {
        String urlTemplate = getContext().getContextPath() + "/city/{id}";
        return urlTemplate.replace("{id}", ((City) entity).getId().toString());
    }

}
