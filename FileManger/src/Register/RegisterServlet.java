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
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "RegisterServlet",urlPatterns = "/registerServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        Date Date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");//设置日期格式
        String time = df.format(Date);
//        request.setAttribute("zcmsg", "zc");
        //获取表单数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repsw = request.getParameter("repsw");
        String sign = request.getParameter("sign");//sign标记，1是管理员，2是用户
        String code = request.getParameter("code");
        String scode = (String) request.getSession().getAttribute("scode");

        Boolean a = true, b = true, c = true;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            if (!(username.isEmpty()) && !(password.isEmpty())) {
//                System.out.println("username:"+username);
//                System.out.println("password:"+password);
                a=false;
                if (password.equals(repsw)) {
                    b = false;
                    if (code.equalsIgnoreCase(scode)) {
                        c = false;
                        String sql = "INSERT INTO user (username,password,sign,tim)" + "VALUES(" + "'" + username + "'," + "'" + password + "'," + "'" + sign +  "'," + "'" + time + "')";
                        ps.executeQuery(sql);
                        out.print("alter('注册成功')");
                        request.getRequestDispatcher("/Login.jsp").forward(request, response);
                    }
                }
                }
                if (a){
                    request.setAttribute("error2", "用户名和密码不能为空");
                    request.getRequestDispatcher("/Login.jsp").forward(request, response);
                    return;
                }
                if (b) {
                    request.setAttribute("error3", "两次密码不一致");
                    request.getRequestDispatcher("/Login.jsp").forward(request, response);
                    return;
                }
                if (c) {
                    request.setAttribute("yanzhengma", "验证码错误");
                    request.getRequestDispatcher("/Login.jsp").forward(request, response);
                    return;
                }

            }catch(Exception e){
                System.out.print("DBUtils又出问题了，数据库服务没开");
                e.printStackTrace();
            }
        finally{
                DBUtils.closeAll(rs, ps, conn);
            }
        }
}
