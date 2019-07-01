package demo;

import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LiuLan extends JPanel implements ActionListener {
    private JTextField jt;
    private JButton jb;
    private JTable table;
    private JScrollPane js;
    private Object data[][];//表格
    private String[] colname={"姓名","性别","专业","班级","学号"};//表头
    public LiuLan(){
        this.setLayout(null);
        this.setBounds(0, 0, 600, 400);


       //查询
        jt = new JTextField("输入查询学生的姓名");
        jt.setBounds(220,5,250,30);
        jt.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                jt.setText("");
            }
        });
        this.add(jt);
        jb = new JButton("查询");
        jb.setBounds(500,5,80,30);
        jb.addActionListener(this);
        this.add(jb);
        //浏览
        data = this.loadData();//调用下面方法获取数据
        table = new JTable(data,colname);//定义实体表格，添加数据和表头
        js = new JScrollPane(table);
        js.setBounds(0,40,600,400);
        this.add(js);
//        js.setPreferredSize(new Dimension(600,400));
    }

    private Object[][] loadData(){
        try{
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs;
            conn = DBUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "select * from student";
            rs = stmt.executeQuery(sql);
            rs.last();//将数据库指针指向最后一行数据
            int n = rs.getRow();//返回此时的行数
            data = new Object[n][6];
            int i = 0;
            rs.beforeFirst();//再将数据库指针指向第一行的之前
            while (rs.next()){
                data[i][0] = rs.getString(1);
                data[i][1] = rs.getString(2);
                data[i][2] = rs.getString(3);
                data[i][3] = rs.getString(4);
                data[i][4] = rs.getString(5);
                i++;
            }
            DBUtils.closeAll(rs,stmt,conn);
        }catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }

    public void actionPerformed(ActionEvent event){
        if(event.getSource()==jb){
            if(jt.getText().equals("输入查询学生的姓名") || jt.getText().isEmpty())
                JOptionPane.showMessageDialog(null,"请输入查询学生的姓名！");
            else{
                String nam = jt.getText();
//                System.out.println(nam);
                this.setVisible(false);
                this.removeAll();
                this.add(new Cha(nam));
                this.setVisible(true);
            }
        }
    }




}
