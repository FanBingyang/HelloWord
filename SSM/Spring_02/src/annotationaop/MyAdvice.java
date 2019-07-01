package annotationaop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//֪ͨ��
@Aspect
//��ʾ������һ��֪ͨ��
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
	
	//ͨ���÷������е��ȡ����
	@Pointcut("execution(* service.*ServiceImpl.*(..))")
	public void pc() {}
	
	//ǰ��֪ͨ
	//ָ���÷�����ǰ��֪ͨ����ָ�������
	@Before("MyAdvice.pc()")
	public void before() {
		System.out.println("����ǰ��֪ͨ��");
	}
	
	//����֪ͨ
	//ָ���÷����Ǻ���֪ͨ����ָ�������
	@AfterReturning("execution(* service.*ServiceImpl.*(..))")
	public void afterReturning() {
		System.out.println("���Ǻ���֪ͨ����������쳣����������ã���");
	}
	
	//����֪ͨ
	//ָ���÷����ǻ���֪ͨ����ָ�������
	@Around("execution(* service.*ServiceImpl.*(..))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("���ǻ���֪֮ͨǰ�Ĳ��֣�");
		
		Object prceed = pjp.proceed();//����Ŀ�귽��
		
		System.out.println("���ǻ���֪֮ͨ��Ĳ��֣�");
		
		return prceed;
	}
	
	//�쳣֪ͨ
	//ָ���÷������쳣֪ͨ����ָ�������
	@AfterThrowing("execution(* service.*ServiceImpl.*(..))")
	public void afterException() {
		System.out.println("�����쳣�ˣ�");
	}
	
	//����֪ͨ
	//ָ���÷����Ǻ���֪ͨ����ָ�������
	@After("execution(* service.*ServiceImpl.*(..))")
	public void after() {
		System.out.println("����֪ͨ�������쳣Ҳ����ã���");
	}
	
	
}
