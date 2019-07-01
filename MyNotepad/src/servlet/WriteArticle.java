package servlet;

import dao.NotepadDao;
import dao.NotepadDaoImpl;
import domain.Article;
import domain.User;
import utils.TimeUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "WriteArticle",urlPatterns = "/writeArticle")
public class WriteArticle extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        int user_id = Integer.parseInt(request.getParameter("user_id"));
        String article_name = request.getParameter("biaoti");
//        String content = new String(request.getParameter("biji").getBytes("ISO8859_1"), "utf-8");
        String content = request.getParameter("biji");
//        System.out.println("biiji="+content);
        String lable = request.getParameter("lable");
//        System.out.println("lable="+lable);
        String time = TimeUtil.getTime();
        //将文章数据打包
        Article writearticle = new Article(article_name,content,user_id,time,lable);
        try{
            NotepadDao np = new NotepadDaoImpl();
            //新发布的文章写入数据库
            np.writeArticle(writearticle);

            //根绝文章名字取出刚刚写的文章
            Article article = np.findArticleByName(article_name);

            //根据作者id查出作者信息
            User author = np.findUserById(user_id);
            //根据作者id查出其文章数量
            int count = np.findArticleCount(user_id,"article");
            int zhuanzaiCount = np.findArticleCount(user_id,"zhuanzai");

            //根据作者id查询出其最新文章
            List<Article> authorZuixin = np.findArticleByUserId(author.getId());
            //如果文章数量大于5，那么久只截取前5跳记录
            if(authorZuixin.size()>=5){
                authorZuixin = authorZuixin.subList(0,5);
            }

            //查询出最新发表得文章并推荐
            List<Article> tuijian = np.findAllArticle();
            //每次最多推荐5条文章
            if(tuijian.size()>=5){
                tuijian = tuijian.subList(0,5);
            }

            //保存数据
            request.setAttribute("article",article);
            request.setAttribute("author",author);
            request.setAttribute("authorZuixin",authorZuixin);
            request.setAttribute("tuijian",tuijian);
            request.setAttribute("count",count);
            request.setAttribute("zhuanzai",zhuanzaiCount);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        request.getRequestDispatcher("wenzhang.jsp").forward(request,response);
    }
}
