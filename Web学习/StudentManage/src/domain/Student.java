package domain;
/**
 * ѧ�������װ�Ķ�����
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
	
	//����Ҫ�еĿղι��췽��
	public Student() {
		
	}
	
	//����id��������Ϣ�Ĺ��췽�������ڸ���ѧ����Ϣʱ��id��װ������Ϊsql��ѯ�Ĺؼ���
	public Student(int id,String nam, String sex, String zhuanye, String banji, String xuehao) {
		super();
		this.nam = nam;
		this.sex = sex;
		this.zhuanye = zhuanye;
		this.banji = banji;
		this.xuehao = xuehao;
		this.id = id;
	}

	//������idֻ���������ݵĹ��췽�����������ѧ����Ϣʱ��װ����
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
