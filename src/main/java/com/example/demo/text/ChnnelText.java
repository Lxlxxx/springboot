package com.example.demo.text;


import java.io.*;

import java.nio.channels.FileChannel;

/**
 * Created by Lxl on 2019/4/2.
 */
public class ChnnelText {

    private static String filepath="d:\\java";
    private static String filedes="E:\\java\\channelText.txt";

    public static  void writeFile(){
        try {
            String fileName="channelText.txt";
            File file =new File(filepath,fileName);
            if (!file.exists()){
                file.getParentFile().mkdirs();//创建父级文件路径
            }else {
                System.out.println("文件已创建");
            }
            StringBuffer sb= new StringBuffer("一些测试数据~~~~~~~~~");
            BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
            for (int i = 0; i < 10; i++) {
                bw.write(sb.toString());
                bw.newLine();
            }
            bw.flush();
            bw.close();

        }catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("文件不存在！！！！！");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

   public static void  copyfile() throws IOException {

       FileInputStream fis =null;
       FileOutputStream fos=null;
       FileChannel fileInChannel =null;
       FileChannel fileOutChannel =null;



       try {
           File file =new File("d:\\java\\channelText.txt");
           File file1 =new File(filedes);
           if (!file1.exists()){
               file.getParentFile().mkdir();
           }


           fis =new FileInputStream(file);
           fos =new FileOutputStream(file1);

           fileInChannel =fis.getChannel();
           fileOutChannel=fos.getChannel();

           fileInChannel.transferTo(0,fileInChannel.size(),fileOutChannel);
           System.out.println("文件复制成功~~~~~~~~~~~~~~~~");

       }catch (IOException e){
           e.printStackTrace();
       }finally {
           if (fis!=null) {
               fis.close();
           }
           if (fos!=null){
               fos.close();
           }
           if (fileInChannel!=null){
               fileInChannel.close();
           }
           if (fileOutChannel!=null){
               fileOutChannel.close();
           }
       }

   }

    public static void main(String[] args) throws IOException {
        writeFile();  //创建文件夹并写入数据
        copyfile();   //将文件copy到指定目录下
    }

}
