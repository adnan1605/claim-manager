package com.cts.authorization.service;



import com.cts.authorization.model.Role;
import com.cts.authorization.model.User;
import com.cts.authorization.repository.RoleDao;
import com.cts.authorization.repository.UserDao;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    UserDao userDao;

    @Autowired
    RoleDao roleDao;

    private  final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if (user == null) {
            log.error("user not found in data base");
            throw new UsernameNotFoundException("user not found in data base");
        } else {
            log.info("user found in data base : {}", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role ->
                authorities.add(new SimpleGrantedAuthority(role.getName()))
        );
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

    @Override
    public User saveUser(User user) {
        // log.info("saving user");
        //log.info("{}");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        log.info("saving new User {} in database", user.getUsername());
        return userDao.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("saving new Role {} in databases", role.getName());
        return roleDao.save(role);
    }



    @Override
    public void addRoleToUser(String userName, String roleName) {
        User user = userDao.findByUsername(userName);

        Role role = roleDao.findByName(roleName);
        // log.info("adding role {} to user");
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        log.info("fetching user {}", username);
        return userDao.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        return userDao.findAll();
    }


}

