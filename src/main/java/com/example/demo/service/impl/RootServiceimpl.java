package com.example.demo.service.impl;

import com.example.demo.dao.RootDeatailsRepository;
import com.example.demo.entity.RootDetails;
import com.example.demo.service.IRootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

@Service
public class RootServiceimpl implements IRootService {

    /**
     * @param //dataList 数据集合
     * @param //cloNames 表头名
     * @param // mapKey 数据列
     */

    private static final String CSV_SPLIT = ",";
    private static final String CSV_RN = "\r\n";




    @Autowired
    private RootDeatailsRepository rootDeatailsRepository;


    @Override
    public boolean export(List<Map<String, Object>> datalist, String colNames,
                          String mapkey, HttpServletRequest request,
                          HttpServletResponse response) {


        OutputStream outputStream = null;

        try {

            outputStream = response.getOutputStream();
            StringBuffer dates = new StringBuffer();
            String[] colNameArr = null;
            String[] mapKeyArr = null;

            colNameArr = colNames.split(",");
            mapKeyArr = mapkey.split(",");

            //完成数据csv文件的封装，第一行的表头信息'
            for (int i = 0; i < colNameArr.length; i++) {
                dates.append(colNameArr[i]).append(CSV_SPLIT);

            }
            dates.append(CSV_RN);


            //输出数据
            if (CollectionUtils.isEmpty(datalist)) {
                for (int i = 0; i < datalist.size(); i++) {
                    dates.append(i + 1).append(CSV_SPLIT);
                    for (int j = 0; j < mapKeyArr.length; j++) {
                        Object data = datalist.get(i).get(mapKeyArr[i]);
                        dates.append("\"").append("\t").append(data == null ? "" : data).append("\"").append(CSV_SPLIT);


                    }
                    dates.append(CSV_RN);
                }
            }
            //设置文件后缀

            String suffix = System.currentTimeMillis() + "_searchItm" + ".csv";

            //读取字符编码

            String utf = "utf-8";
            //设置响应
            response.setContentType("application/csv;charset =UTF-8");
            response.setCharacterEncoding(utf);
            //写出响应
            outputStream.write(dates.toString().getBytes());
            //清除流
            outputStream.flush();
            //关闭流
            outputStream.close();


        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }


        return true;
    }


    @Override
    public void insertRootDetails() {
        RootDetails rootDetails = new RootDetails();
      //  rootDetails.setId("1");
        rootDetails.setName("李翔龙");
        rootDetails.setAge("25");
        rootDetails.setSex("M");
        rootDetails.setPay(15000);
        rootDetails.setProfession("程序员");
        rootDetails.setZw("中级开发");

        rootDeatailsRepository.saveAndFlush(rootDetails);


    }

//    @Override
//    public RootDetails getRootDeatails(int  id) {
//        return rootDeatailsRepository.findByName();
//    }  @Override
//    public RootDetails getRootDeatails(int  id) {
//        return rootDeatailsRepository.findByName();
//    }
}
