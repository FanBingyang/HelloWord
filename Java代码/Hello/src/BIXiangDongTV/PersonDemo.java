package BIXiangDongTV;
/*
 * 装饰设计模式：
 * 当想要对已有的对象进行功能增强时，可以定义类，将已有对象传入，
 * 基于已有功能，并提供加强功能。那么自定义的类称为装饰类。
 * 
 * 装饰类通常会通过构造方法接受被装饰的对象。
 * 并基于被装饰的对象的功能，提供更强的功能。
 * 
 * 通常Person类和SuperPerson这两个类在同一个接口或者在同一个体系中。
 * 
 * 装饰设计模式通俗讲解例子：
 * 人，会穿衣服。
 * 但在面试时会穿更体面的衣服 ，对人进行装饰。
 * 装饰类也是如此。
 */


//以下代码为实例代码，三个类，单独封装可以运行
/*
public class Person
{
	public void chifan()
	{
		System.out.println("吃饭");
	}
}

public class SuperPerson
{
	private Person p;
	SuperPerson(Persono p) 
	{
		this.p = p;
	}
	
	public void superchifan()
	{
		System.out.println("开胃酒");
		p.chifan();
		System.out.println("甜点");
		System.out.println("来一根烟");	}
}

public class PersonDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p = new Person();
		//p.chifan();
		SuperPerson sp = new SuperPerson(p); 
		sp.superchifan();
	}

}
*/
