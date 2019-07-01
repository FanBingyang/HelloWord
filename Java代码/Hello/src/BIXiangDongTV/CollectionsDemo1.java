package BIXiangDongTV;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fillDemo();
		replaceAllDemo();
	}
	public static void replaceAllDemo()//用于集合中元素的替换
	{
		List<String> list = new ArrayList<String>();
		
		list.add("abcde");
		list.add("a");
		list.add("sdfh");
		list.add("kk");
		list.add("qqc");
		
		sop(list);
		Collections.replaceAll(list, "kk"," jj");//将了list集合中的"kk"元素替换成"jj"
		sop(list);
		Collections.reverse(list);//反转集合中的元素顺序
		sop(list);
	}
	
	public static void fillDemo()
	{
		List<String> list = new ArrayList<String>();
		
		list.add("abcde");
		list.add("a");
		list.add("sdfh");
		list.add("kk");
		list.add("qqc");
		
		sop(list);
		Collections.fill(list,"pp");//将集合中的元素全部换成"pp"。
		sop(list);
	}
	
	
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}

}

/*
	 * 练习，fill方法可以将list集合中的所有元素替换成指定元素。
	 * 		将list集合中的部分元素替换成指定元素。
	 * 
	 * */