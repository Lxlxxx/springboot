package com.example.demo.text;

import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public class FileExport {

    /**
     *
     * @param //dataList 数据集合
      * @param //cloNames 表头名
     * @param // mapKey 数据列
     *
     *
     *
     */

    private  static final String CSV_SPLIT=",";
    private  static final String  CSV_RN ="\r\n";

    private  static final String[] str={"姓名","年龄","性别","职业","薪水","职位"};



    public static boolean export(List<Map<String,Object> >datalist , String colNames,
                                 String mapkey, HttpServletRequest request,
                                 HttpServletResponse response){
        OutputStream outputStream = null;

        try {

           outputStream  =response.getOutputStream();
           StringBuffer dates =new StringBuffer();
           String[] colNameArr =null;
           String[] mapKeyArr = null;

           colNameArr = colNames.split(",");
           mapKeyArr  = mapkey.split(",");

           //完成数据csv文件的封装，第一行的表头信息'
            for (int i = 0; i <colNameArr.length ; i++) {
                dates.append(colNameArr[i]).append(CSV_SPLIT);
                
            }
            dates.append(CSV_RN);


            //输出数据
            if (CollectionUtils.isEmpty(datalist)){
                for (int i = 0; i < datalist.size(); i++) {
                    dates.append(i+1).append(CSV_SPLIT);
                    for (int j = 0; j < mapKeyArr.length; j++) {
                        Object  data =datalist.get(i).get(mapKeyArr[i]);
                        dates.append("\"").append("\t").append(data==null?"":data).append("\"").append(CSV_SPLIT);


                    }
                    dates.append(CSV_RN);
                }
            }
            //设置文件后缀

            String suffix = System.currentTimeMillis()+"_searchItm"+".csv";

            //读取字符编码

            String utf ="utf-8";
            //设置响应
            response.setContentType("application/csv;charset =UTF-8");
            response.setCharacterEncoding(utf);
            //写出响应
            outputStream.write(dates.toString().getBytes());
            //清除流
            outputStream.flush();
            //关闭流
            outputStream.close();




        }
catch (Exception e){
    e.printStackTrace();

    return false;
}


        return true;

    }
}
