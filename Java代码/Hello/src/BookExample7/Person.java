package BookExample7;
/*功能简介：使用抛出异常功能。构造一个Person类，封装姓名和年龄，可以比较两个人年龄的大小*/

public class Person {
	private String name;
	private int age;
	public Person(String name,int age){    //构造方法
		this.name=name;
		this.age=age;
	}
	public void setName(String name){
		if(name==null||name=="")
			this.name="姓名未知";
		else
			this.name=name;
	}
	public String getName(){
		return name;
	}
	
	public void setAge(int age){
		try{
			if(age>0 && age<100)
				this.age=age;
			else 
				throw new Exception(age+"岁 年龄无效");    //抛出异常类对象
		
	}
		catch(Exception e){
			System.out.println(e.toString());    //e.toString获得异常种类和错误信息
		}
}
	
	public int getAge(){
		return age;
	}
	
	@Override
	public String toString(){
		return getName()+","+getAge()+"岁";
	}
	
	public int olderThen(Person p2){     //比较两个人的年龄
		return this.getAge()-p2.getAge();
	}
	
	public static void main(String[] args) {    
		Person p1=new Person("小李子", 36);
		System.out.println(p1.toString());
		Person p2=new Person("小贾", 26);
		System.out.println(p2.toString());
		System.out.println(p1.getName()+"比"+p2.getName()+"大"+p1.olderThen(p2)+"岁");
		p1.setAge(123);
		System.out.println(p1.getName()+"比"+p2.getName()+"大"+p1.olderThen(p2)+"岁");
	}

}
