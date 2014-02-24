package com.globex.arcturus.dao.location;

import com.globex.arcturus.domain.Location;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

    public void addLocation(Location location) {
        getSession().save(location);
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


    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
