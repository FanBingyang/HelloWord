package BIXiangDongTV;
/*
���ͣ�JDK1.5�汾֮����ֵ������ԡ����ڽ����ȫ���⣬��һ����ȫ����

 �ô���
 1��������ʱ�ڳ�������classCastException��ת�Ƶ��˱���ʱ�ڡ�
 	�����ڳ���Ա������⡣������ʱ������٣���ȫ��
 	
 2��������ǿ��ת���鷳��
 
 ���͸�ʽ��ͨ��<>������Ҫ�����������������͡�
 
 ����ʹ��Java�ṩ�Ķ���ʱ��ʲôʱ��ʹ�÷����أ�
 	ͨ���ڼƻ��Ϳ���кܳ�����ֻҪ����<>��Ҫ���巺�͡�
 	��ʵ<>���������������͵ġ�
 	��ʹ�ü���ʱ����������Ҫ�洢������������Ϊ�������ݵ�<>���ɡ�
 */
import java.util.ArrayList;
import java.util.Iterator;

public class GenericDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> al = new ArrayList<String>();//����һ���ַ������͵ļ�������
		
		al.add("adc01");
		al.add("adc09991");
		al.add("adc014");
		
		Iterator<String> it = al.iterator();
		while(it.hasNext()){
//			String s = (String)it.next();//����ǿ��ת��,
			String s = it.next();   //ʹ�ö��弯�����ͺ͵��������ͺ���ת������
			System.out.println(s+":"+s.length());
		}
	}

}
