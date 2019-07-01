package BIXiangDongTV;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapTest2 {
/*
��ϰ
"sdfgzxcvasdfxcvdf"��ȡ���ַ���������ĸ���ֵĴ���

ϣ����ӡ�����a(1)c(2)....

ͨ��������֣�ÿһ����ĸ���ж�Ӧ�Ĵ�����
˵����ĸ�ʹ���֮����ӳ���ϵ��

ע�⣺��������ӳ���ϵʱ������ѡ��Map���ϣ�
��ΪMap�����д�ŵľ���ӳ���ϵ

ʲôʱ���ʹ��Map������?
������֮�����ӳ���ϵʱ���Ϳ���ʹ��Map���ϡ�

˼·��
1�����ַ���ת�����ַ����飬��ΪҪ��ÿһ����ĸ���в�����
2������һ��Map���ϣ���Ϊ��ӡ����ĸ��˳�����Ե���ʹ��TreeMap���ϡ�
3�������ַ�����
	��ÿһ����ĸ��Ϊ��ȥ��Map���ϡ�
	�������null��������ĸ�ĺ�1���뵽Map�����С�
	������ز���null��˵������ĸ��Map�������Ѿ����ڲ��ж�Ӧ����
	��ô�ͻ�ȡ�ô���������������Ȼ�󽫸���ĸ��������Ĵ������뵽Map�����У����ǵ���ԭ�������Ӧ��ֵ
4����Map�����е����ݱ��ָ�����ַ�����ʽ���ء�

	
*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = charCount("sdfgzxcvasdfxcvdf");
		System.out.println(s);
	}
	public static String charCount(String str){
		char[] chs = str.toCharArray();
		
		TreeMap<Character,Integer> tm = new TreeMap<Character, Integer>();
		
		int count = 0;
		for(int x=0;x<chs.length;x++)
		{
			if(!(chs[x]>='a' && chs[x]<='z' || chs[x]>='A' && chs[x]<='Z'))
				continue;
			Integer value = tm.get(chs[x]);
			
			if(value!=null)
				count = value;
			count++;
			tm.put(chs[x], count);
			count = 0;
			
		/*�ȼ�������ڶ���if����
		 	if(value==null)
			{
				tm.put(chs[x],1);
			}
			else {
				value = value+1;
				tm.put(chs[x],value);
			}
		*/
		}
		System.out.println(tm);
		
		StringBuilder sb = new StringBuilder();//������
		
		Set<Map.Entry<Character, Integer>>  entrySet = tm.entrySet();
		Iterator<Map.Entry<Character, Integer>> it = entrySet.iterator();
		
		while(it.hasNext())
		{
			Map.Entry<Character, Integer> me = it.next();
			Character ch = me.getKey();
			Integer value = me.getValue();
			sb.append(ch+"("+value+")");
		}
		return sb.toString();
	}
}
