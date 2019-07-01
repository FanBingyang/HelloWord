package MVC;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class UserForm {
	private String username;
	private String password;
	private String repassword;
	private String email;
	private String birthday;
	Map<String,String> msg = new HashMap<String,String>();
	
	public boolean validate() {
		// TODO Auto-generated method stub
		if("".equals(username)){
			msg.put("username", "�û�������Ϊ��");
		}
		else if(!username.matches("\\w{3,8}")){//�û������������룬��3~8λ����ĸ���<br>
			msg.put(username, "�û���Ϊ3~8λ����ĸ���");
			
		}
		
		if("".equals(password)){
			msg.put("password", "���벻��Ϊ��");
		}
		else if(!password.matches("\\d{3,8}")){//���룺�������룬��3~8λ���������<br>
			msg.put(password, "����Ϊ3~8λ����ĸ���");
			
		}
		
		//ȷ�����룺�����뱣��һ��
		if(!repassword.equals(password)){
			msg.put("repassword", "�������벻һ��");
		}
		
		if("".equals(email)){
			msg.put("email", "���䲻��Ϊ��");
		}
		
		if("".equals(birthday)){
			msg.put("birthday", "���ղ���Ϊ��");
		}
		else{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				sdf.parse(birthday);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				msg.put("birthday", "���ո�ʽ����ȷ");
				e.printStackTrace();
			}
		}
		
		return msg.isEmpty();//��Map������û������ʱ������true
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public Map<String, String> getMsg() {
		return msg;
	}
	public void setMsg(Map<String, String> msg) {
		this.msg = msg;
	}
	
	
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
}
