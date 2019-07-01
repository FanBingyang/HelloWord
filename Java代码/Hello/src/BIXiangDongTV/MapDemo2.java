package BIXiangDongTV;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
Map集合的两种取出方式：
1，keySet:将Map中所有的键存入到了Set集合，因为Set具备迭代器，
	所以可以迭代方式取出所有的键，再根据get方法获取每一个键对应的值。
	
	Map集合取出的原理：将Map结合转成Set集合，再通过迭代器取出。
	
2,Set<Map.Entry<k,v>> entrySet:将Map集合中的映射关系存入到了set集合中，
	而这个关系的数据类型就是：Map.Entry


*/
public class MapDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,String> map = new HashMap<String, String>();
		
		map.put("01","zhangsan--1");
		map.put("02","zhangsan--2");
		map.put("03","zhangsan--3");
		map.put("04","zhangsan--4");
	/*	
		//将Map集合中的映射关系取出，存入道set集合中
		Set<Map.Entry<String, String>> entrySet = map.entrySet();
		
		Iterator<Map.Entry<String, String>> it = entrySet.iterator();
		
		while(it.hasNext())
		{
			Map.Entry<String, String> me = it.next();
			String key = me.getKey();
			String value = me.getValue();
			System.out.println(key+":"+value);
		}
	*/	
		
	/*
		//先获取Map集合中的所有键的Set集合，用keySet()方法
		Set<String> keySet = map.keySet();
		
		//有了Set集合就可以获取其迭代器
		Iterator<String> it = keySet.iterator();
		while(it.hasNext())
		{
			String key = it.next();
			//有了键就可以通过map集合的ge方法获取其对应的值
			String value = map.get(key);
			System.out.println("key:"+key+", value："+value);
		}
	*/	
	}

}
/*
Map.Entry 其实Entry也是一个接口，它是Map接口中的一个内部接口。

interface Map
{
	public static interface Entry
	{
		public abstract Object getKey(){}
		public abstract Object getValue(){}
	}
}

calss HashMap implements Map
{
	class Hahs implements Map.Entry
	{
		public  Object getKey(){}
		public  Object getValue(){}
	}
}
*/

