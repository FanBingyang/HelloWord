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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "LableArticle",urlPatterns = "/lableArctile")
public class LableArticle extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式
        request.setCharacterEncoding("UTF-8");
        //获取对应标签
        String lable = request.getParameter("lable");

        try{
            //执行查询
            NotepadDao np = new NotepadDaoImpl();
            List<Article> labeArticle = np.findArticleByLable(lable);

            //用迭代器遍历查询文章的集合,
            for (Iterator iterators = labeArticle.iterator(); iterators.hasNext();)
            {
                Article article = (Article) iterators.next();//获取当前遍历的元素，指定为Article对象
                //通过文章中的作者id查询出该作者信息
                User author = np.findUserById(article.getUser_id());
                //将查询出来的作者信息存放到对应的文章的JavaBean中
                article.setAuthor(author);
//                System.out.println("author="+author.toString());
//                System.out.println(article.toString());
            }

            //分别将文章集合和对应的作者集合存放到作用域中
            request.setAttribute("labeArticles",labeArticle);

            //跳转页面
            request.getRequestDispatcher("/shouye.jsp").forward(request,response);
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
