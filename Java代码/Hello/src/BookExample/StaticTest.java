package BookExample;

public class StaticTest {
	public static String toChar(double x){   //声明静态方法
		return Double.toString(x);  //调用Double类的toString（）静态方法，其功能就是将Double类型的参数值转换为String类型并返回
	}
	public static void main(String[] args) {  //main（）方法是静态方法，静态方法无须实例化对象就可以直接使用
		System.out.println(Math.round(6.5));  //调用Math类的round（）静态方法，其功能就是对参数值进行四舍五入处理，并将处理的结果返回
		String s=toChar(12.6);   //调用了StaticTest类中定义的toChar（）静态方法
		System.out.println("e="+s);
	}
}
