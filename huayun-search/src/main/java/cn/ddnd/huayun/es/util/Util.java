package cn.ddnd.huayun.es.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @program: huayun
 * @description: 工具类
 * @author: Xue 8
 * @create: 2019-05-23 22:35
 **/
public class Util {

    /**
      *  UTC转北京时间
     */
    public static String UTCToCST(String UTCStr){
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        try {
            date = sdf.parse(UTCStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("UTC时间: " + date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR, calendar.get(Calendar.HOUR) + 8);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datetime = format.format(calendar.getTime());
        return datetime;
    }

}
