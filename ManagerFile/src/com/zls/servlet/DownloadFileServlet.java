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
		//�����ļ����ı���
		filepath = new String(filepath.getBytes("iso-8859-1"),"utf-8");
		System.out.println("filepath="+filepath);
		//ͨ��·���õ�һ��������
		String path = this.getServletContext().getRealPath("/WEB-INF/upload/"+filepath);
		System.out.println("path="+path);
		//�õ�Ҫ���ص��ļ���
		String filename = path.substring(path.lastIndexOf("\\")+1);
		System.out.println("filename="+filename);
		// ��֪�����Ҫ�����ļ�
		response.setHeader("content-disposition", "attachment;filename="
				+ filename);
		response.setContentType(this.getServletContext().getMimeType(filename));// �����ļ����Զ�����ļ�����
		FileInputStream fis = new FileInputStream(path);
		ServletOutputStream sos = response.getOutputStream();
		//ִ���������
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
