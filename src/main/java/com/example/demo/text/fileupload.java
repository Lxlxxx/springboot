package com.example.demo.text;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.UUID;

public class fileupload {


    public static void fileupload() throws FileNotFoundException {

        String path = "/Users/lixianglong/Pictures/test.jpg";

        String destpath = "/Users/lixianglong/Downloads/";
        HttpServletRequest httpServletRequest =null;
//        ServletContext servletContext = httpServletRequest.getSession().getServletContext();

        try {
            File file =new File(path);
            String newfilename= UUID.randomUUID() + file.getName();

            FileInputStream fis = new FileInputStream(path);

            FileOutputStream fos = new FileOutputStream(destpath+newfilename);

            int len = 0;

            byte[] bytes = new byte[512];


            while ((len = fis.read(bytes)) != -1) {

                fos.write(bytes,0,len);

            }
            fos.write(bytes);

            fis.close();
            fos.close();
            System.out.println("文件已经复制完毕～～～～～·");


        } catch (IOException e) {

            e.printStackTrace();

        }





    }

    public static void main(String[] args)  throws  IOException{
        fileupload();
    }
}
