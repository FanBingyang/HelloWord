package ShiYan_1;
public class BankAccount {
	private String account;     //�˻�
	private double balance=0;     //���
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
		System.out.println("���ѳɹ����"+c+"Ԫ��");
		return balance=balance+c;
	}
	public double qukuan(double q){
		if(balance>=q){
			balance=balance-q;
			System.out.println("���ѳɹ�ȡ��"+q+"Ԫ��");
		}
			
		else {
			System.out.println("���㣡����");
		}
		return balance;
	}
	public void chaxun(){
		 System.out.println("������Ϊ��"+balance);
	}

}
