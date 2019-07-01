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
        //���ñ����ʽ
        request.setCharacterEncoding("UTF-8");
        //��ȡ��Ӧ�û�id
        int userId = Integer.parseInt(request.getParameter("userId"));

        try{
            //ִ�в�ѯ
            NotepadDao np = new NotepadDaoImpl();
            //�����û�id��ѯ�û���Ϣ
            User author = np.findUserById(userId);

            //ͨ���û�id��ѯ��������
            List<Article> userArticle = np.findArticleByUserId(userId);
            //ͨ���û�id��ѯ����������
            int count = np.findArticleCount(userId,"article");
            int zhuanzaiCount = np.findArticleCount(author.getId(),"zhuanzai");



            //���������������5����ô��ֻ��ȡǰ5����¼
            List<Article> authorZuixin = np.findArticleByUserId(userId);
            if(userArticle.size()>=5){
                authorZuixin = userArticle.subList(0,5);
            }

            //��ѯ�����·�������²��Ƽ�
            List<Article> tuijian = np.findAllArticle();
            //ÿ������Ƽ�5������
            if(tuijian.size()>=5){
                tuijian = tuijian.subList(0,5);
            }

            //��������
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
