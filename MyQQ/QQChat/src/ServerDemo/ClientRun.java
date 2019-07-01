package ServerDemo;
/**
 * 用户端的线程
 */

import ClientDemo.Message;
import ClientDemo.Type;

import java.io.*;
import java.net.Socket;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ListIterator;

public class ClientRun implements Runnable{
    Socket socket;
    Thread t;
    Message ms = null;
    Houtai h;
    ObjectOutputStream out1,out2;//输出流，向服务器发送数据
    ObjectInputStream in;//读取流
    private String name=null;
    private String password=null;

    private ResultSet rs;

    //构造方法
    public ClientRun(Socket s,Houtai h) throws Exception{
        this.h=h;
        this.socket=s;
        in = new ObjectInputStream(s.getInputStream());
        out1 = new ObjectOutputStream(s.getOutputStream());
        out2 = new MyObjectOutputStream(s.getOutputStream());
        ms = (Message)in.readObject();
        //验证登录
        if(DBUtils.userSQL(ms.getId(),ms.getPassword())){
            t = new Thread(this);
            t.start();//创建用户线程并且开启
            Server.addConnections(s,this);
            ms.setIslog(true);//将用户添加为允许登录
            out1.writeObject(ms);//将消息写回服务器
            out1.flush();
            h.inster(ms);//将信息在后台显示
         }
         else {//验证失败,返回相应的消息，关闭所有流对象
            ms.setIslog(false);
            out1.writeObject(ms);
            out1.flush();
            in.close();
            out1.close();
            s.close();
        }
    }

    @Override
    public void run(){

        while (name==null){
            name = ms.getName();
            try{
                this.friendList();//加载好友列表
                this.notification(ms);//通知好友自己上线
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("获取好友列表时异常");
            }
        }
        //循环接收消息，并处理
        while (true){
            Message ss = null;//当前用户的信息
            Message m = new Message();
            try {
                ss = (Message) in.readObject();
                //处理退出登录或者掉线
                if(ss.getType()==Type.loginout){
                    m.setType(Type.loginout);
                    m.setName(name);
                    h.inster(m);//告知后台服务器
                    Server.deletConnections(socket,this);//将用户的流和线程从集合中删除
                    Thread.sleep(1000);//等待线程结束，防止继续循环异常
                    notification(m);
                    in.close();
                    socket.close();
                    out1.close();
                }
                //处理群聊
                else if (ss.getType()==Type.talkall){
                    Server.talkAll(ss);
                    h.inster(ss);
                }
                //处理私聊以及文件的发送
                else if(ss.getType()==Type.talk || ss.getType()==Type.sendfile || ss.getType()==Type.canclefile || ss.getType()==Type.acceptfile || ss.getType()==Type.refusefile){
                    Server.Talk(ss);
                    h.inster(ss);
                }
                else if(ss.getType()==Type.addfriend){
//                    System.out.printf("Clientrun:......name:"+ ss.getName()+"----hisname:"+ss.getHisname());
                    DBUtils.addFriend(h,ss);
                }
                else if(ss.getType()==Type.deletefriend) {
                    DBUtils.deleteFriend(h, ss);
                }
            }
            catch (IOException e){
                try{
                    socket.close();
                }catch (IOException e1){
                    e1.printStackTrace();
                }
                return;
            }
            catch (Exception e){
                e.printStackTrace();
                System.out.println("循环接收消息异常");
            }
        }
    }


    /**
     * 当一开始上线的时候，加载此方法，获取数据库中的好友列表并且在线的好友信息，返回给客户端
     * @throws Exception
     */
    public void friendList() throws Exception{
        ArrayList clientList = Server.getClients();
        String yonghu = null;
        if(clientList!=null){
//            System.out.printf("开始加载好友列表\n");
            yonghu="";
            ListIterator<ClientRun> iterator = clientList.listIterator();
            ResultSet rs = DBUtils.getFriendList(ms);
            while (rs.next()){
                while (iterator.hasNext()){
                    ClientRun clr = (ClientRun)iterator.next();
                    String yh = clr.getName();//获取用户信息
                    if (yh.equals(rs.getString("friendname"))){
                        yonghu = yonghu+yh+"#";//结尾处的 # 是标记，再好友列表里面用于切割
                    }
                }
            }
            if (yonghu!=""){
                Message m = new Message();
                m.setHisname(name);
                m.setName(name);
                m.setText(yonghu);//发送上线信息
                m.setType(Type.getfriendlist);
                Server.Talk(m);
            }
        }
    }

    /**
     * 上线上发送好友提醒
     * @param message
     * @throws Exception
     */
    public void notification(Message message) throws Exception{
        ArrayList clientList = Server.getClients();
                        if(clientList!=null){
//            System.out.println("开始通知好友上线提醒");
                            ListIterator<ClientRun> iterator = clientList.listIterator();
                            ResultSet rs = DBUtils.getFriendList(message);//拿到数据库中的好友列表
                            while (rs.next()){
                                while (iterator.hasNext()){
                                    ClientRun clr = (ClientRun)iterator.next();
                                    if(clr.getName().equals(rs.getString("friendname")))
                                    {
                                        message.setHisname(rs.getString("friendname"));
//                        System.out.println("好友上线");
                                        Server.Talk(message);
                    }
                }
            }
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket s) {
        this.socket = s;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
