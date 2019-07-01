package BIXiangDongTV;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/*
Collection
	|--List��Ԫ��������ģ�Ԫ�ؿ����ظ�����Ϊ�ü�����ϵ������
		|--ArrayList:�ײ�����ݽṹʹ�õ�������ṹ
		|--LinkedList���ײ�ʹ�õ����������ݽṹ
		|--Vector��
	|--Set��Ԫ��������ģ��������ظ�
	
List��
	���з�������ʱ���Բ����Ǳ�ķ��������Ǹ���ϵ���еķ���
	
��
	add(index,element);
	addAll(index,Collection);
	
ɾ
	remove(index);
	
��
	set(index,element);
	
��
	get(index);
	suList(from,to);
	listIterator();
	

List�������еĵ�������ListIterator��Iterator���ӽӿ�

�ڵ���ʱ��������ͨ�����϶���ķ������������е�Ԫ�أ�
��Ϊ�ᷢ���쳣��

���ԣ��ڵ���ʱ��ֻ���õ������ķ�������Ԫ�أ�����Iterator����ʱ���޵ģ�
ֻ�ܶ�Ԫ�ؽ����жϡ�ȡ����ɾ���Ĳ�����
�����Ҫ������������������ӡ��޸ĵȣ�����Ҫʹ�����ӽӿڣ�����ListIterator��

�ýӿ�ֻ��ͨ��List���ϵ�ListIterator������ȡ��

*/
public class ListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��ʾ�б������
		ArrayList  al=new ArrayList();
		al.add("java01");
		al.add("java02");
		al.add("java03");
		sop("ԭ���ϣ�"+al);
		
		ListIterator li = al.listIterator();
		while(li.hasNext()){
			Object obj = li.next();
			if(obj.equals("java02"))
				li.add("java009");
		}
		while(li.hasPrevious())
			sop("hasPrevious():"+li.previous());
//		sop("hasNext():"+li.hasNext());//�������������û��Ԫ����Ϊfals
//		sop("hasPrevious():"+li.hasPrevious());//���������ǰ����Ԫ��Ϊtrue

		sop("al="+al);
		
		
//		//�ڵ��������У�׼����ӻ���ɾ��Ԫ��
//		Iterator  it=al.iterator();
//		while(it.hasNext()){
//			Object obj = it.next();
//			if(obj.equals("java02"))
////				al.add("java008");
//				it.remove();//����java02���Ӽ�����ɾ����
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
		
		sop("ԭ����Ϊ��"+al3);
		//��ָ��λ�����Ԫ��
		al3.add(1,"java09");
		sop(al3);
		
		
//		//ɾ��ָ��λ�õ�Ԫ��
//		al3.remove(2);
		
//		//�޸�Ԫ��
//		al3.set(2, "java07");
		
		
		//ͨ���Ǳ��ȡԪ��
		sop("get(1):"+al3.get(1));
		
		//��ȡ����Ԫ��
		for(int x=0;x<al3.size();x++)
		{
			sop("al3("+x+")="+al3.get(x));
		}
		
		Iterator  it=al3.iterator();
		while(it.hasNext()){
			sop("next:"+it.next());
		}
		
		
		//ͨ��indexOf��ȡ�����λ��
		sop("index="+al3.indexOf("java02"));
		
		List sub = al3.subList(1,3);
		sop("sub="+sub);
	}
	
	public static void sop(Object obj){
		System.out.println(obj);
	}
}
