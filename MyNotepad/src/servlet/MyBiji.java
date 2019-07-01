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
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "MyBiji",urlPatterns = "/myBiji")
public class MyBiji extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式
        request.setCharacterEncoding("UTF-8");
        //获取对应作者id
        int authorId = Integer.parseInt(request.getParameter("authorId"));
        try{
            //执行查询
            NotepadDao np = new NotepadDaoImpl();
            List<Article> userArticle = np.findArticleByUserId(authorId);
            //通过用户id查询其文章数量
            int count = np.findArticleCount(authorId,"article");
            int zhuanzaiCount = np.findArticleCount(authorId,"zhuanzai");

            User user = np.findUserById(authorId);

            //保存数据
            request.setAttribute("MyBiji",userArticle);
            request.setAttribute("user",user);
            request.setAttribute("count",count);
            request.setAttribute("zhuanzai",zhuanzaiCount);

            request.getRequestDispatcher("MyBiji.jsp").forward(request,response);

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
