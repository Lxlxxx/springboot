package com.example.demo.controller;

import com.example.demo.dao.TargetRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.annotations.Test;

/**
 * Created by as on 2019/3/13.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TargetText {

    @Autowired
    TargetRepository targetRepository;

    @Test
    public void text() {

       // targetRepository.save(new Target("王五",20));
     //   targetRepository.save(new Target("张三",30));
        System.out.println("执行成功!");


    }
}