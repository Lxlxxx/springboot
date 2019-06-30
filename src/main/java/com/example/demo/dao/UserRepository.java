package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by Lxl on 2019/3/20.
 */
public interface UserRepository extends JpaRepository<User,Integer> {
    public User findByusername(String username);


    Page<User> findAll(Specification<User> specification, Pageable pageable);


}
