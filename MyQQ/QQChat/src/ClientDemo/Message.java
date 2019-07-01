package ClientDemo;

import java.io.Serializable;
import java.net.Socket;

/**
 * 各种消息的获取和设置
 */
public class Message implements Serializable {
    private String id;
    private String name;
    private String password;
    private String filename;
    private int type;
    private boolean islog;//判单是允许登录
    private int filelength;
    private String hisname;//对方的名字
    private String ip;
    private int port;
    private String  text;//发送的消息
    private transient Socket socket;



    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isIslog() {
        return islog;
    }

    public void setIslog(boolean islog) {
        this.islog = islog;
    }

    public int getFilelength() {
        return filelength;
    }

    public void setFilelength(int filelength) {
        this.filelength = filelength;
    }

    public String getHisname() {
        return hisname;
    }

    public void setHisname(String hisname) {
        this.hisname = hisname;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
