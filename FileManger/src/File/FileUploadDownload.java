package File;


import java.sql.Date;

public class FileUploadDownload {
    private String id;
    private String uuidname; //�ϴ��ļ������ƣ��ļ���uuid��
    private String filename; //�ϴ��ļ�����ʵ����
    private String savepath; //��ס�ļ���λ��
    private Date uploadtime; //�ļ��ϴ�ʱ��
    private String miaoshu; //��Ŀ����
    private String username; //�ϴ���

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUuidname() {
        return uuidname;
    }

    public void setUuidname(String uuidname) {
        this.uuidname = uuidname;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getSavepath() {
        return savepath;
    }

    public void setSavepath(String savepath) {
        this.savepath = savepath;
    }

    public Date getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
    }

    public String getMiaoshu() {
        return miaoshu;
    }

    public void setMiaoshu(String miaoshu) {
        this.miaoshu = miaoshu;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
