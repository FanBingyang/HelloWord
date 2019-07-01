package com.zls.servlet;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import com.zls.domain.StoreFile;

public class UpLoadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// request.setCharacterEncoding("UTF-8");
		// 要执行文件上传的操作
		// 判断表单是否支持文件上传。即：enctype="multipart/form-data"
		boolean isMultipartContent = ServletFileUpload
				.isMultipartContent(request);
		if (!isMultipartContent) {
			throw new RuntimeException("your form is not multipart/form-data");
		}

		// 创建一个DiskFileItemfactory工厂类
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(new File("E:\\"));// 指定临时文件的存储目录
		// 创建一个ServletFileUpload核心对象
		ServletFileUpload sfu = new ServletFileUpload(factory);
		// 解决上传表单项乱码问题
		sfu.setHeaderEncoding("UTF-8");
		// 限制上传文件的大小

		// 解析request对象，并得到一个表单项的集合
		try {
			// sfu.setFileSizeMax(1024*1024*3);//表示3M大小
			// sfu.setSizeMax(1024*1024*6);
			List<FileItem> fileItems = sfu.parseRequest(request);

			// 遍历表单项数据 
			for (FileItem fileitem : fileItems) {
				if (fileitem.isFormField()) {
					// 普通表单项
					processFormField(fileitem);
				} else {
					// 上传表单项
					processUploadField1(fileitem,request);
				}
			}
			String fileType = request.getParameter("fileType");
			fileType = new String(fileType.getBytes("iso-8859-1"),"utf-8");
			System.out.println("fileType="+fileType);
			request.setAttribute("filetype", fileType);
			
			request.getRequestDispatcher("addFileServlet").forward(request, response);
		} catch (FileUploadBase.FileSizeLimitExceededException e) {
			// throw new RuntimeException("文件过在，不能超过3M");

			System.out.println("文件过在，不能超过3M");
		} catch (FileUploadBase.SizeLimitExceededException e) {
			System.out.println("总文件大小不能超过6M");
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	}

	

	// 上传表单项
	@SuppressWarnings("deprecation")
	private void processUploadField1(FileItem fileitem, HttpServletRequest request) {
		
		StoreFile storefile = new StoreFile();
		
		try {
			// 得到文件输入流
			InputStream is = fileitem.getInputStream();

			// 创建一个文件存盘的目录
			String directoryRealPath = this.getServletContext().getRealPath(
					"/WEB-INF/upload");
			File storeDirectory = new File(directoryRealPath);// 即代表文件又代表目录
			if (!storeDirectory.exists()) {
				storeDirectory.mkdirs();// 创建一个指定的目录
			}
			// 得到上传的名子
			String filename = fileitem.getName();// 文件项中的值 F:\图片素材\小清新\43.jpg 或者
													// 43.jpg
           
			System.out.println("filename"+filename);
			
			// 处理文件名
			/*
			 * 解决此问题： F:\\apache-tomcat-7.0.52\\webapps\\day18_00_upload\\upload\\F:\\图片素材\\小清新\\41.jpg
			 */
			if (filename != null) {
				// filename =
				// filename.substring(filename.lastIndexOf(File.separator)+1);
				filename = FilenameUtils.getName(filename);// 效果同上
			}
			System.out.println("filename........."+filename);
            storefile.setFilename(filename);
            //获取文件的后缀名
            //String[] file_name = filename.split("\\.");
            //storefile.setFilestyle(file_name[1]);
			//获取文件来自哪一个类型
            String fileType = request.getParameter("fileType");
            if(fileType.equals("blueFile")){
            	
            	storefile.setFilestyle("蓝桥杯文件");
            }
            if(fileType.equals("calcuFile")){
            	storefile.setFilestyle("计赛文件");
            }
			// 解决文件同名的问题
			//filename = UUID.randomUUID() + "_" + filename;

			// 按日期打散
			String childDirectory = makeChildDirectory(storeDirectory); //
			
			Date date = new Date();
			int hours = date.getHours();
			int minutes = date.getMinutes();
			int seconds = date.getSeconds();
			
			storefile.setUptime(childDirectory+" "+hours+":"+minutes+":"+seconds);

			System.out.println("childDirectory"+childDirectory);
			// 在storeDirectory下，创建完整目录下的文件
			filename = childDirectory+ File.separator+hours+File.separator+filename;
			File file = new File(storeDirectory, filename); // 绝对目录/日期目录/文件名
			System.out.println("file:"+storeDirectory+".."+childDirectory+".."+
					 File.separator + filename);
			String file_url = filename;
			
			storefile.setFilepath(file_url);
			// 通过文件输出流将上传的文件保存到磁盘
			FileOutputStream fos = new FileOutputStream(file);

			int len = 0;
			int filelen = 0;
			byte[] b = new byte[1024];
			while ((len = is.read(b)) != -1) {
				fos.write(b, 0, len);
				filelen+=len;
			}
			fos.close();
			is.close();
			//File file1 = new File(filename);
			storefile.setFilesize(setSize(filelen));
			System.out.println("filelen:"+filelen+"fileSize:"+storefile.getFilesize());
            request.setAttribute("storefile", storefile);
			fileitem.delete();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// 按日期打散
	
	  private String makeChildDirectory(File storeDirectory) {
	  
	  SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd"); 
	  
	  String dateDirectory = sdf.format(new Date()); //只管创建目录
	  
	  File file = new File(storeDirectory,dateDirectory); 
	  if(!file.exists())
	  { 
		   file.mkdirs(); 
	  }
	  Date date = new Date();
	  String hour = date.getHours()+"";
//	  dateDirectory = dateDirectory+File.separator+hour;
	  File file2 = new File(storeDirectory,dateDirectory+File.separator+hour);
	  if(!file2.exists())
	  { 
		   file2.mkdirs(); 
	  }
	  return dateDirectory; 
	  }
	 
	// 普通表单项
	private void processFormField(FileItem fileitem) {
		try {
			String fieldname = fileitem.getFieldName();// 字段名
			String fieldvalue = fileitem.getString("UTF-8");// 字段值
			//fieldvalue = new String(fieldvalue.getBytes("iso-8859-1"),"utf-8");
			System.out.println(fieldname + "=" + fieldvalue);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
	
	public String setSize(int size) {

		// 获取到的size为：1705230
		int GB = 1024 * 1024 * 1024;// 定义GB的计算常量
		int MB = 1024 * 1024;// 定义MB的计算常量
		int KB = 1024;// 定义KB的计算常量
		DecimalFormat df = new DecimalFormat("0.00");// 格式化小数
		String resultSize = "";
		if (size / GB >= 1) {
			// 如果当前Byte的值大于等于1GB
			resultSize = df.format(size / (float) GB) + "GB   ";
		} else if (size / MB >= 1) {
			// 如果当前Byte的值大于等于1MB
			resultSize = df.format(size / (float) MB) + "MB   ";
		} else if (size / KB >= 1) {
			// 如果当前Byte的值大于等于1KB
			resultSize = df.format(size / (float) KB) + "KB   ";
		} else {
			resultSize = size + "B   ";
		}
		return resultSize;
	}

}
