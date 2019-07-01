package proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import service.UserService;
import service.UserServiceImpl;

//�۹����=>cglib����
public class UserServiceProxyFactory2 implements MethodInterceptor {
	

	public UserService getUserServiceProxy(){
		//���������ɴ������
		Enhancer en = new Enhancer();
		//���ö�˭���д���
		en.setSuperclass(UserServiceImpl.class);
		//����Ҫ��ʲô
		en.setCallback(this);
		//�����������
		UserService us = (UserService) en.create();
		
		return us;
	}

	@Override
	public Object intercept(Object prxoyobj, Method method, Object[] arg, MethodProxy methodProxy) throws Throwable {
		//������
		System.out.println("������!");
		//����ԭ�з���
		Object returnValue = methodProxy.invokeSuper(prxoyobj, arg);
		//�ύ����
		System.out.println("�ύ����!");
		
		return returnValue;
	}


}
