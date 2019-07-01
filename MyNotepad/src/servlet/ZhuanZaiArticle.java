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

@WebServlet(name = "ZhuanZaiArticle",urlPatterns = "/zhuanZaiArticle")
public class ZhuanZaiArticle extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        int user_id = Integer.parseInt(request.getParameter("user_id"));

        try {
            NotepadDao np = new NotepadDaoImpl();
            //查询转载数据库里的数据
            List<Zhuanzai> list = np.ZhuanZaiArticle(user_id);
            List<Article> zhuanzailist = new ArrayList<>();
            //对接进行遍历
            for (Iterator iterator = list.iterator();iterator.hasNext();){
                //取出元素
                Zhuanzai z = (Zhuanzai)iterator.next();
                //根据元素中的文章id查询出该文章
                Article article = np.findArticleById(z.getArticle_id());
                //将该文章放入JavaBean中
                zhuanzailist.add(article);
            }
            //根据用户id查询用户信息
            User author = np.findUserById(user_id);

            //通过用户id查询出其文章
            List<Article> userArticle = np.findArticleByUserId(user_id);
            //通过用户id查询其文章数量
            int count = np.findArticleCount(user_id,"article");
            int zhuanzaiCount = np.findArticleCount(author.getId(),"zhuanzai");



            //如果文章数量大于5，那么久只截取前5跳记录
            List<Article> authorZuixin = np.findArticleByUserId(user_id);
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
            request.setAttribute("userArticle",zhuanzailist);
            request.setAttribute("author",author);
            request.setAttribute("authorZuixin",authorZuixin);
            request.setAttribute("tuijian",tuijian);
            request.setAttribute("count",count);
            request.setAttribute("zhuanzai",zhuanzaiCount);

            request.getRequestDispatcher("/gerenzhuye.jsp").forward(request,response);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
