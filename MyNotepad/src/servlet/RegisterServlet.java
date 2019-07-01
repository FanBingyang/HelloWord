package servlet;

import dao.NotepadDao;
import dao.NotepadDaoImpl;
import domain.User;
import org.apache.commons.dbutils.DbUtils;
import utils.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "RegisterServlet",urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //注册新用户时默认的头像
        String touxiang = "/pic/TouXiang/moren.png";

        Date Date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");//设置日期格式
        String time = df.format(Date);
        //获取表单数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repsw = request.getParameter("repsw");
        String sex = request.getParameter("sex");
        String age = request.getParameter("age");
        String code = request.getParameter("code");
        String scode = (String) request.getSession().getAttribute("scode");

        try {
            //判断用户名和密码是否为空
            if (!(username.isEmpty()) && !(password.isEmpty())) {
                //判断两次密码是否一致
                if (password.equals(repsw)) {
                    //判断验证码是否正确
                    if (code.equalsIgnoreCase(scode)) {
                        NotepadDao np = new NotepadDaoImpl();
                        //封装用户信息
                        User u = new User(username,password,sex,age,time,touxiang);
                        //写入数据库
                        np.insterUser(u);
                        //用DBUtils操作
                        //DBUtils.insterUser(u);


                        out.print("<script>alter('注册成功')</script>;");
                        request.getRequestDispatcher("/index.jsp").forward(request, response);
                    }else{
                        request.setAttribute("yanzhengma", "验证码错误");
                        request.getRequestDispatcher("/index.jsp").forward(request, response);
                        return;
                }

                }else {
                    request.setAttribute("error3", "两次密码不一致");
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                    return;
                }

            }else{
                request.setAttribute("error2", "用户名和密码不能为空");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                return;
            }
        }catch(Exception e){
            System.out.print("DBUtils又出问题了，数据库服务没开");
            e.printStackTrace();
        }
    }
}
