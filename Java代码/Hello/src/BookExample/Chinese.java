package BookExample;
import java.util.Random;          //导入chinese类中使用的类Random，其中，java.util为包名，import为关键字

/*功能简介：编写一个chinese类，用来示范Java程序的基本结构*/

public class Chinese {
	private String name;            //在规范的Java类的声明中，成员变量一般声明为私有权限，那么是变量名，用于保存姓名
	private String sex;             //sex是变量名，用于保存性别
	Random luckyN=new Random();     //实例化对象，用于初始化变量luckyN，Random（x）方法可以随机生成一个0~x的整数
	public Chinese(String name,String sex){    //声明类的构造方法，用于再实例化对象时初始化成员变量
		this.name=name;
		this.sex=sex;
	}
	public void setName(String name){   //规范的java编程中，setName(String name)方法用于设置成员变量name的值
		this.name=name;
	}
	public String getName(){            //规范的Java编程中，getName()方法用于获取成员变量name的值
		return name;
	}
	public void setSex(String sex){
		this.sex=sex;
	}
	public String getSex(){
		return sex;
	}
	public void myInformation(){                       //声明Chinese类中的成员方法，该方法实现的功能是输出对象的基本信息
		System.out.println("我的名字叫"+getName()+"，我是一名"+getSex()+"生!");    //运算符 + 用于字符串的连接
	}
	public void chineseDeram(){
		System.out.println("我们的中国梦是：实现中华名族的伟大复兴!");
	}
	public void myDeram(){                             //声明Chinese类中的成员方法，该方法实现的功能是输出文字提示信息
		System.out.println("我的中国梦是：成为一名优秀的程序员，实现自己的中国梦!");
	}
	public void luckyNumber(){                         //声明Chinese类中的成员方法，该方法实现的功能是输出运算结果
		System.out.println(1+luckyN.nextInt(10));
	}
	public static void main(String[] args) {            //用于运行程序的main()方法
		Chinese chinese=new Chinese("梦想","女");       //实例化对象
		chinese.myInformation();                        //对象调用方法，执行功能
		chinese.chineseDeram();
		chinese.myDeram();
		chinese.luckyNumber();
	}

}
