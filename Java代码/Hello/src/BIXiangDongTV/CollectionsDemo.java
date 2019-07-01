package BIXiangDongTV;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
���Ͽ���ࡣ
Collections��

*/
public class CollectionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		sortDemo();
//		maxDemo();
		binarySearchDemo();
	}
	
	public static void maxDemo()
	{
		List<String> list = new ArrayList<String>();
		
		list.add("abcde");
		list.add("a");
		list.add("sdfh");
		list.add("kk");
		list.add("qqc");
		Collections.sort(list);
		sop(list);
		String max = Collections.max(list);
//		String max = Collections.max(list,new StrLenComparator());
		sop("max:"+max);
	}
	
	
	public static void binarySearchDemo()
	{
		List<String> list = new ArrayList<String>();
		
		list.add("abcde");
		list.add("a");
		list.add("sdfh");
		list.add("kk");
		list.add("qqc");
		Collections.sort(list);
		sop(list);
		
//		int index = Collections.binarySearch(list,"qqc");//������ڣ��򷵻������Ǳ� 
//		int index = Collections.binarySearch(list,"aa");//��������ڣ����� (-�����-1) ��
		int index = halfSearch(list,"aaa");
		sop("index:"+index);
	}
	
	public static int halfSearch(List<String> list,String key)
	{
		int max,min,mid;
		max = list.size()-1;
		min = 0;
		
		while(min<=max)
		{
			mid = (max+min)>>1;  //    �൱�� /2;
		
			String str = list.get(mid);
			
			int num = str.compareTo(key);
			if(num>0)
				max = mid-1;
			else if(num<0)
				min = mid+1;
			else
				return mid;
		}
		return -min-1;
	}
	
	public static int halfSearch2(List<String> list,String key,Comparator<String> cmp)
	{
		int max,min,mid;
		max = list.size()-1;
		min = 0;
		
		while(min<=max)
		{
			mid = (max+min)>>1;  //    �൱�� /2;
		
			String str = list.get(mid);
			
			int num = cmp.compare(str, key);
			if(num>0)
				max = mid-1;
			else if(num<0)
				min = mid+1;
			else
				return mid;
		}
		return -min-1;
	}
	public static void sortDemo()
	{
		List<String> list = new ArrayList<String>();
		
		list.add("abcde");
		list.add("a");
		list.add("sdfh");
		list.add("kk");
		list.add("qqc");

		
		sop(list);//��ӡԭ����
		
//		Collections.sort(list);//��Collections��������Ҳ������Ȼ����
		Collections.sort(list,new StrLenComparator());
		sop(list);
	}
	
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}
/*	public static <T extends Comparable<? super T>> void sort(List<T> list)
	{
		
	}
*/	










