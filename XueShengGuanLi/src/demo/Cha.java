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

public class Cha extends JPanel implements ActionListener {
    private JTextField jt;
    private JButton jb;
    private JLabel jl;
    private JTable table;//实体表格
    private JScrollPane js;
    private Object data[][];//数据表格
    private String name;
    private String[] colname={"姓名","性别","专业","班级","学号"};//表头

    public Cha(String nam){
        this.name = nam;
        this.setLayout(null);
        this.setBounds(0, 0, 600, 440);

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

        jl = new JLabel("以下是查询信息");
        jl.setFont(new Font("粗体",Font.PLAIN,15));
        jl.setBounds(180,50,300,30);
        this.add(jl);

        data = loadData();
        table = new JTable(data,colname);
        js = new JScrollPane(table);
        js.setBounds(0,90,600,300);
        this.add(js);



    }
    private Object[][] loadData(){
        try{
            Connection conn;
            Statement stmt;
            ResultSet rs;
            conn = DBUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "select * from student where nam='"+name+"'";
            rs = stmt.executeQuery(sql);
            data = new Object[1][6];
            int i = 0;
            if(rs.next()){
                data[i][0] = rs.getString(1);
                data[i][1] = rs.getString(2);
                data[i][2] = rs.getString(3);
                data[i][3] = rs.getString(4);
                data[i][4] = rs.getString(5);
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
                this.setVisible(false);
                this.removeAll();
                this.add(new Cha(nam));
                this.setVisible(true);
            }
        }
    }
}
