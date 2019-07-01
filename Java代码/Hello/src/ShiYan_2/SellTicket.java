package ShiYan_2;

public class SellTicket  extends Thread{
	private String name;
	Ticket  p;
	public SellTicket(String name ,Ticket p) {
		this.name=name;
		this.p = p;
		start();
	}
	public void run() {
			try {
				while(!p.flag) {
					p.sell(name);
					Thread.sleep(100);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ticket  pp = new Ticket();
		for(int i = 1;i<=10;i++) {
			String s = "µÚ"+i+"ÊÛÆ±µã";
			new SellTicket(s,pp);
		}
	}

}

