package ShiYan_2;
class Money extends Thread{
	private Bank bank;
	public Money(String str) {
		super(str);
	}
	public void run() {
		bank = new Bank();
		for(int i=0;i<=2;i++) {
		bank.save(this.getName());
	}
	
}
}

class Bank{
	private int money = 0;
	public synchronized void save(String str) {
		money+=100;
		System.out.println(str+"存入100元，当前账户余额为："+money);
		
	}
}

public class BankDemo {
	
	public static void main(String[] args) {
		Money m1 = new Money("用户一");
		Money m2 = new Money("用户二");
		
		m1.start();
		m2.start();
	}
}
