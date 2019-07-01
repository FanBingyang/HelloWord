package servlet;

import dao.NotepadDao;
import dao.NotepadDaoImpl;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "UpdateUser",urlPatterns = "/update")
public class UpdateUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        //1.获取客户端提交的数据
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        String sex = request.getParameter("sex");
        String age = request.getParameter("age");


        try {
            NotepadDao np = new NotepadDaoImpl();
            //先根据id查出用户信息
            User u = np.findUserById(id);
            //判断密码框是否为空
            if(password == ""){
                //如果密码框为空，那么证明用户没有修改密码，将保留原密码
                password = u.getPassword();
            }

            //2.将数据打包
            User user = new User(id,name,password,sex,age);
            System.out.println(user.toString());
            //修改数据库用户信息
            np.update(user);

            //3.跳转页面
            //这里是直接跳到页面上，那么这个页面会重新翻译一次，之前的那个request请求存放的数据是没有了
            //servlet除了能跳转到jsp之外，还能跳转到servlet
            request.getRequestDispatcher("personal?userid="+id).forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
