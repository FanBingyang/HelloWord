package commoncrud;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import util.C3P0Util;

public class CommonCRUDUtils<T> {

	@Test
	public void testUpdate() {
//		update("insert into zhanghu values(?,?,?)", "ddd",1000,4);
		
//		update("delete from zhanghu where id = ?", 4);
		
		update("update zhanghu set money = ? where name=?", 1000,"aaa");
		
		update2("insert into zhanghu values(?,?,?)", "ddd",1000,4,"sdg",123,4);
		
	}
	
	@Test
	public void textQuery() {
//		query("select * from zhanghu where id = ?", 接口的实现类对象, 3);
		query("select * from zhanghu where id = ?", new ResultSetHandle() {
			
			@Override
			public void handle(ResultSet rs) {
				try {
					while(rs.next()) {
						String name = rs.getString("name");
						String monety = rs.getString("money");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}, 3);
	}
	
	
	
	
	//select * from aa
	//select * from aa where id=?
	//select * from aa where id=? and name=?
	//T 是返回对象，在这里是泛型
	public void query(String sql,ResultSetHandle handle,Object...args) { 
		//1.获取连对象
		Connection conn = null;
		//2.数据库连接对象
		PreparedStatement ps = null;
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement(sql);
		
			//获取sql语句中有几个？，占位符
			ParameterMetaData metadata = ps.getParameterMetaData();
			int count = metadata.getParameterCount();
			
			for (int i = 0; i < count; i++) {
				//因为不知道是什么类型的数据，所以使用setObject来对待
				ps.setObject(i+1, args[i]);
			}
			
			//执行查询工作，然后得到结果集
			ResultSet rs = ps.executeQuery();
			//把结果集丢给调用者，让他去封装数据，返回封装数据
//			Users u = handle.handle(rs);
//			return u;
			handle.handle(rs);
			
			
			//问题一：这里的数据获取，以及封装成什么对象返回，不知道，因为调用的地方需要的数据不哦她那个
			while(rs.next()) {
				rs.getInt("id");
				rs.getInt("name");
				//.....
			}
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			C3P0Util.release(null, ps, conn);
		}
	}

	
	/**
	 * 通用的增删改功能方法，依靠于传参的个数
	 * 当传参个数多于？个数时，会报错
	 * @param sql 需要操作的sql语句
	 * @param args  可变参数，有几个占位符，就写进几个参数，可变参数就是一个数组
	 */
	public void update(String sql,Object...args) { 
		//1.获取连对象
		Connection conn = null;
		//2.数据库连接对象
		PreparedStatement ps = null;
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement(sql);
		
			
			for (int i = 0; i < args.length; i++) {
				//因为不知道是什么类型的数据，所以使用setObject来对待
				ps.setObject(i+1, args[i]);
			}
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			C3P0Util.release(null, ps, conn);
		}
	}
	
	
	/**
	 * 通用的增删改功能方法，依靠于sql语句中的 ？ 的个数为准
	 * 参数个数多于？也无所谓，因为是按？的个数取参数
	 * @param sql 需要操作的sql语句
	 * @param args  可变参数，有几个占位符，就写进几个参数，可变参数就是一个数组
	 */
	public void update2(String sql,Object...args) { 
		//1.获取连对象
		Connection conn = null;
		//2.数据库连接对象
		PreparedStatement ps = null;
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement(sql);
			
			/* 元数据  
			 * 描述数据的数据，String sql，描述这份sql字符串的数据叫做元数据
			 * 数据库元数据   DatabaseMetaData
			 * 参数元数据	ParameteMetaData
			 * 结果集元数据	ResultSetMetaData
			 * 
			*/
			
			//获取sql语句中有几个？，占位符
			ParameterMetaData metadata = ps.getParameterMetaData();
			int count = metadata.getParameterCount();
			
			for (int i = 0; i < count; i++) {
				//因为不知道是什么类型的数据，所以使用setObject来对待
				ps.setObject(i+1, args[i]);
			}
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			C3P0Util.release(null, ps, conn);
		}
	}
}
