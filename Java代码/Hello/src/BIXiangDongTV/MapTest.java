package BIXiangDongTV;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
练习
每一个学生都有对应的归属地。
学生Student，地址String。
学生属性：姓名，年龄，
注意：姓名和年龄相同的视为同一个学生。
保证学生的唯一性。

1，描述学生
2，定义Map容器，将学生作为键，地址作为值，存入。
3，获取Map集合中的元素。


 */
public class MapTest implements Comparable<MapTest>{
	private String name;
	private int age;
	MapTest(String name,int age)
	{
		this.name = name;
		this.age = age;
	}
	
	public int compareTo(MapTest s)
	{
		int num = new Integer(this.age).compareTo(new Integer(s.age));
		if(num==0)
			return this.name.compareTo(s.name);
		return num;
	}
	public int hashCode()
	{
		return name.hashCode()+age+34;
	}
	public boolean equals(Object obj)
	{
		if(!(obj instanceof MapTest))
			throw new ClassCastException("类型不匹配");
		MapTest s = (MapTest)obj;
		
		return this.name.equals(s.name) && this.age==s.age;
	}
	
	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}
	public String toString(){
		return name+":"+age;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<MapTest,String> hm = new HashMap<MapTest,String>();
		
		hm.put(new MapTest("lisi03",23), "nanjing");
		hm.put(new MapTest("lisi01",21), "beijing");
		hm.put(new MapTest("lisi04",24), "wuhan");
		hm.put(new MapTest("lisi02",22), "shanghai");
		
		//第一种取出方式 keySet
		Set<MapTest> keySet = hm.keySet();
		Iterator<MapTest> it = keySet.iterator();
		
		while(it.hasNext())
		{
			MapTest stu = it.next();
			String addr = hm.get(stu);
			System.out.println(stu+".."+addr);
		}
	/*------------------------------------------------------- */
		
		
	/*	//第二种取出方式 entrySet
		Set<Map.Entry<MapTest,String>> entrySet = hm.entrySet();
		Iterator<Map.Entry<MapTest,String>> it = entrySet.iterator();
		
		while(it.hasNext())
		{
			Map.Entry<MapTest,String> me = it.next();
			MapTest stu = me.getKey();
			String addr = me.getValue();
			System.out.println(stu+"....."+addr);
		}
	*/
	}

}
