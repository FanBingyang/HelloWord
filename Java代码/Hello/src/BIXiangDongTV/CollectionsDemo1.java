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
	public static void replaceAllDemo()//���ڼ�����Ԫ�ص��滻
	{
		List<String> list = new ArrayList<String>();
		
		list.add("abcde");
		list.add("a");
		list.add("sdfh");
		list.add("kk");
		list.add("qqc");
		
		sop(list);
		Collections.replaceAll(list, "kk"," jj");//����list�����е�"kk"Ԫ���滻��"jj"
		sop(list);
		Collections.reverse(list);//��ת�����е�Ԫ��˳��
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
		Collections.fill(list,"pp");//�������е�Ԫ��ȫ������"pp"��
		sop(list);
	}
	
	
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}

}

/*
	 * ��ϰ��fill�������Խ�list�����е�����Ԫ���滻��ָ��Ԫ�ء�
	 * 		��list�����еĲ���Ԫ���滻��ָ��Ԫ�ء�
	 * 
	 * */