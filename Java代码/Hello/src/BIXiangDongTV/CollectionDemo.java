package BIXiangDongTV;

import java.util.ArrayList;
import java.util.Iterator;
/*
 1��add�����Ĳ���������Object���Ա��ڽ����������͵Ķ��� 
 2�������д洢�Ķ��Ƕ��������(��ַ)
 
 ʲô�ǵ������أ�
 ��ʵ���Ǽ���ȡ��Ԫ�صķ�ʽ
 
 

 * */
public class CollectionDemo {

public static void main(String[] args) {
//	base_method();
//	method2();
	method_get();	
		

	}

public static void method_get()
{
		//����һ������������ʹ��Coiiection�ӿڵ����࣬ArrayList
		ArrayList al=new ArrayList();
		
		//���Ԫ��
		al.add("java01");//add(Object obj)
		al.add("java02");
		al.add("java03");
		al.add("java04");
		
		Iterator it = al.iterator();//��ȡ������������ȡ�������е�Ԫ��
		while(it.hasNext()){
			sop(it.next());
		}
		
		//�ȼ������ϵ���������
/*		for(Iterator it = al.iterator();it.hasNext();)
		{
			sop(it.next());
		}
*/		
		
//		sop(al);
	
}

public static void method2(){
	//����һ������������ʹ��Coiiection�ӿڵ����࣬ArrayList
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
		
//		al1.retainAll(al2);//ȡ������al1��ֻ�ᱣ��al2����ͬ��Ԫ�أ����û�н�������Ϊ��
		al1.removeAll(al2);//
		
		sop("al1"+al1);
		sop("al2"+al2);
		
}


public static void base_method()
{
	//����һ������������ʹ��Coiiection�ӿڵ����࣬ArrayList
	ArrayList al=new ArrayList();
	
	//1�����Ԫ��
	al.add("java01");//add(Object obj)
	al.add("java02");
	al.add("java03");
	al.add("java04");
	
	//��ӡԭ����
	sop(al);
	
	//2����ȡ���������ϳ���
	sop("size:" +al.size());
	
	//3��ɾ��Ԫ��
//	al.remove("java02");
//	al.clear();//��ռ���
	
	//4,�ж�Ԫ��
	sop("java03�Ƿ���ڣ�"+al.contains("java03"));
	sop("�����Ƿ�Ϊ�գ�"+al.isEmpty());
	
	
//	//��ӡ�ı�󼯺�
//	sop(al);//ɾ����
	
}
	public static void sop(Object obj){
		System.out.println(obj);
	}

}
