package ClientDemo;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;

public class GroupChat extends JFrame implements ActionListener,MouseListener,KeyListener {
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
    private InputStream in = null;
    private Socket socket;
    private boolean acceptFileboolean = false;


    private StyledDocument doc = null;
    protected Font textFont = new Font("宋体",Font.PLAIN,16);
    protected Font wordsFont=new  Font("宋体",Font.PLAIN,15);//编辑区和消息区的默认字体
    private SimpleAttributeSet attrset;//设置面板字体
    private int width = 515,height = 600;//窗口的高和宽

    public GroupChat(String myname,ObjectOutputStream out){
        super("群聊-----"+myname);
        this.setLayout(null);//设置为空布局
        this.myname = myname;
        this.out = out;
        this.socket = socket;
        time = new TimeDemo();//时间对象

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


//        this.requestFocus();
        // 匿名类 监听窗口关闭事件
        this.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent event)
            {
                FriendView.deleteGroupChat("群聊");
            }
        });

        //匿名类，监听面板键盘事件，Esc关闭窗口
        textPane.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == 27){////监听Esc键，当按下Esc键时销毁当前窗口
//                    System.out.printf("按下Esc");
                    dispose();
                    FriendView.deleteGroupChat("群聊");
                }
            }
        });

        this.setSize(width,height);
        this.setLocation(350,100);
//        this.setResizable(false);//窗口大小不可改变
        this.setVisible(true);
    }


    /**
     * 接收消息，对接收过来的Message进行类型判断，然后进行相应的操作
     * @param message
     */
    public void reciveMessage(Message message){
        this.inster(message);
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


    //按钮的监听
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==menu[0]){//清屏
            textPane.setText("");
        }
        if(e.getSource()==menu[1]){//保存聊天记录
            try {
                FileOutputStream fw = new FileOutputStream(myname+"的群聊纪录");
                byte[] b = textPane.getText().getBytes();
                fw.write(b);
                fw.flush();
                fw.close();
            } catch (IOException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(this,"聊天记录保存失败");
                System.out.println("保存聊天记录异常");
            }
        }
        if(e.getSource()==cut || e.getSource()==menu[2]){//截屏
            CutPanle.Cut();
        }
        if(e.getSource()==send){//发送消息
            Message words = new Message();
            saywords = wordsArea.getText();
            if((saywords.trim()).length()!=0) {//trim()方法   返回字符串的副本，忽略前导空白和尾部空白。
                words.setText(saywords);
                words.setName(myname);
                words.setType(ClientDemo.Type.talkall);
                try {
                    out.writeObject(words);
                    out.flush();
                    wordsArea.setText("");//将输入框清空
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

    /**
     * 将群成员的动态显示在聊天面板上
     * @param message
     */
    public void inster(Message message){
            doc = textPane.getStyledDocument();
            try{  //插入文本
                if(message.getType()== ClientDemo.Type.login){
                    doc.insertString(doc.getLength(),time.getTime()+"\n"+message.getName()+"已上线\n",attrset);
                }
                else if(message.getType()== ClientDemo.Type.loginout){
                    doc.insertString(doc.getLength(),time.getTime()+"\n"+message.getName()+"已下线\n",attrset);
                }
                else if (message.getType()== ClientDemo.Type.talkall){
                    doc.insertString(doc.getLength(),time.getTime()+"\n『"+message.getName()+"』说："+message.getText()+"\n",attrset);
                }
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        }

    /**
     *对键盘Esc和Enter的监听
     * Esc：关闭当前窗口
     * Enter：发送消息
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar()==KeyEvent.VK_ESCAPE){//监听Esc键，当按下Esc键时销毁当前窗口
            GroupChat.this.dispose();
        }
        if(e.getKeyChar()==KeyEvent.VK_ENTER){//监听回车键
            Message words = new Message();
            saywords = wordsArea.getText();
            if((saywords.trim()).length()!=0) {//trim()方法   返回字符串的副本，忽略前导空白和尾部空白。
                words.setText(saywords);
                words.setName(myname);
                words.setType(ClientDemo.Type.talkall);
                try {
                    out.writeObject(words);
                    out.flush();
                    wordsArea.setText("");//将输入框清空
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
