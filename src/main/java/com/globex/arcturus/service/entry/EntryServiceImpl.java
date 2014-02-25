package com.globex.arcturus.service.entry;

import com.globex.arcturus.dao.entry.EntryDao;
import com.globex.arcturus.domain.Entry;
import com.globex.arcturus.domain.Location;
import com.globex.arcturus.domain.User;
import com.globex.arcturus.domain.helper.Link;
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
public class EntryServiceImpl implements EntryService {

    @Autowired
    private EntryDao entryDao;

    @Autowired
    ServletContext context;


    @Transactional
    public Entry addEntry(Entry entry) {
        return entryDao.addEntry(entry);
    }

    @Transactional
    public List<Entry> listEntries() {
        List<Entry> entries = entryDao.listEntries();
        if (entries != null) {
            for (Entry entry : entries) {
                addLinks(entry);
            }
        }
        return entries;
    }

    @Transactional
    public void removeEntry(Integer id) {
        entryDao.removeEntry(id);
    }

    @Transactional
    public Entry findById(Integer id) {
        Entry entry = entryDao.findById(id);
        addLinks(entry);
        return entry;
    }

    @Transactional
    public List<Entry> listEntriesForUser(String userId) {
        List<Entry> entries = entryDao.listEntriesForUser(userId);
        if (entries != null) {
            for (Entry entry : entries) {
                addLinks(entry);
            }
        }
        return entries;
    }

    @Transactional
    public List<Entry> listEntriesForLocation(String locationId) {
        List<Entry> entries = entryDao.listEntriesForLocation(locationId);
        if (entries != null) {
            for (Entry entry : entries) {
                addLinks(entry);
            }
        }
        return entries;

    }

    @Transactional
    public Entry updateEntry(Entry entry) {
        Entry updatedEntry = entryDao.updateEntry(entry);
        addLinks(updatedEntry);
        return updatedEntry;
    }

    private void addLinks(Entry entry) {
        addUserLink(entry);
        addLocationLink(entry);
    }

    private void addUserLink(Entry entry) {
        System.out.println("ENTRY USER ID:" + entry.getUserId());
        String urlTemplate = context.getContextPath() + "/users/{userId}/";
        String url = urlTemplate.replace("{userId}", entry.getUserId().toString());
        Link link = new Link().setUrl(url).setRel("user").setType(User.TYPE);
        entry.addLink(link);
    }

     private void addLocationLink(Entry entry) {
        String urlTemplate = context.getContextPath() + "/location/{locationId}/";
         if (entry.getLocationId() != null) {
             String url = urlTemplate.replace("{locationId}", entry.getLocationId().toString());
             Link link = new Link().setUrl(url).setRel("location").setType(Location.TYPE);
             entry.addLink(link);
         }
    }
}
