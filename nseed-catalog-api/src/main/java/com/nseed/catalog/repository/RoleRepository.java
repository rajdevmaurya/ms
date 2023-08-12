package com.nseed.catalog.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.nseed.catalog.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role getByName(String roleCustomer);
}
