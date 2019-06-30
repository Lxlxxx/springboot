package com.example.demo.dao;

import com.example.demo.entity.TbUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



public interface TbUserRepository extends JpaRepository<TbUser,Integer> {



    @Modifying
    @Query(value = "update  TbUser set user_name =:username , password =:password where id=:Id")
     void updateUserById(int Id,String username,String password);
}
