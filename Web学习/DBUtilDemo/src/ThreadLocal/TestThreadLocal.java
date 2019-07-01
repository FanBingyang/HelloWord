package ThreadLocal;

public class TestThreadLocal {
	public static void main(String[] args) {
		ThreadLocal tl  =new ThreadLocal();
		tl.set("p");
		
		Mythread mt = new Mythread(tl);
		
		mt.start();
		
		System.out.println(tl.get());
	}
}
