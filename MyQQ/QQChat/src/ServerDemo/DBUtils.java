package ServerDemo;
/**
 * 数据库工具类，有关数据库操作的都在此执行
 */

import ClientDemo.Message;
import ClientDemo.Type;

import java.sql.*;
import java.util.ResourceBundle;

public class DBUtils {
	private static String driverClass;
	private static String url;
	private static String username;
	private static String password;

	/**
	 * 读取配置文件，加载数据库驱动
	 */
	static{
		ResourceBundle rb = ResourceBundle.getBundle("dbinfo");
		driverClass = rb.getString("driverClass");
		url = rb.getString("url");
		username = rb.getString("username");
		password = rb.getString("password");
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取数据库的连接
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception{
		return DriverManager.getConnection(url, username, password);
	}

	/**
	 * 对登录的用户名和密码进行判断
	 * @param id
	 * @param password
	 * @return true:允许登录；false:不允许登录
	 */
	public static boolean userSQL(String id,String password){
		boolean flag = false;
		Connection conn ;
		ResultSet rs;
		PreparedStatement ps ;
		try{
//			System.out.println("验证登录");
			conn = getConnection();
			String sql = "select * from user";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()){

				if(id.equals(rs.getString(1))&&password.equals(rs.getString(3)))
				{
					System.out.println("id："+ rs.getString("id")+"  密码："+rs.getString("password"));
					flag=true;//用户名密码判断完成，允许登录
				}
			}
			return flag;
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("登录连接数据库错误");
			return false;//姓名密码不匹配，不允许登录
		}

	}

	/**
	 * 添加好友，在双方数据库的好友列表中将对方添加进去
	 * @param h
	 * @param s
	 */
	public static void addFriend(Houtai h, Message s){
		boolean flag = false;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		String sql_1 = "select * from user";
		s.setText("接受");
		try{
			conn = getConnection();
			ps = conn.prepareStatement(sql_1);
			rs = ps.executeQuery();
			while (rs.next()){  //查询是否有该用户
//				System.out.println("DBUtils:....."+s.getName()+"----"+s.getHisname());
				if(s.getHisname().equals(rs.getString("name"))){
					flag = true;
				}
			}
				if (flag){
					if(Server.Talk(s)){
						String sql_2 = "INSERT INTO friend_list(name,friendname) VALUES (?,?)";
						PreparedStatement ps1 = conn.prepareStatement(sql_2);
						ps1.setString(1,s.getName());
						ps1.setString(2,s.getHisname());
						ps1.executeUpdate();
						ps1.setString(1,s.getHisname());
						ps1.setString(2,s.getName());
						ps1.executeUpdate();
						h.inster(s);
						s.setType(Type.login);//表示当前用户登录
						Server.Talk(s);
						Message m = new Message();
						m.setName(s.getHisname());
						m.setType(Type.login);//表示添加的用户已登陆
						Server.Talk(m);
						closeAll(rs,ps,conn);//关闭数据库资源
					}
					else {
						s.setText("该用户当前不在线");
						s.setHisname(s.getName());
						Server.Talk(s);
						System.out.println("该用户当前不在线");
					}
				}
				else {
					s.setHisname(s.getName());
					s.setText("没有此用户");
					Server.Talk(s);
					System.out.println("没有此用户");
				}
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("添加好友异常");
		}
	}

	/**
	 * 删除好友，在双方数据库的好友列表删除对方
	 * @param h
	 * @param s
	 */
	public static void deleteFriend(Houtai h, Message s){
		boolean flag = false;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try{
			String sql = "delete from friend_list where name='"+s.getName()+"' AND friendname='"+s.getHisname()+"'";
			conn=getConnection();
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			h.inster(s);
			s.setType(Type.deletefriend);
			Server.Talk(s);
			String sql1 = "delete from friend_list where name='"+s.getHisname()+"' AND friendname='"+s.getName()+"'";
			PreparedStatement ps1 = conn.prepareStatement(sql1);
			ps1.executeUpdate();
			closeAll(rs,ps,conn);
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("删除好友异常");
		}
	}

	/**
	 * 获取数据库中的好友列表，返回列表
	 * @param message
	 * @return
	 */
	public static ResultSet getFriendList(Message message){
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try{
			conn = getConnection();
			String sql = "select * from friend_list where name='"+message.getName()+"'";
			ps = conn.prepareStatement(sql);
			return rs = ps.executeQuery();
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("DBUtil加载好友异常");
			return null;
		}
	}

	/**
	 * 查询搜索用户和查看个人信息
	 * @param name
	 * @return
	 */
	public static ResultSet getUser(String name){
		Connection conn = null;
		ResultSet rs= null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			String sql = "select * from user where name='"+name+"'";
			ps = conn.prepareStatement(sql);
			return rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
			return rs = null;
		}


	}

	/**
	 * 修改个人信息
	 * @param id
	 * @param name
	 * @param sex
	 * @param age
	 * @param qianming
	 * @param psw
	 * @return 返回真，修改成功，返回假，修改失败
	 */
	public static boolean ChangeUser(String id,String name,String sex,String age,String qianming,String psw){
		Connection conn = null;
		ResultSet rs= null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			String sql = "update user set name=?,sex=?,age=?,qianming=?,password=? where id='"+id+"'";
			ps = conn.prepareStatement(sql);
			ps.setString(2,name);
			ps.setString(3,psw);
			ps.setString(4,sex);
			ps.setString(5,age);
			ps.setString(6,qianming);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 拿到用户的个性签名
	 * @param name
	 * @return
	 */
	public static ResultSet getQianming(String name){
		Connection conn = null;
		ResultSet rs= null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			String sql = "select * from user where name='"+name+"'";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
			//return rs;
		}
		return rs;
	}

	/**
	 * 根据id拿到用户的姓名
	 * @param id
	 * @return
	 */
	public static ResultSet getUsername(String id){
		Connection conn = null;
		ResultSet rs= null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			String sql = "select * from user where id='"+id+"'";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
			//return rs;
		}
		return rs;
	}


	/**
	 * 断开数据库的连接，释放资源
	 * @param rs
	 * @param stmt
	 * @param conn
	 */
	public static void closeAll(ResultSet rs,Statement stmt,Connection conn){

		if(rs!=null){
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			stmt = null;
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
}
