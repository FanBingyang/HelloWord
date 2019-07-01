package BIXiangDongTV;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/*
Collection
	|--List：元素是有序的，元素可以重复，因为该集合体系有索引
		|--ArrayList:底层的数据结构使用的是数组结构
		|--LinkedList：底层使用的是链表数据结构
		|--Vector：
	|--Set：元素是无序的，不可以重复
	
List：
	特有方法：饭时可以操作角标的方法，都是该体系特有的方法
	
增
	add(index,element);
	addAll(index,Collection);
	
删
	remove(index);
	
改
	set(index,element);
	
查
	get(index);
	suList(from,to);
	listIterator();
	

List集合特有的迭代器。ListIterator是Iterator的子接口

在迭代时，不可以通过集合对象的方法操作集合中的元素，
因为会发生异常。

所以，在迭代时，只能用迭代器的方法操作元素，可是Iterator方法时有限的，
只能对元素进行判断、取出、删除的操作，
如果想要进行其他操作，如添加、修改等，就需要使用其子接口，叫做ListIterator。

该接口只能通过List集合的ListIterator方法获取。

*/
public class ListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//演示列表迭代器
		ArrayList  al=new ArrayList();
		al.add("java01");
		al.add("java02");
		al.add("java03");
		sop("原集合："+al);
		
		ListIterator li = al.listIterator();
		while(li.hasNext()){
			Object obj = li.next();
			if(obj.equals("java02"))
				li.add("java009");
		}
		while(li.hasPrevious())
			sop("hasPrevious():"+li.previous());
//		sop("hasNext():"+li.hasNext());//正序遍历，后面没有元素了为fals
//		sop("hasPrevious():"+li.hasPrevious());//逆向遍历，前面有元素为true

		sop("al="+al);
		
		
//		//在迭代过程中，准备添加或者删除元素
//		Iterator  it=al.iterator();
//		while(it.hasNext()){
//			Object obj = it.next();
//			if(obj.equals("java02"))
////				al.add("java008");
//				it.remove();//将“java02”从集合中删除了
//			
//			sop("obj:"+obj);
//		}
//		sop("al="+al);
	}
	
	
	
	public static void method(){
		ArrayList  al3=new ArrayList();
		al3.add("java01");
		al3.add("java02");
		al3.add("java03");
		
		sop("原集合为："+al3);
		//在指定位置添加元素
		al3.add(1,"java09");
		sop(al3);
		
		
//		//删除指定位置的元素
//		al3.remove(2);
		
//		//修改元素
//		al3.set(2, "java07");
		
		
		//通过角标获取元素
		sop("get(1):"+al3.get(1));
		
		//获取所有元素
		for(int x=0;x<al3.size();x++)
		{
			sop("al3("+x+")="+al3.get(x));
		}
		
		Iterator  it=al3.iterator();
		while(it.hasNext()){
			sop("next:"+it.next());
		}
		
		
		//通过indexOf获取对象的位置
		sop("index="+al3.indexOf("java02"));
		
		List sub = al3.subList(1,3);
		sop("sub="+sub);
	}
	
	public static void sop(Object obj){
		System.out.println(obj);
	}
}
