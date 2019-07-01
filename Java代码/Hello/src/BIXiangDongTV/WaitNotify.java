package BIXiangDongTV;
/**
 * �߳�֮��ͨѶ
 * ��ʵ���Ƕ���߳��ڲ���ͬһ����Դ
 * ���ǲ����ö�����ͬ
 * 
 * �����̲߳���ȫ���⣬��ȥ����ǰ��
 * 1����Щ�ǹ�����Դ���Ƿ�ͬ����
 * 2��ͬ���Ĵ�����õ��Ƿ���ͬһ����
 * 3�����Ƿ�Ψһ
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
//						r.wait();//��������Ƕ������ʱ��Ҫ��ȷ���󣬱�������ĳ�������̶߳���
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
				if(x==0){
					r.set("zhangsan", "man");
				}else {
					r.set("����", "Ů");
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
 * ��ʹ����ͬ���У���ΪҪ�Գ��м��������������سǲ���
 * ����Ҫʹ����ͬ���У���Ϊֻ��ͬ��������
 * 
 * Ϊʲô��Щ�����̵߳ķ���Ҫ������OBject�����أ�
 * ��Ϊ��Щ�����ڲ���ͬ���߳�ʱ��������Ҫ��ʶ�����������̳߳��е���
 * ֻ��ͬһ�����ϵĵȴ��̣߳����Ա�ͬһ�����ϵ�notify����
 * 
 * Ҳ����˵���ȴ��ͻ��ѱ�����ͬһ����
 * 
 * ��������������������Կ��Ա����������õķ���������Object��
 * 
*/