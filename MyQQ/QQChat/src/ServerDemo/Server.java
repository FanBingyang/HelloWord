package ServerDemo;

import ClientDemo.Message;
import ClientDemo.Type;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class Server extends Thread{
    private int PORT = 8000;
    static ServerSocket ss;
    static ArrayList<Socket> connections;//该集合存储所有Socket流
    static ArrayList<ClientRun> clients;//该集合存储所有的ClientRun的线程
    private Houtai houtai;
    public Server(Houtai houtai){
        System.out.println("加载服务器。。。");
        this.houtai = houtai;
    }

    public void run(){
        int port = PORT;
        try {
            ss = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("初始化ServerSocket异常");
        }
        while (true){
            try {
                Socket s = ss.accept();
                ClientRun cr = new ClientRun(s,houtai);//每次接收请求就启动一个用户线程
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取所有用户的线程
     * @return
     */
    public static ArrayList getClients(){
        return clients;
    }

    /**
     * 与好友聊天，拿到好友的Message，进行操作
     * @param s
     * @return true：找到好友，false：没有找到好友
     */
    public static boolean Talk(Message s){
        if(clients!=null){
            for(Iterator i = clients.iterator();i.hasNext();){
                ClientRun c = (ClientRun)i.next();
                if (c.getName().equals(s.getHisname())){
                    try {
                        MyObjectOutputStream out = new MyObjectOutputStream(c.getSocket().getOutputStream());
                        out.writeObject(s);//将好友信息发给客户端
                        out.flush();
                        return true;//在线程集合中找到好友，返回true
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return false;//找不到，返回false
    }


    /**
     * 群聊,通过集合迭代获取所有人的通信流，并将信息发送
     * @param s
     */
    public static void talkAll(Message s){
        for(Iterator i = clients.iterator();i.hasNext();){
            ClientRun c = (ClientRun) i.next();
        }
        if (connections!=null){
            for (Iterator it = connections.iterator();it.hasNext();){
                try{
                    MyObjectOutputStream out = new MyObjectOutputStream(((Socket)it.next()).getOutputStream());
                    out.writeObject(s);
                    out.flush();
                }catch (IOException ie){
                    ie.printStackTrace();
                }
            }
        }
    }

    /**
     * 用户登录成功后，将其Socket流和线程ClientRun添加到服务器的相应集合中
     * @param s
     * @param cr
     */
    public static void addConnections(Socket s,ClientRun cr){
        if(connections==null){
            connections = new ArrayList<Socket>();
        }
        connections.add(s);

        if (clients==null){
            clients = new ArrayList<ClientRun>();
        }
        clients.add(cr);
    }

    /**
     * 删除线程，当用户退出登录或者与服务器断开连接时，将用户从集合中删除
     * @param s
     * @param cr
     * @throws Exception
     */
    public static void deletConnections(Socket s,ClientRun cr) throws Exception{
        if(connections!=null){
            connections.remove(s);
            s.close();
        }
        if(clients!=null){
            clients.remove(cr);
        }
    }

    /**
     * 关闭服务器时的操作，给所有用户发送消息
     */
    public void breaklink() {
        Message m = new Message();
        System.out.println("服务器被关闭");
        m.setName("服务器");
        m.setType(Type.serverbreak);
        Server.talkAll(m);
    }



    }
