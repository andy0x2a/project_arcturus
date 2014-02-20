package com.globex.arcturus.dao.entry;

import com.globex.arcturus.domain.Entry;
import com.globex.arcturus.domain.User;
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
        sessionFactory.getCurrentSession().save(entry);
    }

    public List<Entry> listEntries() {
        return sessionFactory.getCurrentSession().createQuery("from Entry")
                .list();
    }

    public void removeEntry(Integer id) {
        User entry = (User) sessionFactory.getCurrentSession().load(
                Entry.class, id);
        if (null != entry) {
            sessionFactory.getCurrentSession().delete(entry);
        }
    }

    public Entry findById(Integer id) {
//        return sessionFactory.getCurrentSession()..byId(User.class)
        return null;
    }
}
