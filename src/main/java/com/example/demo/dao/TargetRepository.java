package com.example.demo.dao;

import com.example.demo.entity.Target;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


/**
 * Created by as on 2019/3/11.
 */

public interface TargetRepository  extends JpaRepository<Target,Integer> {
   /*
     按照Tid来查询Targetbiao

    */
   Target findById(int id);

   @Query(value = "select id,tname,tage from Target t where t.tname=:tname")
   Target findByTname(@Param( "tname") String  tname);






}
