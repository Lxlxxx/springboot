package com.example.demo.controller;


import com.example.demo.dao.RootDeatailsRepository;
import com.example.demo.entity.RootDetails;
import com.example.demo.service.IRootService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/root")
@CrossOrigin
public class RootController {

    Logger logger =  LoggerFactory.getLogger(RootController.class);


    @Autowired
    private IRootService iRootService;

    @Autowired
    private RootDeatailsRepository  repository;





    @RequestMapping(value = "export",method = RequestMethod.GET)
    @ResponseBody
    public String  export(HttpServletRequest request,
                         HttpServletResponse response,int id){

        try {
            logger.info("RootController.export name:"+id);

            RootDetails rootDetails =repository.findById(id);
            Map<String,Object>  map= beanToMap(rootDetails);
            logger.info("RootController.export map :"+map.toString());
            List<Map<String,Object>> datalist =new ArrayList<>();

            datalist.add(map);


            logger.info("RootController.export datalist :"+datalist.toString());
            String mapkey = "name,age,sex,profession,pay,zw";
            String colNames ="姓名,年龄,性别,职业, 薪水,职位";
           Boolean flag   =iRootService.export(datalist,colNames,mapkey,request,response);
           if (flag==true){
               logger.info("RootController.export SUCCESS  !!!!!!!");
           }

        }catch (Exception e){
            e.printStackTrace();
        logger.info("RootController.insertMethod is error ");

}

        return "SUCCESS";

    }

    @RequestMapping(value = "/inert",method = RequestMethod.GET)
    @ResponseBody
    public void insert(){
        try {
            iRootService.insertRootDetails();

            logger.info("RootController.insertMethod  SUCCESS" );
        }catch (Exception e){
            e.printStackTrace();
            logger.info("RootController.insertMethod is error" );
        }
    }

    public static <T> Map<String, Object> beanToMap(T bean) {
        Map<String, Object> map = new HashMap<>();
        if (bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            for (Object key : beanMap.keySet()) {
                map.put(key + "", beanMap.get(key));
            }
        }
        return map;


    }
}
