package com.example.demo.commonutils;

import com.example.demo.dao.PowerRepository;
import com.example.demo.dao.RoleRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.entity.Power;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Created by Lxl on 2019/3/20.
 */
@Component
public class Commontils {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private   UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PowerRepository powerRepository;



    public  String  initData() throws JSONException {
        JSONObject json =new JSONObject();

        String[]  name={"查看详情","增加详情","删除详情","修改详情"};
        String[] type={"工具","工具","工具","工具"};
        String[] url={
                "http://www.baidu.com",
                "http://www.csdn.com",
                "http://www.muoke.com",
                "http://www.hao123.com"
        };


        try{
            //循环添加权限种类
            for (int i =0;i<name.length;i++){
                Power power =powerRepository.findByname(name[i]);
                if (power==null){
                    power =new Power();
                    power.setName(name[i]);
                    power.setType(type[i]);
                    power.setUrl(url[i]);
                    powerRepository.save(power);
                }


            }
            //添加rolo表的管理员
            Role role =roleRepository.findByname("role_管理员1");
            if (role==null){
                role =new Role();
                role.setName("role_管理员1");
            }
            for (String n:name) {
                role.getPowers().add(powerRepository.findByname(n));
            }
            roleRepository.save(role);

            //添加user用户的信息
            User user =userRepository.findByusername("Lxl");
            if (user==null){
                user =new User();
                user.setUsername("Lxl");
                user.setEmail("529412341@qq.com");
                user.setPwd("123456");
                user.setDeptId("软件研发部");
                user.setStationId("java工程师");
            }
            user.getRoles().add(roleRepository.findByname("role1_管理员"));
            userRepository.save(user);

            json.put("SCUUESS",true);

        }catch (Exception e){
            e.printStackTrace();
            json.put("ERROR",false);
            logger.debug("数据初始化异常,当前时间为:"+System.currentTimeMillis());
        }


return json.toString();

    }
}
