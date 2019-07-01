package BIXiangDongTV;
/**
 * 单例设计模式
 * @author FBY
 *
 */

//饿汉式
/*
	class Single{
		private static final Single s = new Single();
		private Single(){}
		public static Single getInstance() {
			return s;
		}
	}
*/

//懒汉式
//延迟加载，如果多线程访问时会有安全问题，
//可以使用同步代码块或同步函数，使用的锁是对应的得字节码文件
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
