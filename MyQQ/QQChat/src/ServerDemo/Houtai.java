package ServerDemo;

import ClientDemo.Message;
import ClientDemo.TimeDemo;
import ClientDemo.Type;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class Houtai extends JFrame implements ActionListener {
    private JScrollPane jScrollPane;
    private JTextArea jt;
    private JButton begin,end;
    private Server server;
    private TimeDemo time;
    public Houtai(){
        super("服务器后台");
        this.setLayout(null);
        time = new TimeDemo();

        begin = new JButton("启动服务器");
        begin.setBounds(0,0,100,40);
        begin.setContentAreaFilled(false);//设置按钮为无色
        begin.addActionListener(this);
        this.add(begin);
        end = new JButton("关闭服务器");
        end.setBounds(100,0,100,40);
        end.setContentAreaFilled(false);
        end.setEnabled(false);//设置按钮不可编辑，防止未开启就直接关闭服务器而引起的异常
        end.addActionListener(this);
        this.add(end);

        jt = new JTextArea();
        jt.setBounds(0,45,500,400);
        jt.setLineWrap(true);//自动换行
        jt.setWrapStyleWord(true);//断行不断字
        jScrollPane = new JScrollPane(jt);
        jScrollPane.setBounds(0,45,500,400);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);//竖直滚动条
        this.add(jScrollPane);

        this.setVisible(true);
        this.setSize(500,500);
        this.setLocation(200,220);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * 事件监听
     * @param e
     */
    public void  actionPerformed(ActionEvent e){
        if(e.getSource()==begin){
            jt.append("正在启动服务器");
            for (int i=0;i<10;i++){
                jt.append(" ●");
            }
            end.setEnabled(true);
            begin.setEnabled(false);
            jt.append("\n服务器启动  (｡･∀･)ﾉﾞ嗨\n");
            server = new Server(this);
            server.start();
        }
        if (e.getSource()==end){
            server.breaklink();
            server.interrupt();
            jt.append("\n服务器关闭!!!");
        }
    }

    /**
     * 后台根据数据类型随时显示出客户端的动态
     * @param message
     */
    public void inster(Message message){
        if(message.getType()== ClientDemo.Type.login){
            jt.append(time.getTime()+" "+message.getName()+" 登录上线\n");
        }
        else if(message.getType()== ClientDemo.Type.loginout){
            jt.append(time.getTime()+" "+message.getName()+" 退出登录\n");
        }
        else if(message.getType()== ClientDemo.Type.sendfile){
            jt.append(time.getTime()+" "+message.getName()+"准备向"+message.getHisname()+"发送文件\n");
        }
        else if(message.getType()== ClientDemo.Type.canclefile){
            jt.append(time.getTime()+" "+message.getName()+" 取消了文件的发送\n");
        }
        else if(message.getType()== ClientDemo.Type.acceptfile){
            jt.append(time.getTime()+" "+message.getName()+"接收了"+message.getHisname()+"发送的文件\n");
        }
        else if(message.getType()== ClientDemo.Type.refusefile){
            jt.append(time.getTime()+" "+message.getName()+"拒绝接收"+message.getHisname()+" 发送的文件\n");
        }
        else if(message.getType()== ClientDemo.Type.addfriend){
            jt.append(time.getTime()+" "+message.getName()+"将"+message.getHisname()+"添加为好友\n");
        }
        else if(message.getType()== ClientDemo.Type.deletefriend){
            jt.append(time.getTime()+" "+message.getName()+"将"+message.getHisname()+"从好友列表删除\n");
        }
        else if(message.getType()== ClientDemo.Type.talk){
            jt.append(time.getTime()+" "+message.getName()+"给"+message.getHisname()+"发送消息："+message.getText()+"\n");
        }
        else if(message.getType()== ClientDemo.Type.talkall){
            jt.append(time.getTime()+" "+message.getName()+"发送了群聊消息："+message.getText()+"\n");
        }
    }



    public static void main(String[] args) {
        new Houtai();
    }
}
