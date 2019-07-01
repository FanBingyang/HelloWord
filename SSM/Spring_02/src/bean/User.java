package bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @author FBY
 *
 */

//下面的@Component("user")注解相当于xml注入中的<bean name="user" class="bean.User"></bean>
//@Component("user")
	//衍生出来的三种注解
//	@Service("user") //service层
//	@Controller("user")//web层
	@Repository("user")//dao层

//指定对象的作用范围,更多关于Scope的用法详见/Spring_01/src/Test_create/applicationContext.xml中的注释
@Scope(scopeName="singleton")	
public class User {
	//注解属性值。
	/*@Value("tom")
	 * 可以写在属性前面，通过反射的Field赋值，破坏了封装性 eg:@Value("tom")  peivatr String name;
	 * 也可写在属性的set方法之前，通过set方法赋值，推荐使用 eg:@Value("tom")  public void setName(String name) {this.name = name;}
	 * 
	 */
	@Value("tom")
	private String name;
	private Integer age;
	
	//@Autowired  //自动装。有问题：如果匹配到多个类型一致的对象，将无法选择具体注入哪一个对象
	//@Qualifier("car2")//使用@Qualifier注解告诉spring容器自动装配那个名称的对象
	@Resource(name="car2")//手动注入，指定注入那个名称的对象（推荐使用）
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
	@Value("tom")
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
	@PostConstruct  //在对象被创建后电泳，init-method
	public void init() {
		System.out.println("我是初始化方法init()");
	}
	//生命周期销毁方法，springhi容器在关闭并销毁所有容器中的对象之前调用
	@PreDestroy  //在对象销毁之前调用  ,destroy-method
	public void destroy() {
		System.out.println("我是销毁方法destroy()");
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", car=" + car + "]";
	}
	
	
	
	
	
	
}
