package com.globex.arcturus.dao.location;

import com.globex.arcturus.domain.Location;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: anewman
 * Date: 2/20/14
 */
public interface LocationDao {

    Location addLocation(Location location);

    List<Location> listLocations();

    void removeLocation(Integer id);

    Location findById(Integer id);

    Location updateLocation(Location location);
}
