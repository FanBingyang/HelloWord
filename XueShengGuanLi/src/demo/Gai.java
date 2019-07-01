package demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Gai extends JPanel implements ActionListener {
    private JLabel top;
    private JTextField nameJT,numberJT;
    private JButton nameJB,numberJB;
    private JPanel aa;

    public Gai(){
        this.setLayout(null);
        this.setBounds(0, 0, 600, 400);

        top = new JLabel("请输入要修改的学生姓名");
        top.setFont(new Font("宋体",Font.PLAIN,20));
        top.setBounds(130,50,300,40);
        this.add(top);

        nameJT = new JTextField("输入修改学生的姓名");
        nameJT.setBounds(120,120,250,30);
        nameJT.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                nameJT.setText("");
            }
        });

        this.add(nameJT);

        nameJB = new JButton("修改");
        nameJB.setBounds(390,120,80,30);
        nameJB.addActionListener(this);
        this.add(nameJB);

//        numberJT = new JTextField("输入修改学生的学号");
//        numberJT.setBounds(120,200,250,30);
//        numberJT.addFocusListener(new FocusAdapter() {
//            @Override
//            public void focusGained(FocusEvent e) {
//                numberJT.setText("");
//                nameJT.setText("输入修改学生的姓名");
//            }
//        });
//        this.add(numberJT);
//
//        numberJB = new JButton("修改");
//        numberJB.setBounds(390,200,80,30);
//        nameJB.addActionListener(this);
//        this.add(numberJB);

    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==nameJB){
            if(nameJT.getText().equals("输入修改学生的姓名") || nameJT.getText().isEmpty())
                JOptionPane.showMessageDialog(null,"请输入学生姓名！");
            try{
                Connection conn = null;
                Statement stmt = null;
                ResultSet rs;
                boolean b = true;
                conn = DBUtils.getConnection();
                stmt = conn.createStatement();
                String sql = "select * from student where nam='"+nameJT.getText()+"'";
                rs = stmt.executeQuery(sql);
                if (rs.next()){
                    String s = rs.getString("xuehao");
                    b = false;
                    this.setVisible(false);
                    this.removeAll();
                    this.add(new Gai_2(s));
                    this.setVisible(true);
                    DBUtils.closeAll(rs,stmt,conn);
                }
                if(b)
                    JOptionPane.showMessageDialog(null,"没有该学生信息！");
            }catch (Exception ee){
                ee.printStackTrace();
            }
        }
//        else if(e.getSource()==numberJB){
//
//        }
    }
}
