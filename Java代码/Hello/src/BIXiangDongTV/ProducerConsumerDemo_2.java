package BIXiangDongTV;
/**
 * JDK1.5���ṩ�˶��߳������Ľ������
 * ��ͬ��synchronized�滻����Lock����
 * ��Object�е�wait��notify��notifyAll�滻����Condition����
 * �ö������Lock�����л�ȡ��ֻҪ��ͬ��Condition���ܻ���
 * �ڸ�ʾ���У�ʵ���˱���ֻ���ѶԷ�����
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

//��Դ
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
			System.out.println(Thread.currentThread().getName()+"...������"+this.name);
			flag = true;
			condition_con.signal();
		} 
		finally{
			lock.unlock();//�ͷ����Ķ���һ��Ҫִ��
		}
	
	}
	
	public void out() throws InterruptedException {
		lock.lock();
		try {
			while(!flag)//while����if��ÿ�ζ�����б�ǵ��жϣ���Ȼ���������������û�����ѵ������
				condition_con.await();
			System.out.println(Thread.currentThread().getName()+"...������.."+this.name);
			flag = false;
			condition_pro.signal();
		} finally{
			lock.unlock();
		}
		
		
	}
}

//������
class Producer_2 implements Runnable{

	private Rescours_2 res;
	
	Producer_2(Rescours_2 res) {
		this.res = res;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				res.set("��Ʒ");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}

//������
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

