package BIXiangDongTV;
/**
 * join��
 * ��A�߳�ִ�е���B�̵߳�join()����ʱ��A�ͻ�ȴ�����B�̶߳�ִ����֮��A�Ż�ִ��
 * join����������ʱ�����߳�ִ�С�
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
		
		t1.join();//����cpuִ��Ȩ�����߳̽�cpuִ��Ȩ����t1�����ڶ��ᣬ��t1���������̲߳��ٴλ�ȡִ��Ȩ
		
		t2.start();
		
		for (int i = 0; i < 80; i++) {
			System.out.println("main......"+i);
		}
		System.out.println("over");

	}

}
