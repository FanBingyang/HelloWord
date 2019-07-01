package BIXiangDongTV;
/*
泛型：JDK1.5版本之后出现的新特性。用于解决安全问题，是一个安全机制

 好处：
 1，将运行时期出现问题classCastException，转移到了编译时期。
 	方便于程序员解决问题。让运行时问题减少，安全。
 	
 2，避免了强制转换麻烦。
 
 泛型格式：通过<>来定义要操作的引用数据类型。
 
 ？在使用Java提供的对象时，什么时候使用泛型呢？
 	通常在计划和框架中很常见，只要见到<>就要定义泛型。
 	其实<>就是用来接收类型的。
 	当使用集合时，将集合中要存储的数据类型作为参数传递道<>即可。
 */
import java.util.ArrayList;
import java.util.Iterator;

public class GenericDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> al = new ArrayList<String>();//定义一个字符串类型的集合容器
		
		al.add("adc01");
		al.add("adc09991");
		al.add("adc014");
		
		Iterator<String> it = al.iterator();
		while(it.hasNext()){
//			String s = (String)it.next();//类型强制转换,
			String s = it.next();   //使用定义集合类型和迭代器类型后不用转换类型
			System.out.println(s+":"+s.length());
		}
	}

}
