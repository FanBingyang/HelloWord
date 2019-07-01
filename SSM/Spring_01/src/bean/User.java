package bean;

/**
 * @author FBY
 *
 */
public class User {
	private String name;
	private Integer age;
	private Car car;
	
	
	
	//���в����Ĺ��췽��������Spring���췽��ע��
	public User(String name, Car car) {
		System.out.println("User(String name, Car car)");
		this.name = name;
		this.car = car;
	}
	
	//���Բ���˳��ͬ�Ĺ��췽��ע�룬�����ļ�����indexָ��˳��
	public User(Car car,String name) {
		System.out.println("User(Car car,String name)");
		this.name = name;
		this.car = car;
	}
	
	//�������Ͳ�ͬ�Ĺ��췽��ע�룬�����ļ��п�����typeָ������
	public User(Integer name, Car car) {
		System.out.println("User(String name, Car car)");
		this.name = name+"";
		this.car = car;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public User() {
		System.out.println("user����Ŀղι��췽��������");
	}
	
	//�������ڳ�ʼ��������spring���ڶ��󴴽�֮����������
	public void init() {
		System.out.println("���ǳ�ʼ������init()");
	}
	//�����������ٷ�����springhi�����ڹرղ��������������еĶ���֮ǰ����
	public void destroy() {
		System.out.println("�������ٷ���destroy()");
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", car=" + car + "]";
	}
	
	
	
	
	
	
}
