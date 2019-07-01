package proxy;

import org.junit.Test;

import service.UserService;
import service.UserServiceImpl;

public class Demo {
	
	//���Զ�̬����
	@Test
	public void fun1() {
		UserService us = new UserServiceImpl();
		
		UserServiceProxyFactory factory = new UserServiceProxyFactory(us);
		
		UserService usProxy = factory.getUserServiceProxy();
		
		usProxy.save();
		
		//�жϴ�������Ƿ����ڱ������������
		//��������뱻�������ʵ������ͬ�Ľӿ�=>false
		//��������뱻�������û�м̳й�ϵ
		System.out.println(usProxy instanceof UserServiceImpl);
	}
	
	//����cglib����
	@Test
	public void fun2() {
		UserServiceProxyFactory2 factory = new UserServiceProxyFactory2();
		
		UserService usProxy = factory.getUserServiceProxy();
		
		usProxy.find();
		
		//�жϴ�������Ƿ����ڱ������������
		//�������̳��˱��������=>true
		System.out.println(usProxy instanceof UserServiceImpl);
	}

}
