package File;

import java.util.List;

//dao�ӿ�
public interface FileDao {
    public void insert(FileUploadDownload fud);//�ϴ��ļ�

    public List<FileUploadDownload> list();//��ѯ�ļ�

    public FileUploadDownload select(String id);//ͨ��id����ļ���ȫ����Ϣ��

}
