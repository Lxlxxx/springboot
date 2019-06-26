package com.example.demo.dao;

import com.example.demo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Lxl on 2019/3/20.
 */
public interface RoleRepository extends JpaRepository<Role,Integer> {

    public Role findByname(String name);


}
