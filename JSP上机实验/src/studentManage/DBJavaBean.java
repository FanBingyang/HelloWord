/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package studentManage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class DBJavaBean {
    private String driverName="com.mysql.jdbc.Driver";
    private String url="jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=gbk";
    private String user="root";
    private String password="root";
    private Connection con=null;
    private Statement st=null;
    private ResultSet rs=null;
    public String getDriverName() {
        return driverName;
    }
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Connection getCon() {
        return con;
    }
    public void setCon(Connection con) {
        this.con = con;
    }
    public Statement getSt() {
        return st;
    }
    public void setSt(Statement st) {
        this.st = st;
    }
    public ResultSet getRs() {
        return rs;
    }
    public void setRs(ResultSet rs) {
        this.rs = rs;
    }
   //瀹屾垚杩炴帴鏁版嵁搴撴搷浣滐紝骞剁敓鎴愬鍣ㄨ繑鍥�
    public Statement getStatement(){
        try{
            Class.forName(getDriverName());
            con=DriverManager.getConnection(getUrl(), getUser(), getPassword());
            return con.createStatement();
        }catch(Exception e){
            e.printStackTrace();
            message("无法完成");
            return null;
        }
    }
    //娣诲姞瀛︾敓淇℃伅鐨勬柟娉�
    public boolean addStudent(String studentNumber,String studentName,String studentSex,String studentAge,String studentWeight){
        try{
                String sql="insert into stuinfo"+"(SID,SName,SSex,SAge,SWeight)"+"values("+"'"+studentNumber+"'"+","+"'"+studentName+"'"+","+"'"+studentSex+"'"+","+"'"+studentAge+"'"+","+"'"+studentWeight+"'"+")";
                st=getStatement();
                int row=st.executeUpdate(sql);
                if(row==1){
                    st.close();
                    con.close();
                    return true;
                }else{
                    st.close();
                    con.close();
                    return false;
            }  
        }catch(Exception e){
            e.printStackTrace();
            message("1");
            return false;
        }
    }
    //鏌ヨ鎵�鏈夊鐢熶俊鎭紝骞惰繑鍥� rs
    public ResultSet selectStudent(){
        try{
            String sql="select * from stuinfo";
            st=getStatement();
            return st.executeQuery(sql);
        }catch(Exception e){
            e.printStackTrace();
            message("2");
            return null;
        }
    }
    //鏌ヨ瑕佷慨鏀圭殑瀛︾敓淇℃伅
    public ResultSet selectUpdateStudent(String NO){
        try{
            String sql="select * from stuinfo where SID='"+NO+"'";
            st=getStatement();
            return st.executeQuery(sql);
        }catch(Exception e){
            e.printStackTrace();
            message("3");
            return null;
        }
    }
    //淇敼瀛︾敓淇℃伅
    public boolean updateStudent(String studentNumber,String studentName,String studentSex,String studentAge,String studentWeight){
        try{
            String sql="update stuinfo set SID='"+studentNumber+"',SName='"+studentName+"',SSex='"+studentSex+"',SAge='"+studentAge+"',SWeight='"+studentWeight+"'";
            st.executeUpdate(sql);
            return true;        
        }catch(Exception e){
            e.printStackTrace();
            message("4");
            return false;
            
        }
    } 
    //鏌ヨ瑕佸垹闄ょ殑瀛︾敓淇℃伅
    public ResultSet lookDeleteStudent(){
        try{
            String sql="select * from stuinfo";
            st=getStatement();
            return st.executeQuery(sql);
        }catch(Exception e){
            e.printStackTrace();
            message("5");
            return null;
        }
    }
    //鏌ヨ瑕佸垹闄ょ殑瀛︾敓淇℃伅
    public boolean DeleteStudent( String NO){
        try{
            String sql="delete  from stuinfo where SID="+NO;
            st=getStatement();
            st.executeUpdate(sql);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            message("6");
            return false;
        }
    }
    //涓�涓甫鍙傛暟鐨勪俊鎭彁绀烘锛屼緵鎵鹃敊鏄敤
    public void message(String msg){
        int type=JOptionPane.YES_NO_OPTION;
        String title="信息提示";
        JOptionPane.showMessageDialog(null,msg,title,type);
    }
    
    
    
}
