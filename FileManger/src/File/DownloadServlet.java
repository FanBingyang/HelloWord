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
        //得到参数id
        String id = request.getParameter("id");
        FileService service = new FileService();
        FileUploadDownload fud = service.select(id);//通过id获取文件相关信息

        String path = fud.getSavepath();//保存路径
        String uuidname = fud.getUuidname();//保存文件名
        File f = new File(path,uuidname);//要下载的文件的存放位置

        //健壮性判断
        if (!f.exists()){
            request.setAttribute("message","对不起，当前文件已删除");
            request.getRequestDispatcher("/xxx.jsp").forward(request,response);

        }

        //将中文的文件名编码后再放到http相应头部中去，编码之后浏览器收到后会自动解码
        String filename = URLEncoder.encode(fud.getFilename(),"utf-8");

        //设置参数，使得浏览器可以以下载的方式打开文件
        response.setHeader("content-disposition", "attachement;filename="+filename);

        //将要下载的文件当作一个inputStream读取进来
        InputStream in = new FileInputStream(f);
        //读取进来后，在写到response.getOutputStream()去就可以了
        //相应的数据
        OutputStream out = response.getOutputStream();

        byte[] buf = new byte[1024];
        int len=0;
        while ((len=in.read(buf))!=-1){
            out.write(buf,0,len);
        }
        in.close();
        out.close();
        System.out.println("下载文件成功");
    }
}
