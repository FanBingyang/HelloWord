package BIXiangDongTV;
/*
Set:无序，不可以有重复元素。
	|--HaxhSet：数据结构是哈希表。线程是非同步的。
				保证元素唯一性的原理：判断元素的hashCode值是否相等。
				如果相等，还会继续判断元素的equals方法，是否为true。
				
	|--TreeSet：可以对set集合中的元素进行排序。
				底层数据结构时二叉树
				保证元素唯一性的依据：compareTo方法和return 0。
				
				TreetSet排序的第一种方式：让元素自身具备比较性。
				元素需要实现Comparable接口，覆盖compareTo方法
				这种方式也称为元素的自然排序，或者叫默认排序。
				
				TreetSet排序的第二种方式：
				当元素自身比不具备比较性时，或者具备的比较性不是所需要的。
				这时就需要让集合自身具备比较性。在集合初始化时，就有了比较方式。
	
	**注意：排序时当主要条件相同时，一定判断一下次要条件。




*/
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetDemo_1 {
	public static void main(String [] args)
	{
		
		TreeSet ts = new TreeSet();//按学生年龄进行排序
//		TreeSet ts = new TreeSet(new Mycompare());//按学生姓名进行排序
		
		
		ts.add(new Student("lisi_02",22));
		ts.add(new Student("lisi_07",20));
		ts.add(new Student("lisi_09",19));
		ts.add(new Student("lisi_08",19));
		ts.add(new Student("lisi_04",40));
		
		Iterator it = ts.iterator();
		while(it.hasNext()){
			Student stu = (Student)it.next();
			System.out.println(stu.getName()+"..."+stu.getAge());
		}
	}
}
