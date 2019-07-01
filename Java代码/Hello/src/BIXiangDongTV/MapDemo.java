package BIXiangDongTV;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/*
Map
	|--Hashtable:底层是哈希表数据结构，不可以存入null键和null值，该集合是线程同步的，jdk1.0，效率高。
	|--HashMap:底层是哈希表数据结构，存入null键和null值，该集合是不同步的，将hashtable替代，jdk1.2，效率高。
	|--TreeMap:底层是二叉树数据结构，线程不同步，可以用于给Map集合中的键进行排序
	
 
和Set很像，其实Set底层就是使用了Map集合。
 
 
 */
public class MapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,String> map = new HashMap<String, String>();
		//添加元素,如果出现添加时相同的键，那么后添加的值就会覆盖原有键对应的值，并put方法会返回被覆盖的值
		map.put("01","zhangsan--1");
		map.put("02","zhangsan--2");
		map.put("03","zhangsan--3");
		
		System.out.println("containtsKey:"+map.containsKey("02"));  //判断有没有"02"号
//		System.out.println("remove:"+map.remove("02"));  //输出"02"，并删除
		System.out.println("get:"+map.get("02"));//判断某个元素是否存在
		
		map.put(null, "haha");
		System.out.println("get:"+map.get("null"));
		//可以通过get方法的返回值来判断一个键是否存在。
		
		//获取map集合中所有的值
		Collection<String> coll = map.values();
		System.out.println(coll);
		
		System.out.println(map);//打印集合
		
		
	}

}
