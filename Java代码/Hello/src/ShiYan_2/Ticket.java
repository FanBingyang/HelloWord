package ShiYan_2;

public class Ticket {
	private int a;
	boolean flag=false;
	public Ticket() {
		a = 1;
	}
	
	public synchronized void sell(String name) {
		if(a==1001)
			flag = true;
		else {
			System.out.println(name+"Âô³öµÚ"+a+"ÕÅÆ±");
			a++;
		}
	}
}

