package demo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CancelVIP extends JPanel implements ActionListener {
	private JLabel l1,l2;
	private JButton esc,ok;
	private JTextField t1,t2;
	public CancelVIP() {
		// TODO Auto-generated constructor stub
		this.setLayout(null);
		this.setBounds(0,0,780,620);
		l1=new JLabel("请输入你要注销的VIP账号  :");
		l1.setFont(new Font("宋体",Font.PLAIN,20));
		l1.setBounds(230,60,300,60);
		l1.setForeground(Color.blue);
		this.add(l1);
		t1=new JTextField();
		t1.setBounds(130,170,500,40);
		this.add(t1);
		esc=new JButton("取消");
		esc.setBounds(150,320,150,40);
		esc.addActionListener(this);
		this.add(esc);
		ok=new JButton("注销");
		ok.setBounds(450,320,150,40);
		ok.addActionListener(this);
		this.add(ok);
		this.setVisible(true);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==esc){
			t1.setText(null);
		}
		if(e.getSource()==ok){
			if(t1.getText().isEmpty())
				JOptionPane.showMessageDialog(null, "VIP账号不能为空！");
			else{
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException g) {
				// TODO: handle exception
				System.out.println("找不到驱动！");
			}
			try {
				Connection con;
				Statement stmt;
				ResultSet rs;
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shangchang??useUnicode=true&characterEncoding=utf8","root","admin");
				stmt=con.createStatement();
				String sql="DELETE FROM vip  where id='"+t1.getText()+"'";
				String sql2="select * from vip  where id='"+t1.getText()+"'";
				rs=stmt.executeQuery(sql2);
				if(rs.next())
				{
					stmt.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "VIP注销成功！");
				stmt.close();
				con.close();
				this.setVisible(false);
				this.removeAll();
				this.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(null, "无记录！");
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println("连接错误！");
				e2.printStackTrace();
			}
		}
		}
	}

}



