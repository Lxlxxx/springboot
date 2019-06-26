package com.example.demo.controller;

import com.example.demo.commonutils.Commontils;
import com.example.demo.dao.PowerRepository;
import com.example.demo.dao.RoleRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.entity.Power;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.service.IUserServcie;
import org.json.JSONArray;
import org.json.JSONException;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by Lxl on 2019/3/20.
 */
@Controller
@RequestMapping("/Lxl")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private static  PowerRepository powerRepository;
    @Autowired
    IUserServcie iUserServcie;


    @Autowired
    private Commontils commontils;

    @RequestMapping(value = "/initData")
    @ResponseBody
    public void  initData() throws JSONException {
            commontils.initData();

    }
    @RequestMapping(value ="/addData")
    @ResponseBody
    public void addData(){
        iUserServcie.saveUser();
    }

        @RequestMapping(value ="/findUserPage",method = RequestMethod.GET)
    public String findUserPage(ModelMap modelMap,  @RequestParam( value =  " page",defaultValue = "0") Integer page,
                                   @RequestParam(value = "size",defaultValue = "5") Integer size, User user){
        Page<User> data =iUserServcie.getUserPage(page, size, user);
        modelMap.addAttribute("datas",data);
        return "index";
    }

    /***
     * 向页面展示user、role、power
     *
     *
     */
    @RequestMapping (value = "/getUser")
    @ResponseBody
    public String formatUser(){

                    JSONArray jsonArray =new JSONArray();
                    JSONObject jsonObject =new JSONObject();
                    try{
                        User user= userRepository.findByusername("Lxlpc");
                        if (user!=null){
                            jsonObject.put("user_id",user.getUserId());
                            jsonObject.put("user_name",user.getUsername());
                jsonObject.put("roles",formatRole(user.getRoles()));
                jsonArray.put(jsonObject);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  jsonArray.toString();

    }
     //格式化role
    public static JSONArray formatRole(Set<Role> roles) throws JSONException {
        JSONArray jsonArray =new JSONArray();


        for (Role r:roles) {
            JSONObject json = new JSONObject();
            json.put("role_id", r.getRoleId());
            json.put("role_name", r.getName());
            json.put("power",formatPower(r.getPowers()));
            jsonArray.put(json);
        }
        return  jsonArray;

    }


    //格式化power
    public static  JSONArray formatPower(List<Power> powers) throws JSONException {

        JSONArray    jsonArray =new JSONArray();
        Boolean boole[] =new Boolean[powers.size()];

        for (int i=0;i<powers.size();i++)
            boole[i] =false;
            int i=0,j;
        for (Power p:powers) {
            if (!boole[i]){
                JSONObject  jsonObject =null;
                j=0;
                for (Power e:powers) {
                    if (j>=i && p.getType().equals(e.getType())){
                        boole[i]=true;
                        jsonObject =new JSONObject();
                        jsonObject.put("power_id",e.getId());
                        jsonObject.put("power_name",e.getName());
                        jsonObject.put("power_type",e.getType());
                        jsonArray.put(jsonObject);
                    }
                    j=j+1;
                }
                if (jsonArray.length()==powers.size()){
                    break;
                }
            }
            i++;
            System.out.println(i);
        }
        return  jsonArray;


          /* JSONArray jsonArray =new JSONArray();

            for (Power e : powers) {
                    JSONObject jsonObject2 = new JSONObject();
                    jsonObject2.put("power_id", e.getId());
                    jsonObject2.put("power_name", e.getName());
                    jsonObject2.put("power_type", e.getType());
                    jsonArray.put(jsonObject2);
                }*/

    }



}
