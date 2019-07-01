package BIXiangDongTV;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		writObj();
		readObj();
	}
	public static void readObj() throws Exception
	{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\Java\\ObjectStreamDemo.txt"));
		Person p = (Person)ois.readObject();
		
		System.out.println(p);
		ois.close();
	}
	
	public static void writObj() throws IOException
	{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\Java\\ObjectStreamDemo.txt"));
		oos.writeObject(new Person("lisi",30));
		oos.close(); 
	}

}
