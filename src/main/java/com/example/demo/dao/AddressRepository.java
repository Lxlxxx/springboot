package com.example.demo.dao;


import com.example.demo.entity.Address;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by as on 2019/3/14.
 */


public interface AddressRepository extends JpaRepository<Address,Integer>{



}
