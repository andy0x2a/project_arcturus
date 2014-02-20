package com.globex.arcturus.dao.user;

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
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public List<User> listUsers() {
        return sessionFactory.getCurrentSession().createQuery("from User")
                .list();
    }

    public void removeUser(Integer id) {
        User user = (User) sessionFactory.getCurrentSession().load(
                User.class, id);
        if (null != user) {
            sessionFactory.getCurrentSession().delete(user);
        }
    }

    public User findById(Integer id) {
//        return sessionFactory.getCurrentSession()..byId(User.class)
        return null;
    }
}
