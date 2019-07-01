package BIXiangDongTV;

import javax.management.RuntimeErrorException;

public class Student implements Comparable{  //�ýӿ�ǿ����ѧ���߱��Ƚ���

	private String name;
	private int age;
		
	Student(String name,int age)
	{
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Object obj) 
	{
		if(!(obj instanceof Student))
			throw new RuntimeException("����ѧ������");
		Student s = (Student)obj;
		
//		System.out.println(this.name+"..."+s.name);//��������Ƚ�����
		if(this.age>s.age)
			return 1;
		if(this.age==s.age)
			return 0;
		return -1;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public void setAge(int age){
		this.age = age;
	}
	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}

}
