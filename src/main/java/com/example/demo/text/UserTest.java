package com.example.demo.text;


import com.example.demo.service.IUserServcie;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    IUserServcie iUserServcie;


    @Test
    public void getUserTest() {
        String username = "Lxl";
        Map<String, Object> resultMap = iUserServcie.count(username);

        System.out.println("resultMap count is  :" + resultMap.get("username")+":" +resultMap.get("count") );
        System.out.println("resultMap count is  :" + resultMap.get("username")+":" +resultMap.get("count") );

    }
}
