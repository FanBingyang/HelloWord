package ShiYan_1;
public class BankAccount {
	private String account;     //账户
	private double balance=0;     //余额
	public BankAccount(String account,double balance){
		this.account=account;
		this.balance=balance;
	}
	private void setBalance(double balance) {
		this.balance=balance;
	}
	public double getBalance(){
		return balance;
	}
	private void setAccount(String account) {
		this.account=account;
	}
	public String getAccount(){
		return account;
	}
	
	public double cunkaun(double c){
		System.out.println("您已成功存款"+c+"元。");
		return balance=balance+c;
	}
	public double qukuan(double q){
		if(balance>=q){
			balance=balance-q;
			System.out.println("您已成功取款"+q+"元。");
		}
			
		else {
			System.out.println("余额不足！！！");
		}
		return balance;
	}
	public void chaxun(){
		 System.out.println("你的余额为："+balance);
	}

}
