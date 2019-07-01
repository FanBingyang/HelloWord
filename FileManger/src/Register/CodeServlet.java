package Register;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import cn.dsna.util.images.ValidateCode;

@WebServlet(name = "CodeServlet",urlPatterns = "/codeServlet")
public class CodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //生成验证码
        ValidateCode vc = new ValidateCode(110,25,4,9);
        String scode = vc.getCode();//获取验证码的值
        System.out.print(scode);
        //向session中保存验证码
        request.getSession().setAttribute("scode",scode);
        vc.write(response.getOutputStream());
    }
}
