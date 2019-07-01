package utils;

import domain.User;

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
        driverClass = rb.getString("diverClass");
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
     * @param name
     * @param password
     * @return true:允许登录；false:不允许登录
     */
    public static boolean userSQL(String name,String password){
        boolean flag = false;
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            conn = getConnection();
            String sql = "select * from user";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                if(name.equals(rs.getString(2))&&password.equals(rs.getString(3)))
                {
                    System.out.println("id："+ rs.getString("username")+"  密码："+rs.getString("password"));
                    flag=true;//用户名密码判断完成，允许登录
                }
            }
            return flag;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("登录连接数据库错误");
            return false;//姓名密码不匹配，不允许登录
        }
        finally {
            closeAll(rs,null,conn);
        }

    }

    /**
     * 新用户注册添加到数据库
     * @param user 封装个人信息
     */
    public static void insterUser(User user){
        Connection conn = null;
        ResultSet rs = null;
        Statement stmt = null;
        try {
            conn = getConnection();
            String sql = "insert into user values(null,'"+user.getUsername()+"','"+user.getPassword()+"','"+user.getSex()+"','"+user.getAge()+"','"+user.getTime()+"','"+user.getTouxiang()+"')";
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("aaaaaaaaaaa");
        }
        finally {
            closeAll(rs,stmt,conn);
        }
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
