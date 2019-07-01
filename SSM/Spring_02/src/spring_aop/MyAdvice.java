package spring_aop;

import org.aspectj.lang.ProceedingJoinPoint;

//通知类
public class MyAdvice {

	//前置通知
//		|-目标方法运行之前通知
	//后置通知（如果出现异常，将不会调用）
//		|-在目标方法运行之后调用
	//环绕通知
//		|-在目标方法之前和之后都会调用
	//异常拦截通知
//		|-如果出现异常就会调用
	//后置通知（有没有异常都会调用）
//		|-在目标方法运行之后调用
//--------------------------------------------------
	
	//前置通知
	public void before() {
		System.out.println("这是前置通知！");
	}
	
	//后置通知
	public void afterReturning() {
		System.out.println("这是后置通知（如果出现异常，将不会调用）！");
	}
	
	//环绕通知
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("这是环绕通知之前的部分！");
		
		Object prceed = pjp.proceed();//调用目标方法
		
		System.out.println("这是环绕通知之后的部分！");
		
		return prceed;
	}
	
	//异常通知
	public void afterException() {
		System.out.println("出现异常了！");
	}
	
	//后置通知
	public void after() {
		System.out.println("后置通知（出现异常也会调用）！");
	}
	
	
}
