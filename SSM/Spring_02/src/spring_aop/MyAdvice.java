package spring_aop;

import org.aspectj.lang.ProceedingJoinPoint;

//֪ͨ��
public class MyAdvice {

	//ǰ��֪ͨ
//		|-Ŀ�귽������֮ǰ֪ͨ
	//����֪ͨ����������쳣����������ã�
//		|-��Ŀ�귽������֮�����
	//����֪ͨ
//		|-��Ŀ�귽��֮ǰ��֮�󶼻����
	//�쳣����֪ͨ
//		|-��������쳣�ͻ����
	//����֪ͨ����û���쳣������ã�
//		|-��Ŀ�귽������֮�����
//--------------------------------------------------
	
	//ǰ��֪ͨ
	public void before() {
		System.out.println("����ǰ��֪ͨ��");
	}
	
	//����֪ͨ
	public void afterReturning() {
		System.out.println("���Ǻ���֪ͨ����������쳣����������ã���");
	}
	
	//����֪ͨ
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("���ǻ���֪֮ͨǰ�Ĳ��֣�");
		
		Object prceed = pjp.proceed();//����Ŀ�귽��
		
		System.out.println("���ǻ���֪֮ͨ��Ĳ��֣�");
		
		return prceed;
	}
	
	//�쳣֪ͨ
	public void afterException() {
		System.out.println("�����쳣�ˣ�");
	}
	
	//����֪ͨ
	public void after() {
		System.out.println("����֪ͨ�������쳣Ҳ����ã���");
	}
	
	
}
