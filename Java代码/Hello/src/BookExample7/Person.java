package BookExample7;
/*���ܼ�飺ʹ���׳��쳣���ܡ�����һ��Person�࣬��װ���������䣬���ԱȽ�����������Ĵ�С*/

public class Person {
	private String name;
	private int age;
	public Person(String name,int age){    //���췽��
		this.name=name;
		this.age=age;
	}
	public void setName(String name){
		if(name==null||name=="")
			this.name="����δ֪";
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
				throw new Exception(age+"�� ������Ч");    //�׳��쳣�����
		
	}
		catch(Exception e){
			System.out.println(e.toString());    //e.toString����쳣����ʹ�����Ϣ
		}
}
	
	public int getAge(){
		return age;
	}
	
	@Override
	public String toString(){
		return getName()+","+getAge()+"��";
	}
	
	public int olderThen(Person p2){     //�Ƚ������˵�����
		return this.getAge()-p2.getAge();
	}
	
	public static void main(String[] args) {    
		Person p1=new Person("С����", 36);
		System.out.println(p1.toString());
		Person p2=new Person("С��", 26);
		System.out.println(p2.toString());
		System.out.println(p1.getName()+"��"+p2.getName()+"��"+p1.olderThen(p2)+"��");
		p1.setAge(123);
		System.out.println(p1.getName()+"��"+p2.getName()+"��"+p1.olderThen(p2)+"��");
	}

}
