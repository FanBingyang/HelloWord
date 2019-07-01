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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        //��ȡ������
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //����ҵ���߼�
        try {
            NotepadDao np = new NotepadDaoImpl();
            User user = np.login(username,password);
            if(user!=null)
            {
//                System.out.printf(user.getUsername()+"��¼�ɹ���");

                /*��¼�ɹ�*/
                //���û����ݷ��͵�ǰ��,��Ϊ���ҳ�涼��Ҫʹ�ø����ݣ�����Ҫ���浽session��
                request.getSession().setMaxInactiveInterval(30*60);//����sesion������ʱ�䣬��λ����
                request.getSession().setAttribute("user",user);

                //��תҳ��
                request.getRequestDispatcher("/shouye?userid="+user.getId()).forward(request,response);
            }
            else{
                //��¼ʧ�ܣ��ַ�ת��
                request.setAttribute("error","�û������������");
                request.getRequestDispatcher("/index.jsp").forward(request,response);
                return;
            }
        } catch (Exception e) {
            System.out.print("DBUtils�ֳ������ˣ����ݿ����û��\n");
            e.printStackTrace();
        }
    }
}
