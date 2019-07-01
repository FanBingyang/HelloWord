package servlet;

import dao.NotepadDao;
import dao.NotepadDaoImpl;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "UpdateUser",urlPatterns = "/update")
public class UpdateUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        //1.��ȡ�ͻ����ύ������
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        String sex = request.getParameter("sex");
        String age = request.getParameter("age");


        try {
            NotepadDao np = new NotepadDaoImpl();
            //�ȸ���id����û���Ϣ
            User u = np.findUserById(id);
            //�ж�������Ƿ�Ϊ��
            if(password == ""){
                //��������Ϊ�գ���ô֤���û�û���޸����룬������ԭ����
                password = u.getPassword();
            }

            //2.�����ݴ��
            User user = new User(id,name,password,sex,age);
            System.out.println(user.toString());
            //�޸����ݿ��û���Ϣ
            np.update(user);

            //3.��תҳ��
            //������ֱ������ҳ���ϣ���ô���ҳ������·���һ�Σ�֮ǰ���Ǹ�request�����ŵ�������û����
            //servlet��������ת��jsp֮�⣬������ת��servlet
            request.getRequestDispatcher("personal?userid="+id).forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
