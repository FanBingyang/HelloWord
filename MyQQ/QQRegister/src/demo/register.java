package demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

@WebServlet(name = "Register",urlPatterns = "/register")
public class register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //获取表单数据
        String username = request.getParameter("user");
        String sex = request.getParameter("sex");
        String age = request.getParameter("age");
        String qianming = request.getParameter("qianming");
        String psw = request.getParameter("psw");
        String id = null;


        //处理业务逻辑
        Connection conn=null;
        Statement stmt=null;

        try {
            conn = DBUtils.getConnection();
            stmt = conn.createStatement();

            RandomID randomID  =new RandomID(stmt);
            id = randomID.checkId();
            System.out.printf(id);
            String sql = "insert into user values('"+id+"','"+username+"','"+psw+"','"+sex+"','"+age+"','"+qianming+"')";
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        DBUtils.closeAll(null,stmt,conn);

        request.setAttribute("id",id+"");

        request.getRequestDispatcher("success.jsp").forward(request,response);

    }
}
