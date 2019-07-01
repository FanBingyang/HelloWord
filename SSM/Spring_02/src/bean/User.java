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

//�����@Component("user")ע���൱��xmlע���е�<bean name="user" class="bean.User"></bean>
//@Component("user")
	//��������������ע��
//	@Service("user") //service��
//	@Controller("user")//web��
	@Repository("user")//dao��

//ָ����������÷�Χ,�������Scope���÷����/Spring_01/src/Test_create/applicationContext.xml�е�ע��
@Scope(scopeName="singleton")	
public class User {
	//ע������ֵ��
	/*@Value("tom")
	 * ����д������ǰ�棬ͨ�������Field��ֵ���ƻ��˷�װ�� eg:@Value("tom")  peivatr String name;
	 * Ҳ��д�����Ե�set����֮ǰ��ͨ��set������ֵ���Ƽ�ʹ�� eg:@Value("tom")  public void setName(String name) {this.name = name;}
	 * 
	 */
	@Value("tom")
	private String name;
	private Integer age;
	
	//@Autowired  //�Զ�װ�������⣺���ƥ�䵽�������һ�µĶ��󣬽��޷�ѡ�����ע����һ������
	//@Qualifier("car2")//ʹ��@Qualifierע�����spring�����Զ�װ���Ǹ����ƵĶ���
	@Resource(name="car2")//�ֶ�ע�룬ָ��ע���Ǹ����ƵĶ����Ƽ�ʹ�ã�
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
		System.out.println("user����Ŀղι��췽��������");
	}
	
	//�������ڳ�ʼ��������spring���ڶ��󴴽�֮����������
	@PostConstruct  //�ڶ��󱻴������Ӿ��init-method
	public void init() {
		System.out.println("���ǳ�ʼ������init()");
	}
	//�����������ٷ�����springhi�����ڹرղ��������������еĶ���֮ǰ����
	@PreDestroy  //�ڶ�������֮ǰ����  ,destroy-method
	public void destroy() {
		System.out.println("�������ٷ���destroy()");
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", car=" + car + "]";
	}
	
	
	
	
	
	
}
