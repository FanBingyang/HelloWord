package Register;

import java.sql.ResultSet;
import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DBUtils {
    private static String driverClass;
    private static String url;
    private static String username;
    private static String password;

    static {
        //ResourceBundle对象是用来加载properties配置文件的护据
        ResourceBundle rb = ResourceBundle.getBundle("dbinfo");
        driverClass = rb.getString("driverClass");
        url = rb.getString("url");
        username = rb.getString("username");
        password = rb.getString("password");
        try{
            Class.forName(driverClass);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    //获取连接方法
    public static Connection getConnection() throws Exception{
        Connection conn = DriverManager.getConnection(url,username,password);
        return conn;
    }


    //关闭资源方法
    public static void closeAll(ResultSet rs, Statement stmt,Connection conn){
        if(rs!=null) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if(stmt!=null) {
            try {
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            stmt = null;
        }
        if(conn!=null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            conn = null;
        }
    }


}
