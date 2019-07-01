package File;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListFileServlet",urlPatterns = "/listFileServlet")
public class ListFileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //查询显示所有的数据到页面
        FileService service = new FileService();
        List<FileUploadDownload> list = service.list();

        request.setAttribute("list",list);
        request.getRequestDispatcher("/Right.jsp").forward(request,response) ;
    }
}
