package com.example.demo.text;


import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lxl on 2019/4/2.
 */
public class Text {


//    public static void main(String[] args) {
//
//        for (int i=0;i<=5;i++){
//
//            for (int j=5-i;j>=0;j--){
//                System.out.print(" ");
//            }
//            for (int k=1;k<=2*i-1;k++){
//                System.out.print("*");
//            }
//
//            System.out.println();
//        }
//    }

    public static void main(String[] args) {


        String str ="abcd1234";
        String str1="";
        Map<String,Object> map =new HashMap<>();
        map.put("key","");

        if (StringUtils.isNotBlank(String.valueOf(map.get("key"))) && !(map.get("key").equals(str)) ){

            System.out.println("数据为空且校验不通过！！！！！1");

        }else{
            System.out.println("逻辑运算为false" +StringUtils.isNotBlank(String.valueOf(map.get("key"))));
        }
    }
}
