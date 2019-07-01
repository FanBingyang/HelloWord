package ClientDemo;

import ServerDemo.DBUtils;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.*;

public class FriendView extends JFrame implements ActionListener,MouseListener,Runnable {
    public Thread thread;
    public String myname,id;
    public ObjectOutputStream out;
    public ObjectInputStream in;
    public static HashMap<String,ChatFrame> chat;
    public static HashMap<String,JLabel> friendlist;
    public static HashMap<String,GroupChat> groupchats;
    public Socket socket;

    private ImageIcon img1;
    //背景图层
    ImageIcon background;
    JPanel buttom;
    JLabel imgLabel;
    JTextField jTextField;
    JButton commend,person,search;//群聊，个人信息，搜索查询
    public static JPanel GImage = null;
    private Toolkit kit;
    private Image imkit;

    //上层北边
    JLabel head,name,sign,qianming;
    private ResultSet rs = null;

    //上层南边
    JPanel jp;//卡片布局
    CardLayout cl;

    //第一张卡片
    JPanel jp1;
    JButton jp1_jb1,jp1_jb2,jp1_jb3;

    //第二张卡片
    JPanel jp2;
    JScrollPane jsp;
    JPanel jp_jsp;//用来放jsp
    JButton jp2_jb1,jp2_jb2,jp2_jb3;

    //第三张卡片
    JPanel jp3;
    JScrollPane jsp2;
    JPanel jp_jsp2;//用来放jsp2
    JButton jp3_jb1,jp3_jb2,jp3_jb3;

    //第四张卡片
    JPanel jp4;
    JScrollPane jsp3;
    JPanel jp_jsp3;
    JButton jp4_jb1,jp4_jb2,jp4_jb3;



    //构造函数
    public FriendView(ObjectOutputStream out,ObjectInputStream in,String myname,String id,Socket socket)
    {
        super("QQ");
        this.socket=socket;
        this.myname=myname;
        this.id = id;
        this.out=out;
        this.in=in;
        friendlist=new HashMap<String, JLabel>();
        chat=new HashMap<String, ChatFrame>();
        groupchats=new HashMap<String, GroupChat>();


        //处理背景
        backGround();

        // 利用JPanel添加背景图片
        GImage = new JPanel() {
            protected void paintComponent(Graphics g) {
                ImageIcon icon = new ImageIcon("src/img/zhuti.jpg");
                icon.setImage(icon.getImage().getScaledInstance(283,165,Image.SCALE_DEFAULT));
                Image img = icon.getImage();
                g.drawImage(img, 0, 0, icon.getIconWidth(),
                        icon.getIconHeight(), icon.getImageObserver());

            }
        };
        GImage.setLayout(null);
        GImage.setBounds(0,0,283,165);

        //处理北边的东西（头像，昵称，签名）

        img1 = new ImageIcon( "src/img/touxiang.PNG");
        img1.setImage(img1.getImage().getScaledInstance(100,120, Image.SCALE_DEFAULT));
        head = new JLabel(img1);
        head.setBounds(10, 20, 100, 120);
        name = new JLabel(myname);
        name.setBounds(120, 50, 80, 20);
        name.setFont(new Font("宋体",Font.BOLD, 16));
        name.setForeground(Color.black);
        sign = new JLabel("个性签名：");
        sign.setBounds(120, 80, 80, 20);
        sign.setForeground(Color.black);

        qianming = new JLabel();
        rs = DBUtils.getQianming(myname);
        try {
            rs.next();
            qianming.setText(rs.getString("qianming"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        qianming.setBounds(205,80,90,20);
        this.add(qianming);


        jTextField = new JTextField("输入姓名进行搜索查询");
        jTextField.setBounds(0,166,280,28);
        commend=new JButton("进入群聊");
        commend.setContentAreaFilled(false);
        commend.setBounds(0,195,91,40);
        commend.addActionListener(this);
        person=new JButton("个人信息");
        person.setContentAreaFilled(false);
        person.setBounds(91,195,91,40);
        person.addActionListener(this);
        search=new JButton("搜索查询");
        search.setContentAreaFilled(false);
        search.setBounds(182,195,91,40);
        search.addActionListener(this);

        //设置好友列表为卡片布局
        cl = new CardLayout();
        jp = new JPanel();
        jp.setOpaque(false);
        jp.setBounds(0, 235, background.getIconWidth(), background.getIconHeight());

        //处理第一张卡片
        firstCard();
        //处理第二张卡片
        secondCard();
        //处理第三张卡片
        thirdCard();
        //处理第四张卡片
        fourthCard();
        GImage.add(head);
        GImage.add(name);
        GImage.add(sign);
        this.add(GImage);
        this.setBackground(Color.white);
        this.add(jTextField);
        this.add(commend);
        this.add(person);
        this.add(search);
        jp.setLayout(cl);
        jp.add(jp1,"1");
        jp.add(jp2,"2");
        jp.add(jp3,"3");
        jp.add(jp4,"4");
        this.add(jp);
        //设置窗口图标
        kit = Toolkit.getDefaultToolkit();
        imkit = kit.createImage("src/img/timg.jpg");
        this.setIconImage(imkit);
        this.getLayeredPane().setLayout(null);
        this.setLayout(null);
        this.setSize(283, 720);
        this.setLocation(800, 30);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        thread=new Thread(this);
        thread.start();
        /**
            对当前窗口进行监听，当关闭窗口时退出登录，
            向好友发送自己下线通知，好友收到后刷新好友列表
         */
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                FriendView.this.Logout();//调用退出时的方法
                System.exit(0);//结束运行
            }
        });

    }

    //处理背景方法
    public void backGround()
    {
        background = new ImageIcon("src/img/zhuti.jpg");
        imgLabel = new JLabel(background);
        imgLabel.setBounds(0, 0,  background.getIconWidth(), background.getIconHeight());
        buttom=(JPanel)this.getContentPane();
        //将contentPane设置为透明的
        buttom.setOpaque(false);
        //this.getLayeredPane().add(imgLabel , new Integer(Integer.MIN_VALUE));
    }

    //处理第一张卡片方法
    public void firstCard()
    {
        jp1 = new JPanel();

        jp1_jb1 = new JButton("> 我的好友");
        jp1_jb1.addActionListener(this);
        jp1_jb1.setLayout(null);
        jp1_jb1.setSize(277, 35);
        jp1_jb1.setHorizontalAlignment(SwingConstants.LEFT );

        jp1_jb2 = new JButton("> 陌生人");
        jp1_jb2.addActionListener(this);
        jp1_jb2.setLayout(null);
        jp1_jb2.setBounds(0, 35, 277, 35);
        jp1_jb2.setHorizontalAlignment(SwingConstants.LEFT );

        jp1_jb3 = new JButton("> 黑名单");
        jp1_jb3.addActionListener(this);
        jp1_jb3.setLayout(null);
        jp1_jb3.setBounds(0, 70, 277, 35);
        jp1_jb3.setHorizontalAlignment(SwingConstants.LEFT );

        jp1.add(jp1_jb1);
        jp1.add(jp1_jb2);
        jp1.add(jp1_jb3);
        jp1.setLayout(null);
        jp1.setOpaque(false);
    }

    //处理第二张卡片方法
    public void secondCard()
    {
        jp2 = new JPanel();

        jp2_jb1 = new JButton("↓ 我的好友");
        jp2_jb1.addActionListener(this);
        jp2_jb1.setLayout(null);
        jp2_jb1.setSize(277, 35);
        jp2_jb1.setHorizontalAlignment(SwingConstants.LEFT );

        jp2_jb2 = new JButton("> 陌生人");
        jp2_jb2.addActionListener(this);
        jp2_jb2.setLayout(null);
        jp2_jb2.setBounds(0, 354, 277, 35);
        jp2_jb2.setHorizontalAlignment(SwingConstants.LEFT );

        jp2_jb3 = new JButton("> 黑名单");
        jp2_jb3.addActionListener(this);
        jp2_jb3.setLayout(null);
        jp2_jb3.setBounds(0, 389, 277, 35);
        jp2_jb3.setHorizontalAlignment(SwingConstants.LEFT );


        jp_jsp = new JPanel(new GridLayout(30,1));
        jsp = new JScrollPane(jp_jsp);

        jsp.setBounds(1, 35, 275, 319);
        jp2.add(jsp);
        jp2.add(jp2_jb1);
        jp2.add(jp2_jb2);
        jp2.add(jp2_jb3);
        jp2.setLayout(null);
        jp2.setOpaque(false);
    }

    //处理第三张卡片方法
    public void thirdCard()
    {
        jp3 = new JPanel();

        jp3_jb1 = new JButton("> 我的好友");
        jp3_jb1.addActionListener(this);
        jp3_jb1.setLayout(null);
        jp3_jb1.setSize(277, 35);
        jp3_jb1.setHorizontalAlignment(SwingConstants.LEFT );

        jp3_jb2 = new JButton("↓ 陌生人");
        jp3_jb2.addActionListener(this);
        jp3_jb2.setLayout(null);
        jp3_jb2.setBounds(0, 35, 277, 35);
        jp3_jb2.setHorizontalAlignment(SwingConstants.LEFT );

        jp3_jb3 = new JButton("> 黑名单");
        jp3_jb3.addActionListener(this);
        jp3_jb3.setLayout(null);
        jp3_jb3.setBounds(0, 389, 277, 35);
        jp3_jb3.setHorizontalAlignment(SwingConstants.LEFT );

        //假定30个好友
        jp_jsp2 = new JPanel(new GridLayout(10,1));
        jsp2 = new JScrollPane(jp_jsp2);

        //初始化10个陌生人
        JLabel[] jbls = new JLabel[10];
        for(int i=0; i<jbls.length; i++)
        {
            jbls[i] = new JLabel(i+1+"号陌生人", new ImageIcon("src/img/laji.png"), JLabel.LEFT);
            jbls[i].addMouseListener(this);
            jp_jsp2.add(jbls[i]);
        }

        jsp2.setBounds(1, 70, 275, 319);

        jp3.add(jsp2);
        jp3.add(jp3_jb1);
        jp3.add(jp3_jb2);
        jp3.add(jp3_jb3);
        jp3.setLayout(null);
        jp3.setOpaque(false);
    }

    //处理第四张卡片方法
    public void fourthCard()
    {
        jp4 = new JPanel();

        jp4_jb1 = new JButton("> 我的好友");
        jp4_jb1.addActionListener(this);
        jp4_jb1.setLayout(null);
        jp4_jb1.setSize(277, 35);
        jp4_jb1.setHorizontalAlignment(SwingConstants.LEFT );

        jp4_jb2 = new JButton("> 陌生人");
        jp4_jb2.addActionListener(this);
        jp4_jb2.setLayout(null);
        jp4_jb2.setBounds(0, 35, 277, 35);
        jp4_jb2.setHorizontalAlignment(SwingConstants.LEFT );

        jp4_jb3 = new JButton("↓ 黑名单");
        jp4_jb3.addActionListener(this);
        jp4_jb3.setLayout(null);
        jp4_jb3.setBounds(0, 70, 277, 35);
        jp4_jb3.setHorizontalAlignment(SwingConstants.LEFT );

        //假定30个好友
        jp_jsp3 = new JPanel(new GridLayout(10,1));
        jsp3 = new JScrollPane(jp_jsp3);

        //初始化30个好友
        JLabel[] jbls = new JLabel[5];
        for(int i=0; i<jbls.length; i++)
        {
            jbls[i] = new JLabel(i+1+"号黑名单", new ImageIcon("src/img/laji.png"), JLabel.LEFT);
            jbls[i].addMouseListener(this);
            jp_jsp3.add(jbls[i]);
        }

        jsp3.setBounds(1, 105, 275, 319);

        jp4.add(jsp3);
        jp4.add(jp4_jb1);
        jp4.add(jp4_jb2);
        jp4.add(jp4_jb3);
        jp4.setLayout(null);
        jp4.setOpaque(false);
    }

    //按钮监听方法
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==commend){//进入群聊
            if (!groupchats.containsKey("群聊")){
                GroupChat c=new GroupChat(myname,out);
                groupchats.put("群聊",c);
            }
        }

        //第一张卡片的按钮
        if(e.getSource()==jp1_jb1)
        {
            cl.show(jp, "2");;
        }
        if(e.getSource()==jp1_jb2)
        {
            cl.show(jp, "3");;
        }
        if(e.getSource()==jp1_jb3)
        {
            cl.show(jp, "4");;
        }

        //第二张卡片的按钮
        if(e.getSource()==jp2_jb1)
        {
            cl.show(jp, "1");
        }
        if(e.getSource()==jp2_jb2)
        {
            cl.show(jp, "3");
        }
        if(e.getSource()==jp2_jb3)
        {
            cl.show(jp, "4");
        }

        //第三张卡片的按钮
        if(e.getSource()==jp3_jb1)
        {
            cl.show(jp, "2");
        }
        if(e.getSource()==jp3_jb2)
        {
            cl.show(jp, "1");
        }
        if(e.getSource()==jp3_jb3)
        {
            cl.show(jp, "4");
        }

        //第四张卡片的按钮
        if(e.getSource()==jp4_jb1)
        {
            cl.show(jp, "2");
        }
        if(e.getSource()==jp4_jb2)
        {
            cl.show(jp, "3");
        }
        if(e.getSource()==jp4_jb3)
        {
            cl.show(jp, "1");
        }
        if (e.getSource()==person){
            new Person(myname);
        }
        if (e.getSource()==search){
            if(jTextField.getText().trim().length()==0 || jTextField.getText().equals("输入姓名进行搜索查询"))
                JOptionPane.showMessageDialog(this,"请输入姓名进行搜索查询！");
            else if(jTextField.getText().equals(myname)){
                new Person(myname);
            } else {
                Message m = new Message();
                m.setName(myname);
                m.setHisname(jTextField.getText());
                new YongHu(m,out,this);
                jTextField.setText("");
            }


        }

    }

    /**
     * 点击好友并打开与其聊天的窗口
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getClickCount()==2)//双击打开对话框
        {
            String str = ((JLabel)e.getSource()).getText();//拿到标签上的文字，即要聊天好友的名字
           if (!chat.containsKey(str)){//查看与该好友的聊天界面是否存在，不存在则创建并加入集合
                ChatFrame s= null;
                s = new ChatFrame(myname,str,out,in,socket);
                chat.put(str,s);
            }
        }
    }

    /**
     * 用户关闭好友列表窗口时执行的方法，通知好友自己下线了
     */
    public void Logout(){
        Message logoutMessage = new Message();
        logoutMessage.setName(myname);
        logoutMessage.setType(ClientDemo.Type.loginout);
        try {
            out.writeObject(logoutMessage);
            out.close();
            in.close();
            thread.interrupt();
            socket.close();
        } catch (IOException e) {
//            e.printStackTrace();
            System.out.println("退出时关闭流错误");
        }
    }

    /**
     * 删除好友或关闭聊天窗口后，将对话窗口从集合中移除
     * @param name
     */
    public  static void deleteChat(String name){
        chat.remove(name);
    }

    /**
     * 从群聊集合中删除
     */
    public static void deleteGroupChat(String s){
        groupchats.remove(s);
    }

    /**
     * 删除好友时好友列表操作
     * @param me
     */
    public void deletefriend(Message me){
        try {
            out.writeObject(me);
            out.flush();
//            if(friendlist.containsKey(me.getHisname())){
            System.out.printf(friendlist.get(me.getHisname()).toString()+"  ahgf ");
                jp_jsp.remove(friendlist.get(me.getHisname()));//在好友列表中将好友标签删除
                friendlist.remove(me.getHisname());
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加好友时好友列表操作
     * @param me
     */
    public void addfriend(Message me){
        try {
            out.writeObject(me);
            out.flush();
            JLabel a = new JLabel(me.getHisname(),new ImageIcon("src/img/huaji.png"),JLabel.LEFT);
            a.addMouseListener(this);
            jp_jsp.add(a);
            friendlist.put(me.getHisname(),a);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JLabel jl =(JLabel)e.getSource();
        jl.setForeground(Color.red);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        JLabel jl =(JLabel)e.getSource();
        jl.setForeground(Color.black);
    }

    public void run(){
        while (true){
            Message message = null;
            ChatFrame chatframe = null;
            GroupChat gc = null;
            try {
                message = (Message)in.readObject();//读到好友的信息
//                System.out.println(message.getName()+"请求类型："+message.getType());
                if(message.getName().length()!=0){
                    //判断接收到的类型，并且分配给不同的处理机制（窗口）
                    if(message.getType()== ClientDemo.Type.talk || message.getType()== ClientDemo.Type.sendfile || message.getType()== ClientDemo.Type.canclefile || message.getType()== ClientDemo.Type.acceptfile || message.getType()== ClientDemo.Type.refusefile)
                    {
//                        接收消息时播放音频
//                        File sound = new File("src/img/msg.wav");
//                        URL url = sound.toURL();
//                        AudioClip ac = Applet.newAudioClip(url);
//                        ac.play();

                        if(chat.containsKey(message.getName())){
                            chatframe = chat.get(message.getName());
                            chatframe.reciveMessage(message);
                        }else {
                            //这是的message是好友的message，所以里面Hisname是自己名字，name是好友的的名字，不要弄混了
                            chatframe = new ChatFrame(message.getHisname(),message.getName(),out,in,socket);//聊天窗口不存在就创建窗口
                            chatframe.reciveMessage(message);//将接收到的消息发送给聊天面板
                            chat.put(message.getName(),chatframe);//将窗口加入集合
                        }
                    }
                    else if(message.getType()== ClientDemo.Type.getfriendlist){//如果对方是刚登陆的时候，那就刷新好友列表，也就是再请求一次初始化好友列表
                        String[] ss=message.getText().split("#");
//                        System.out.println(message.getText());
                        for (int i = 0; i < ss.length; i++) {
//                            System.out.printf(ss.length+"aaa"+ss[i]);
                            JLabel a=new JLabel(ss[i], new ImageIcon("src/img/huaji.png"), JLabel.LEFT);
                            a.addMouseListener(this);
                            friendlist.put(ss[i],a);
                        }
                        for (String keys:friendlist.keySet()){
                            jp_jsp.add((JLabel)friendlist.get(keys));
                        }
                    }
                    else if(message.getType()== ClientDemo.Type.login){//当有好友登录时，加入到好友列表集合和群聊集合
                        if (message.getName()!=myname){
                            if(groupchats.containsKey("群聊")){
                                gc =groupchats.get("群聊");
                                gc.reciveMessage(message);
                            }
                            JLabel a = new JLabel(message.getName(),new ImageIcon("src/img/huaji.png"),JLabel.LEFT);
                            a.addMouseListener(this);
                            jp_jsp.add(a);
                            friendlist.put(message.getName(),a);
                        }
                    }
                    else if (message.getType()== ClientDemo.Type.loginout){//如果有好友掉线，就从集合中删除,并且删除好友列表中的标签
                        jp_jsp.remove(friendlist.get(message.getName()));
                        friendlist.remove(message.getName());
                    }
                    else if(message.getType()== ClientDemo.Type.addfriend){//如果是添加好友的请求，
                        JOptionPane.showMessageDialog(this,message.getName()+"添加你为好友！");
                    }
                    else if (message.getType()== ClientDemo.Type.deletefriend){//如果是删除好友的请求，
                        if (chat.containsKey(message.getName())){
                            ChatFrame cf = chat.get(message.getName());
                            cf.dispose();
                            FriendView.deleteChat(message.getName());
                        }
                        if(friendlist.containsKey(message.getName())){
                            JLabel jl = friendlist.get(message.getName());
                            jp_jsp.remove(jl);
                            friendlist.remove(jl);
                        }
                    }
                    else if (message.getType()== ClientDemo.Type.talkall){//如果有人发群聊
                        if(groupchats.containsKey("群聊")){
                            gc= groupchats.get("群聊");
                            gc.reciveMessage(message);
                        }else {
                            gc = new GroupChat(myname,out);
                            gc.reciveMessage(message);
                            groupchats.put("群聊",gc);
                        }
                    }
                    else if (message.getType()== ClientDemo.Type.serverbreak){//如果服务器断开,关闭所有流
                        JOptionPane.showMessageDialog(this,"服务器终止连接");
                        out.close();
                        in.close();
                        socket.close();
                    }
                }



            } catch (IOException e) {
//                e.printStackTrace();
            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
            }
        }
    }

}