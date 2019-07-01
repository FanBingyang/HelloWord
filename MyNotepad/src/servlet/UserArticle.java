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
import java.util.List;

@WebServlet(name = "UserArticle",urlPatterns = "/userArticle")
public class UserArticle extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式
        request.setCharacterEncoding("UTF-8");
        //获取对应用户id
        int userId = Integer.parseInt(request.getParameter("userId"));

        try{
            //执行查询
            NotepadDao np = new NotepadDaoImpl();
            //根据用户id查询用户信息
            User author = np.findUserById(userId);

            //通过用户id查询出其文章
            List<Article> userArticle = np.findArticleByUserId(userId);
            //通过用户id查询其文章数量
            int count = np.findArticleCount(userId,"article");
            int zhuanzaiCount = np.findArticleCount(author.getId(),"zhuanzai");



            //如果文章数量大于5，那么久只截取前5跳记录
            List<Article> authorZuixin = np.findArticleByUserId(userId);
            if(userArticle.size()>=5){
                authorZuixin = userArticle.subList(0,5);
            }

            //查询出最新发表得文章并推荐
            List<Article> tuijian = np.findAllArticle();
            //每次最多推荐5条文章
            if(tuijian.size()>=5){
                tuijian = tuijian.subList(0,5);
            }

            //保存数据
            request.setAttribute("userArticle",userArticle);
            request.setAttribute("author",author);
            request.setAttribute("authorZuixin",authorZuixin);
            request.setAttribute("tuijian",tuijian);
            request.setAttribute("count",count);
            request.setAttribute("zhuanzai",zhuanzaiCount);

            request.getRequestDispatcher("/gerenzhuye.jsp").forward(request,response);

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
