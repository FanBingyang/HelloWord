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
                    //判断已经转载的文章中有没有与当前转载文章id相同的，如果有，标志设为false，在下面对标志进行判断时，不再将该转载记录写入数据库
                    flag = false;
            }

            //添加到数据库
            //如果flag为true，证明没有转载过该文章，那么将转载记录写入数据库
            //如果flag为false，证明该文章已经被转载过，则不再紫萼如数据库，直接跳转页面
            if(flag)
                np.ZhuanZai(user_id,article_id);

            //依然跳转到查看文章的servlet，
            request.getRequestDispatcher("articleId?article_id="+article_id).forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
