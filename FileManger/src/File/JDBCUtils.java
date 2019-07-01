package File;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * ������ �ṩ���ݿ����ӳ� �����ݿ�����
 */
public class JDBCUtils {
    private static DataSource dataSource = new ComboPooledDataSource();

    public static DataSource getDataSource(){
        return dataSource;
    }

    /**
     * ��DBUtils��Ҫ�ֶ���������ʱ��҅�ø÷������һ������
     *
     * @return
     * @throws SQLException
     */

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
