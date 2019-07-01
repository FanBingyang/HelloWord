package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
    public static String getTime(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyÄêMMÔÂddÈÕ HH:mm:ss");
        String time = sdf.format(date);
//        System.out.println("time:"+time);
        return time;
    }
}
