package BIXiangDongTV;

import java.io.File;
import java.io.IOException;
/*
 * File�ೣ���ķ���;
 * 1������
 * 		boolean  createNewFile();��ָ��λ�ô����ļ��������ɹ�����true��������ļ��Ѿ����ڣ��򲻴���������false��
 * 								���������һ�������������һ�����ͻᴴ���������ļ��Ѿ����ڣ���Ḳ�ǡ�
 * 		boolean mkdir();  �����ļ���
 * 		boolean mkdirs();  �����༶�ļ���
 * 
 * 2��ɾ��
 * 		boolean  delete();ɾ��ʧ�ܷ���false
 * 		void  deleteOnExit();�ڳ����˳�ʱɾ��ָ���ļ�
 * 
 * 3���ж�
 * 		boolean  exists();�ж��ļ��Ƿ����
 * 		boolean  canExecute()���ж��ļ��Ƿ���ִ��
 * 		isDirectory());�ж��ļ������Ƿ����ļ���
 * 		isFile();�жϼ������Ƿ����ļ�
 * 		isAbsolute();�ж��ļ�����·���Ƿ��Ǿ���·����������ļ������ڣ�ֻҪ�Ǿ���·�����ͷ���true��
 * 
 * 4����ȡ��Ϣ
 * 		String  getName();��ȡ�ļ���������
 * 		String  getPatn();��ȡ�ļ���������·��
 * 		String getParent();��ȡ�ļ�����ľ���·���еĸ�Ŀ¼·������
 * 		String getAbsolutePath();��ȡ�ļ�����ľ���·��
 * 		long  lastModified();�����ļ����һ�ε��޸�ʱ��
 * 		long  length();��ȡ�ļ��ĳ��ȴ�С
 * 
 * 		boolean  renameTo(File f);//���ļ�f1�����ƺ�·���޸�Ϊf2����ġ��޸ĳɹ�����true�����򷵻�false
 * 
 */
public class FileDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		consMethod();
//		method_1();
		method_2();
//		method_3();
//		method_4();
//		method_5();
	}
	
	public static void method_5() throws IOException
	{
		File f1 = new File("D:\\Java\\FileDemo.txt");
		File f2 = new File("D:\\Java\\FileDemo2.txt");
		
		sop("rename:"+f1.renameTo(f2));//���ļ�f1�����ƺ�·���޸�Ϊf2����ġ�
	}
	
	public static void method_4() throws IOException
	{
		File f = new File("D:\\Java\\FileDemo.txt");
		
		sop("path:"+f.getPath());//�������·�������ļ�·����װ��·��
		sop("abspath:"+f.getAbsolutePath());//���ؾ���·��
		sop("parent:"+f.getParent());//�÷������ص�ʱ����·���е��ļ���Ŀ¼��������ȡ��ʱ���·�����򷵻�null
									//������·��������һ��Ŀ¼����ô��Ŀ¼���Ƿ��ؽ����
		
	}
	
	public static void method_1() throws IOException
	{
		File f = new File("D:\\Java\\FileDemo.txt"); 
		f.deleteOnExit();//�������׳��쳣�ٳ������ʱҲ��ǿ��ɾ��
//			code();//����˴���һ�Ѷ��ļ����д���Ĵ���飬
//		sop("create:"+f.createNewFile());
		sop("delete��"+f.delete());
	}
	
	public static void method_2() throws IOException
	{
		File f = new File("D:\\Java\\FileDemo.txt");
		
//		sop("canExcute:"+f.canExecute());//�ж��ļ��Ƿ���ִ��
		sop("exists:"+f.exists());//�ж��ļ��Ƿ����
		
		//�����ļ���
//		File dir = new File("D:\\Java\\bilaoshi");
//		
//		sop("mkdir:"+dir.mkdir());//.mkdir()ֻ�ܴ���һ���ļ���
		
		File dir1 = new File("D:\\Java\\bilaoshi\\aa\\bb");
		
		sop("mkdir:"+dir1.mkdirs());//.mkdirs()�����༶�ļ���
	}
	
	public static void method_3() throws IOException
	{
		File f = new File("D:\\Java\\FileDemo.txt");
		
//		f.createNewFile();
		
//		f.mkdir();
		
		//�мǣ����ж��ļ������Ƿ����ļ������ļ���ʱ������Ҫ���жϸ��ļ������װ�������Ƿ����
		//ͨ��exists()�����������ж�
		sop("dir:"+f.isDirectory());//�ж�ָ��·���ļ��Ƿ����ļ���
		sop("file:"+f.isFile());//�ж�ָ��·���ļ������Ƿ����ļ�
		sop(f.isAbsolute());//�ж��ļ�����·���Ƿ��Ǿ���·��
	}
	
	
	
	
	//����File����
	public static void consMethod()
	{
		//��FileDemo.txt��װ��file���󡣿��Խ����еĺ�δ���ֵ��ļ������ļ��з�װ�ɶ���
		File f1 = new File("D:\\Java\\FileDemo.txt");
		
		File f2 = new File("D:\\Java\\������Ƶ","FileDemo.txt");
		
		File d = new File("D:\\Java\\������Ƶ");
		File f3 = new File(d,"FileDemo.txt");
		
		sop("f1:"+f1);
		sop("f2:"+f2);
		sop("f3:"+f3);
		
		//��ƽ̨ʹ�õķָ��File.separator���൱��Windows���"\"
		File f4 = new File("D:"+File.separator+"Java"+File.separator+"������Ƶ"+File.separator+"FileDemo.txt");
	}
	
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}

}
