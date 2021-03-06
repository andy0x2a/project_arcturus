package com.globex.arcturus.dao.location;

import com.globex.arcturus.domain.Location;
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
 * Date: 2/24/14
 */
@Repository
public class LocationDaoImpl implements LocationDao {
    @Autowired
    private SessionFactory sessionFactory;

    public Location addLocation(Location location) {
        Serializable save = getSession().save(location);
        return (Location) getSession().get(Location.class, save);
    }

    public List<Location> listLocations() {
        return getSession().createQuery("from Location").list();
    }

    public void removeLocation(Integer id) {
        Session session = getSession();
        Location location = (Location) session.load(Location.class, id);
        if (null != location) {
            session.delete(location);
        }
    }

    public Location findById(Integer id) {
        return (Location) getSession().get(Location.class, id);
    }

    public Location updateLocation(Location location) {
        Session session = getSession();
        session.update(location);
        return (Location) session.get(Location.class, location.getId());
    }

    public List<Location> listLocationsForCity(Integer cityId) {
        Query query = getSession().createQuery("from Location where city_id= :cityId");
        query.setParameter("cityId", cityId);
        List list = query.list();
        return list;
    }


    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
