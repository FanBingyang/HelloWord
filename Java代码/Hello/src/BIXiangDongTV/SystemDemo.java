package BIXiangDongTV;

import java.util.Properties;

/*
 * System:���еķ��������Զ��Ǿ�̬�ġ�
 * out����׼�����Ĭ���ǿ���̨
 * in����׼���룬Ĭ���Ǽ���
 * 
 * ����ϵͳһЩ��Ϣ��
 * 
 * ��ȡϵͳ������Ϣ��Properties getProperties();
 * 
 * 
 * 
 */
public class SystemDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Properties prop = System.getProperties();
		
		//��ΪProperties��Hashtable�����࣬Ҳ����Map���ϵ�һ���������
		//��ô����ͨ��map�ķ���ȡ���ü����е�Ԫ�ء�
		//�ü����д洢�Ķ����ַ�����û�з��Ͷ���
		
		//�����ϵͳ���Զ���һЩ������Ϣ�أ�
		System.setProperty("Mykey", "Myvalue");//�����Զ���������Ϣ
		
		//��ȡָ��������Ϣ
		String value = System.getProperty("os.name");//���ص�ǰ�汾��Ϣ���ַ�����
		System.out.println("��ǰϵͳ�汾:"+value);
		
	/*	//�ɲ�������jvm����ʱ����̬����һЩ������Ϣ�أ�
		String v = System.getProperty("haha");
		System.out.println("v:"+v);
	*/	
		
	/*	//��ȡ����������Ϣ
		for(Object obj : prop.keySet())
		{
			String value = (String)prop.get(obj);
			
			System.out.println(obj+"::"+value);
			
		}
	*/
	}

}
