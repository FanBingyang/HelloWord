package servlet;

import dao.NotepadDao;
import dao.NotepadDaoImpl;
import domain.Article;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserLable",urlPatterns = "/userLable")
public class UserLable extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        int userid = Integer.parseInt(request.getParameter("userid"));
        String lable = request.getParameter("lable");
        try{
            NotepadDao np = new NotepadDaoImpl();
            //查询文章
            List<Article> articles =  np.UserLableArticle(userid,lable);
            //获取文章数量
            int count = articles.size();

            //保存数据
            request.setAttribute("MyBiji",articles);
//            request.setAttribute("user",user);
            request.setAttribute("count",count);

            request.getRequestDispatcher("MyBiji.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
