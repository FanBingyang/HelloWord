package HttpServlet;

import java.util.Arrays;

public class User {
	//在实体类中的字段要与表单中的name名一致，约定优于编码
	private String userName;
	private String pwd;
	private String sex;
	private String[] hobby;
	private String city;
	
	
	@Override
	public String toString() {
		return "User [userName=" + userName + ", pwd=" + pwd + ", sex=" + sex + ", hobby=" + Arrays.toString(hobby)
				+ ", city=" + city + "]";
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
}
