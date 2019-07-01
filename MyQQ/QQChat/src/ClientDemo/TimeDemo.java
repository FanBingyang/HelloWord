package ClientDemo;

import java.util.Calendar;

public class TimeDemo {
    /**
     * 获取时间
     * @return
     */
    public String getTime(){
        int y, mi, d, h, m, s;
        Calendar cal = Calendar.getInstance();
        y = cal.get(Calendar.YEAR);
        mi = cal.get(Calendar.MONTH);
        d = cal.get(Calendar.DATE);
        h = cal.get(Calendar.HOUR_OF_DAY);
        m = cal.get(Calendar.MINUTE);
        s = cal.get(Calendar.SECOND);

        String ss=h + ":" + m + ":" + s+" ";
        return ss;
    }
}
