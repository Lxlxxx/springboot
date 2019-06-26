package com.example.demo.text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateText {

    /**
     * 获取三天前的时间
     * @param Hour
     * @return
     */
    public static  String getBeforeByHourTime(int Hour){


        String returnstr = "";
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) + Hour);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH");
        returnstr = df.format(calendar.getTime());

        System.out.println("72小时之后的时间为 ："+returnstr);
        return returnstr;

        //超时时间为72个小时 ，如过当前时间为：4月4号 面试时间为：4月1号  4月1号往后推3天  66tt

    }


    public static void dat(){


        Long time = System.currentTimeMillis();//获得系统当前时间的毫秒数

        System.out.println("获取当前系统时间为："+new SimpleDateFormat("HH时mm分ss秒").format(time));//转换成标准年月日的形式

        Date date = new Date(time);

        time +=30*1000*60;//在当前系统时间的基础上往后加30分钟

        System.out.println("三十分钟后的时间为："+new SimpleDateFormat("HH时mm分ss秒").format(time));

    }

    //比较两个时间的大小

    public static boolean compareDate(Date date1,String date2,int days) throws ParseException {
        try{
            Calendar d1 =Calendar.getInstance();
            d1.set(Calendar.HOUR_OF_DAY,00);
            d1.set(Calendar.MINUTE,00);
            d1.set(Calendar.SECOND,00);

            System.out.println("当前日期 ："+new SimpleDateFormat("yyyyMMdd").format(d1.getTime()));
            Calendar d2 =Calendar.getInstance();
            SimpleDateFormat sf =new SimpleDateFormat("yyyyMMdd");
            Date tmp= sf.parse(date2);
            d2.setTime(tmp);
            d2.set(Calendar.HOUR_OF_DAY,00);
            d2.set(Calendar.MINUTE,00);
            d2.set(Calendar.SECOND,00);
            d2.set(Calendar.DATE,+days);
            System.out.println("创建时间 +3天后的日期： "+new SimpleDateFormat("yyyyMMdd").format(d2.getTime()));
            return  d2.after(d1);

        }catch (ParseException e){
            e.printStackTrace();

        }
       return false;


    }

    public static void main(String[] args)  throws ParseException {

//        Calendar d1 =Calendar.getInstance();
//        Date date1 =d1.getTime();
//
//        String date ="20190420";
//        if (compareDate(date1,date,3)){
//            System.out.println("面试有效期正常");
//        }else{
//            System.out.println("面试有效期失效");

        }


       // getBeforeByHourTime(72);

       // dat();


    //
}
