package BIXiangDongTV;

import java.util.ArrayList;
import java.util.Iterator;
/*
 1，add方法的参数类型是Object，以便于接受任意类型的对象 
 2，集合中存储的都是对象的引用(地址)
 
 什么是迭代器呢？
 其实就是集合取出元素的方式
 
 

 * */
public class CollectionDemo {

public static void main(String[] args) {
//	base_method();
//	method2();
	method_get();	
		

	}

public static void method_get()
{
		//创建一个集合容器，使用Coiiection接口的子类，ArrayList
		ArrayList al=new ArrayList();
		
		//添加元素
		al.add("java01");//add(Object obj)
		al.add("java02");
		al.add("java03");
		al.add("java04");
		
		Iterator it = al.iterator();//获取迭代器，用于取出集合中的元素
		while(it.hasNext()){
			sop(it.next());
		}
		
		//等价于以上迭代器代码
/*		for(Iterator it = al.iterator();it.hasNext();)
		{
			sop(it.next());
		}
*/		
		
//		sop(al);
	
}

public static void method2(){
	//创建一个集合容器，使用Coiiection接口的子类，ArrayList
		ArrayList al1=new ArrayList();
		al1.add("java01");
		al1.add("java02");
		al1.add("java03");
		al1.add("java04");
		
		ArrayList al2=new ArrayList();
		
		al2.add("java01");
		al2.add("java02");
		al2.add("java05");
		al2.add("java06");
		
//		al1.retainAll(al2);//取交集，al1中只会保留al2中相同的元素，如果没有交集，则为空
		al1.removeAll(al2);//
		
		sop("al1"+al1);
		sop("al2"+al2);
		
}


public static void base_method()
{
	//创建一个集合容器，使用Coiiection接口的子类，ArrayList
	ArrayList al=new ArrayList();
	
	//1，添加元素
	al.add("java01");//add(Object obj)
	al.add("java02");
	al.add("java03");
	al.add("java04");
	
	//打印原集合
	sop(al);
	
	//2，获取个数，集合长度
	sop("size:" +al.size());
	
	//3，删除元素
//	al.remove("java02");
//	al.clear();//清空集合
	
	//4,判断元素
	sop("java03是否存在："+al.contains("java03"));
	sop("集合是否为空？"+al.isEmpty());
	
	
//	//打印改变后集合
//	sop(al);//删除后
	
}
	public static void sop(Object obj){
		System.out.println(obj);
	}

}
