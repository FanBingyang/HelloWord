package demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    private JButton zeng,shan,gai,cha;
    private JLabel biaoti,dibu;
    private JPanel top,right,left,bottom;
    public Main(){
        super("学生管理系统");
        Container c = getContentPane();
        c.setLayout(null);

        //顶部面板
        top = new JPanel();
        top.setBackground(Color.cyan);
        top.setLayout(null);
        top.setBounds(0,0,800,100);
        biaoti = new JLabel("欢迎来到学生管理系统");
        biaoti.setFont(new Font("楷体",Font.PLAIN,20));
        biaoti.setBounds(300,30,200,40);
        top.add(biaoti);
        c.add(top);

        //左边面板
        left = new JPanel();
        left.setLayout(null);
        left.setBackground(Color.pink);
        left.setBounds(0,100,200,440);

        zeng = new JButton("增加学生");
        zeng.setBackground(null);
        zeng.setBounds(40,40,120,60);
        zeng.addActionListener(this);
        left.add(zeng);

        shan = new JButton("删除学生");
        shan.setBackground(null);
        shan.setBounds(40,140,120,60);
        shan.addActionListener(this);
        left.add(shan);

        gai = new JButton("修改学生");
        gai.setBackground(null);
        gai.setBounds(40,240,120,60);
        gai.addActionListener(this);
        left.add(gai);

        cha = new JButton("浏览查看");
        cha.setBackground(null);
        cha.setBounds(40,340,120,60);
        cha.addActionListener(this);
        left.add(cha);

        c.add(left);

        //右边面板
        right = new JPanel();
        right.setLayout(null);
        right.setBounds(200,100,600,440);
        right.add(new LiuLan());
        c.add(right);

        //底部面板
        bottom = new JPanel();
        bottom.setBackground(Color.cyan);
        bottom.setLayout(null);
        bottom.setBounds(0,540,800,60);
        dibu = new JLabel("软件工程 17-03班 范秉洋");
        dibu.setFont(new Font("楷体",Font.PLAIN,16));
        dibu.setBounds(300,0,200,30);
        bottom.add(dibu);
        c.add(bottom);
    }

    //监听器里的方法
    public void actionPerformed(ActionEvent e){
        //增加学生
        if(e.getSource()==zeng){
            right.setVisible(false);
            right.removeAll();
            right.add(new Zeng());
            right.setVisible(true);

        }

        //删除学生
        if(e.getSource()==shan){
            right.setVisible(false);
            right.removeAll();
            right.add(new Shan());
            right.setVisible(true);
        }

        //修改学生
        if(e.getSource()==gai){
            right.setVisible(false);
            right.removeAll();
            right.add(new Gai());
            right.setVisible(true);

        }

        //查找学生
        if(e.getSource()==cha){
            right.setVisible(false);
            right.removeAll();
            right.add(new LiuLan());
            right.setVisible(true);

        }
    }

    public static void main(String[] args) {
        Main a = new Main();
        a.setSize(800,600);
        a.setLocation(150,150);
        a.setVisible(true);
        a.setResizable(false);     //设置窗口大小不可改变
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
