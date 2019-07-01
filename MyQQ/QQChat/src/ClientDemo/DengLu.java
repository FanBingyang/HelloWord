package ClientDemo;



import ServerDemo.DBUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.*;
import java.sql.ResultSet;


public class DengLu extends JFrame implements ActionListener {
    private Socket socket;// 套接字
    private String hostName = "localhost";
    private static int PORT = 8000;
    private JButton enter,login;
    private JRadioButton rem,ent;
    private ImageIcon img,img1,en,lo;
    private Image imkit;
    private JLabel icon,icon1,jl1,jl2;
    private JTextField id;
    private JPasswordField pw;
    private Toolkit kit;//图标
    private ObjectInputStream in;//输入流
    private ObjectOutputStream out;//输出流
    private Desktop dp;//桌面
    public DengLu(){
        super("QQ");
        Container c = getContentPane();
        c.setLayout(null);

        //登录界面
        img = new ImageIcon("src/img/denglu.jpg");
        img.setImage(img.getImage().getScaledInstance(600,200,Image.SCALE_DEFAULT));
        icon = new JLabel(img);
        icon.setBounds(0,0,600,200);
        c.add(icon);
        //将原图片压缩为指定大小
        img1 = new ImageIcon( "src/img/timg.jpg");
        img1.setImage(img1.getImage().getScaledInstance(125,125,Image.SCALE_DEFAULT));
        //登录时显示默认头像
        icon1 = new JLabel(img1);
        icon1.setBounds(25,220,130,125);
        c.add(icon1);

        //设置账号行
        jl1 = new JLabel("账号：");
        jl1.setFont(new Font("宋体",Font.PLAIN,15));
        id = new JTextField();
        jl1.setBounds(160,230,50,30);
        id.setBounds(220,230,300,30);
        c.add(jl1);
        c.add(id);

        //设置密码行
        jl2 = new JLabel("密码：");
        jl2.setFont(new Font("宋体",Font.PLAIN,15));
        pw = new JPasswordField();
        jl2.setBounds(160,280,50,30);
        pw.setBounds(220,280,300,30);
        c.add(jl2);
        c.add(pw);

        //设置记住密码和自动登录
        rem = new JRadioButton("记住密码");
        rem.setBounds(220,315,140,20);
        c.add(rem);
        ent = new JRadioButton("自动登录");
        ent.setBounds(380,315,140,20);
        c.add(ent);

        //设置登录注册
        en = new ImageIcon("src/img/ent.jpg");
        enter = new JButton(en);
        enter.setBounds(220,345,140,50);
        enter.addActionListener(this);
        c.add(enter);
        lo = new ImageIcon("src/img/log.jpg");
        login = new JButton(lo);
        login.setBounds(380,345,140,50);
        login.addActionListener(this);
        c.add(login);

        //设置窗口图标
        kit = Toolkit.getDefaultToolkit();
        imkit = kit.createImage("src/img/timg.jpg");
        this.setIconImage(imkit);

        this.setSize(600,450);
        this.setLocation(500,150);
        this.setVisible(true);
        this.setResizable(false);     //设置窗口大小不可改变
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    //对按钮进行监听
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==login)
        {
            openurl();
        }
        if (e.getSource()==enter)
        {
            if (id.getText().equals("")){
                JOptionPane.showMessageDialog(this,"请输入账号");
            }else if (pw.getText().equals("")){
                JOptionPane.showMessageDialog(this,"请输入密码");
            }else {
                try {
                    link();
                    Message m=null;
                    m=(Message) in.readObject();//接收服务器返回的信息
                    if (m.isIslog()){//判断服务器给出的信息是否允许登录
                        FriendView f=new FriendView(out,in,m.getName(),id.getText(),socket);
                        this.dispose();
                    }else {
                        JOptionPane.showMessageDialog(this,"账号或密码错误");
                    }
                }catch (Exception te){
                    JOptionPane.showMessageDialog(this,"与服务器连接异常");
                    te.printStackTrace();
                }
            }
        }
    }
    public void link() throws Exception{

        socket=new Socket(hostName,PORT);
        Message m=new Message();
        m.setType(ClientDemo.Type.login);
        m.setId(id.getText());

        ResultSet rs = DBUtils.getUsername(id.getText());
        rs.next();
        m.setName(rs.getString("name"));

        m.setPassword(pw.getText());
        out=new ObjectOutputStream(socket.getOutputStream());
        in=new ObjectInputStream(socket.getInputStream());
        out.writeObject(m);
        out.flush();
    }


    public void openurl(){

        if(java.awt.Desktop.isDesktopSupported()){
            try{
                //创建一个URI实例,注意不是URL
                URI uri=URI.create("http://10.85.16.12:8080/index.jsp");
                //获取当前系统桌面扩展
                dp=Desktop.getDesktop();
                //判断系统桌面是否支持要执行的功能
                if(dp.isSupported(Desktop.Action.BROWSE) && dp.isDesktopSupported()){
                    //获取系统默认浏览器打开链接
                    dp.browse(uri);
                }
            }catch(java.lang.NullPointerException e){
                //此为uri为空时抛出异常
            }catch(java.io.IOException e){
                //此为无法获取系统默认浏览器
            }
        }
    }
    public static void main(String[] args) {
        new DengLu();
    }
}