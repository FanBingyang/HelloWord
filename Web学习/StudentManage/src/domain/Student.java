package domain;
/**
 * 学生对象封装的对象类
 * @author FBY
 *
 */
public class Student {
	private String nam;
	private String sex;
	private String zhuanye;
	private String banji;
	private String xuehao;
	private int id;
	
	//必须要有的空参构造方法
	public Student() {
		
	}
	
	//带有id和其他信息的构造方法，用于更新学生信息时将id封装进来作为sql查询的关键字
	public Student(int id,String nam, String sex, String zhuanye, String banji, String xuehao) {
		super();
		this.nam = nam;
		this.sex = sex;
		this.zhuanye = zhuanye;
		this.banji = banji;
		this.xuehao = xuehao;
		this.id = id;
	}

	//不带有id只有其他数据的构造方法，用于添加学生信息时封装数据
	public Student(String nam, String sex, String zhuanye, String banji, String xuehao) {
		this.nam = nam;
		this.sex = sex;
		this.zhuanye = zhuanye;
		this.banji = banji;
		this.xuehao = xuehao;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNam() {
		return nam;
	}
	public void setNam(String nam) {
		this.nam = nam;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getZhuanye() {
		return zhuanye;
	}
	public void setZhuanye(String zhuanye) {
		this.zhuanye = zhuanye;
	}
	public String getBanji() {
		return banji;
	}
	public void setBanji(String banji) {
		this.banji = banji;
	}
	public String getXuehao() {
		return xuehao;
	}
	public void setXuehao(String xuehao) {
		this.xuehao = xuehao;
	}
	
	
	
}
