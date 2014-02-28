package com.globex.arcturus.service.location;

import com.globex.arcturus.domain.Entry;
import com.globex.arcturus.domain.Location;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: anewman
 * Date: 2/24/14
 */
public interface LocationService {

    Location addLocation(Location location);
    List<Location> listLocations();
    void removeLocation(Integer id);
    Location findById(Integer id);
    Location  updateLocation(Location location);

    List<Location> listLocationsForCity(Integer cityId);

    List<Entry> getEntries(Integer locationId);
}
