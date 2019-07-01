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
		// Ҫִ���ļ��ϴ��Ĳ���
		// �жϱ��Ƿ�֧���ļ��ϴ�������enctype="multipart/form-data"
		boolean isMultipartContent = ServletFileUpload
				.isMultipartContent(request);
		if (!isMultipartContent) {
			throw new RuntimeException("your form is not multipart/form-data");
		}

		// ����һ��DiskFileItemfactory������
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(new File("E:\\"));// ָ����ʱ�ļ��Ĵ洢Ŀ¼
		// ����һ��ServletFileUpload���Ķ���
		ServletFileUpload sfu = new ServletFileUpload(factory);
		// ����ϴ�������������
		sfu.setHeaderEncoding("UTF-8");
		// �����ϴ��ļ��Ĵ�С

		// ����request���󣬲��õ�һ������ļ���
		try {
			// sfu.setFileSizeMax(1024*1024*3);//��ʾ3M��С
			// sfu.setSizeMax(1024*1024*6);
			List<FileItem> fileItems = sfu.parseRequest(request);

			// ������������ 
			for (FileItem fileitem : fileItems) {
				if (fileitem.isFormField()) {
					// ��ͨ����
					processFormField(fileitem);
				} else {
					// �ϴ�����
					processUploadField1(fileitem,request);
				}
			}
			String fileType = request.getParameter("fileType");
			fileType = new String(fileType.getBytes("iso-8859-1"),"utf-8");
			System.out.println("fileType="+fileType);
			request.setAttribute("filetype", fileType);
			
			request.getRequestDispatcher("addFileServlet").forward(request, response);
		} catch (FileUploadBase.FileSizeLimitExceededException e) {
			// throw new RuntimeException("�ļ����ڣ����ܳ���3M");

			System.out.println("�ļ����ڣ����ܳ���3M");
		} catch (FileUploadBase.SizeLimitExceededException e) {
			System.out.println("���ļ���С���ܳ���6M");
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	}

	

	// �ϴ�����
	@SuppressWarnings("deprecation")
	private void processUploadField1(FileItem fileitem, HttpServletRequest request) {
		
		StoreFile storefile = new StoreFile();
		
		try {
			// �õ��ļ�������
			InputStream is = fileitem.getInputStream();

			// ����һ���ļ����̵�Ŀ¼
			String directoryRealPath = this.getServletContext().getRealPath(
					"/WEB-INF/upload");
			File storeDirectory = new File(directoryRealPath);// �������ļ��ִ���Ŀ¼
			if (!storeDirectory.exists()) {
				storeDirectory.mkdirs();// ����һ��ָ����Ŀ¼
			}
			// �õ��ϴ�������
			String filename = fileitem.getName();// �ļ����е�ֵ F:\ͼƬ�ز�\С����\43.jpg ����
													// 43.jpg
           
			System.out.println("filename"+filename);
			
			// �����ļ���
			/*
			 * ��������⣺ F:\\apache-tomcat-7.0.52\\webapps\\day18_00_upload\\upload\\F:\\ͼƬ�ز�\\С����\\41.jpg
			 */
			if (filename != null) {
				// filename =
				// filename.substring(filename.lastIndexOf(File.separator)+1);
				filename = FilenameUtils.getName(filename);// Ч��ͬ��
			}
			System.out.println("filename........."+filename);
            storefile.setFilename(filename);
            //��ȡ�ļ��ĺ�׺��
            //String[] file_name = filename.split("\\.");
            //storefile.setFilestyle(file_name[1]);
			//��ȡ�ļ�������һ������
            String fileType = request.getParameter("fileType");
            if(fileType.equals("blueFile")){
            	
            	storefile.setFilestyle("���ű��ļ�");
            }
            if(fileType.equals("calcuFile")){
            	storefile.setFilestyle("�����ļ�");
            }
			// ����ļ�ͬ��������
			//filename = UUID.randomUUID() + "_" + filename;

			// �����ڴ�ɢ
			String childDirectory = makeChildDirectory(storeDirectory); //
			
			Date date = new Date();
			int hours = date.getHours();
			int minutes = date.getMinutes();
			int seconds = date.getSeconds();
			
			storefile.setUptime(childDirectory+" "+hours+":"+minutes+":"+seconds);

			System.out.println("childDirectory"+childDirectory);
			// ��storeDirectory�£���������Ŀ¼�µ��ļ�
			filename = childDirectory+ File.separator+hours+File.separator+filename;
			File file = new File(storeDirectory, filename); // ����Ŀ¼/����Ŀ¼/�ļ���
			System.out.println("file:"+storeDirectory+".."+childDirectory+".."+
					 File.separator + filename);
			String file_url = filename;
			
			storefile.setFilepath(file_url);
			// ͨ���ļ���������ϴ����ļ����浽����
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

	// �����ڴ�ɢ
	
	  private String makeChildDirectory(File storeDirectory) {
	  
	  SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd"); 
	  
	  String dateDirectory = sdf.format(new Date()); //ֻ�ܴ���Ŀ¼
	  
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
	 
	// ��ͨ����
	private void processFormField(FileItem fileitem) {
		try {
			String fieldname = fileitem.getFieldName();// �ֶ���
			String fieldvalue = fileitem.getString("UTF-8");// �ֶ�ֵ
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

		// ��ȡ����sizeΪ��1705230
		int GB = 1024 * 1024 * 1024;// ����GB�ļ��㳣��
		int MB = 1024 * 1024;// ����MB�ļ��㳣��
		int KB = 1024;// ����KB�ļ��㳣��
		DecimalFormat df = new DecimalFormat("0.00");// ��ʽ��С��
		String resultSize = "";
		if (size / GB >= 1) {
			// �����ǰByte��ֵ���ڵ���1GB
			resultSize = df.format(size / (float) GB) + "GB   ";
		} else if (size / MB >= 1) {
			// �����ǰByte��ֵ���ڵ���1MB
			resultSize = df.format(size / (float) MB) + "MB   ";
		} else if (size / KB >= 1) {
			// �����ǰByte��ֵ���ڵ���1KB
			resultSize = df.format(size / (float) KB) + "KB   ";
		} else {
			resultSize = size + "B   ";
		}
		return resultSize;
	}

}
