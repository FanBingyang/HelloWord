/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package studentManage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class UpdateStudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String studentNumber=request.getParameter("studentNumber");
        String studentName=request.getParameter("studentName");
        String studentSex=request.getParameter("studentSex");
        String studentAge=request.getParameter("studentAge");
        String studentWeight=request.getParameter("studentWeight");
        DBJavaBean db=new DBJavaBean();
        if(db.updateStudent(studentNumber,studentName,studentSex,studentAge,studentWeight)){
            response.sendRedirect("shiyan10/message2.jsp");
        }else{
            response.sendRedirect("shiyan10/lookUpdateStudent.jsp");
       }        
      
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
