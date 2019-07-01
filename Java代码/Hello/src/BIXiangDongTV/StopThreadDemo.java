package BIXiangDongTV;
/**
 * stop方法已过时。
 * 如何停止线程呢？
 * 只有一种方法，run方法结束
 * 开启多线程运行，运行代码通常是循环的
 * 只要控制住循环，就可以让run方法结束，也就是线程结束
 * 
 * 
 * 特殊情况，，当线程处于冻结状态
 * 就不会读取到标记，那么线程就不会结束
 * 
 * 当没有指定的方式让冻结的线程恢复到运行状态，这时需要对冻结状态进行清除
 * 强制让线程恢复到运行状态中来，就让就可以操作标记让线程结束，
 * 因为该方法会返回一个异常，可以进行捕到之后处理。处理时对标记进行操作
 * Thread类提供的方法：interrupt();
 * @author FBY
 *
 */

class StopThread implements Runnable{
	private boolean flag = true;
	public synchronized void run() {
		while (flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println(Thread.currentThread().getName()+"...Exception");
				flag = flag;
			}
			System.out.println(Thread.currentThread().getName()+"...run");
		}
	}
	
	public void changFlag(){
		flag = false;
	}
	
	
}



public class StopThreadDemo {

	public static void main(String[] args) {
		StopThread st = new StopThread();
		
		Thread t1 = new Thread(st);
		Thread t2 = new Thread(st);
		
		t1.start();
		t2.start();
		
		int num = 0;
		while(true) {
			if(num++ == 60){
//				st.changFlag();
				t1.interrupt();//强制清楚线程的冻结状态，不过会返回一个异常
				t2.interrupt();
				break;
			}
			System.out.println(Thread.currentThread().getName()+"......"+num);
		}
		System.out.println("over");
	}

}
