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
		System.out.println(str+"����100Ԫ����ǰ�˻����Ϊ��"+money);
		
	}
}

public class BankDemo {
	
	public static void main(String[] args) {
		Money m1 = new Money("�û�һ");
		Money m2 = new Money("�û���");
		
		m1.start();
		m2.start();
	}
}
