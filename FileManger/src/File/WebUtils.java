package File;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.FileUploadException;
/*
* �ϴ��ļ��Ĺ�����
*/
public class WebUtils {
    public static FileUploadDownload doFileUpload(HttpServletRequest request) throws FileSizeLimitExceededException{
        FileUploadDownload fud = new FileUploadDownload();//�ļ���Ϣ����

        try {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //��ʱ�ļ���temp
            factory.setRepository((new File(request.getSession().getServletContext().getContextPath()+"/temp")));
            //factory.setRepository(new File("/temp"));// ��ʱ�ļ���temp
            factory.setSizeThreshold(1024*1024*2);//��ʱ�ļ��Ļ�������СΪ2M

            ServletFileUpload parse = new ServletFileUpload(factory); //������

            //�ϴ��ļ���С
            parse.setFileSizeMax(1024*1024*20);//�����ļ���С����Ϊ20M
            parse.setSizeMax(1024*1024*100);//�ܵ��ļ���С����Ϊ100M

            //��������ļ���������
            parse.setHeaderEncoding("utf-8");

            List<FileItem> list = parse.parseRequest(request);
            for (FileItem fileItem : list) {
                //��ͨ��
                if(fileItem.isFormField()){
                    String filedName = fileItem.getFieldName();
                    // String value = fileItem.getString();
                    String value = fileItem.getString("utf-8");//����ֶε�������������
                    //System.out.println("filedName:"+filedName);
                    //System.out.println("value:"+value);
                    //����ǰ�ֶη�װ��fud�����ж�Ӧ���ֶ���ȥ

                    //��ͨ�ֶζ�ͨ��������浽fud��
                    BeanUtils.setProperty(fud,filedName,value);
                }
                //�ļ�
                else {
                    String filename = fileItem.getName();//��ȡ�ļ���

                    //�ļ�����aa.txt��c:\a\b\c\aa.txt�Ĵ���ͳһ
                    int index = filename.lastIndexOf("\\");
                    if (index!=-1){
                        filename = filename.substring(index+1);
                    }
                    String realPath = request.getSession().getServletContext().getRealPath("/WEB_INF/upload");

                    //��������ļ���
                    String savePath = generateSavePath(realPath,filename);

                    //����Ψһ���ļ���
                    String uuidname = generateUUIDName(filename);

                    //�ϴ��ļ�
                    InputStream in = fileItem.getInputStream();//��ȡ�ļ���ȡ��

//                    OutputStream out = new FileOutputStream("d:/"+name);
                    //�����ļ��У�savePath  Ψһ�ļ�����uuidname
                    OutputStream out = new FileOutputStream(new File(savePath,uuidname));

                    byte[] buf = new byte[1024];
                    int len = 0;
                    while((len = in.read(buf)) != -1){
                        out.write(buf,0,len);
                    }
                    in.close();
                    out.close();
                    //ɾ����ʱ�ļ�
                    fileItem.delete();
                    fud.setFilename(filename);//�ļ���
                    fud.setUuidname(uuidname);//Ψһ�ļ���
                    fud.setSavepath(savePath);//����·��
                    fud.setId(UUID.randomUUID().toString());//id
                }
            }
            return fud;//�����ļ���Ϣ��װ����
        }catch (FileSizeLimitExceededException e){
           // e.printStackTrace();//����ֻ�Ǵ�ӡ�쳣������Ϣ

            //ʹ��ʧ�ܣ���Ϊ�˴���û��response
            //	request.setAttribute("message", "�Բ������ϴ����ļ���С�����˴�С������");
            //	request.getRequestDispatcher("/message.jsp").forward(request,response);

            //��ô�죿
            //�׳�һ���쳣��ȥ  ʵ�����쳣Ҳ��һ������ֵ
            //���쳣������ʱ�쳣  ����   ����ʱ�쳣��
            //����ʱ�쳣
            throw e;//�ǵ��׳��쳣Ҫ�ڷ����н�������
        }
        catch (Exception e){
            throw new RuntimeException(e);//�׳�����ʱ�쳣
        }
    }

    //����Ψһ���ļ���
    private static String generateUUIDName(String filename){
        return UUID.randomUUID().toString()+"_"+filename;
    }

    //��������ļ���
    private static String generateSavePath(String realPath, String filename){
        int hashCode = filename.hashCode();
        //ͨ��λ���㣬�����һ���Ͷ���Ŀ¼������
        int first = hashCode & (0xf);//һ��Ŀ¼
        int second = (hashCode>>4) & (0xf);//����Ŀ¼
        String savePath = realPath+"/"+first+"/"+second;
        File f = new File((savePath));
        if(!f.exists()){
            f.mkdirs();//�����༶Ŀ¼
        }
        return savePath;//����·��
    }
}
