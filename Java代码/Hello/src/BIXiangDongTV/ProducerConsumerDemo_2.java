package BIXiangDongTV;
/**
 * JDK1.5中提供了多线程升级的解决方案
 * 将同步synchronized替换成了Lock操作
 * 将Object中的wait，notify，notifyAll替换成了Condition对象
 * 该对象可以Lock锁进行获取，只要相同的Condition才能唤醒
 * 在该示例中，实现了本方只唤醒对方操作
 */
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerDemo_2 {
	
	public static void main(String[] args) {
		Rescours_2 rescours = new Rescours_2();
		
		Producer_2 producer = new Producer_2(rescours);
		Consumer_2 consumer = new Consumer_2(rescours);
		
		Thread t1 = new Thread(producer);
		Thread t2 = new Thread(producer);
		Thread t3 = new Thread(consumer);
		Thread t4 = new Thread(consumer);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}

//资源
class Rescours_2{
	private String name;
	private int count = 1;
	private boolean flag = false;
	private Lock lock = new ReentrantLock();
	
	private Condition condition_pro = lock.newCondition();
	private Condition condition_con = lock.newCondition();

	public void set(String name) throws InterruptedException  {
		lock.lock();
		
		try {
			while (flag) 
				condition_pro.await();
			this.name = name+"..."+count++;
			System.out.println(Thread.currentThread().getName()+"...生产者"+this.name);
			flag = true;
			condition_con.signal();
		} 
		finally{
			lock.unlock();//释放锁的动作一定要执行
		}
	
	}
	
	public void out() throws InterruptedException {
		lock.lock();
		try {
			while(!flag)//while代替if，每次都会进行标记的判断，不然会出现连续生产而没有消费的情况，
				condition_con.await();
			System.out.println(Thread.currentThread().getName()+"...消费者.."+this.name);
			flag = false;
			condition_pro.signal();
		} finally{
			lock.unlock();
		}
		
		
	}
}

//生产者
class Producer_2 implements Runnable{

	private Rescours_2 res;
	
	Producer_2(Rescours_2 res) {
		this.res = res;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				res.set("商品");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}

//消费者
class Consumer_2 implements Runnable{
	private Rescours_2 res;
	
	Consumer_2(Rescours_2 res) {
		this.res = res;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				res.out();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}

