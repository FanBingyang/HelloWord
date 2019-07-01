package servlet;

import dao.NotepadDao;
import dao.NotepadDaoImpl;
import domain.Zhuanzai;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "ZhuanZaiServlet",urlPatterns = "/zhuanzai")
public class ZhuanZaiServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        boolean flag = true;

        PrintWriter out = response.getWriter();

        int article_id = Integer.parseInt(request.getParameter("article_id"));
        int user_id = Integer.parseInt(request.getParameter("user_id"));

        try{
            NotepadDao np = new NotepadDaoImpl();
            List<Zhuanzai> zhuanzais = np.ZhuanZaiArticle(user_id);
            for(Iterator iterator = zhuanzais.iterator();iterator.hasNext();)
            {
                Zhuanzai zz = (Zhuanzai)iterator.next();
                if(zz.getArticle_id() == article_id)
                    //�ж��Ѿ�ת�ص���������û���뵱ǰת������id��ͬ�ģ�����У���־��Ϊfalse��������Ա�־�����ж�ʱ�����ٽ���ת�ؼ�¼д�����ݿ�
                    flag = false;
            }

            //��ӵ����ݿ�
            //���flagΪtrue��֤��û��ת�ع������£���ô��ת�ؼ�¼д�����ݿ�
            //���flagΪfalse��֤���������Ѿ���ת�ع����������������ݿ⣬ֱ����תҳ��
            if(flag)
                np.ZhuanZai(user_id,article_id);

            //��Ȼ��ת���鿴���µ�servlet��
            request.getRequestDispatcher("articleId?article_id="+article_id).forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
