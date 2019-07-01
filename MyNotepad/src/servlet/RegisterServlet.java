package servlet;

import dao.NotepadDao;
import dao.NotepadDaoImpl;
import domain.User;
import org.apache.commons.dbutils.DbUtils;
import utils.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "RegisterServlet",urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //ע�����û�ʱĬ�ϵ�ͷ��
        String touxiang = "/pic/TouXiang/moren.png";

        Date Date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss");//�������ڸ�ʽ
        String time = df.format(Date);
        //��ȡ������
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repsw = request.getParameter("repsw");
        String sex = request.getParameter("sex");
        String age = request.getParameter("age");
        String code = request.getParameter("code");
        String scode = (String) request.getSession().getAttribute("scode");

        try {
            //�ж��û����������Ƿ�Ϊ��
            if (!(username.isEmpty()) && !(password.isEmpty())) {
                //�ж����������Ƿ�һ��
                if (password.equals(repsw)) {
                    //�ж���֤���Ƿ���ȷ
                    if (code.equalsIgnoreCase(scode)) {
                        NotepadDao np = new NotepadDaoImpl();
                        //��װ�û���Ϣ
                        User u = new User(username,password,sex,age,time,touxiang);
                        //д�����ݿ�
                        np.insterUser(u);
                        //��DBUtils����
                        //DBUtils.insterUser(u);


                        out.print("<script>alter('ע��ɹ�')</script>;");
                        request.getRequestDispatcher("/index.jsp").forward(request, response);
                    }else{
                        request.setAttribute("yanzhengma", "��֤�����");
                        request.getRequestDispatcher("/index.jsp").forward(request, response);
                        return;
                }

                }else {
                    request.setAttribute("error3", "�������벻һ��");
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                    return;
                }

            }else{
                request.setAttribute("error2", "�û��������벻��Ϊ��");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                return;
            }
        }catch(Exception e){
            System.out.print("DBUtils�ֳ������ˣ����ݿ����û��");
            e.printStackTrace();
        }
    }
}
