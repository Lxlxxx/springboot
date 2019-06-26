package com.example.demo.dao;

import com.example.demo.entity.RootDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface RootDeatailsRepository extends JpaRepository<RootDetails,Integer> {




//    @Query(value = "select Name as name,Age as age,Sex as sex ,Profession as profession,Pay as pay,Zw as zw from RootDetails  where Name=:name")
    RootDetails findById(int id );


//     @Query ("select new map(s.name,s.age,s.sex,s.profession,s.pay,s.zw)from RootDetails s where s.Id=:id" )
//    Map<String,Object > findAllforMap(@Param("id")  Integer id );



}
