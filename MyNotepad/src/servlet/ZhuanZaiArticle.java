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
            //��ѯת�����ݿ��������
            List<Zhuanzai> list = np.ZhuanZaiArticle(user_id);
            List<Article> zhuanzailist = new ArrayList<>();
            //�Խӽ��б���
            for (Iterator iterator = list.iterator();iterator.hasNext();){
                //ȡ��Ԫ��
                Zhuanzai z = (Zhuanzai)iterator.next();
                //����Ԫ���е�����id��ѯ��������
                Article article = np.findArticleById(z.getArticle_id());
                //�������·���JavaBean��
                zhuanzailist.add(article);
            }
            //�����û�id��ѯ�û���Ϣ
            User author = np.findUserById(user_id);

            //ͨ���û�id��ѯ��������
            List<Article> userArticle = np.findArticleByUserId(user_id);
            //ͨ���û�id��ѯ����������
            int count = np.findArticleCount(user_id,"article");
            int zhuanzaiCount = np.findArticleCount(author.getId(),"zhuanzai");



            //���������������5����ô��ֻ��ȡǰ5����¼
            List<Article> authorZuixin = np.findArticleByUserId(user_id);
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
