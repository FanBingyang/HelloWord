package BIXiangDongTV;
/*
 * Runtime对象
 * 该类并没有提供构造方法，
 * 说明不可以new对象，那么会有直接想到该类中的方法都是静态的。
 * 发现该类中还有非静态方法。
 * 说明该类肯定会提供了方法获取本类对象。而且该方法是静态 的，并且返回值类型是本类类型。
 * 
 * 有这个特点可以看出该类使用了单例设计模式完成。
 * 
 * 该方法是 static getRuntime();
 * 
 * 
 */
import java.io.IOException;

public class RuntimeDemo {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		Runtime r = Runtime.getRuntime();//不能new对象，直接掉用方法
		Process p = r.exec("E:\\Tencent\\QQLive\\QQLive.exe");//打开路径下的.exe文件
		Thread.sleep(5000);
		
		p.destroy();//终结线程
	}

}
