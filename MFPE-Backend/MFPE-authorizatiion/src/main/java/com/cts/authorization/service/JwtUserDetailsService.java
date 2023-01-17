/*

package com.cts.authorization.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.cts.authorization.model.Role;
import com.cts.authorization.repository.RoleDao;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cts.authorization.model.MyUserDeails;
import com.cts.authorization.model.User;
import com.cts.authorization.repository.UserDao;

import lombok.extern.slf4j.Slf4j;

@Service @Slf4j
@AllArgsConstructor
public class JwtUserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    RoleDao roleDao;





	*/
/*public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
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

		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), authorities);
	}


public boolean userVarification(String userName, String password) {
		// TODO Auto-generated method stu
		User user=userDao.findByUserName(userName);
		if(user==null)
			return false;
		else if (user.getPassword().equals(password))
			return true;


		return false;
	}*//*



}*/
