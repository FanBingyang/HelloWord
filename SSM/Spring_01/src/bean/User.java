package bean;

/**
 * @author FBY
 *
 */
public class User {
	private String name;
	private Integer age;
	private Car car;
	
	
	
	//带有参数的构造方法，用于Spring构造方法注入
	public User(String name, Car car) {
		System.out.println("User(String name, Car car)");
		this.name = name;
		this.car = car;
	}
	
	//测试参数顺序不同的构造方法注入，配置文件中用index指定顺序
	public User(Car car,String name) {
		System.out.println("User(Car car,String name)");
		this.name = name;
		this.car = car;
	}
	
	//测试类型不同的构造方法注入，配置文件中可以用type指定类型
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
		System.out.println("user对象的空参构造方法！！！");
	}
	
	//生命周期初始化方法，spring会在对象创建之后立即调用
	public void init() {
		System.out.println("我是初始化方法init()");
	}
	//生命周期销毁方法，springhi容器在关闭并销毁所有容器中的对象之前调用
	public void destroy() {
		System.out.println("我是销毁方法destroy()");
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", car=" + car + "]";
	}
	
	
	
	
	
	
}
