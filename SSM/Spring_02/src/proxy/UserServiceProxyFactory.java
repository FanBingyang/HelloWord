package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import service.UserService;
import service.UserServiceImpl;
//��̬����
public class UserServiceProxyFactory implements InvocationHandler {

	public UserServiceProxyFactory(UserService us)
	{
		super();
		this.us = us;
	}
	private UserService us;

	public UserService getUserServiceProxy() {
		// ���ɴ���
		UserService usProxy = (UserService) Proxy.newProxyInstance(UserServiceProxyFactory.class.getClassLoader(),
				UserServiceImpl.class.getInterfaces(), this);
		// ����
		return usProxy;

	}

	@Override
	public Object invoke(Object arg0, Method method, Object[] arg2) throws Throwable {
		System.out.println("������!");
		Object invoke = method.invoke(us, arg2);
		System.out.println("�ύ����!");
		return invoke;
	}
}
