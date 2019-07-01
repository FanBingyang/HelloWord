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

//��Դ
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
		System.out.println(Thread.currentThread().getName()+"...������"+this.name);
		flag = true;
		this.notifyAll();
	
	}
	
	public synchronized void out() {
		while(!flag){//while����if��ÿ�ζ�����б�ǵ��жϣ���Ȼ���������������û�����ѵ������
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+"...������.."+this.name);
		flag = false;
		this.notifyAll();//ÿ�λ��������̣߳���ֹ�����̶߳��ȴ������ֳ��������
		
		
	}
}

//������
class Producer implements Runnable{

	private Rescours res;
	
	Producer(Rescours res) {
		this.res = res;
	}
	
	@Override
	public void run() {
		while (true) {
			res.set("��Ʒ");
		}
		
	}
	
}

//������
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
