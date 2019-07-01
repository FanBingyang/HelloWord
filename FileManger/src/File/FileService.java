package File;

import java.util.List;

//�ϴ��ļ���ҵ���
public class FileService {

    //FileDaoImplʵ����ʵ��
    FileDao f = FileDaoFactory.getInstance().createDao(FileDao.class);

    //�ϴ��ļ�
    public void insert(FileUploadDownload fud){
        f.insert(fud);//����dao��������
    }

    //��ѯ�ļ�
    public List<FileUploadDownload> list(){
        List<FileUploadDownload> list = f.list();
        return list;
    }

    //ͨ��id���ȫ���ļ������ȫ����Ϣ
    public FileUploadDownload select(String id){
        FileUploadDownload fud = f.select(id);
        return fud;
    }

}
