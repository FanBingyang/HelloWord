package demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Gai_2 extends JPanel implements ActionListener {
    private JLabel L;
    private JLabel zh, xm, xb, zk, dh;
    private JButton esc, ok;
    private JTextField  txm,txb, tzy, tbj, txh;
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private String s;

    public Gai_2(String s) {
        this.s = s;
        this.setLayout(null);
        this.setBounds(0, 0, 600, 400);
        //按钮
        esc = new JButton("重置");
        esc.setFont(new Font("宋体", Font.PLAIN, 15));
        esc.setBounds(175, 350, 120, 40);
        esc.addActionListener(this);
        this.add(esc);
        ok = new JButton("确定");
        ok.setFont(new Font("宋体", Font.PLAIN, 15));
        ok.setBounds(400, 350, 120, 40);
        ok.addActionListener(this);
        this.add(ok);

        //标签
        L = new JLabel("修改学生信息");
        L.setFont(new Font("宋体", Font.PLAIN, 20));
        L.setBounds(200, 25, 200, 35);
        this.add(L);
        zh = new JLabel("姓名 :");
        zh.setBounds(100, 80, 100, 30);
        zh.setFont(new Font("宋体", Font.PLAIN, 20));
        add(zh);
        xm = new JLabel("性别 :");
        xm.setBounds(100, 130, 90, 30);
        xm.setFont(new Font("宋体", Font.PLAIN, 20));
        add(xm);
        xb = new JLabel("专业 :");
        xb.setBounds(100, 180, 90, 30);
        xb.setFont(new Font("宋体", Font.PLAIN, 20));
        add(xb);
        zk = new JLabel("班级 :");
        zk.setBounds(100, 230, 90, 30);
        zk.setFont(new Font("宋体", Font.PLAIN, 20));
        add(zk);
        dh = new JLabel("学号 :");
        dh.setBounds(100, 280, 90, 30);
        dh.setFont(new Font("宋体", Font.PLAIN, 20));
        add(dh);
        //文本框
        txm = new JTextField();
        txm.setBounds(210, 80, 330, 30);
        add(txm);
        txb = new JTextField();
        txb.setColumns(10);
        txb.setBounds(210, 130, 330, 30);
        add(txb);
        tzy = new JTextField();
        tzy.setColumns(10);
        tzy.setBounds(210, 180, 330, 30);
        add(tzy);
        tbj = new JTextField();
        tbj.setColumns(10);
        tbj.setBounds(210, 230, 330, 30);
        add(tbj);
        txh = new JTextField();
        txh.setColumns(10);
        txh.setBounds(210, 280, 330, 30);
        txh.setEditable(false);
        add(txh);
        try {
            conn = DBUtils.getConnection();
            stmt = conn.createStatement();
            String sql1 = "select * from student where xuehao='" + s + "'";
            rs = stmt.executeQuery(sql1);
            while (rs.next()) {
                tzy.setText(rs.getString("zhuanye"));
                txm.setText(rs.getString("nam"));
                txb.setText(rs.getString("sex"));
                tbj.setText(rs.getString("banji"));
                txh.setText(s);
                this.setVisible(true);
            }
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==esc){
            tzy.setText("");
            txm.setText("");
            txb.setText("");
            tbj.setText("");
        }
        if(e.getSource()==ok){
            if((tzy.getText().isEmpty())||(txm.getText().isEmpty())||(txb.getText().isEmpty())
                    ||(tbj.getText().isEmpty())||(txh.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "请填写完整信息！");
            }
            else {
                try{
                    String sql2 = "update student set nam=?,sex=?,zhuanye=?,banji=? where xuehao='"+s+"'";
                    PreparedStatement ps = conn.prepareStatement(sql2);
                    ps.setString(1,txm.getText());
                    ps.setString(2,txb.getText());
                    ps.setString(3,tzy.getText());
                    ps.setString(4,tbj.getText());
                    ps.execute();
                    JOptionPane.showMessageDialog(null,"修改学生信息成功！");
                    this.setVisible(false);
                    this.removeAll();
                    this.add(new Gai());
                    this.setVisible(true);
                }catch (Exception ee){
                    ee.printStackTrace();
                }
                finally {
                    DBUtils.closeAll(rs,stmt,conn);
                }

            } }
        }
}
