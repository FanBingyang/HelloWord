package BIXiangDongTV;
/*
Set:���򣬲��������ظ�Ԫ�ء�
	|--HaxhSet�����ݽṹ�ǹ�ϣ���߳��Ƿ�ͬ���ġ�
				��֤Ԫ��Ψһ�Ե�ԭ���ж�Ԫ�ص�hashCodeֵ�Ƿ���ȡ�
				�����ȣ���������ж�Ԫ�ص�equals�������Ƿ�Ϊtrue��
				
	|--TreeSet�����Զ�set�����е�Ԫ�ؽ�������
				�ײ����ݽṹʱ������
				��֤Ԫ��Ψһ�Ե����ݣ�compareTo������return 0��
				
				TreetSet����ĵ�һ�ַ�ʽ����Ԫ������߱��Ƚ��ԡ�
				Ԫ����Ҫʵ��Comparable�ӿڣ�����compareTo����
				���ַ�ʽҲ��ΪԪ�ص���Ȼ���򣬻��߽�Ĭ������
				
				TreetSet����ĵڶ��ַ�ʽ��
				��Ԫ������Ȳ��߱��Ƚ���ʱ�����߾߱��ıȽ��Բ�������Ҫ�ġ�
				��ʱ����Ҫ�ü�������߱��Ƚ��ԡ��ڼ��ϳ�ʼ��ʱ�������˱ȽϷ�ʽ��
	
	**ע�⣺����ʱ����Ҫ������ͬʱ��һ���ж�һ�´�Ҫ������




*/
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetDemo_1 {
	public static void main(String [] args)
	{
		
		TreeSet ts = new TreeSet();//��ѧ�������������
//		TreeSet ts = new TreeSet(new Mycompare());//��ѧ��������������
		
		
		ts.add(new Student("lisi_02",22));
		ts.add(new Student("lisi_07",20));
		ts.add(new Student("lisi_09",19));
		ts.add(new Student("lisi_08",19));
		ts.add(new Student("lisi_04",40));
		
		Iterator it = ts.iterator();
		while(it.hasNext()){
			Student stu = (Student)it.next();
			System.out.println(stu.getName()+"..."+stu.getAge());
		}
	}
}
