package BIXiangDongTV;
/**
 * �������ģʽ
 * @author FBY
 *
 */

//����ʽ
/*
	class Single{
		private static final Single s = new Single();
		private Single(){}
		public static Single getInstance() {
			return s;
		}
	}
*/

//����ʽ
//�ӳټ��أ�������̷߳���ʱ���а�ȫ���⣬
//����ʹ��ͬ��������ͬ��������ʹ�õ����Ƕ�Ӧ�ĵ��ֽ����ļ�
/*q
class Single{	
	private static Single s = null;
	public Single() {}
	
	public static synchronized Single getInstance() {
		if(s==null)
		{
			synchronized (Single.class) {
				if(s==null)
					s = new Single();
			}
		}
		return s;
	}
}
*/


public class SingleDemo {

}
