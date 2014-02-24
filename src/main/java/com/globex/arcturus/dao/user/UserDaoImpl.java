package com.globex.arcturus.dao.user;

import com.globex.arcturus.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: anewman
 * Date: 2/20/14
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public User addUser(User user) {
        Serializable save = getSession().save(user);
        return (User) getSession().get(User.class, save);
    }

    public List<User> listUsers() {
        return getSession().createQuery("from User")
                .list();
    }

    public void removeUser(Integer id) {
        User user = (User) getSession().load(
                User.class, id);
        if (null != user) {
            getSession().delete(user);
        }
    }

    public User findById(Integer id) {

        return (User) getSession().get(User.class, id);
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public User updateUser(User user) {
        Session session = getSession();
        session.update(user);
        return (User) session.get(User.class, user.getId());
    }
}
