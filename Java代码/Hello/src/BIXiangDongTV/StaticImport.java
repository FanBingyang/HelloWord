package BIXiangDongTV;

import java.util.Arrays;
import static java.util.Arrays.*;//�������Arrays������е����о�̬��Ա��
/*
 * StaticImport����̬���롣
 * 
 *����������ʱ����Ҫָ������İ�����
 *����������ʱ����Ҫָ���߱������Ķ�����ࡣ
 * 
 */

public class StaticImport {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,1,5};
//		Arrays.sort(arr);
		sort(arr);
		int index = Arrays.binarySearch(arr,3);
		
		System.out.println(Arrays.toString(arr));
		System.out.println("index="+index);
		
		
	}

}
