package servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import com.sun.org.apache.xml.internal.security.keys.storage.StorageResolver;

/**
 * Servlet implementation class uploadServlet2
 */
@WebServlet("/uploadServlet2")
public class uploadServlet2 extends HttpServlet {
	
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
		factory.setRepository(new File("G:\\CodeSpace\\Web学习\\上传文件"));
		
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
				if(fileItem.isFormField()) {
					//普通表单项
					processFormField(fileItem);
				}else {
					//上传表单项
//					processUploadField_1(fileItem);
					processUploadField(fileItem);
				}
			}
		}catch (FileUploadBase.FileSizeLimitExceededException e1) {
//			throw new RuntimeException("上传文件大小超出限制，不能超过10M");
			System.out.println("上传文件大小超出限制，不能超过5M");
		}catch (FileUploadBase.SizeLimitExceededException e2) {
			System.out.println("总文件大小不能超过10M");
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
	}

	private void processUploadField(FileItem fileItem) {
		try {
			//得到文件输入流
			InputStream is = fileItem.getInputStream();
			
			//创建一个文件存盘目录
			/*调用下面方法在项目下创建文件夹的路径：G:\\代码仓库\\Web\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\uploadFile\\upload*/
//		String directroyRealPath = this.getServletContext().getRealPath("/upload");
			//在指定目录下创建保存上传文件的文件夹路径
			String directroyRealPath = "G:\\CodeSpace\\Web学习\\上传文件";
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
			//解决文件同名问题,在文件名前加上随机数
			filename = UUID.randomUUID()+"_"+filename;
			
			//目录打散    按时间打散\\2018-11-12\\文件
			String childDirectroy = makeChildDirectory(stroeDirectory);
			
			//上传文件，
			fileItem.write(new File(stroeDirectory,childDirectroy+File.separator+filename));
			//自动删除临时文件
			fileItem.delete();
			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	//普通表单项
	private void processFormField(FileItem fileItem) {
		try {
			String fieldname = fileItem.getFieldName();//字段名
			String fieldvalue = fileItem.getString("UTF-8");//字段值,直接转码
			//手动转码
//			fieldvalue = new String(fieldvalue.getBytes("iso-8859-1"),"UTF-8");
			System.out.println(fieldname+":"+fieldvalue);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}
	
	//上传表单项
	private void processUploadField_1(FileItem fileItem){
		try {
			//得到文件输入流
			InputStream is = fileItem.getInputStream();
			
			//创建一个文件存盘目录
			/*调用下面方法在项目下创建文件夹的路径：G:\\代码仓库\\Web\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\uploadFile\\upload*/
//			String directroyRealPath = this.getServletContext().getRealPath("/upload");
			//在指定目录下创建保存上传文件的文件夹路径
			String directroyRealPath = "G:\\代码仓库\\Web\\上传文件";
//			System.out.println(directroyRealPath);
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
			//解决文件同名问题,在文件名前加上随机数
			filename = UUID.randomUUID()+"_"+filename;
			
			//目录打散    按时间打散\\2018-11-12\\文件
			String childDirectroy = makeChildDirectory(stroeDirectory);
			//随机打散
//			String childDirectroy = makeChildDirectory(stroeDirectory,filename);
			
			
			//在stroeDirectory目录下，创建一个完整目录文件,
//			File file = new File(stroeDirectory,filename);
			//按时间创建到子文件夹。绝对目录\\时间目录\\文件名        File.separator代表斜杠 \ 拼接用于创建二级目录
			File file = new File(stroeDirectory,childDirectroy+File.separator+filename);
			//通过文件输出流将上传的文件保存到磁盘
			FileOutputStream fos = new FileOutputStream(file);
			
			int len = 0;
			byte[] b = new byte[1024];
			while((len=is.read(b))!=-1) {
				fos.write(b, 0, len);
			}
			//关闭流
			fos.close();
			is.close();
			
			//删除保存的临时文件
			fileItem.delete();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}


	/**
	 * 按照日期将主文件夹创建不同子文件夹
	 * @param stroeDirectory
	 * @return
	 */
	private String makeChildDirectory(File stroeDirectory) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateDirectory = sdf.format(new Date());
		//只管创建目录
		File file = new File(stroeDirectory,dateDirectory);
		if(!file.exists()) {
			file.mkdirs();
		}
		return dateDirectory;
	}
	
	/**
	 * 用文件名的hashcode值随机创建二级目录并且打散文件
	 * @param stroeDirectory
	 * @param filename
	 * @return
	 */
	private String makeChildDirectory(File stroeDirectory,String filename) {
		int hashcode = filename.hashCode();//返回字符串转换的32位hashcode码
		System.out.println(hashcode);
		String code = Integer.toHexString(hashcode); //把hashcode准换成1进制的字符串
		System.out.println(code);
		//File.separator代表斜杠 \ 拼接用于创建二级目录
		String childDirectory = code.charAt(0)+File.separator+code.charAt(1);
		//创建指定目录
		File file = new File(stroeDirectory,childDirectory);
		if(!file.exists()) {
			file.mkdirs();
		}
		return childDirectory;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
