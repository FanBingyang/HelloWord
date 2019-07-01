package ClientDemo;

import ServerDemo.DBUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Person extends JFrame implements ActionListener {
    private String name;
    private ImageIcon img;
    private JLabel touxiang,top,idLabel,nameLabel,sexLabel,aggLabel,qinmingLabel,pswLabel;
    private JTextField idText,nameText,sexText,aggText,qinmingText;
    private JPasswordField pswText;
    private JButton change;
    private ResultSet rs;
    public Person(String name){
        super(name+" 个人信息");
        this.name = name;
        this.setLayout(null);

        //左边头像部分
        img = new ImageIcon("src/img/touxiang.PNG");
        img.setImage(img.getImage().getScaledInstance(100,120,Image.SCALE_DEFAULT));
        touxiang = new JLabel(img);
        touxiang.setBounds(10,40,100,120);
        this.add(touxiang);

        //右边个人信息部分
        top = new JLabel("个人信息");
        top.setBounds(160,10,100,20);
        this.add(top);

        idLabel = new JLabel("账号：");
        idLabel.setBounds(120,40,60,20);
        this.add(idLabel);
        idText = new JTextField();
        idText.setBounds(190,40,100,20);
        idText.setEnabled(false);
        this.add(idText);
        nameLabel = new JLabel("昵称：");
        nameLabel.setBounds(120,65,60,20);
        this.add(nameLabel);
        nameText = new JTextField();
        nameText.setBounds(190,65,100,20);
        this.add(nameText);
        sexLabel = new JLabel("性别：");
        sexLabel.setBounds(120,90,60,20);
        this.add(sexLabel);
        sexText = new JTextField();
        sexText.setBounds(190,90,100,20);
        this.add(sexText);
        aggLabel = new JLabel("年龄：");
        aggLabel.setBounds(120,115,60,20);
        this.add(aggLabel);
        aggText = new JTextField();
        aggText.setBounds(190,115,100,20);
        this.add(aggText);
        qinmingLabel = new JLabel("签名：");
        qinmingLabel.setBounds(120,140,60,20);
        this.add(qinmingLabel);
        qinmingText = new JTextField();
        qinmingText.setBounds(190,140,100,20);
        this.add(qinmingText);
        pswLabel = new JLabel("新密码：");
        pswLabel.setBounds(120,165,60,20);
        this.add(pswLabel);
        pswText = new JPasswordField();
        pswText.setBounds(190,165,100,20);
        this.add(pswText);

        change = new JButton("确认");
        change.setBounds(40,160,70,30);
        change.addActionListener(this);
        this.add(change);

        //读取数据库中的信息
        try {
            rs = DBUtils.getUser(name);
            while (rs.next()){
                idText.setText(rs.getString("id"));
                nameText.setText(rs.getString("name"));
                sexText.setText(rs.getString("sex"));
                aggText.setText(rs.getString("age"));
                qinmingText.setText(rs.getString("qianming"));
//                pswText.setText(rs.getString("password"));
            }
        }catch (Exception e){ }


        this.setSize(300,250);
        this.setLocation(200,200);
        this.setVisible(true);
        this.setResizable(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==change){
            if (nameText.getText().isEmpty() || sexText.getText().isEmpty() || aggText.getText().isEmpty() || pswText.getText().isEmpty())
                JOptionPane.showMessageDialog(this,"请输入完整信息！");
            else {
                if (qinmingText.getText().isEmpty())
                    qinmingText.setText("无");
                else{
                    if (DBUtils.ChangeUser(idText.getText(),nameText.getText(),sexText.getText(),aggText.getText(),qinmingText.getText(),pswText.getText()))
                    {
                        JOptionPane.showMessageDialog(this,"修改成功！");
                        this.dispose();
                    }
                    else JOptionPane.showMessageDialog(this,"修改失败！");
                }
            }
        }
    }

}
