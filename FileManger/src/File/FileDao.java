package File;

import java.util.List;

//dao接口
public interface FileDao {
    public void insert(FileUploadDownload fud);//上传文件

    public List<FileUploadDownload> list();//查询文件

    public FileUploadDownload select(String id);//通过id获得文件的全部信息、

}
