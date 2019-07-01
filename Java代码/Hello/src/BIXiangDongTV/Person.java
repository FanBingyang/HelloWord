package BIXiangDongTV;

import java.io.Serializable;

public class Person implements Serializable{
	String name;
	int age;
	Person(String name,int age)
	{
		this.name = name;
		this.age = age;
	}
	public String toString()
	{
		return name+":"+age;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
