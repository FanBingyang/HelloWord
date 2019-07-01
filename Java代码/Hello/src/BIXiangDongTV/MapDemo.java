package BIXiangDongTV;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/*
Map
	|--Hashtable:�ײ��ǹ�ϣ�����ݽṹ�������Դ���null����nullֵ���ü������߳�ͬ���ģ�jdk1.0��Ч�ʸߡ�
	|--HashMap:�ײ��ǹ�ϣ�����ݽṹ������null����nullֵ���ü����ǲ�ͬ���ģ���hashtable�����jdk1.2��Ч�ʸߡ�
	|--TreeMap:�ײ��Ƕ��������ݽṹ���̲߳�ͬ�����������ڸ�Map�����еļ���������
	
 
��Set������ʵSet�ײ����ʹ����Map���ϡ�
 
 
 */
public class MapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,String> map = new HashMap<String, String>();
		//���Ԫ��,����������ʱ��ͬ�ļ�����ô����ӵ�ֵ�ͻḲ��ԭ�м���Ӧ��ֵ����put�����᷵�ر����ǵ�ֵ
		map.put("01","zhangsan--1");
		map.put("02","zhangsan--2");
		map.put("03","zhangsan--3");
		
		System.out.println("containtsKey:"+map.containsKey("02"));  //�ж���û��"02"��
//		System.out.println("remove:"+map.remove("02"));  //���"02"����ɾ��
		System.out.println("get:"+map.get("02"));//�ж�ĳ��Ԫ���Ƿ����
		
		map.put(null, "haha");
		System.out.println("get:"+map.get("null"));
		//����ͨ��get�����ķ���ֵ���ж�һ�����Ƿ���ڡ�
		
		//��ȡmap���������е�ֵ
		Collection<String> coll = map.values();
		System.out.println(coll);
		
		System.out.println(map);//��ӡ����
		
		
	}

}
