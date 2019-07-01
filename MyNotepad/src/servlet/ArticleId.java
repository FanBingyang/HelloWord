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
        //���ñ����ʽ
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        //��ȡ��Ӧ����id
        int articleId = Integer.parseInt(request.getParameter("article_id"));

        try{
            //ִ�в�ѯ
            NotepadDao np = new NotepadDaoImpl();
            Article article = np.findArticleById(articleId);
            //��������id���������Ϣ
            User author = np.findUserById(article.getUser_id());
            //��������id�������������
//            System.out.printf("-------------------ArticleId:"+author.getId());
            int count = np.findArticleCount(author.getId(),"article");
            int zhuanzaiCount = np.findArticleCount(author.getId(),"zhuanzai");


            //��������id��ѯ������������
            List<Article> authorZuixin = np.findArticleByUserId(author.getId());
            //���������������5����ô��ֻ��ȡǰ5����¼
            if(authorZuixin.size()>=5){
                authorZuixin = authorZuixin.subList(0,5);
            }

            //��ѯ�����·�������²��Ƽ�
            List<Article> tuijian = np.findAllArticle();
            //ÿ������Ƽ�5������
            if(tuijian.size()>=5){
                tuijian = tuijian.subList(0,5);
            }

            //��������
            request.setAttribute("article",article);
            request.setAttribute("author",author);
            request.setAttribute("authorZuixin",authorZuixin);
            request.setAttribute("tuijian",tuijian);
            request.setAttribute("count",count);
            request.setAttribute("zhuanzai",zhuanzaiCount);

            //��תҳ��
            request.getRequestDispatcher("/wenzhang.jsp").forward(request,response);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
