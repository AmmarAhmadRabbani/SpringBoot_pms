package com.te.springbootproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.springbootproject.entity.Role;

public interface RoleDao extends JpaRepository<Role, String> {

}
