package ShiYan_1;
public class StudentYIchang {
	private int m;
	public StudentYIchang(int m){
		this.m=m;
		try{
			if(m>=0&&m<=1000)
				this.m=m;
			else
				throw new Exception("数值有误，超过1000！");      //抛出异常
		}
		catch(Exception e){
			System.out.println(e.toString());       //获得异常的种类和错误信息
		}
	}
	public void setM(int m){
		this.m=m;
	}
	public int getM(){
		return m;
	}
	public void speak(int m){                         //自定义异常类
		try{
			if(m>=0&&m<=1000)
				this.m=m;
			else
				throw new Exception("数值有误，超过1000！");      //抛出异常
		}
		catch(Exception e){
			System.out.println(e.toString());       //获得异常的种类和错误信息
		}
	}
	public String toString(){
		return "你输入的数值为"+m;
	}
}
