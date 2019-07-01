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

@WebServlet(name = "SerearchArticle",urlPatterns = "/serearchArticle")
public class SerearchArticle extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式
        request.setCharacterEncoding("UTF-8");
        //获取搜索关键字
        String str = request.getParameter("sousuo");

        try {
            //执行查询
            NotepadDao np = new NotepadDaoImpl();
            List<Article> searchArticle = np.findArticleLikeName(str);

            for (Iterator iterators = searchArticle.iterator();iterators.hasNext();){
                //遍历出集合中的元素，转换为Article类型
                Article article = (Article)iterators.next();
                //通过文章得作者id查询出作者信息
                User author = np.findUserById(article.getUser_id());
                //将作者信息写到文章的JavaBean中
                article.setAuthor(author);
            }

            //将数据保存保存到作用域
            request.setAttribute("searchArticle", searchArticle);

            //跳转页面
            request.getRequestDispatcher("search.jsp").forward(request,response);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
