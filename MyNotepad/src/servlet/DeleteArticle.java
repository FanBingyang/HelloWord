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

@WebServlet(name = "DeleteArticle",urlPatterns = "/deleteArticle")
public class DeleteArticle extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式
        request.setCharacterEncoding("UTF-8");
        //获取对应文章id
        int articleId = Integer.parseInt(request.getParameter("articleId"));
        int userId = Integer.parseInt(request.getParameter("userId"));

        try{

            NotepadDao np = new NotepadDaoImpl();
            //根据文章id查出文章
            Article article = np.findArticleById(articleId);

            //执行删除，判断标识，如果文章作者id对应当前操作者id，证明是作者进行删除，那就删除文章并删除所有转载该文章的记录，
            // 否则就是非作者进行删除，就只删除转载记录
            if(userId == article.getUser_id())
            {
                np.deleteArticleById(articleId);
            }
            else np.deleteZhuanzai(userId,articleId);

            //跳转页面,并将用户id传递给下一个servlet
            request.getRequestDispatcher("myBiji?authorId="+userId).forward(request,response);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
