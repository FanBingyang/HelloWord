package BIXiangDongTV;

import java.io.File;

/*
 * 练习：
 * 列出指定目录下文件或者文件夹，包含子目录中的内容。
 * 也就是列出指定目录下的所有内容。
 * ***************
 * 因为目录中还有目录，只要使用 同一个列出目录功能函数完成即可。
 * 在列出过程中出现的还是目录的话，还可以再次调用本功能。
 * 也就是函数自身调用自身。
 * 这种表现形式（编程手法）成为递归。
 * 
 * 递归要注意的：
 * 1，限定条件
 * 2，注意递归的次数，尽量避免内存溢出。
 * 
 */
public class FileDemo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File dir = new File("D:\\Java\\毕向东视频");
		showDir(dir,0);
		
		
		//两个递归示例的调用
//		toBin(6);
//		System.out.println("sum="+getSum(10));
	}
	
	public static String getLevel(int level)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("|---");
		for (int i = 0; i < level; i++) {
//			sb.append("  ");
			sb.insert(0, "  ");
			
		}
		return sb.toString();
	}

	public static void showDir(File dir,int level)
	{
		System.out.println(getLevel(level)+dir.getName());
		level++;
		
		File[] files = dir.listFiles();
		for(int x=0;x<files.length;x++)
		{
			if(files[x].isDirectory())
				showDir(files[x],level);
			else
				System.out.println(getLevel(level)+files[x]);//列出指定目录下的所有内容
		}
	}
	
//下面是两个递归函数的简单示例
public static int getSum(int n)
	{
		if(n==1)
			return 1;
		else
			return n+getSum(n-1);
	}
	
	public static void toBin(int num)//打印指定正整数的二进制
	{
		if(num>0)
		{
			toBin(num/2);
			System.out.println(num%2);
//			num = num/2;
		}
		
	}
}


