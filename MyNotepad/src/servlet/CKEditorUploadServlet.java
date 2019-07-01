package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class CKEditorUploadServlet extends HttpServlet {

    private static String baseDir;// CKEditor�ĸ�Ŀ¼
    private static boolean debug = false;// �Ƿ�debugģʽ
    private static boolean enabled = false;// �Ƿ���CKEditor�ϴ�
    private static Hashtable allowedExtensions;// ������ϴ��ļ���չ��
    private static Hashtable deniedExtensions;// ��ֹ���ϴ��ļ���չ��
    private static SimpleDateFormat dirFormatter;// Ŀ¼������ʽ:yyyyMM
    private static SimpleDateFormat fileFormatter;// �ļ�������ʽ:yyyyMMddHHmmssSSS
    private static String PicPath = "F:\\MyProjectDatabase\\MyNotepadImg\\UserFiles";

    /**
     * Servlet��ʼ������
     */
    @SuppressWarnings("unchecked")
    public void init() throws ServletException {
        // ��web.xml�ж�ȡdebugģʽ
        debug = (new Boolean(getInitParameter("debug"))).booleanValue();
        if (debug)
            System.out.println("\r\n---- SimpleUploaderServlet initialization started ----");
        // ��ʽ��Ŀ¼���ļ�������ʽ
        dirFormatter = new SimpleDateFormat("yyyyMM");
        fileFormatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        // ��web.xml�л�ȡ��Ŀ¼����
        baseDir = getInitParameter("baseDir");
        // ��web.xml�л�ȡ�Ƿ���Խ����ļ��ϴ�
        enabled = (new Boolean(getInitParameter("enabled"))).booleanValue();
        if (baseDir == null)
            baseDir = "/UserFiles/";
        //��ȡ��Ŀ¼��·��
        String realBaseDir = getServletContext().getRealPath(baseDir);
        //������Ŀ¼�ļ���
        File baseFile = new File(realBaseDir);
        if (!baseFile.exists()) {
            baseFile.mkdirs();
        }
        // ʵ�����������չ������ֹ����չ��
        allowedExtensions = new Hashtable(3);
        deniedExtensions = new Hashtable(3);
        // ��web.xml�ж�ȡ������Ϣ
        allowedExtensions.put("File",
                stringToArrayList(getInitParameter("AllowedExtensionsFile")));
        deniedExtensions.put("File",
                stringToArrayList(getInitParameter("DeniedExtensionsFile")));

        allowedExtensions.put("Image",
                stringToArrayList(getInitParameter("AllowedExtensionsImage")));
        deniedExtensions.put("Image",
                stringToArrayList(getInitParameter("DeniedExtensionsImage")));

        allowedExtensions.put("Flash",
                stringToArrayList(getInitParameter("AllowedExtensionsFlash")));
        deniedExtensions.put("Flash",
                stringToArrayList(getInitParameter("DeniedExtensionsFlash")));
        if (debug)
            System.out.println("---- SimpleUploaderServlet initialization completed ----\r\n");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (debug)
            System.out.println("--- BEGIN DOPOST ---");
        //���ñ����ʽ
        response.setContentType("text/html; charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control", "no-cache");
        //��ȡ�����
        PrintWriter out = response.getWriter();
        // ����������л�ȡ�ϴ��ļ������ͣ�File/Image/Flash
        String typeStr = request.getParameter("Type");
        if (typeStr == null) {
            typeStr = "File";
        }
        if (debug)
            System.out.println(typeStr);
        // ʵ����dNow���󣬻�ȡ��ǰʱ��
        Date dNow = new Date();
        // �趨�ϴ��ļ�·��
        String currentPath = baseDir + typeStr + "/"
                + dirFormatter.format(dNow);
        // ���webӦ�õ��ϴ�·��
//        String currentDirPath1 = getServletContext().getRealPath(currentPath);

        String currentDirPath = PicPath+ "\\"
                + dirFormatter.format(dNow);
//        System.out.println(currentDirPath);
//        System.out.println(currentDirPath1);
//        System.out.println("baseDir:"+baseDir+"\n"+
//                "dirFormatter.format(dNow)="+dirFormatter.format(dNow)+"\n"+
//                "currentPath="+currentPath);
        // �ж��ļ����Ƿ���ڣ��������򴴽�
        File dirTest = new File(currentDirPath);
        if (!dirTest.exists()) {
            dirTest.mkdirs();
        }
        // ��·��ǰ����webӦ����
        currentPath = request.getContextPath() + currentPath;
//        System.out.println(currentPath);
        if (debug)
            System.out.println(currentDirPath);
        // �ļ������ļ���ʵ·��
        String newName = "";
        String fileUrl = "";
        String fileName = "";
        if (enabled) {
            // ʹ��Apache Common����е�fileupload�����ļ��ϴ�
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            try {
                List items = upload.parseRequest(request);
                Map fields = new HashMap();
                Iterator iter = items.iterator();
                while (iter.hasNext()) {
                    FileItem item = (FileItem) iter.next();
                    if (item.isFormField())
                        fields.put(item.getFieldName(), item.getString());
                    else
                        fields.put(item.getFieldName(), item);
                }
                // CEKditor��file���nameֵ��upload
                FileItem uplFile = (FileItem) fields.get("upload");
                // ��ȡ�ļ�����������
                String fileNameLong = uplFile.getName();
                fileNameLong = fileNameLong.replace('\\', '/');
                String[] pathParts = fileNameLong.split("/");
                fileName = pathParts[pathParts.length - 1];
                // ��ȡ�ļ���չ��
                String ext = getExtension(fileName);
                // �����ϴ��ļ���
                fileName = fileFormatter.format(dNow) + "." + ext;
                // ��ȡ�ļ���(����չ��)
                String nameWithoutExt = getNameWithoutExtension(fileName);

                File pathToSave = new File(currentDirPath, fileName);
//                fileUrl = currentPath + "/" + fileName;
                fileUrl =  "/pic/" + dirFormatter.format(dNow)+"/"+ fileName;
                if (extIsAllowed(typeStr, ext)) {
                    int counter = 1;
                    while (pathToSave.exists()) {
                        newName = nameWithoutExt + "_" + counter + "." + ext;
                        fileUrl = currentPath + "/" + newName;
                        pathToSave = new File(currentDirPath, newName);
                        counter++;
                    }
                    uplFile.write(pathToSave);
                } else {
                    if (debug)
                        System.out.println("��Ч���ļ����ͣ� " + ext);
                }
            } catch (Exception ex) {
                if (debug)
                    ex.printStackTrace();
            }
        } else {
            if (debug)
                System.out.println("δ����CKEditor�ϴ�����");
        }
        // CKEditorFuncNum�ǻص�ʱ��ʾ��λ�ã��������������
//        String callback = request.getParameter("CKEditorFuncNum");
        //�ص���ʾ����json����
        /*
            uploaded- �ϴ��ɹ�����Ϊ1�����ɹ�Ϊ0��
            fileName - �ϴ��ļ������ơ�
            url - �ϴ��ļ���URL��URL���룩��
         */
        String json = "{\"uploaded\": 1,\"filename\": \""+fileName+"\",\"url\":\""+fileUrl+"\"}";
        out.print(json);
        out.flush();
        out.close();
        if (debug)
            System.out.println("--- END DOPOST ---");
    }

    /**
     * ��ȡ�ļ����ķ���
     */
    private static String getNameWithoutExtension(String fileName) {
        return fileName.substring(0, fileName.lastIndexOf("."));
    }

    /**
     * ��ȡ��չ���ķ���
     */
    private String getExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    /**
     * �ַ�����ArrayListת���ķ���
     */

    private ArrayList stringToArrayList(String str) {
        if (debug)
            System.out.println(str);
        String[] strArr = str.split("\\|");
        ArrayList tmp = new ArrayList();
        if (str.length() > 0) {
            for (int i = 0; i < strArr.length; ++i) {
                if (debug)
                    System.out.println(i + " - " + strArr[i]);
                tmp.add(strArr[i].toLowerCase());
            }
        }
        return tmp;
    }

    /**
     * �ж���չ���Ƿ�����ķ���
     */
    private boolean extIsAllowed(String fileType, String ext) {
        ext = ext.toLowerCase();
        ArrayList allowList = (ArrayList) allowedExtensions.get(fileType);
        ArrayList denyList = (ArrayList) deniedExtensions.get(fileType);
        if (allowList.size() == 0) {
            if (denyList.contains(ext)) {
                return false;
            } else {
                return true;
            }
        }
        if (denyList.size() == 0) {
            if (allowList.contains(ext)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

}