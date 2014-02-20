package com.globex.arcturus.service.user;

import com.globex.arcturus.dao.user.UserDao;
import com.globex.arcturus.domain.User;
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
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Transactional
    public List<User> listUsers() {
        return  userDao.listUsers();
    }

    @Transactional
    public void removeUser(Integer id) {
        userDao.removeUser(id);
    }

    @Transactional
    public User findById(Integer id) {
        return userDao.findById(id);
    }
}
