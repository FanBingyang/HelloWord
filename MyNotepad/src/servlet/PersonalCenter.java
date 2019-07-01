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
import java.sql.SQLException;

@WebServlet(name = "PersonalCenter",urlPatterns = "/personal")
public class PersonalCenter extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        //获取用户id
        int userid = Integer.parseInt(request.getParameter("userid"));

        try{
            //查询数据
            NotepadDao np = new NotepadDaoImpl();
            User user = np.findUserById(userid);
            //保存数据
            request.setAttribute("user",user);
            //跳转页面
            request.getRequestDispatcher("perCenter.jsp").forward(request,response);

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
