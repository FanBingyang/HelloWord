package ShiYan_2;



public class ThreadAB extends Thread{
	private String s;
	private int i=0;
	public ThreadAB(String s) {
		this.s=s;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			System.out.println(s);
			i++;
			try {
				this.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i==50) { //设置打印次数，不然线程一直在执行
				this.stop();
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadAB A = new ThreadAB("A");
		ThreadAB B = new ThreadAB("B");
		A.start();
		B.start();
	}

}
