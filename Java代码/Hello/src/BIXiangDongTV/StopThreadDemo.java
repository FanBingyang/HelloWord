package BIXiangDongTV;
/**
 * stop�����ѹ�ʱ��
 * ���ֹͣ�߳��أ�
 * ֻ��һ�ַ�����run��������
 * �������߳����У����д���ͨ����ѭ����
 * ֻҪ����סѭ�����Ϳ�����run����������Ҳ�����߳̽���
 * 
 * 
 * ��������������̴߳��ڶ���״̬
 * �Ͳ����ȡ����ǣ���ô�߳̾Ͳ������
 * 
 * ��û��ָ���ķ�ʽ�ö�����ָ̻߳�������״̬����ʱ��Ҫ�Զ���״̬�������
 * ǿ�����ָ̻߳�������״̬���������þͿ��Բ���������߳̽�����
 * ��Ϊ�÷����᷵��һ���쳣�����Խ��в���֮��������ʱ�Ա�ǽ��в���
 * Thread���ṩ�ķ�����interrupt();
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
				t1.interrupt();//ǿ������̵߳Ķ���״̬�������᷵��һ���쳣
				t2.interrupt();
				break;
			}
			System.out.println(Thread.currentThread().getName()+"......"+num);
		}
		System.out.println("over");
	}

}
