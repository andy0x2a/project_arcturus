package com.globex.arcturus.dao.entry;

import com.globex.arcturus.domain.Entry;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: anewman
 * Date: 2/20/14
 */
public interface EntryDao {

    public void addEntry(Entry entry);
    public List<Entry> listEntries();
    public void removeEntry(Integer id);
    public Entry findById(Integer id);

    List<Entry> listEntriesForUser(String userId);

    Entry updateEntry(Entry entry);
}
