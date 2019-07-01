package ClientDemo;

import com.sun.xml.internal.ws.api.model.MEP;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatFrame extends JFrame implements ActionListener,MouseListener,KeyListener{
    private JScrollPane textjScrollPane,wordsjScrollPane;//两个滚动面板
    private JTextPane textPane;//消息显示框
    private JTextArea wordsArea;//对话输入框
    private JButton send;//发送信息按钮e
    private JButton cut;//截屏按钮，截屏软件的默认位置C:\Windows\System32\SnippingTool.exe
    private JButton fileButton,getFileButton;//打开文件发送，选择文件按钮
    private JButton sendFileButton;//发送文件按钮
    private JButton acceptFileButton,refuseFileButton;//接收文件和拒绝接收文件
    private MyJTextPanel fileTextPanel;//文件拖拽面板
    private JFileChooser jFileChooser;//文件选择框
    private String filepath,filename;//要发送的文件路径和文件名
    private JPanel leftJPanel,rightJPanel;//左右面板
    private Frame jf;//创建这个对象用于打开文件对话框的时候传入参数
    private TimeDemo time;//时间
    private JPopupMenu popupMenu;//菜单项
    private JMenuItem[] menu;//快捷菜单

    private String myname,hisname;//自己的名字和要聊天用户的名字
    private String saywords;//要发送的信息
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private InputStream inn = null;
    private Socket socket;
    private boolean acceptFileboolean = false;

    //发送文件和接收文件需要的变量
    private ServerSocket fileserversocket;
    private Socket filesocket;
    private Socket acceptfilesocket;
    private String fileIP;
    private int fileport = 8200;
    private Message acceptfileMsg;


    private StyledDocument doc = null;
    protected Font textFont = new Font("宋体",Font.PLAIN,16);
    protected Font wordsFont=new  Font("宋体",Font.PLAIN,15);//编辑区和消息区的默认字体
    private SimpleAttributeSet  attrset;//设置面板字体
    private int width = 515,height = 600;//窗口的高和宽

    public ChatFrame(String myname, String hisname, ObjectOutputStream out,ObjectInputStream in, Socket socket){
        super("正在与"+hisname+"进行聊天");
        this.setLayout(null);//设置为空布局
        this.myname = myname;
        this.hisname = hisname;
        this.out = out;
        this.in = in;
        this.socket = socket;
        time = new TimeDemo();//时间对象

        try {
            fileIP = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            System.out.printf("获取主机IP异常");
        }

        //设置字体大小
        attrset = new SimpleAttributeSet();
        StyleConstants.setFontSize(attrset,16);
        // 边框修饰色
        Border brd = BorderFactory.createMatteBorder(2, 2, 2, 1, new Color(125, 161, 253));

        //左面板内容
        leftJPanel = new JPanel();
        leftJPanel.setLayout(null);
        leftJPanel.setBounds(0,0,500,700);
        this.add(leftJPanel);
        //消息显示区
        textPane = new JTextPane();
        textPane.setBounds(0,0,500,350);
        textPane.setEditable(false);//消息框不可编辑
        textPane.setBorder(brd);//设置边框颜色
        textPane.setBackground(new Color(248, 243, 209));
        textPane.setFont(textFont);//设置默认字体
        textPane.addMouseListener(this);//对消息框快捷菜单监听
        //消息区的滚动窗格
        textjScrollPane = new JScrollPane(textPane);
        textjScrollPane.setBorder(BorderFactory.createTitledBorder("闲聊"));
        //设置垂直滚动
        textjScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        textjScrollPane.setBounds(0,0,500,350);
        //加入到左面板
        leftJPanel.add(textjScrollPane);
        this.ContextMenu();//调用快捷菜单方法
        //截图组件
        cut = new JButton("截图");
        cut.setBounds(10,355,100,30);
        cut.setContentAreaFilled(false);//设置按钮为无色
        cut.addActionListener(this);
        leftJPanel.add(cut);
        fileButton = new JButton("文件▼");
        fileButton.setBounds(120,355,100,30);
        fileButton.setContentAreaFilled(false);//设置按钮为无色
        fileButton.addActionListener(this);
        leftJPanel.add(fileButton);

        acceptFileButton = new JButton("接收文件");
        acceptFileButton.setBounds(230,355,100,30);
        acceptFileButton.setContentAreaFilled(false);
        acceptFileButton.setEnabled(false);
        acceptFileButton.addActionListener(this);
        leftJPanel.add(acceptFileButton);

        refuseFileButton = new JButton("拒绝文件");
        refuseFileButton.setBounds(340,355,100,30);
        refuseFileButton.setContentAreaFilled(false);
        refuseFileButton.setEnabled(false);
        refuseFileButton.addActionListener(this);
        leftJPanel.add(refuseFileButton);

        //消息编辑区
        wordsArea = new JTextArea(1,2);
        wordsArea.setBounds(0,400,500,120);
        wordsArea.setFont(wordsFont);
        wordsArea.setBackground(new Color(255, 231, 147));// 设置聊天框体的颜色
        wordsArea.setLineWrap(true);        //激活自动换行功能
        wordsArea.setWrapStyleWord(true);   // 激活断行不断字功能
        wordsArea.addKeyListener(this);
        //编辑区滚动窗格
        wordsjScrollPane = new JScrollPane(wordsArea);
        wordsjScrollPane.setBounds(0,400,500,120);
        //设置滚动条
        wordsjScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //设置边框
        wordsArea.setBorder(brd);
        wordsjScrollPane.setBorder(BorderFactory.createTitledBorder("编辑区"));
        leftJPanel.add(wordsjScrollPane);

        send = new JButton("发送");
        send.setBounds(390,525,100,30);
        send.addActionListener(this);
        leftJPanel.add(send);


        //右面版
        rightJPanel = new JPanel();
        rightJPanel.setLayout(null);
        rightJPanel.setBounds(510,0,200,560);
        rightJPanel.setBorder(brd);
        this.add(rightJPanel);

        getFileButton = new JButton("选择文件");
        getFileButton.setBounds(5,340,90,30);
        getFileButton.addActionListener(this);
        rightJPanel.add(getFileButton);
        jFileChooser = new JFileChooser();//选择文件窗口

        sendFileButton = new JButton("确认发送");
        sendFileButton.setBounds(100,340,90,30);
        sendFileButton.addActionListener(this);
        rightJPanel.add(sendFileButton);

        fileTextPanel = new MyJTextPanel();//文件发送面板
        fileTextPanel.setBounds(10,375,180,140);
        fileTextPanel.setEditable(false);//不可编辑
        fileTextPanel.setBorder(brd);
        fileTextPanel.setBorder(BorderFactory.createTitledBorder("选择文件或者拖入文件"));
        fileTextPanel.setBackground(new Color(255, 231, 147));
        rightJPanel.add(fileTextPanel);

//        this.requestFocus();
        // 匿名类 监听窗口关闭事件
        this.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent event)
            {
                FriendView.deleteChat(hisname);
            }
        });

        //匿名类，监听面板键盘事件，Esc关闭窗口
        textPane.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == 27){////监听Esc键，当按下Esc键时销毁当前窗口
//                    System.out.printf("按下Esc");
                    dispose();
                    FriendView.deleteChat(hisname);
                }
            }
        });

        this.setSize(width,height);
        this.setLocation(350,100);
//        this.setResizable(false);//窗口大小不可改变
        this.setVisible(true);
    }


    //按钮的监听
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==menu[0]){//清屏
            textPane.setText("");
        }
        if(e.getSource()==menu[1]){//保存聊天记录
            if(textPane.getText().trim().length()!=0){//聊天记录长度不为0
                try {
                    FileOutputStream fw = new FileOutputStream(myname+"与"+hisname+"的聊天纪录.txt");
                    byte[] b = textPane.getText().getBytes();
                    fw.write(b);
                    fw.flush();
                    fw.close();
                    JOptionPane.showMessageDialog(this,"聊天记录已保存");
                } catch (IOException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(this,"聊天记录保存失败");
                    System.out.println("保存聊天记录异常");
                }
            }else {
                JOptionPane.showMessageDialog(this,"没有记录需要保存！");
            }
        }
        if(e.getSource()==cut || e.getSource()==menu[2]){//截屏
            CutPanle.Cut();
        }
        if (e.getActionCommand()=="文件▼"){//打开文件发送面板
            ChatFrame.this.setSize(730,height);
            fileButton.setText("文件▲");
        }
        if (e.getActionCommand()=="文件▲"){//关闭面板
            ChatFrame.this.setSize(515,height);
            fileButton.setText("文件▼");
        }
        if (e.getSource()==getFileButton){//选择文件
            jFileChooser = new JFileChooser(new File("D:\\Java"));//设置文件选择框的默认打开路径ss
            if(jFileChooser.showOpenDialog(this)==JFileChooser.APPROVE_OPTION ){
                //解释下这里,弹出个对话框,可以选择要上传的文件,如果选择了,就把选择的文件的绝对路径拿出来,有了绝对路径,通过JTextField的settext就能设置进去了,
                filepath = jFileChooser.getSelectedFile().getAbsolutePath();
                fileTextPanel.setText(filepath);
            }
//            jFileChooser.setCurrentDirectory(jFileChooser.getSelectedFile());//一次运行过程中，第二次打开选择框时打开的上次打开的路径
        }
        if (e.getSource()==sendFileButton){
            filepath = fileTextPanel.getText();
            if (filepath.trim().length()==0){
                inster("没有文件要发送，请选择文件！");
            }
            else{
                File file = new File(filepath);
                if(file.isFile()){
                    try {
                        //创建文件发送文件线程并启动
                        sendFile sf = new sendFile();
                        sf.start();
                        Message fileMessage = new Message();
                        fileMessage.setName(myname);
                        fileMessage.setHisname(hisname);
                        filename = filepath.substring((filepath.lastIndexOf("\\")+1));//切割字符串，逆向取字符 \ 出现的位置，然后截取之后的字符串，这样拿到的就只是文件的名字
                        fileMessage.setFilename(filename);
                        fileMessage.setType(ClientDemo.Type.sendfile);
                        fileMessage.setPort(fileport);
                        fileMessage.setIp(fileIP);
                        fileMessage.setSocket(socket);
                        out.writeObject(fileMessage);
                        out.flush();
                        inster("『你』发送了文件:"+fileMessage.getFilename());

                        if (acceptFileboolean){//对方接收文件，开始发送
                            fileTextPanel.setText("");//文件发送成功之后清空文件面板
                        }
                        else {
                            sf.interrupt();
                            fileTextPanel.setText("");
                        }
                    }
                    catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
                else {
                    inster("文件格式错误，请重新选择！");
                }
            }

        }
        if (e.getSource()==acceptFileButton){
            acceptFileButton.setEnabled(false);
                refuseFileButton.setEnabled(false);
                inster("正在接收文件！");
                Message message = new Message();
                try {
                    message.setName(myname);
                    message.setHisname(hisname);
                    message.setType(ClientDemo.Type.acceptfile);
                    out.writeObject(message);
                    out.flush();

                    //开创建文件接收线程并且开启
                    acceptFile acfile = new acceptFile(acceptfileMsg.getIp(),acceptfileMsg.getPort(),acceptfileMsg.getFilename());

                    acfile.start();


            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
                inster("文件接收失败！");
            }

        }
        if(e.getSource()==refuseFileButton){
            Message message = new Message();
            message.setName(myname);
            message.setHisname(hisname);
            message.setType(ClientDemo.Type.refusefile);
            try {
                out.writeObject(message);
                out.flush();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            acceptFileButton.setEnabled(false);
            refuseFileButton.setEnabled(false);
            inster("『你』拒绝了『"+hisname+"』发来的文件");
        }
        if(e.getSource()==send){//发送消息
            Message words = new Message();
            saywords = wordsArea.getText();
            if((saywords.trim()).length()!=0) {//trim()方法   返回字符串的副本，忽略前导空白和尾部空白。
                words.setText(saywords);
                words.setName(myname);
                words.setHisname(hisname);
                words.setType(ClientDemo.Type.talk);
                try {
                    out.writeObject(words);
                    out.flush();
                    sendInster(words);//将信息显示在聊天面板上
                } catch (IOException e1) {
                    e1.printStackTrace();
                    System.out.println("发送信息异常");
                }
                finally {
                    wordsArea.setText("");//无论发送成功或者失败，都将输入框清空
                }
            }

        }
    }


//-----------------发送文件线程-----------------
    class sendFile extends Thread{
        private String ip;
        Message filemsg= new Message();

        //空参构造方法
        sendFile(){

        }

    @Override
    public void run() {

            //打开文件
            File file = new File(filepath);
            FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            System.out.printf("打开文件异常");
        }

        try {
            //建立网络流
            fileserversocket = new ServerSocket(fileport);
            filesocket = fileserversocket.accept();

            OutputStream fileout = null;
            OutputStream bufout = null;

            //创建缓冲区
            fileout = filesocket.getOutputStream();
            bufout = new BufferedOutputStream(fileout);

            //读文件并且发送给对方客户端
            byte[] buf  = new byte[1024];
            int len = 0;
            while ((len=fis.read(buf))!=-1){
                bufout.write(buf,0,len);
                bufout.flush();
            }
            inster("文件发送完成！");

            //关闭网络流和文件流
            fis.close();
            bufout.close();
            filesocket.close();
            fileserversocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return;//结束线程
    }
}



//------------------接收文件线程---------------
    class acceptFile extends Thread{
        private String ip,fname;
        private int port;

        acceptFile(String ip,int port,String fname){
            this.ip = ip;
            this.port = port;
            this.fname = fname;
        }

        @Override
        public void run() {

            int count = 1;
            File file = new File(fname);
            while (file.exists()){//判断接收的文件是否存在，存在就进行重命名操作,eg:文件(1).txt
                fname = fname.substring(0,fname.indexOf("."))+"("+count++ +")"+fname.substring(fname.lastIndexOf("."));
                file = new File(fname);
            }

            FileOutputStream fos = null;
            InputStream filein = null;
            InputStream bufin = null;
            try {
                fos = new FileOutputStream(file);
                Thread.sleep(3000);
                acceptfilesocket = new Socket(ip,port);

                filein = acceptfilesocket.getInputStream();
                bufin = new BufferedInputStream(filein);

                byte[] buf = new byte[1024];
                int len = 0;
                while ((len=bufin.read(buf))!=-1){
                    //读取数据
                    System.out.printf("读取文件数据");
                    fos.write(buf,0,len);
                }
                inster("文件接收完成！");

                fos.close();
                bufin.close();
                acceptfilesocket.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnknownHostException e) {
                System.out.printf("接收文件建立网络服务移异常");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return;
        }
}

    /**
     * 接收消息，对接收过来的Message进行类型判断，然后进行相应的操作
     * @param message
     */
    public void reciveMessage(Message message){
        if(message.getType()== ClientDemo.Type.talk){
            acceptInster(message);
        }
        if (message.getType()== ClientDemo.Type.sendfile){
            acceptFileButton.setEnabled(true);
            refuseFileButton.setEnabled(true);
            filename = message.getFilename();
            acceptfileMsg = message;
//            System.out.printf(message.getFilename());

            inster("『"+message.getName()+"』给『你』发送文件:"+message.getFilename());
        }
        if (message.getType()== ClientDemo.Type.acceptfile){
            acceptFileboolean = true;
            inster("『"+message.getName()+"』接收了你发送的文件");
        }
        if (message.getType()== ClientDemo.Type.refusefile){
            acceptFileboolean = false;
            inster("『"+message.getName()+"』拒绝了你发送的文件");
        }
    }


    /**
     * 将发送的消息显示在面板上
     * @param ms
     */
    public void sendInster(Message ms){
        doc = textPane.getStyledDocument();
            try{  //插入文本
                doc.insertString(doc.getLength(),time.getTime()+"\n『你』说："+ms.getText()+"\n",attrset);
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
            wordsArea.setText("");//清空输入框
    }


    /**
     * 将接收的消息显示在面板上
     * @param ms
     */
    public void acceptInster(Message ms){
        doc = textPane.getStyledDocument();
            try{  //插入文本
                doc.insertString(doc.getLength(),time.getTime()+"\n『"+ms.getName()+"』说："+ms.getText()+"\n",attrset);
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
    }


    /**
     * 插入指定信息
     * @param string
     */
    public void inster(String string){
        doc = textPane.getStyledDocument();
        try{  //插入文本
            doc.insertString(doc.getLength(),time.getTime()+"\n"+string+"\n",attrset);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }


    /**
     * 聊天区的快捷菜单
     */
    public void ContextMenu(){
        //创建快捷菜单
        popupMenu = new JPopupMenu();
        menu =new JMenuItem[]{new JMenuItem("清屏"),new JMenuItem("保存"),new JMenuItem("截屏")};
        for (JMenuItem m : menu) {
            m.addActionListener(this);
            popupMenu.add(m);
        }

    }
    //消息框快捷菜单监听
    @Override
    public void mousePressed(MouseEvent e) {
        if(e.isPopupTrigger())
            popupMenu.show(e.getComponent(),e.getX(),e.getY());
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        mousePressed(e);
    }


    /**
     *对键盘Esc和Enter的监听
     * Esc：关闭当前窗口
     * Enter：发送消息
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == 27){////监听Esc键，当按下Esc键时销毁当前窗口
//            System.out.printf("按下Esc");
            dispose();
            FriendView.deleteChat(hisname);
        }
        if(e.getKeyCode() == 10){//监听回车键，当按下回车键时发送信息
//            System.out.printf("按下回车键");
            Message words = new Message();
            saywords = wordsArea.getText();
            if((saywords.trim()).length()!=0) {//trim()方法   返回字符串的副本，忽略前导空白和尾部空白。
                words.setText(saywords);
                words.setName(myname);
                words.setHisname(hisname);
                words.setType(ClientDemo.Type.talk);
                try {
                    out.writeObject(words);
                    out.flush();
                    sendInster(words);//将信息显示在聊天面板上
                } catch (IOException e1) {
                    e1.printStackTrace();
                    System.out.println("发送信息异常");
                }
                finally {
                    wordsArea.setText("");//无论发送成功或者失败，都将输入框清空
                }
            }
        }
    }


    //接口中多余的方法
    @Override
    public void mouseClicked(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyReleased(KeyEvent e) { }

}


