package BIXiangDongTV;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
Map���ϵ�����ȡ����ʽ��
1��keySet:��Map�����еļ����뵽��Set���ϣ���ΪSet�߱���������
	���Կ��Ե�����ʽȡ�����еļ����ٸ���get������ȡÿһ������Ӧ��ֵ��
	
	Map����ȡ����ԭ����Map���ת��Set���ϣ���ͨ��������ȡ����
	
2,Set<Map.Entry<k,v>> entrySet:��Map�����е�ӳ���ϵ���뵽��set�����У�
	�������ϵ���������;��ǣ�Map.Entry


*/
public class MapDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,String> map = new HashMap<String, String>();
		
		map.put("01","zhangsan--1");
		map.put("02","zhangsan--2");
		map.put("03","zhangsan--3");
		map.put("04","zhangsan--4");
	/*	
		//��Map�����е�ӳ���ϵȡ���������set������
		Set<Map.Entry<String, String>> entrySet = map.entrySet();
		
		Iterator<Map.Entry<String, String>> it = entrySet.iterator();
		
		while(it.hasNext())
		{
			Map.Entry<String, String> me = it.next();
			String key = me.getKey();
			String value = me.getValue();
			System.out.println(key+":"+value);
		}
	*/	
		
	/*
		//�Ȼ�ȡMap�����е����м���Set���ϣ���keySet()����
		Set<String> keySet = map.keySet();
		
		//����Set���ϾͿ��Ի�ȡ�������
		Iterator<String> it = keySet.iterator();
		while(it.hasNext())
		{
			String key = it.next();
			//���˼��Ϳ���ͨ��map���ϵ�ge������ȡ���Ӧ��ֵ
			String value = map.get(key);
			System.out.println("key:"+key+", value��"+value);
		}
	*/	
	}

}
/*
Map.Entry ��ʵEntryҲ��һ���ӿڣ�����Map�ӿ��е�һ���ڲ��ӿڡ�

interface Map
{
	public static interface Entry
	{
		public abstract Object getKey(){}
		public abstract Object getValue(){}
	}
}

calss HashMap implements Map
{
	class Hahs implements Map.Entry
	{
		public  Object getKey(){}
		public  Object getValue(){}
	}
}
*/

