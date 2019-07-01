package File;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@WebServlet(name = "DownloadServlet",urlPatterns = "/downloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //�õ�����id
        String id = request.getParameter("id");
        FileService service = new FileService();
        FileUploadDownload fud = service.select(id);//ͨ��id��ȡ�ļ������Ϣ

        String path = fud.getSavepath();//����·��
        String uuidname = fud.getUuidname();//�����ļ���
        File f = new File(path,uuidname);//Ҫ���ص��ļ��Ĵ��λ��

        //��׳���ж�
        if (!f.exists()){
            request.setAttribute("message","�Բ��𣬵�ǰ�ļ���ɾ��");
            request.getRequestDispatcher("/xxx.jsp").forward(request,response);

        }

        //�����ĵ��ļ���������ٷŵ�http��Ӧͷ����ȥ������֮��������յ�����Զ�����
        String filename = URLEncoder.encode(fud.getFilename(),"utf-8");

        //���ò�����ʹ����������������صķ�ʽ���ļ�
        response.setHeader("content-disposition", "attachement;filename="+filename);

        //��Ҫ���ص��ļ�����һ��inputStream��ȡ����
        InputStream in = new FileInputStream(f);
        //��ȡ��������д��response.getOutputStream()ȥ�Ϳ�����
        //��Ӧ������
        OutputStream out = response.getOutputStream();

        byte[] buf = new byte[1024];
        int len=0;
        while ((len=in.read(buf))!=-1){
            out.write(buf,0,len);
        }
        in.close();
        out.close();
        System.out.println("�����ļ��ɹ�");
    }
}
