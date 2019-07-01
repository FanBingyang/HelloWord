package util;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	private String username;
	private String password;
	private String email;
	private String birthday;
	
	
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
	
	@Override
	public String toString() {
		return "User [name=" + username + ", password=" + password
				+ ", email=" + email + ", birthday=" + birthday + "]";
	}
	
	
}
