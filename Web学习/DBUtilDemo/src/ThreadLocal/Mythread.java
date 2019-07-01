package ThreadLocal;

public class Mythread extends Thread{
	private ThreadLocal tl;

	public Mythread(ThreadLocal tl) {
		this.tl = tl;
	}
	
	@Override
	public void run() {
		System.out.println(tl.get()+"aaaaaaaaaaaaa");
	}
}
