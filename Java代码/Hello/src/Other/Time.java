package Other;
/*���ܼ�飺ʾ��Java��3�ֻ�ȡ��ǰ��̬ʱ��ķ�����*/
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Time {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//	��һ�ַ���
	 	Date date=new Date();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd EEEE ww WW HH:mm:ss  hh:mm:ss");
		SimpleDateFormat dateFormat1=new SimpleDateFormat("yyyy��MM��dd�� EEEE ����ĵ�ww��  ���µĵ�WW�� HH:mm:ss  hh:mm:ss");
		System.out.println(dateFormat.format(date));
		System.out.println(dateFormat1.format(date));
		/*"yyyy-MM-dd EEEE HH:mm:ss"
		 * �������ʱ��ĸ�ʽ��
		 * yyyy-MM-dd   ���������յ���ʾ��ʽ
		 * EEEE   ��ʾ�������ڼ�
		 * wwww   ��ʾ���Ǳ����ǽ���ĵڼ���
		 * WW     ��ʾ���Ǳ����Ǳ��µĵڼ���
		 * HH:mm:ss   ����Сʱ�����ӡ������ʾ��ʽ������HHΪ24Сʱ�Ƶ�Сʱʱ�䣬hhΪ12Сʱ�Ƶ�Сʱʱ��.
		 * */
			
		
	/*�ڶ��ַ���
	 * 	Calendar calendar=Calendar.getInstance();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
		System.out.println(dateFormat.format(calendar.getTime()));    */
		
	/*�ڶ��ַ���	
		Calendar cal=Calendar.getInstance();
		int y=cal.get(Calendar.YEAR);
		int m=cal.get(Calendar.MONTH);
		int d=cal.get(Calendar.DATE);
		int h=cal.get(Calendar.HOUR_OF_DAY);
		int mi=cal.get(Calendar.MINUTE);
		int s=cal.get(Calendar.SECOND);
		System.out.println("������"+y+"��"+(m+1)+"��"+d+"��"+h+"ʱ"+mi+"��"+s+"��");
		*/
	}

}
