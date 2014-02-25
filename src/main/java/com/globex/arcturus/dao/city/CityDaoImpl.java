package com.globex.arcturus.dao.city;

import com.globex.arcturus.domain.City;
import com.globex.arcturus.domain.Entry;
import com.globex.arcturus.domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: anewman
 * Date: 2/20/14
 */
@Repository
public class CityDaoImpl implements CityDao {

    @Autowired
    private SessionFactory sessionFactory;

    public City addCity(City city) {
        Serializable save = getSession().save(city);
        return (City) getSession().get(City.class, save);
    }

    public List<City> listCities() {
        return getSession().createQuery("from City")
                .list();
    }

    public void removeCity(Integer id) {
        City city = (City) getSession().load(
                City.class, id);
        if (null != city) {
            getSession().delete(city);
        }
    }

    public City findById(Integer id) {
        return (City) getSession().get(City.class, id);
    }


    public City updateCity(City city) {

        Session currentSession = getSession();
        currentSession.update(city);
        return (City) currentSession.get(City.class, city.getId());

    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
