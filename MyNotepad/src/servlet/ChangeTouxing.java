package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import dao.NotepadDao;
import dao.NotepadDaoImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

@WebServlet(name = "ChangeTouxing",urlPatterns = "/change")
public class ChangeTouxing extends HttpServlet{
    private int userid;
    private String path;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        //Ҫִ���ļ��ϴ��Ĳ���
        //1�����жϱ��Ƿ�֧���ļ��ϴ�����enctype="multipart/form-data"
        boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
        if(!isMultipartContent) {
            throw new RuntimeException("your form is not \"multipart/form-data\"");
        }

        //2������һ��DiskFileItemFactory������
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //�����ļ���ʱ�����ļ���
        factory.setRepository(new File("F:\\MyProjectDatabase\\MyNotepadImg\\UserFiles\\TouXiang"));

        //3������һ��ServletFileUpload���Ķ���
        ServletFileUpload sfu = new ServletFileUpload(factory);
        //���ñ����ʽ����������ļ��ϴ�����
        sfu.setHeaderEncoding("UTF-8");

        //4������request���󣬲��õ�һ������ļ���
        try {
            //�����ϴ��ļ��ĵ����ļ���С
            sfu.setFileSizeMax(1024*1024*5);//���Ƶ����ļ���СΪ5M
            //�����ϴ��ļ������ļ���С
            sfu.setSizeMax(1024*1024*10);//�������ļ���СΪ10M

            List<FileItem> fileItems = sfu.parseRequest(request);

            //������������
            for (FileItem fileItem : fileItems) {
                System.out.println(fileItem);
                if(fileItem.isFormField()) {
                    //��ͨ����
                    userid = Integer.parseInt(processFormField(fileItem));
                }else {
                    //�ϴ�����,��������·�����ļ���ƴ����һ���ŵ����ݿ�
                    path = "/pic/TouXiang/"+processUploadField(fileItem);
                }
            }
            //���µ�ͷ����Ϣ��ŵ����ݿ�
            NotepadDao np = new NotepadDaoImpl();
            np.changeTouxiang(userid,path);
            //��תҳ��
            request.getRequestDispatcher("personal?userid="+userid).forward(request,response);

        }catch (FileUploadBase.FileSizeLimitExceededException e1) {
//			throw new RuntimeException("�ϴ��ļ���С�������ƣ����ܳ���10M");
            System.out.println("�ϴ��ļ���С�������ƣ����ܳ���5M");
        }catch (FileUploadBase.SizeLimitExceededException e2) {
            System.out.println("���ļ���С���ܳ���10M");
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private String processUploadField(FileItem fileItem) {
        try {
            //�õ��ļ�������
            InputStream is = fileItem.getInputStream();

            //����һ���ļ�����Ŀ¼
            /*�������淽������Ŀ�´����ļ��е�·����G:\\����ֿ�\\Web\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\uploadFile\\upload*/
//		String directroyRealPath = this.getServletContext().getRealPath("/upload");
            //��ָ��Ŀ¼�´��������ϴ��ļ����ļ���·��
            String directroyRealPath = "F:\\MyProjectDatabase\\MyNotepadImg\\UserFiles\\TouXiang";
//		System.out.println(directroyRealPath);
            File stroeDirectory = new File(directroyRealPath);
            if(!stroeDirectory.exists()) {
                stroeDirectory.mkdirs();//����һ��ָ����Ŀ¼
            }

            //�õ��ϴ��ļ�������
            String filename = fileItem.getName();//�ļ����е�ֵ��a.txt
            if(filename!=null) {
                //�����ļ���,ֻ��ȡ�ļ�������Ҫ�ϴ�·��                File.separator����б�� \ ƴ�����ڴ�������Ŀ¼
//				filename = filename.substring(filename.lastIndexOf(File.separator)+1);
                //����jar���еĹ����෽������ȡ��ʵ�ļ���
                filename = FilenameUtils.getName(filename);
            }

            //�ϴ��ļ���
            fileItem.write(new File(stroeDirectory,filename));
            //�Զ�ɾ����ʱ�ļ�
            fileItem.delete();
            //���ļ�������
            return filename;
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //��ͨ����
    private String processFormField(FileItem fileItem) {
        try {
            String fieldname = fileItem.getFieldName();//�ֶ���
            String fieldvalue = fileItem.getString("UTF-8");//�ֶ�ֵ,ֱ��ת��
            //�ֶ�ת��
//			fieldvalue = new String(fieldvalue.getBytes("iso-8859-1"),"UTF-8");
            System.out.println(fieldname+":"+fieldvalue);
            //���û�id���ַ�������ʽ����
            return fieldvalue;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;

    }

}
