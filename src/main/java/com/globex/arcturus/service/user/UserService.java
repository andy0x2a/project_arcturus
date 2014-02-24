package com.globex.arcturus.service.user;

import com.globex.arcturus.domain.User;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: anewman
 * Date: 2/20/14
 */
public interface UserService {

    User addUser(User user);

    List<User> listUsers();

    void removeUser(Integer id);

    User findById(Integer id);

    User updateUser(User user);
}
