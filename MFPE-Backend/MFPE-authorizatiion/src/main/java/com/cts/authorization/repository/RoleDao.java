package com.cts.authorization.repository;

import com.cts.authorization.model.Role;
import com.cts.authorization.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
