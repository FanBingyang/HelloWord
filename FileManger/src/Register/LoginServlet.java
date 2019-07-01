package Register;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "LoginServlet",urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
        Date Date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日 EEEE");//设置日期格式
        String time = df.format(Date);

        //获取表单数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //处理业务逻辑
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean b = true;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement("select * from user");
            rs = ps.executeQuery();
            while(rs.next()){
                String user = rs.getString(1);
                String pwd  =rs.getString(2);
                if(username.equals(user) && password.equals(pwd))
                {
                    b = false;
                    request.setAttribute("username",username);
                    request.getSession().setAttribute("username",username);
                    request.getSession().setAttribute("time",time);
//                  String name = (String)request.getSession().getAttribute("username");
//                  request.setAttribute("username",name);
                    request.getRequestDispatcher("/Main.jsp").forward(request,response);
            }
        }//分发转向
            if (b){
                request.setAttribute("error","用户名或密码错误");
                request.getRequestDispatcher("/Login.jsp").forward(request,response);
//                System.out.print("error"+username+"\t"+password+"\t"+code+"\t"+scode);
                return;
            }
//            if(c)
//            {
//                request.setAttribute("yanzhengma","验证码错误");
//                request.getRequestDispatcher("/Login.jsp").forward(request,response);
//                return;
//            }
        } catch (Exception e) {
            System.out.print("DBUtils又出问题了，数据库服务没开");
            e.printStackTrace();
        }
        finally {
            DBUtils.closeAll(rs, ps, conn);
        }
    }
}
