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
        //���ñ����ʽ
        request.setCharacterEncoding("UTF-8");
        //��ȡ��Ӧ��ǩ
        String lable = request.getParameter("lable");

        try{
            //ִ�в�ѯ
            NotepadDao np = new NotepadDaoImpl();
            List<Article> labeArticle = np.findArticleByLable(lable);

            //�õ�����������ѯ���µļ���,
            for (Iterator iterators = labeArticle.iterator(); iterators.hasNext();)
            {
                Article article = (Article) iterators.next();//��ȡ��ǰ������Ԫ�أ�ָ��ΪArticle����
                //ͨ�������е�����id��ѯ����������Ϣ
                User author = np.findUserById(article.getUser_id());
                //����ѯ������������Ϣ��ŵ���Ӧ�����µ�JavaBean��
                article.setAuthor(author);
//                System.out.println("author="+author.toString());
//                System.out.println(article.toString());
            }

            //�ֱ����¼��ϺͶ�Ӧ�����߼��ϴ�ŵ���������
            request.setAttribute("labeArticles",labeArticle);

            //��תҳ��
            request.getRequestDispatcher("/shouye.jsp").forward(request,response);
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
