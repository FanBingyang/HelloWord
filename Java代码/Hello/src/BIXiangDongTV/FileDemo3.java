package BIXiangDongTV;

import java.io.File;

/*
 * ��ϰ��
 * �г�ָ��Ŀ¼���ļ������ļ��У�������Ŀ¼�е����ݡ�
 * Ҳ�����г�ָ��Ŀ¼�µ��������ݡ�
 * ***************
 * ��ΪĿ¼�л���Ŀ¼��ֻҪʹ�� ͬһ���г�Ŀ¼���ܺ�����ɼ��ɡ�
 * ���г������г��ֵĻ���Ŀ¼�Ļ����������ٴε��ñ����ܡ�
 * Ҳ���Ǻ��������������
 * ���ֱ�����ʽ������ַ�����Ϊ�ݹ顣
 * 
 * �ݹ�Ҫע��ģ�
 * 1���޶�����
 * 2��ע��ݹ�Ĵ��������������ڴ������
 * 
 */
public class FileDemo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File dir = new File("D:\\Java\\������Ƶ");
		showDir(dir,0);
		
		
		//�����ݹ�ʾ���ĵ���
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
				System.out.println(getLevel(level)+files[x]);//�г�ָ��Ŀ¼�µ���������
		}
	}
	
//�����������ݹ麯���ļ�ʾ��
public static int getSum(int n)
	{
		if(n==1)
			return 1;
		else
			return n+getSum(n-1);
	}
	
	public static void toBin(int num)//��ӡָ���������Ķ�����
	{
		if(num>0)
		{
			toBin(num/2);
			System.out.println(num%2);
//			num = num/2;
		}
		
	}
}


