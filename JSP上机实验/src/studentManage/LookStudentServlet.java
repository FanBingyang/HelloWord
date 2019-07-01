/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package studentManage;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrator
 */
public class LookStudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            DBJavaBean db=new DBJavaBean();
            ResultSet rs=db.selectStudent();
             HttpSession session=request.getSession();
             ArrayList al=new ArrayList();
             while(rs.next()){
                 Student st=new Student();
                 st.setStudentNumber(rs.getString("SID"));
                 st.setStudentName(rs.getString("SName"));
                 st.setStudentSex(rs.getString("SSex"));
                 st.setStudentAge(rs.getString("SAge"));
                 st.setStudentWeight(rs.getString("SWeight"));
                 al.add(st); 
                 session.setAttribute("al", al);
             }           
             rs.close();
             response.sendRedirect("shiyan10/lookStudent.jsp");
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
