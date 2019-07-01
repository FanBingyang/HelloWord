package demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Shan extends JPanel implements ActionListener {
    private JLabel top;
    private JTextField nameJT,numberJT;
    private JButton nameJB,numberJB;
    private Statement stmt = null;
    private  Connection conn = null;
    private ResultSet rs,rs1 = null,rs2 = null;

    public Shan(){
        this.setLayout(null);
        this.setBounds(0, 0, 600, 400);

        top = new JLabel("请输入要删除的学生的姓名或学号");
        top.setFont(new Font("宋体",Font.PLAIN,20));
        top.setBounds(130,50,300,40);
        this.add(top);

        nameJT = new JTextField("输入学生姓名");
        nameJT.setBounds(120,120,250,30);
        nameJT.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
               nameJT.setText("");
               numberJT.setText("输入学生学号");
            }
        });

        this.add(nameJT);

        nameJB = new JButton("删除");
        nameJB.setBounds(390,120,80,30);
        nameJB.addActionListener(this);
        this.add(nameJB);

        numberJT = new JTextField("输入学生学号");
        numberJT.setBounds(120,200,250,30);
        numberJT.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                numberJT.setText("");
                nameJT.setText("输入学生姓名");
            }
        });
        this.add(numberJT);

        numberJB = new JButton("删除");
        numberJB.setBounds(390,200,80,30);
        numberJB.addActionListener(this);
        this.add(numberJB);

    }

    public void actionPerformed(ActionEvent e){
        try{
            //按姓名删除
            if(e.getSource()==nameJB){
                if((nameJT.getText().equals("输入学生姓名")) || nameJT.getText().isEmpty())
                    JOptionPane.showMessageDialog(null,"学生姓名不能为空！");
                else{
                    shan("nam='"+nameJT.getText()+"'",true);
                }
            }

            //按学号删除
            if(e.getSource()==numberJB){
                if((numberJT.getText().equals("输入学生学号")) || numberJT.getText().isEmpty())
                    JOptionPane.showMessageDialog(null,"学生学号不能为空！");
                else{
                    shan("xuehao='"+numberJT.getText()+"'",false);
                }
            }
        }
        catch (Exception e1){
            e1.printStackTrace();
        }


        }

        public void shan(String sql,boolean c){
        try{
            String sql1 = "delete from student where ";
            String sql2 = "select * from student  where ";
            boolean b = true;
            conn = DBUtils.getConnection();
            stmt = conn.createStatement();
            if(c){
                rs1 = stmt.executeQuery(sql2+sql);
                rs = rs1;
            }
            else{
                rs2 = stmt.executeQuery(sql2+sql);
                rs = rs2;
            }
            if(rs.next()){
                stmt.executeUpdate(sql1+sql);
                JOptionPane.showMessageDialog(null,"学生删除成功!");
                b = false;

;
            }
//            rs.last();//一个rs对应多个stmt时的操作。对rs的操作应马上操作,操作完后再从数据库得到rst,再对rst操作,防止rs执行完stmt.executeQuery而关闭的错误
            if(b)
                JOptionPane.showMessageDialog(null,"没有该学生信息！");
        }catch (Exception e1){
            e1.printStackTrace();
        }
        finally {
            DBUtils.closeAll(rs,stmt,conn);
        }
        }
    }

