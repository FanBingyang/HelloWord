package SQL;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.logging.Logger;

import javax.sql.DataSource;

public class MyDataSource implements DataSource{
	
	//创建一个存放将连接的池子
	private static LinkedList<Connection> pool = (LinkedList<Connection>)Collections.synchronizedList(new LinkedList<Connection>());
	
	static {
		try {
			for (int i = 0; i < 10; i++) {
				Connection conn = DBUtils.getConnection();
				pool.add(conn);
			}
		} catch (Exception e) {
			throw new ExceptionInInitializerError("初始化数据库连接池失败，请检查配置文件是否正确");
		}
	}
	
	@Override
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		if(pool.size()>0) {
			conn = pool.removeFirst();//从池中取出一个连接
			MyConnection myconn = new MyConnection(conn,pool);//得到一个包装后的MyConnection对象
			return myconn;
		}else {
			//等待
			//等待超时就新创建一个连接
			
			throw new RuntimeException("服务器忙。。。");
		}
	}
	
	

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isWrapperFor(Class<?> arg0) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> arg0) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Connection getConnection(String arg0, String arg1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
