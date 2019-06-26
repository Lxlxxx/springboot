package com.example.demo.dao;

import com.example.demo.entity.Power;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Lxl on 2019/3/20.
 */
public interface PowerRepository extends JpaRepository<Power,Integer> {
    public Power findByname(String name);



}
