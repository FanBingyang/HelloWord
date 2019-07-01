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

@WebServlet(name = "DeleteArticle",urlPatterns = "/deleteArticle")
public class DeleteArticle extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //���ñ����ʽ
        request.setCharacterEncoding("UTF-8");
        //��ȡ��Ӧ����id
        int articleId = Integer.parseInt(request.getParameter("articleId"));
        int userId = Integer.parseInt(request.getParameter("userId"));

        try{

            NotepadDao np = new NotepadDaoImpl();
            //��������id�������
            Article article = np.findArticleById(articleId);

            //ִ��ɾ�����жϱ�ʶ�������������id��Ӧ��ǰ������id��֤�������߽���ɾ�����Ǿ�ɾ�����²�ɾ������ת�ظ����µļ�¼��
            // ������Ƿ����߽���ɾ������ֻɾ��ת�ؼ�¼
            if(userId == article.getUser_id())
            {
                np.deleteArticleById(articleId);
            }
            else np.deleteZhuanzai(userId,articleId);

            //��תҳ��,�����û�id���ݸ���һ��servlet
            request.getRequestDispatcher("myBiji?authorId="+userId).forward(request,response);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
