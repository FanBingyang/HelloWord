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
        //���������ݴ��
        Article writearticle = new Article(article_name,content,user_id,time,lable);
        try{
            NotepadDao np = new NotepadDaoImpl();
            //�·���������д�����ݿ�
            np.writeArticle(writearticle);

            //������������ȡ���ո�д������
            Article article = np.findArticleByName(article_name);

            //��������id���������Ϣ
            User author = np.findUserById(user_id);
            //��������id�������������
            int count = np.findArticleCount(user_id,"article");
            int zhuanzaiCount = np.findArticleCount(user_id,"zhuanzai");

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
        } catch (SQLException e) {
            e.printStackTrace();
        }


        request.getRequestDispatcher("wenzhang.jsp").forward(request,response);
    }
}
