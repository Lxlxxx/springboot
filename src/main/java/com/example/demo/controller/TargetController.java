package com.example.demo.controller;


import com.example.demo.dao.TargetRepository;
import com.example.demo.entity.Address;
import com.example.demo.entity.Target;
import com.example.demo.service.IAddressService;
import com.example.demo.service.ITargerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by as on 2019/3/11.
 */
@RestController
public class TargetController {


    @Autowired
    ITargerService iTargerService;
    @Autowired
    IAddressService iAddressService;
    @Autowired
    TargetRepository targetRepository;

     @RequestMapping(value = "select" ,method= RequestMethod.GET)
    public Target getTargetById(int id) {

    Target list = iTargerService.findByTid(id);
    return  list;
}
    @RequestMapping(value = "add")
    public String getAddTarget(Target target) {
        iTargerService.saveTarget(target);
      return "插入成功";

    }



    @RequestMapping(value = "delete")
    public String getDeleteTarget(int id){

        iTargerService.deleteTarget(id);
        return  "删除成功";
    }

    @RequestMapping(value = "addAdress")
    public String getAddAddress(Address address){
        iAddressService.saveAddress(address);
        return  "插入成功";
    }

    @RequestMapping(value = "addAll")
    public String getAll(){
        iTargerService.save();
        return "ontToone 关联插入成功";
    }

    @RequestMapping(value = "deleteByTname")
    public List<Target> getByname(String Tname){

        java.util.List<Target> list =new ArrayList<>();
        list.add(iTargerService.finByTname(Tname));

       return list;
    }

}
