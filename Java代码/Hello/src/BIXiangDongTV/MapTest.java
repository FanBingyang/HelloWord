package BIXiangDongTV;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
��ϰ
ÿһ��ѧ�����ж�Ӧ�Ĺ����ء�
ѧ��Student����ַString��
ѧ�����ԣ����������䣬
ע�⣺������������ͬ����Ϊͬһ��ѧ����
��֤ѧ����Ψһ�ԡ�

1������ѧ��
2������Map��������ѧ����Ϊ������ַ��Ϊֵ�����롣
3����ȡMap�����е�Ԫ�ء�


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
			throw new ClassCastException("���Ͳ�ƥ��");
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
		
		//��һ��ȡ����ʽ keySet
		Set<MapTest> keySet = hm.keySet();
		Iterator<MapTest> it = keySet.iterator();
		
		while(it.hasNext())
		{
			MapTest stu = it.next();
			String addr = hm.get(stu);
			System.out.println(stu+".."+addr);
		}
	/*------------------------------------------------------- */
		
		
	/*	//�ڶ���ȡ����ʽ entrySet
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
