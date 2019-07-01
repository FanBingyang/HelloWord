package ShiYan_2;

class SimpleThread implements Runnable { 
	private String string;
	public SimpleThread(String str) {
		this.string = str;
	} 
	public void run() { //重写run方法 
		for (int i = 0; i < 10; i++) {
			System.out.println(i + " " + string); 
			try {
				Thread.sleep((int)(Math.random() * 1000));   //线程睡眠，把控制权交出去 
			}
			catch (InterruptedException e) {
			}
		} 
		System.out.println("DONE! " + string); 
	} 
} 	 
public class TwoThreadsTest { 
	public static void main (String args[]) {
		SimpleThread t1 = new SimpleThread("First");   //第一个线程的名字为First 
		SimpleThread t2 =new SimpleThread("Second"); //第二个线程的名字为Second 
		 
		Thread thread1 = new Thread(t1);
		Thread thread2 = new Thread(t2);
		thread1.start();
		thread2.start(); 
	 } 
 }

