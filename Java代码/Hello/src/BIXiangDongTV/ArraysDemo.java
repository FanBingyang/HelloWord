package BIXiangDongTV;

/*
Arrays:用于操作数组的工具类
里面都是静态方法

asList:将数组变成List的集合

如果数组中的元素都是对象,那么变成集合时,数组中的元素就直接变成集合中的元素.
如果数组中的元素都是基本数据类型,那么会将该数组作为集合中的元素存在.
*/

import java.util.*;
public class ArraysDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = {2,4,5};
//		System.out.println(Arrays.toString(arr));
		
		String[] arr = {"aaa","dff","kkk"};
		//把数组变成集合有什么好处呢?
		/*
		 *可以用集合的思想和方法用来操作数组和中的元素.
		 *注意:将数组变成结集合,不可以使用集合中 的增删方法.
		 *因为数组的长度是固定 的.如果增删,则会抛出UnsupportedOperationException异常
		 *
		 * */
		List<String> list = Arrays.asList(arr);//将数组变成集合
		sop("contains:"+list.contains("kkk"));
//		list.add("qq");//不可以使用集合的增删方法
		sop(list);
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}

}

