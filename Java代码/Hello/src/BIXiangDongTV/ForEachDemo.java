package BIXiangDongTV;


import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/*�߼�forѭ��:forEach
 *��ʽ:
 *for(��������  ������ : �������ļ���(Collection)������)
 *{       }
 * 
 * �Լ��Ͻ��б�����ʱ��,ֻ�ܻ�ȡԪ��,���ܶԼ��Ͻ��в���
 * 
 * ���������˱���,�����Խ���remove�����е�Ԫ�ض���.
 * �������ListIteartor�������ڱ��������жԼ��Ͻ�����ɾ�Ĳ�Ķ���
 * 
 ** ��ͳforѭ���͸߼�forѭ����ʲô������?
 *�߼�for��һ��������,�����б�������Ŀ��
 *
 *����:�ڱ��������ʱ��ʹ�ô�ͳfor,��ͳfor���Զ���Ǳ�
 */
public class ForEachDemo {

	private static final boolean Integer = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> al = new ArrayList<String>();
		
		al.add("abc-1");
		al.add("abc-2");
		al.add("abc-3");
		al.add("abc-4");
		
		for(String s:al)
		{
			System.out.println(s);
		}
	/*	Iterator it = al.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	*/
		
		int[] arr = {3,5,1};
		for(int i:arr)
		{
			System.out.println("i=:"+i);
		}
		
		HashMap<Integer,String> hm =new HashMap<Integer,String>();
		
		hm.put(1, "a");
		hm.put(2, "b");
		hm.put(3, "c");
		
		Set<Integer> keySet = hm.keySet();
		for(Integer i:keySet)
		{
			System.out.println(i+"::"+hm.get(i));
		}	
		
//		Set<Map.Entry<Integer,String>> entry = hm.entrySet();
//		for(Map.Entry<Integer,String> me:entry)
//		{
//			
//		}
		
		for(Map.Entry<Integer,String> me:hm.entrySet())
		{
			System.out.println(me.getKey()+"-----"+me.getValue());
		}
	}

}
