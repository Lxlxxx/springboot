package com.example.demo.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


import java.util.Map;

@Mapper
public interface UserMapper {

   @Select(" SELECT  count(1) as \"count\" ,user_name as username FROM tb_user WHERE user_name = #{username} group by user_name ")
    Map<String ,Object> count(String username );
}
