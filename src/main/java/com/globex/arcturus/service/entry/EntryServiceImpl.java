package com.globex.arcturus.service.entry;

import com.globex.arcturus.dao.EntryDao;
import com.globex.arcturus.domain.Entry;
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
public class EntryServiceImpl implements EntryService{

    @Autowired
    private EntryDao entryDao;

    @Transactional
    public void addEntry(Entry entry) {
        entryDao.addEntry(entry);
    }

    @Transactional
    public List<Entry> listEntries() {
        return  entryDao.listEntries();
    }

    @Transactional
    public void removeEntry(Integer id) {
        entryDao.removeEntry(id);
    }

    @Transactional
    public Entry findById(Integer id) {
        return entryDao.findById(id);
    }
}
