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
	
	//����һ����Ž����ӵĳ���
	private static LinkedList<Connection> pool = (LinkedList<Connection>)Collections.synchronizedList(new LinkedList<Connection>());
	
	static {
		try {
			for (int i = 0; i < 10; i++) {
				Connection conn = DBUtils.getConnection();
				pool.add(conn);
			}
		} catch (Exception e) {
			throw new ExceptionInInitializerError("��ʼ�����ݿ����ӳ�ʧ�ܣ����������ļ��Ƿ���ȷ");
		}
	}
	
	@Override
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		if(pool.size()>0) {
			conn = pool.removeFirst();//�ӳ���ȡ��һ������
			MyConnection myconn = new MyConnection(conn,pool);//�õ�һ����װ���MyConnection����
			return myconn;
		}else {
			//�ȴ�
			//�ȴ���ʱ���´���һ������
			
			throw new RuntimeException("������æ������");
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
