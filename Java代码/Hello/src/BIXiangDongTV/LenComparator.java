package BIXiangDongTV;

import java.util.Comparator;

public class LenComparator implements Comparator<String>{
	public int compare(String o1,String o2)
	{
		int num = new Integer(o1.length()).compareTo(new Integer(o2.length()));
		if(num==0)
			return o2.compareTo(o1);
		return num;
		
	}

}
