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
            request.setAttribute("message","�����������Ϣ������ȷ�ϱ������Ƿ���ȷ");
            request.getRequestDispatcher("/Message.jsp").forward(request,response);
            return;
        }

        try {
            //���ù����࣬����ϴ��ļ���Ϣ
            FileUploadDownload fud = WebUtils.doFileUpload(request);
            FileService service = new FileService();
            service.insert(fud);//�����ϴ��ļ���Ϣ

            request.setAttribute("message","�ϴ��ļ��ɹ�");
            request.getRequestDispatcher("/Message.jsp").forward(request,response);

        }catch (FileUploadBase.FileSizeLimitExceededException e){
            request.setAttribute("message","���ϴ����ļ���С���ܳ���������");
            request.getRequestDispatcher("/Message.jsp").forward(request,response);

        }

    }
}
