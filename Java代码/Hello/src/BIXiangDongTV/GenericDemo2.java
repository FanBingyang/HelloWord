package BIXiangDongTV;

import java.util.Iterator;
import java.util.TreeSet;

public class GenericDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<String> ts =new  TreeSet<String>(new LenComparator());
	
		ts.add("abcd");
		ts.add("cc");
		ts.add("cba");
		ts.add("aaa");
		ts.add("z");
		ts.add("hahaha");
		
		Iterator<String> it = ts.iterator();
		
		while(it.hasNext())
		{
			String s = it.next();
			System.out.println(s);
		}
	}
}
