package com.example.demo.text;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Filetxt {


    public static void createfile() {


        String path ="测试文件.txt";




        String str = "lineId" + "|" + "query" + "|" + "姓名" + "|" + "证件类型" + "|" + "证件号" + "|" + "账号" + "|" + "账户信息" + "|" + "客户信息" + "|" + "存款信息"
                + "|" + "交易明细" + "|" + "理财产品" + "|" + "司法冻结信息" + "|" + "关联账户信息" + "|" + "主/子账户信息" + "|" + "交易明细起止时点";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);


        File file = new File(path,"/Users/lixianglong/file");


        try {

            FileWriter fileWriter =new FileWriter(file);

            fileWriter.write(str);
            fileWriter.flush();
            FileInputStream in =null;
            FileOutputStream fos = null;

             in =new FileInputStream(file);

             fos  =new FileOutputStream(String.valueOf(in));



            byte[] bytes =new byte[1024];

            int i   =0;
            while ((i=in.read(bytes))!= -1){
                fos.write(bytes,0,i);
            }
            fos.flush();
            System.out.println("success !!!! ");


        }catch (Exception e){
            e.printStackTrace();
        }








//        FileWriter fileWriter = new FileWriter(file);
////        BufferedWriter bw = new BufferedWriter(fileWriter);
////        bw.write(stringBuffer.toString());



//        bw.flush();
//        System.out.println("创建成功～～～～～～");
//        bw.close();

    }


    public static void mathfloat() throws JSONException {


//        float f = 1.1345f;
//        float in = Math.round(f * 10) / 10;
//        System.out.println(in);




        Random random = new Random();
        String str ="";

        List<String> list =new ArrayList<>();

        for (int i = 0; i < 6; i++) {

            str+= random.nextInt(10);

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("random",str);

        }

        System.out.println(str);
    }

    public static void main(String[] args) throws JSONException {
        createfile();
        //mathfloat();
    }
}
