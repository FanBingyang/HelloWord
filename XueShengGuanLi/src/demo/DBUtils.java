package demo;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * 数据库工具类
 * 提供方法：
 * 连接数据库方法
 * 关闭数据库方法
 */
public class DBUtils {
    private static String diverClass;
    private static String url;
    private static String username;
    private static String password;

    //加载配置文件，即数据库的信息
    static {
        //此对象用于加载properties文件数据的
        ResourceBundle rb = ResourceBundle.getBundle("dbinfo");
        diverClass = rb.getString("diverClass");
        url = rb.getString("url");
        username = rb.getString("username");
        password = rb.getString("password");
        try {
            Class.forName(diverClass);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    //得到链接的方法
    public static Connection getConnection() throws Exception{
        return DriverManager.getConnection(url,username,password);
    }

    //关闭资源的方法
    public static void closeAll(ResultSet rs, Statement stmt,Connection conn){
        if(rs!=null){ //防止空指针异常无法关闭
            try {
                rs.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
            rs = null;
        }

        if(stmt!=null){ //防止空指针异常无法关闭
            try {
                stmt.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
            stmt = null;
        }

        if(conn!=null){ //防止空指针异常无法关闭
            try {
                conn.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
            conn = null;
        }

    }
}
