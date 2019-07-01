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
//		query("select * from zhanghu where id = ?", �ӿڵ�ʵ�������, 3);
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
	//T �Ƿ��ض����������Ƿ���
	public void query(String sql,ResultSetHandle handle,Object...args) { 
		//1.��ȡ������
		Connection conn = null;
		//2.���ݿ����Ӷ���
		PreparedStatement ps = null;
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement(sql);
		
			//��ȡsql������м�������ռλ��
			ParameterMetaData metadata = ps.getParameterMetaData();
			int count = metadata.getParameterCount();
			
			for (int i = 0; i < count; i++) {
				//��Ϊ��֪����ʲô���͵����ݣ�����ʹ��setObject���Դ�
				ps.setObject(i+1, args[i]);
			}
			
			//ִ�в�ѯ������Ȼ��õ������
			ResultSet rs = ps.executeQuery();
			//�ѽ�������������ߣ�����ȥ��װ���ݣ����ط�װ����
//			Users u = handle.handle(rs);
//			return u;
			handle.handle(rs);
			
			
			//����һ����������ݻ�ȡ���Լ���װ��ʲô���󷵻أ���֪������Ϊ���õĵط���Ҫ�����ݲ�Ŷ���Ǹ�
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
	 * ͨ�õ���ɾ�Ĺ��ܷ����������ڴ��εĸ���
	 * �����θ������ڣ�����ʱ���ᱨ��
	 * @param sql ��Ҫ������sql���
	 * @param args  �ɱ�������м���ռλ������д�������������ɱ��������һ������
	 */
	public void update(String sql,Object...args) { 
		//1.��ȡ������
		Connection conn = null;
		//2.���ݿ����Ӷ���
		PreparedStatement ps = null;
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement(sql);
		
			
			for (int i = 0; i < args.length; i++) {
				//��Ϊ��֪����ʲô���͵����ݣ�����ʹ��setObject���Դ�
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
	 * ͨ�õ���ɾ�Ĺ��ܷ�����������sql����е� �� �ĸ���Ϊ׼
	 * �����������ڣ�Ҳ����ν����Ϊ�ǰ����ĸ���ȡ����
	 * @param sql ��Ҫ������sql���
	 * @param args  �ɱ�������м���ռλ������д�������������ɱ��������һ������
	 */
	public void update2(String sql,Object...args) { 
		//1.��ȡ������
		Connection conn = null;
		//2.���ݿ����Ӷ���
		PreparedStatement ps = null;
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement(sql);
			
			/* Ԫ����  
			 * �������ݵ����ݣ�String sql���������sql�ַ��������ݽ���Ԫ����
			 * ���ݿ�Ԫ����   DatabaseMetaData
			 * ����Ԫ����	ParameteMetaData
			 * �����Ԫ����	ResultSetMetaData
			 * 
			*/
			
			//��ȡsql������м�������ռλ��
			ParameterMetaData metadata = ps.getParameterMetaData();
			int count = metadata.getParameterCount();
			
			for (int i = 0; i < count; i++) {
				//��Ϊ��֪����ʲô���͵����ݣ�����ʹ��setObject���Դ�
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
