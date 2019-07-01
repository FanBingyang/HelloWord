package BIXiangDongTV;
/**
 * 线程之间通讯
 * 其实就是多个线程在操作同一个资源
 * 但是操作得动作不同
 * 
 * 碰到线程不安全问题，先去考虑前提
 * 1，那些是共享资源，是否同步了
 * 2，同步的代码块用的是否是同一个锁
 * 3，锁是否唯一
 * @author FBY
 *
 */
class Res{
	private String name;
	private String sex;
	boolean flag = false;
	
	public synchronized void set(String name,String sex) {
		if(flag)
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		this.name = name;
		this.sex = sex;
		
		flag = true;
		this.notify();
	}
	
	public synchronized void out() {
		if(!flag)
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println(name+"..."+sex);
		flag = false;
		this.notify();
	}
}

class Input implements Runnable{
	private Res r ;
	Input(Res r) {
		this.r = r;
	}
	public void run() {
		int x = 0;
		while (true) {
//			synchronized (r) {
//				if(r.flag)
//					try {
//						r.wait();//当锁里面嵌套锁的时候，要明确对象，表明持有某个锁的线程对象
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
				if(x==0){
					r.set("zhangsan", "man");
				}else {
					r.set("丽丽", "女");
				}
				x = (x+1)%2;
//				r.flag = true;
//				r.notify();
//			}
		}
	}
	
}

class Output implements Runnable{
	private Res r ;
	Output(Res r) {
		this.r = r;
	}
	public void run() {
		while (true) {
//			synchronized (r) {
//				if(!r.flag)
//					try {
//						r.wait();
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
				r.out();
//				r.flag = false;
//				r.notify();
			}
		}
	}
//}


public class WaitNotify {
	public static void main(String[] args) {
		Res r = new Res();
		
//		Input in = new Input(r);
//		Output out = new Output(r);
//		
//		Thread t1 = new Thread(in);
//		Thread t2 = new Thread(out);
//		
//		t1.start();
//		t2.start();
		
		new Thread(new Input(r)).start();
		new Thread(new Output(r)).start();
	}
}

/*
 * wait();
 * notify();
 * notifyAll();
 * 
 * 都使用在同步中，因为要对持有监视器（锁）的县城操作
 * 所以要使用在同步中，因为只有同步才有锁
 * 
 * 为什么这些操作线程的方法要定义在OBject类中呢？
 * 因为这些方法在操作同步线程时，都必须要标识他们所操作线程持有的锁
 * 只有同一个锁上的等待线程，可以被同一个锁上的notify唤醒
 * 
 * 也就是说，等待和唤醒必须是同一个锁
 * 
 * 而锁可以是任意对象，所以可以被任意对象调用的方法定义在Object中
 * 
*/