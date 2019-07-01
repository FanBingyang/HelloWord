package ClientDemo;

import ServerDemo.DBUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.sql.ResultSet;

public class YongHu extends JFrame implements ActionListener {

    private String myname,hisname;
    private ImageIcon img;
    private JLabel touxiang,top,idLabel,nameLabel,sexLabel,aggLabel,qinmingLabel;
    private JLabel idText,nameText,sexText,aggText,qinmingText;
    private JButton deletefriend,addfriend;
    private ResultSet rs;
    private Message message;
    private ObjectOutputStream out;
    private FriendView friendView;
    public YongHu(Message message, ObjectOutputStream out,FriendView friendView){
        super(message.getHisname()+" 个人信息");
        myname = message.getName();
        hisname = message.getHisname();
//        System.out.println("YouHu.......name:"+ myname+"----hisname:"+hisname);
        this.friendView = friendView;
        this.message = message;
        this.out = out;
        this.setLayout(null);

        //左边头像部分
        img = new ImageIcon("src/img/touxiang.PNG");
        img.setImage(img.getImage().getScaledInstance(100,120,Image.SCALE_DEFAULT));
        touxiang = new JLabel(img);
        touxiang.setBounds(10,55,100,120);
        this.add(touxiang);

        //右边个人信息部分
        top = new JLabel("个人信息");
        top.setBounds(160,10,100,20);
        this.add(top);

        idLabel = new JLabel("账号：");
        idLabel.setBounds(120,40,60,20);
        this.add(idLabel);
        idText = new JLabel();
        idText.setBounds(190,40,100,20);
        this.add(idText);
        nameLabel = new JLabel("昵称：");
        nameLabel.setBounds(120,65,60,20);
        this.add(nameLabel);
        nameText = new JLabel();
        nameText.setBounds(190,65,100,20);
        this.add(nameText);
        sexLabel = new JLabel("性别：");
        sexLabel.setBounds(120,90,60,20);
        this.add(sexLabel);
        sexText = new JLabel();
        sexText.setBounds(190,90,100,20);
        this.add(sexText);
        aggLabel = new JLabel("年龄：");
        aggLabel.setBounds(120,115,60,20);
        this.add(aggLabel);
        aggText = new JLabel();
        aggText.setBounds(190,115,100,20);
        this.add(aggText);
        qinmingLabel = new JLabel("签名：");
        qinmingLabel.setBounds(120,140,60,20);
        this.add(qinmingLabel);
        qinmingText = new JLabel();
        qinmingText.setBounds(190,140,100,20);
        this.add(qinmingText);

        addfriend = new JButton("添加好友");
        addfriend.setBounds(40,190,100,30);
        addfriend.addActionListener(this);
        this.add(addfriend);
        deletefriend = new JButton("删除好友");
        deletefriend.setBounds(160,190,100,30);
        deletefriend.addActionListener(this);
        this.add(deletefriend);


        boolean flag = false;
        //读取数据库中的信息
        try {
            rs = DBUtils.getUser(message.getHisname());
            while (rs.next()){
                if(message.getHisname().equals(rs.getString("name"))){//判断搜索的用户是否存在
                    flag = true;
                    break;
                }
            }
            if(flag){
                idText.setText(rs.getString("id"));
                nameText.setText(rs.getString("name"));
                sexText.setText(rs.getString("sex"));
                aggText.setText(rs.getString("age"));
                qinmingText.setText(rs.getString("qianming"));
            }
            else {
                JOptionPane.showMessageDialog(friendView,"该用户不存在！");
            }
        }catch (Exception e){ }

        this.setSize(300,260);
        this.setLocation(200,200);
        this.setVisible(flag);
        this.setResizable(false);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==addfriend){//添加好友
            Message me = new Message();
            me.setName(myname);
            me.setHisname(hisname);
            me.setType(ClientDemo.Type.addfriend);
            friendView.addfriend(me);
            JOptionPane.showMessageDialog(this,"添加成功！");
            this.dispose();

        }
        if (e.getSource()==deletefriend){//删除好友
                Message me =  new Message();
                me.setName(myname);
                me.setHisname(hisname);
                me.setType(ClientDemo.Type.deletefriend);
                friendView.deletefriend(me);
                JOptionPane.showMessageDialog(this,"删除成功！");
                this.dispose();

        }
    }
}
