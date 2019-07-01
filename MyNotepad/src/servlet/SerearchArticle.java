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
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "SerearchArticle",urlPatterns = "/serearchArticle")
public class SerearchArticle extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //���ñ����ʽ
        request.setCharacterEncoding("UTF-8");
        //��ȡ�����ؼ���
        String str = request.getParameter("sousuo");

        try {
            //ִ�в�ѯ
            NotepadDao np = new NotepadDaoImpl();
            List<Article> searchArticle = np.findArticleLikeName(str);

            for (Iterator iterators = searchArticle.iterator();iterators.hasNext();){
                //�����������е�Ԫ�أ�ת��ΪArticle����
                Article article = (Article)iterators.next();
                //ͨ�����µ�����id��ѯ��������Ϣ
                User author = np.findUserById(article.getUser_id());
                //��������Ϣд�����µ�JavaBean��
                article.setAuthor(author);
            }

            //�����ݱ��汣�浽������
            request.setAttribute("searchArticle", searchArticle);

            //��תҳ��
            request.getRequestDispatcher("search.jsp").forward(request,response);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
