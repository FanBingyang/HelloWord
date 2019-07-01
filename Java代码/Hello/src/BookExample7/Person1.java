package BookExample7;
/*���ܼ�飺�Զ����쳣���ʹ��*/

public class Person1 {
	private String name;
	private int age;
	public Person1(String name,int age) throws AgeException{
		this .name=name;
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
		return getName()+","+getAge()+"��";
	}
	public void print(){
		System.out.println(this.toString());
	}
	public static void main(String[] args) {
		Person1 p1=null;
		try{            //�����������׳��쳣�ķ���
			p1=new Person1("С����", 36);
			p1.setAge(166);
		}
		catch(AgeException e){
			e.printStackTrace();    //����쳣ջ������Ϣ
		}
		finally{
			p1.print();
		}
	}

}
