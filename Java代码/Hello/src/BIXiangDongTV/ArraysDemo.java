package BIXiangDongTV;

/*
Arrays:���ڲ�������Ĺ�����
���涼�Ǿ�̬����

asList:��������List�ļ���

��������е�Ԫ�ض��Ƕ���,��ô��ɼ���ʱ,�����е�Ԫ�ؾ�ֱ�ӱ�ɼ����е�Ԫ��.
��������е�Ԫ�ض��ǻ�����������,��ô�Ὣ��������Ϊ�����е�Ԫ�ش���.
*/

import java.util.*;
public class ArraysDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = {2,4,5};
//		System.out.println(Arrays.toString(arr));
		
		String[] arr = {"aaa","dff","kkk"};
		//�������ɼ�����ʲô�ô���?
		/*
		 *�����ü��ϵ�˼��ͷ�����������������е�Ԫ��.
		 *ע��:�������ɽἯ��,������ʹ�ü����� ����ɾ����.
		 *��Ϊ����ĳ����ǹ̶� ��.�����ɾ,����׳�UnsupportedOperationException�쳣
		 *
		 * */
		List<String> list = Arrays.asList(arr);//�������ɼ���
		sop("contains:"+list.contains("kkk"));
//		list.add("qq");//������ʹ�ü��ϵ���ɾ����
		sop(list);
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}

}

