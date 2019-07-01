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

		//Ҫִ���ļ��ϴ��Ĳ���
		//1�����жϱ��Ƿ�֧���ļ��ϴ�����enctype="multipart/form-data"
		boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
		if(!isMultipartContent) {
			throw new RuntimeException("your form is not \"multipart/form-data\"");
		}
		
		//2������һ��DiskFileItemFactory������
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//�����ļ���ʱ�����ļ���
		factory.setRepository(new File("G:\\CodeSpace\\Webѧϰ\\�ϴ��ļ�"));
		
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
				if(fileItem.isFormField()) {
					//��ͨ����
					processFormField(fileItem);
				}else {
					//�ϴ�����
//					processUploadField_1(fileItem);
					processUploadField(fileItem);
				}
			}
		}catch (FileUploadBase.FileSizeLimitExceededException e1) {
//			throw new RuntimeException("�ϴ��ļ���С�������ƣ����ܳ���10M");
			System.out.println("�ϴ��ļ���С�������ƣ����ܳ���5M");
		}catch (FileUploadBase.SizeLimitExceededException e2) {
			System.out.println("���ļ���С���ܳ���10M");
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
	}

	private void processUploadField(FileItem fileItem) {
		try {
			//�õ��ļ�������
			InputStream is = fileItem.getInputStream();
			
			//����һ���ļ�����Ŀ¼
			/*�������淽������Ŀ�´����ļ��е�·����G:\\����ֿ�\\Web\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\uploadFile\\upload*/
//		String directroyRealPath = this.getServletContext().getRealPath("/upload");
			//��ָ��Ŀ¼�´��������ϴ��ļ����ļ���·��
			String directroyRealPath = "G:\\CodeSpace\\Webѧϰ\\�ϴ��ļ�";
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
			//����ļ�ͬ������,���ļ���ǰ���������
			filename = UUID.randomUUID()+"_"+filename;
			
			//Ŀ¼��ɢ    ��ʱ���ɢ\\2018-11-12\\�ļ�
			String childDirectroy = makeChildDirectory(stroeDirectory);
			
			//�ϴ��ļ���
			fileItem.write(new File(stroeDirectory,childDirectroy+File.separator+filename));
			//�Զ�ɾ����ʱ�ļ�
			fileItem.delete();
			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	//��ͨ����
	private void processFormField(FileItem fileItem) {
		try {
			String fieldname = fileItem.getFieldName();//�ֶ���
			String fieldvalue = fileItem.getString("UTF-8");//�ֶ�ֵ,ֱ��ת��
			//�ֶ�ת��
//			fieldvalue = new String(fieldvalue.getBytes("iso-8859-1"),"UTF-8");
			System.out.println(fieldname+":"+fieldvalue);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}
	
	//�ϴ�����
	private void processUploadField_1(FileItem fileItem){
		try {
			//�õ��ļ�������
			InputStream is = fileItem.getInputStream();
			
			//����һ���ļ�����Ŀ¼
			/*�������淽������Ŀ�´����ļ��е�·����G:\\����ֿ�\\Web\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\uploadFile\\upload*/
//			String directroyRealPath = this.getServletContext().getRealPath("/upload");
			//��ָ��Ŀ¼�´��������ϴ��ļ����ļ���·��
			String directroyRealPath = "G:\\����ֿ�\\Web\\�ϴ��ļ�";
//			System.out.println(directroyRealPath);
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
			//����ļ�ͬ������,���ļ���ǰ���������
			filename = UUID.randomUUID()+"_"+filename;
			
			//Ŀ¼��ɢ    ��ʱ���ɢ\\2018-11-12\\�ļ�
			String childDirectroy = makeChildDirectory(stroeDirectory);
			//�����ɢ
//			String childDirectroy = makeChildDirectory(stroeDirectory,filename);
			
			
			//��stroeDirectoryĿ¼�£�����һ������Ŀ¼�ļ�,
//			File file = new File(stroeDirectory,filename);
			//��ʱ�䴴�������ļ��С�����Ŀ¼\\ʱ��Ŀ¼\\�ļ���        File.separator����б�� \ ƴ�����ڴ�������Ŀ¼
			File file = new File(stroeDirectory,childDirectroy+File.separator+filename);
			//ͨ���ļ���������ϴ����ļ����浽����
			FileOutputStream fos = new FileOutputStream(file);
			
			int len = 0;
			byte[] b = new byte[1024];
			while((len=is.read(b))!=-1) {
				fos.write(b, 0, len);
			}
			//�ر���
			fos.close();
			is.close();
			
			//ɾ���������ʱ�ļ�
			fileItem.delete();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}


	/**
	 * �������ڽ����ļ��д�����ͬ���ļ���
	 * @param stroeDirectory
	 * @return
	 */
	private String makeChildDirectory(File stroeDirectory) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateDirectory = sdf.format(new Date());
		//ֻ�ܴ���Ŀ¼
		File file = new File(stroeDirectory,dateDirectory);
		if(!file.exists()) {
			file.mkdirs();
		}
		return dateDirectory;
	}
	
	/**
	 * ���ļ�����hashcodeֵ�����������Ŀ¼���Ҵ�ɢ�ļ�
	 * @param stroeDirectory
	 * @param filename
	 * @return
	 */
	private String makeChildDirectory(File stroeDirectory,String filename) {
		int hashcode = filename.hashCode();//�����ַ���ת����32λhashcode��
		System.out.println(hashcode);
		String code = Integer.toHexString(hashcode); //��hashcode׼����1���Ƶ��ַ���
		System.out.println(code);
		//File.separator����б�� \ ƴ�����ڴ�������Ŀ¼
		String childDirectory = code.charAt(0)+File.separator+code.charAt(1);
		//����ָ��Ŀ¼
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
