package BIXiangDongTV;

import java.util.Arrays;
import static java.util.Arrays.*;//导入的是Arrays这个类中的所有静态成员。
/*
 * StaticImport：静态导入。
 * 
 *当类名重名时，需要指定具体的包名。
 *当方法重名时，需要指定具备所属的对象或类。
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
