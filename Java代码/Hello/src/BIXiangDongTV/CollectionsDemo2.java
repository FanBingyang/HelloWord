package BIXiangDongTV;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;

public class CollectionsDemo2 {
	class StrComparator implements Comparator<String>
	{
		public int compare(String s1,String s2)
		{
			int num = s1.compareTo(s2);
			if(num>0)
				return 1;
			if(num<0)
				return -1;
			return num;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		orderDemo();
	}
	
	public static void orderDemo()
	{
		TreeSet<String> ts = new TreeSet<String>(Collections.reverseOrder());//Collections.reverseOrder()һ����ת�ӿڣ�����һ���Ƚ���
		
		ts.add("abcde");
		ts.add("aaa");
		ts.add("kkk");
		ts.add("ccc");
		
		Iterator<String> it = ts.iterator();
		
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		
	}

}

/*
    public class CollectionDemo2 {
	public static void main(String [] args) {
		orderDemo();
	}
	public static void orderDemo()
	{
//		TreeSet<String> ts = new TreeSet<String>();//��Ȼ����
		TreeSet<String> ts = new TreeSet<String>(Collections.reverseOrder());//ǿ����ת˳��Collections.reverseOrder()�������ص���һ���Ƚ���
		
		ts.add("abcde");
		ts.add("ade");
		ts.add("z");
		ts.add("kkkk");
		
		Iterator it = ts.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		
	}
	
	
	
}
*/