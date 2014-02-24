package com.globex.arcturus.service.user;

import com.globex.arcturus.dao.user.UserDao;
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
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    ServletContext context;

    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Transactional
    public List<User> listUsers() {


        List<User> users = userDao.listUsers();
        if (users != null) {
            for (User user : users) {
                addLinkToEntries(user);
            }
        }

        return users;
    }

    @Transactional
    public void removeUser(Integer id) {
        userDao.removeUser(id);
    }

    @Transactional
    public User findById(Integer id) {
        User user = userDao.findById(id);
         addLinkToEntries(user);
        return user;
    }

    @Transactional
    public User updateUser(User user) {
        return userDao.updateUser(user);
    }

    private void addLinkToEntries(User user) {
        Link link = new Link();
        link.setRel("entries");
        link.setType("vnd.globex.arcturus.LIST");

        String contextPath = context.getContextPath();
        String urlTemplate = contextPath + "/users/{userId}/entries/";
        String url = urlTemplate.replace("{userId}", user.getId().toString());

        link.setUrl(url);

        user.addLink(link);

    }
}
