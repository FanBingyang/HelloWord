package Test_create;

import bean.User;

public class UserFactory {

	public static User createUser() {
		
		System.out.println("��̬��������User");
		
		return new User();
	}
	
	public User createUser2() {
		
		System.out.println("ʵ����������User");
		
		return new User();
	}
}
