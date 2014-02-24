package com.globex.arcturus.dao.entry;

import com.globex.arcturus.domain.Entry;
import com.globex.arcturus.domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: anewman
 * Date: 2/20/14
 */
@Repository
public class EntryDaoImpl implements EntryDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addEntry(Entry entry) {
        getSession().save(entry);
    }

    public List<Entry> listEntries() {
        return getSession().createQuery("from Entry")
                .list();
    }

    public void removeEntry(Integer id) {
        User entry = (User) getSession().load(
                Entry.class, id);
        if (null != entry) {
            getSession().delete(entry);
        }
    }

    public Entry findById(Integer id) {
        return (Entry) getSession().get(Entry.class, id);
    }

    public List<Entry> listEntriesForUser(String userId) {
        Query query = getSession().createQuery("from Entry where user_id = :userId");
        query.setParameter("userId", userId);
        List list = query.list();
        return list;
    }

    public Entry updateEntry(Entry entry) {

        Session currentSession = getSession();
        currentSession.update(entry);
        return (Entry) currentSession.get(Entry.class, entry.getId());

    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
