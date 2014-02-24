package com.globex.arcturus.service.user;

import com.globex.arcturus.domain.User;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: anewman
 * Date: 2/20/14
 */
public interface UserService {

    public void addUser(User user);
    public List<User> listUsers();
    public void removeUser(Integer id);
    public User findById(Integer id);

    User updateUser(User user);
}
