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

@WebServlet(name = "ArticleId",urlPatterns = "/articleId")
public class ArticleId extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        //获取对应文章id
        int articleId = Integer.parseInt(request.getParameter("article_id"));

        try{
            //执行查询
            NotepadDao np = new NotepadDaoImpl();
            Article article = np.findArticleById(articleId);
            //根据文章id查出作者信息
            User author = np.findUserById(article.getUser_id());
            //根据作者id查出其文章数量
//            System.out.printf("-------------------ArticleId:"+author.getId());
            int count = np.findArticleCount(author.getId(),"article");
            int zhuanzaiCount = np.findArticleCount(author.getId(),"zhuanzai");


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

            //跳转页面
            request.getRequestDispatcher("/wenzhang.jsp").forward(request,response);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
