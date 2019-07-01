package BookExample7;
/*功能简介：声明自定义异常类*/

public class AgeException extends Exception{   //自定义无效年龄异常类
	public AgeException(String s){
		super(s);
 }
	public AgeException()
	{
		this("");
	}
	
}
