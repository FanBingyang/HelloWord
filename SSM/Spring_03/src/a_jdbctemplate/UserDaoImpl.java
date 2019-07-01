package a_jdbctemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import bean.User;

//使用JDBC模板实现增删改查
public class UserDaoImpl extends JdbcDaoSupport implements UserDao {
//JdbcDaoSupport:根据连接池创建模板，不需要自己动手创建，直接从父类方法中获取
	
	//创建模板
//	private JdbcTemplate jt;
	

	@Override
	public void save(User u) {
		String sql = "insert into springUser values(null,?)";
//		jt.update(sql,u.getName());
		super.getJdbcTemplate().update(sql,u.getName());

	}

	@Override
	public void delete(Integer id) {
		String sql = "delete from springUser where id =?";
		
		super.getJdbcTemplate().update(sql,id);

	}

	@Override
	public void update(User u) {
		String sql = "update springUser set name = ? where id = ?";
		
		super.getJdbcTemplate().update(sql,u.getName(),u.getId());

	}

	@Override
	public User getById(Integer id) {
		String sql = "select * from springUser where id = ?";
		
		return super.getJdbcTemplate().queryForObject(sql, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));			
				return u;
			}
		},id);
	}

	@Override
	public int getTotailCount() {
		String sql = "select count(*) from springUser";
		
		Integer count = super.getJdbcTemplate().queryForObject(sql, Integer.class);
		return count;
	}

	@Override
	public List<User> getAll() {
		String sql = "select * from springUser";
		
		List<User> list = super.getJdbcTemplate().query(sql,  new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));			
				return u;
			}
		});
		return list;
	} 
	
//	/**
//	 * @return the jt
//	 */
//	public JdbcTemplate getJt() {
//		return jt;
//	}
//
//	/**
//	 * @param jt the jt to set
//	 */
//	public void setJt(JdbcTemplate jt) {
//		this.jt = jt;
//	}

}
