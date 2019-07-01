package BookExample7;
/*功能简介：自定义异常类的使用*/

public class Person1 {
	private String name;
	private int age;
	public Person1(String name,int age) throws AgeException{
		this .name=name;
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
	public void setAge(int age) throws AgeException{
			if(age>=0 && age<100)
				this.age=age;
			else
				throw new AgeException(""+age);
	}
	public int getAge(){
		return age;
	}
	public String toString(){
		return getName()+","+getAge()+"岁";
	}
	public void print(){
		System.out.println(this.toString());
	}
	public static void main(String[] args) {
		Person1 p1=null;
		try{            //调用以声明抛出异常的方法
			p1=new Person1("小李子", 36);
			p1.setAge(166);
		}
		catch(AgeException e){
			e.printStackTrace();    //输出异常栈跟踪信息
		}
		finally{
			p1.print();
		}
	}

}
