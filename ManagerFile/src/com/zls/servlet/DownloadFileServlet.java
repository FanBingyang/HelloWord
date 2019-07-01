package com.zls.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadFileServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String filepath = request.getParameter("filepath");
		//设置文件名的编码
		filepath = new String(filepath.getBytes("iso-8859-1"),"utf-8");
		System.out.println("filepath="+filepath);
		//通过路径得到一个输入流
		String path = this.getServletContext().getRealPath("/WEB-INF/upload/"+filepath);
		System.out.println("path="+path);
		//得到要下载的文件名
		String filename = path.substring(path.lastIndexOf("\\")+1);
		System.out.println("filename="+filename);
		// 告知浏览器要下载文件
		response.setHeader("content-disposition", "attachment;filename="
				+ filename);
		response.setContentType(this.getServletContext().getMimeType(filename));// 根据文件名自动获得文件类型
		FileInputStream fis = new FileInputStream(path);
		ServletOutputStream sos = response.getOutputStream();
		//执行输出操作
		int len = 1;
		byte[] b = new byte[1024];
		while ((len = fis.read(b)) != -1) {
			sos.write(b, 0, len);
		}

		sos.close();
		fis.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
