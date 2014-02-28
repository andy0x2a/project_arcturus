package com.globex.arcturus.service.location;

import com.globex.arcturus.dao.location.LocationDao;
import com.globex.arcturus.domain.Entry;
import com.globex.arcturus.domain.Location;
import com.globex.arcturus.domain.helper.Link;
import com.globex.arcturus.domain.helper.Linkable;
import com.globex.arcturus.service.AbstractService;
import com.globex.arcturus.service.entry.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: anewman
 * Date: 2/24/14
 */
@Service
public class LocationServiceImpl extends AbstractService implements LocationService {


    @Autowired
    private LocationDao locationDao;

    @Autowired
    private EntryService entryService;

    @Transactional
    public Location addLocation(Location location) {
        Location createdLocation = locationDao.addLocation(location);
        addLinks(createdLocation);
        return createdLocation;
    }

    @Transactional
    public List<Location> listLocations() {
        List<Location> locations = locationDao.listLocations();
        if (locations != null) {
            for (Location location : locations) {
                addLinks(location);
            }
        }
        return locations;
    }

    @Transactional
    public void removeLocation(Integer id) {
        locationDao.removeLocation(id);
    }

    @Transactional
    public Location findById(Integer id) {
        Location location = locationDao.findById(id);
        addLinks(location);
        return location;
    }

    @Transactional
    public Location updateLocation(Location location) {
        Location updatedLocation = locationDao.updateLocation(location);
        addLinks(location);
        return updatedLocation;
    }

    @Transactional
    public List<Location> listLocationsForCity(Integer cityId) {

        List<Location> locations = locationDao.listLocationsForCity(cityId);
        if (locations != null) {
            for (Location location : locations) {
                addLinks(location);
            }
        }
        return locations;
    }


    @Transactional
    public List<Entry> getEntries(Integer locationId) {
        return entryService.listEntriesForLocation(locationId.toString());

    }

    private void addLinks(Location location) {
        addSelf(location);
         addEntries(location);
    }

    private void addEntries(Location location) {
        Link link = new Link();
        link.setRel("entries").setType("LIST").setUrl(location.getSelf().getUrl()+"/entries");
        location.addLink(link);
    }

    @Override
    public String getSelfURL(Linkable entity) {
        String urlTemplate = getContext().getContextPath() + "/location/{id}";
        return urlTemplate.replace("{id}", ((Location) entity).getId().toString());
    }
}
