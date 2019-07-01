package File;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet(name = "UploadServlet",urlPatterns = "/uploadServlet")
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(!ServletFileUpload.isMultipartContent(request)){
            request.setAttribute("message","不是请求的信息表单，请确认表单属性是否正确");
            request.getRequestDispatcher("/Message.jsp").forward(request,response);
            return;
        }

        try {
            //调用工具类，获得上传文件信息
            FileUploadDownload fud = WebUtils.doFileUpload(request);
            FileService service = new FileService();
            service.insert(fud);//保存上传文件信息

            request.setAttribute("message","上传文件成功");
            request.getRequestDispatcher("/Message.jsp").forward(request,response);

        }catch (FileUploadBase.FileSizeLimitExceededException e){
            request.setAttribute("message","你上传的文件大小可能超过了限制");
            request.getRequestDispatcher("/Message.jsp").forward(request,response);

        }

    }
}
