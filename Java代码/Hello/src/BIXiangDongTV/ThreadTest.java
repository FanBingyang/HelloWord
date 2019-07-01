package BIXiangDongTV;

public class ThreadTest {

	public static void main(String[] args) {
		new Thread(){
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println(Thread.currentThread().getName()+"......."+i);
				}
			}
		}.start();
		
		
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName()+"......."+i);
		}
		
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println(Thread.currentThread().getName()+"......."+i);
				}
			}
		};
		new Thread(r).start();
		
//		new Test1().start();
		
	}

}
	
//class Test1 extends Thread{
//	public void run() {
//		for (int i = 0; i < 100; i++) {
//			System.out.println(Thread.currentThread().getName()+"......."+i);
//		}
//	}
//}
