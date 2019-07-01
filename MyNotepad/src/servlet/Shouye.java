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
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "Shouye",urlPatterns = "/shouye")
public class Shouye extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        int  userid = Integer.parseInt(request.getParameter("userid"));

        try{
            NotepadDao np = new NotepadDaoImpl();

            User u = np.findUserById(userid);

            //首先查询所有文章
            List<Article> articles = np.findAllArticle();

            //用迭代器遍历查询文章的集合,
            for (Iterator iterators = articles.iterator(); iterators.hasNext();)
            {
                Article article = (Article) iterators.next();//获取当前遍历的元素，指定为Article对象
                //通过文章中的作者id查询出该作者信息
                User author = np.findUserById(article.getUser_id());
                //将查询出来的作者信息存放到对应的文章的JavaBean中
                article.setAuthor(author);
            }

            //将文章集合存放到作用域中
            request.setAttribute("labeArticles",articles);
            request.setAttribute("user",u);
            //跳转页面
            request.getRequestDispatcher("/shouye.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
