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

        //要执行文件上传的操作
        //1，先判断表单是否支持文件上传，即enctype="multipart/form-data"
        boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
        if(!isMultipartContent) {
            throw new RuntimeException("your form is not \"multipart/form-data\"");
        }

        //2，创建一个DiskFileItemFactory工厂类
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //设置文件临时保存文件夹
        factory.setRepository(new File("F:\\MyProjectDatabase\\MyNotepadImg\\UserFiles\\TouXiang"));

        //3，创建一个ServletFileUpload核心对象
        ServletFileUpload sfu = new ServletFileUpload(factory);
        //设置编码格式，解决表单中文件上传乱码
        sfu.setHeaderEncoding("UTF-8");

        //4，解析request对象，并得到一个表单项的集合
        try {
            //限制上传文件的单个文件大小
            sfu.setFileSizeMax(1024*1024*5);//限制单个文件大小为5M
            //限制上传文件的总文件大小
            sfu.setSizeMax(1024*1024*10);//限制总文件大小为10M

            List<FileItem> fileItems = sfu.parseRequest(request);

            //遍历表单项数据
            for (FileItem fileItem : fileItems) {
                System.out.println(fileItem);
                if(fileItem.isFormField()) {
                    //普通表单项
                    userid = Integer.parseInt(processFormField(fileItem));
                }else {
                    //上传表单项,将服务器路径和文件名拼接在一起存放到数据库
                    path = "/pic/TouXiang/"+processUploadField(fileItem);
                }
            }
            //新新的头像信息存放到数据库
            NotepadDao np = new NotepadDaoImpl();
            np.changeTouxiang(userid,path);
            //跳转页面
            request.getRequestDispatcher("personal?userid="+userid).forward(request,response);

        }catch (FileUploadBase.FileSizeLimitExceededException e1) {
//			throw new RuntimeException("上传文件大小超出限制，不能超过10M");
            System.out.println("上传文件大小超出限制，不能超过5M");
        }catch (FileUploadBase.SizeLimitExceededException e2) {
            System.out.println("总文件大小不能超过10M");
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private String processUploadField(FileItem fileItem) {
        try {
            //得到文件输入流
            InputStream is = fileItem.getInputStream();

            //创建一个文件存盘目录
            /*调用下面方法在项目下创建文件夹的路径：G:\\代码仓库\\Web\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\uploadFile\\upload*/
//		String directroyRealPath = this.getServletContext().getRealPath("/upload");
            //在指定目录下创建保存上传文件的文件夹路径
            String directroyRealPath = "F:\\MyProjectDatabase\\MyNotepadImg\\UserFiles\\TouXiang";
//		System.out.println(directroyRealPath);
            File stroeDirectory = new File(directroyRealPath);
            if(!stroeDirectory.exists()) {
                stroeDirectory.mkdirs();//创建一个指定的目录
            }

            //得到上传文件的名字
            String filename = fileItem.getName();//文件项中的值。a.txt
            if(filename!=null) {
                //处理文件名,只截取文件名，不要上传路径                File.separator代表斜杠 \ 拼接用于创建二级目录
//				filename = filename.substring(filename.lastIndexOf(File.separator)+1);
                //调用jar包中的工具类方法，获取真实文件名
                filename = FilenameUtils.getName(filename);
            }

            //上传文件，
            fileItem.write(new File(stroeDirectory,filename));
            //自动删除临时文件
            fileItem.delete();
            //将文件名返回
            return filename;
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //普通表单项
    private String processFormField(FileItem fileItem) {
        try {
            String fieldname = fileItem.getFieldName();//字段名
            String fieldvalue = fileItem.getString("UTF-8");//字段值,直接转码
            //手动转码
//			fieldvalue = new String(fieldvalue.getBytes("iso-8859-1"),"UTF-8");
            System.out.println(fieldname+":"+fieldvalue);
            //讲用户id以字符穿的形式返回
            return fieldvalue;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;

    }

}
