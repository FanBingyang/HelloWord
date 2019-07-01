package Other;
/*功能简介：示例Java中3种获取当前静态时间的方法。*/
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Time {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//	第一种方法
	 	Date date=new Date();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd EEEE ww WW HH:mm:ss  hh:mm:ss");
		SimpleDateFormat dateFormat1=new SimpleDateFormat("yyyy年MM月dd日 EEEE 今年的第ww周  本月的第WW周 HH:mm:ss  hh:mm:ss");
		System.out.println(dateFormat.format(date));
		System.out.println(dateFormat1.format(date));
		/*"yyyy-MM-dd EEEE HH:mm:ss"
		 * 该语句是时间的格式：
		 * yyyy-MM-dd   设置年月日的显示格式
		 * EEEE   显示的是星期几
		 * wwww   显示的是本周是今年的第几周
		 * WW     显示的是本周是本月的第几周
		 * HH:mm:ss   设置小时、分钟、秒的显示格式。其中HH为24小时制的小时时间，hh为12小时制的小时时间.
		 * */
			
		
	/*第二种方法
	 * 	Calendar calendar=Calendar.getInstance();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
		System.out.println(dateFormat.format(calendar.getTime()));    */
		
	/*第二种方法	
		Calendar cal=Calendar.getInstance();
		int y=cal.get(Calendar.YEAR);
		int m=cal.get(Calendar.MONTH);
		int d=cal.get(Calendar.DATE);
		int h=cal.get(Calendar.HOUR_OF_DAY);
		int mi=cal.get(Calendar.MINUTE);
		int s=cal.get(Calendar.SECOND);
		System.out.println("现在是"+y+"年"+(m+1)+"月"+d+"日"+h+"时"+mi+"分"+s+"秒");
		*/
	}

}
