package com.example.demo.text;

import com.alibaba.fastjson.JSONObject;
import org.json.JSONArray;
import sun.tools.jstat.Jstat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Base {
    private String baseName ="base";
    public Base(){
        callName();

    }
    public void callName(){
        System.out.println(baseName);
    }

    static class Sub extends Base{


        private String badeName="sub";
        public void callName(){
            System.out.println(badeName);
        }
    }

    public static void main(String[] args) {
       // Base base =new Sub();

//        List list =new ArrayList();
//        list.add("a");
//        list.add("b");
//        list.add("a");
//
//        Set set  =new HashSet();
//        set.add("a");
//        set.add("b");
//        set.add("a");
//        System.out.println(list.size() +"" +set.size());

//        String text1 ="abc";
//        StringBuffer sb =new StringBuffer("cba");
//        sb.append(text1);
//        text1=sb.toString();
//        text1.concat("bac");
//        System.out.println(text1);

        String message ="name=wangerxiao adg=24 classNo=070497";
        List<String> list =new ArrayList<>();
//        JSONObject jsonObject

        list.add(message);
        for (int i = 0; i <list.size(); i++) {
            System.out.println(list.get(0)+"\t");
        }


//        String s =list.get()


    }
}
