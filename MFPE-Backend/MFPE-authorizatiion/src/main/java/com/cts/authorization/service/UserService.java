package com.cts.authorization.service;

import com.cts.authorization.model.Role;
import com.cts.authorization.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String userName, String roleName);

    User getUser(String userName);

    List<User> getUsers();
}
