package a_jdbctemplate;

import java.beans.PropertyVetoException;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import bean.User;

//��ʾJDBCģ��
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo {
	
	@Resource(name="userDao")
	private UserDao ud;
	
	@Test
	public void fun1() throws Exception {
		 
		//0 ׼�����ӳ�
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass("com.mysql.jsbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql:///mydb");
		dataSource.setUser("root");
		dataSource.setPassword("123456");
		
		//1 ����JDBCģ��
		JdbcTemplate jt = new JdbcTemplate();
		jt.setDataSource(dataSource);
		
		//2 ��дsql����ִ��
		String sql = "insert into springUser values(null,'tom')";
		
		jt.update(sql);
		
		
	}
	
	@Test
	public void fun2() throws Exception{
		User u = new User();
		u.setName("cat");
		ud.save(u);
	}
	@Test
	public void fun3() throws Exception{
		User u = new User();
		u.setId(2);
		u.setName("jack");
		ud.update(u);
		
	}
	
	@Test
	public void fun4() throws Exception{
		ud.delete(2);
	}
	
	@Test
	public void fun5() throws Exception{
		System.out.println(ud.getTotailCount());
	}
	
	@Test
	public void fun6() throws Exception{
		System.out.println(ud.getById(1));
	}
	
	@Test
	public void fun7() throws Exception{
		System.out.println(ud.getAll());
	}

}
