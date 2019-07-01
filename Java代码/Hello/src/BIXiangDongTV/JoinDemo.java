package BIXiangDongTV;
/**
 * join：
 * 当A线程执行到了B线程的join()方法时，A就会等待，等B线程都执行完之后，A才会执行
 * join可以用来临时加入线程执行。
 * 
 * @author FBY
 *
 */
class Demo implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 70; i++) {
			System.out.println(Thread.currentThread().getName()+"..."+i);
		}
	}
	
}

public class JoinDemo {

	public static void main(String[] args) throws InterruptedException {
		Demo d = new Demo();
		Thread t1 = new Thread(d);
		Thread t2 = new Thread(d);
		t1.start();
		
		t1.join();//抢夺cpu执行权，主线程将cpu执行权交给t1，处于冻结，等t1结束后，主线程才再次获取执行权
		
		t2.start();
		
		for (int i = 0; i < 80; i++) {
			System.out.println("main......"+i);
		}
		System.out.println("over");

	}

}
