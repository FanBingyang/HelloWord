package SQL;

import java.sql.Connection;
import java.util.Collections;
import java.util.LinkedList;

/**
 * ģ�����ݿ����ӳأ������߱���������
 * @author FBY
 *
 */
public class SimpleConnectionPool {

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
	
	//�õ�һ������
	public Connection getConnectionFormPool() {
		Connection conn = null;
		if(pool.size()>0) {
			conn = pool.removeFirst();//�ӳ���ȡ��һ������
			return conn;
		}else {
			//�ȴ�
			//�ȴ���ʱ���´���һ������
			
			throw new RuntimeException("������æ������");
		}
		
	}
	
	//�ͷ���Դ
	public void release(Connection conn) {
		pool.addLast(conn);//�������ٴηŻص����ӳ����һ��
	}
	
	
	
}
