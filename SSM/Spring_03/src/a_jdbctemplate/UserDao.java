package a_jdbctemplate;

import java.util.List;

import bean.User;

public interface UserDao {
	
	//��
	void save(User u);
	//ɾ
	void delete(Integer id);
	//��
	void update(User u);
	//��
	User getById(Integer id);
	//��
	int getTotailCount();
	//��
	List<User> getAll();
	
	
	
	
}
