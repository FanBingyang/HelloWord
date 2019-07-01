package servlet;

import dao.NotepadDao;
import dao.NotepadDaoImpl;
import domain.Article;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        //获取表单数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //处理业务逻辑
        try {
            NotepadDao np = new NotepadDaoImpl();
            User user = np.login(username,password);
            if(user!=null)
            {
//                System.out.printf(user.getUsername()+"登录成功！");

                /*登录成功*/
                //将用户数据发送到前端,因为多个页面都需要使用该数据，所以要保存到session中
                request.getSession().setMaxInactiveInterval(30*60);//设置sesion的作用时间，单位是秒
                request.getSession().setAttribute("user",user);

                //跳转页面
                request.getRequestDispatcher("/shouye?userid="+user.getId()).forward(request,response);
            }
            else{
                //登录失败，分发转向
                request.setAttribute("error","用户名或密码错误");
                request.getRequestDispatcher("/index.jsp").forward(request,response);
                return;
            }
        } catch (Exception e) {
            System.out.print("DBUtils又出问题了，数据库服务没开\n");
            e.printStackTrace();
        }
    }
}
