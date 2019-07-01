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
     * ��ȡ�����ļ����������ݿ�����
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
     * ��ȡ���ݿ������
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception{
        return DriverManager.getConnection(url, username, password);
    }


    /**
     * �Ե�¼���û�������������ж�
     * @param name
     * @param password
     * @return true:�����¼��false:�������¼
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
                    System.out.println("id��"+ rs.getString("username")+"  ���룺"+rs.getString("password"));
                    flag=true;//�û��������ж���ɣ������¼
                }
            }
            return flag;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("��¼�������ݿ����");
            return false;//�������벻ƥ�䣬�������¼
        }
        finally {
            closeAll(rs,null,conn);
        }

    }

    /**
     * ���û�ע����ӵ����ݿ�
     * @param user ��װ������Ϣ
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
     * �Ͽ����ݿ�����ӣ��ͷ���Դ
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
