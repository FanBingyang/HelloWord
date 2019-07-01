package BIXiangDongTV;

public class ProducerConsumerDemo {
	
	public static void main(String[] args) {
		Rescours rescours = new Rescours();
		
		Producer producer = new Producer(rescours);
		Consumer consumer = new Consumer(rescours);
		
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
class Rescours{
	private String name;
	private int count = 1;
	private boolean flag = false;
	
	public synchronized void set(String name) {
		while (flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.name = name+"..."+count++;
		System.out.println(Thread.currentThread().getName()+"...生产者"+this.name);
		flag = true;
		this.notifyAll();
	
	}
	
	public synchronized void out() {
		while(!flag){//while代替if，每次都会进行标记的判断，不然会出现连续生产而没有消费的情况，
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+"...消费者.."+this.name);
		flag = false;
		this.notifyAll();//每次唤醒所有线程，防止所有线程都等待而出现程序卡死情况
		
		
	}
}

//生产者
class Producer implements Runnable{

	private Rescours res;
	
	Producer(Rescours res) {
		this.res = res;
	}
	
	@Override
	public void run() {
		while (true) {
			res.set("商品");
		}
		
	}
	
}

//消费者
class Consumer implements Runnable{
	private Rescours res;
	
	Consumer(Rescours res) {
		this.res = res;
	}
	
	@Override
	public void run() {
		while (true) {
			res.out();
		}
		
	}
}
