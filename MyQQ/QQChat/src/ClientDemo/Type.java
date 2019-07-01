package ClientDemo;

/**
 * 定义规范字
 */
public interface Type {
    public static int login = 1;//登录
    public static int loginout = 2;//退出
    public static int getfriendlist = 3;//获取好友列表
    public static int talk = 4;//私聊
    public static int sendfile = 5;//发文件
    public static int canclefile = 6;//取消发送
    public static int acceptfile = 7;//接收文件
    public static int refusefile = 8;//拒绝接收
    public static int addfriend = 9;//添加好友
    public static int deletefriend = 10;//删除好友
    public static int talkall = 11;//群聊
    public static int serverbreak = 12;//断开服务器

}
