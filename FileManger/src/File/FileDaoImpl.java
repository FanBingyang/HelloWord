package File;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class FileDaoImpl implements FileDao{
    QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

    @Override
    public void insert(FileUploadDownload fud){ //�ϴ��ļ�
        /**
         * private String id;
         * private String uuidname; //�ϴ��ļ������ƣ��ļ���uuid��
         * private String filename; //�ϴ��ļ�����ʵ����
         * private String savepath;	//��ס�ļ���λ��
         * private Date uploadtime; //�ļ����ϴ�ʱ��
         * private String description; //�ļ�������
         * private String username;
         */

        Object[] param = {
                fud.getId(),fud.getUuidname(),fud.getFilename(),
                fud.getSavepath(),fud.getMiaoshu(),fud.getUsername()
        };//û��ʱ�䣺fud.getUploadtime()

        try {
            qr.update("insert into file values(?,?,?,?,null,?,?)",param);

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<FileUploadDownload> list(){ //��ѯ�ļ�
        try {
            List<FileUploadDownload> list = qr.query("select * from file",
                    new BeanListHandler<>(FileUploadDownload.class));
            return list;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public FileUploadDownload select(String id) {//ͨ��id����ļ���ȫ����Ϣ
        try {
            FileUploadDownload fud=(FileUploadDownload)qr.query("select * from file where id=?",new BeanHandler(FileUploadDownload.class),id);
            return fud;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
