package MVC;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;




public class UserDaoImpl implements UserDao{

	@Override
	public void addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("insert into users(username,password,email,birthday) values(?,?,?,?)");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String date = sdf.format(user.getBirthday());
			ps.setString(4, date);
			
			int i = ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("ÃÌº” ß∞‹");
		}finally {
			DBUtils.closeAll(null, ps, conn);
		}
		
		
		
		
	}

	@Override
	public User findUser(User user) throws Exception {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User u = null;
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("select * from users where username=? and password=?");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			
			rs = ps.executeQuery();
			if(rs.next())
			{
				u = new User();
				u.setUsername(rs.getString(1));
				u.setPassword(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setBirthday(rs.getDate(4));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(rs, ps, conn);
		}
		
		return u;
	}

	@Override
	public boolean findUserByName(String name) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("select * from users where username=?");
			ps.setString(1, name);

			rs = ps.executeQuery();
			if(rs.next())
			{
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(rs, ps, conn);
		}
		
		return false;
	}

}
