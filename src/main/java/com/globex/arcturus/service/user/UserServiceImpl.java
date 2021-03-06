package com.globex.arcturus.service.user;

import com.globex.arcturus.dao.user.UserDao;
import com.globex.arcturus.domain.User;
import com.globex.arcturus.domain.helper.Link;
import com.globex.arcturus.domain.helper.Linkable;
import com.globex.arcturus.service.AbstractService;
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
public class UserServiceImpl extends AbstractService implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public User addUser(User user) {
        return userDao.addUser(user);
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
        User updatedUser = userDao.updateUser(user);
        addLinkToEntries(updatedUser);
        return updatedUser;
    }

    private void addLinkToEntries(User user) {
        Link link = new Link();
        link.setRel("entries");
        link.setType("vnd.globex.arcturus.LIST");

        String contextPath = getContext().getContextPath();
        String urlTemplate = contextPath + "/users/{userId}/entries/";
        String url = urlTemplate.replace("{userId}", user.getId().toString());

        link.setUrl(url);

        user.addLink(link);

        addSelf(user);
    }

    @Override
    public String getSelfURL(Linkable entity) {
        String urlTemplate = getContext().getContextPath() + "/users/{id}";
        return urlTemplate.replace("{id}", ((User) entity).getId().toString());
    }
}

