package ShiYan_1;
public class StudentYIchang {
	private int m;
	public StudentYIchang(int m){
		this.m=m;
		try{
			if(m>=0&&m<=1000)
				this.m=m;
			else
				throw new Exception("��ֵ���󣬳���1000��");      //�׳��쳣
		}
		catch(Exception e){
			System.out.println(e.toString());       //����쳣������ʹ�����Ϣ
		}
	}
	public void setM(int m){
		this.m=m;
	}
	public int getM(){
		return m;
	}
	public void speak(int m){                         //�Զ����쳣��
		try{
			if(m>=0&&m<=1000)
				this.m=m;
			else
				throw new Exception("��ֵ���󣬳���1000��");      //�׳��쳣
		}
		catch(Exception e){
			System.out.println(e.toString());       //����쳣������ʹ�����Ϣ
		}
	}
	public String toString(){
		return "���������ֵΪ"+m;
	}
}
