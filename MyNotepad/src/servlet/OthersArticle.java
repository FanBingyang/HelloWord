package servlet;

import dao.NotepadDao;
import dao.NotepadDaoImpl;
import domain.Article;
import domain.User;
import domain.Zhuanzai;

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

@WebServlet(name = "OthersArticle",urlPatterns = "/others")
public class OthersArticle extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        int user_id = Integer.parseInt(request.getParameter("user_id"));
        try{
            NotepadDao np = new NotepadDaoImpl();

            User user = np.findUserById(user_id);

            List<Zhuanzai> list = np.ZhuanZaiArticle(user_id);

            List<Article> articles = new ArrayList<>();

            for (Iterator iterator = list.iterator();iterator.hasNext();){
                Zhuanzai z = (Zhuanzai)iterator.next();
                Article article = np.findArticleById(z.getArticle_id());
                articles.add(article);
            }

            int count = np.findArticleCount(user_id,"zhuanzai");

            request.setAttribute("MyBiji",articles);
            request.setAttribute("user",user);
            request.setAttribute("count",count);
            //表示为 0 代表是转载的文章，删除时删除转载记录，
            request.setAttribute("sign",0);

            request.getRequestDispatcher("MyBiji.jsp").forward(request,response);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
