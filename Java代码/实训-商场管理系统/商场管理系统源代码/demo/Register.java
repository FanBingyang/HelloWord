package demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Register extends JFrame implements ActionListener{
	private JButton Exit,Enter,Login;
	private JLabel jl1,jl2,jl3;
	private JTextField idField;
	private JPasswordField psField1,psField2;
	private int massage=0;
	public Register(){
		super("商场信息管理系统");
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		jl1=new JLabel("用户账号");
		jl2=new JLabel("登录密码");
		jl3=new JLabel("确认密码");
		idField=new JTextField(16);
		psField1=new JPasswordField(16);
		psField2=new JPasswordField(16);
		c.add(jl1);
		c.add(idField);
		c.add(jl2);
		c.add(psField1);
		c.add(jl3);
		c.add(psField2);
		Exit=new JButton("退出");
		Enter=new JButton("登录");
		Login=new JButton("注册");
		c.add(Login);
		c.add(Enter);
		c.add(Exit);
		c.setBackground(Color.cyan);
		Exit.addActionListener(this);
		Enter.addActionListener(this);
		Login.addActionListener(this);
		this.setSize(260,200);
		this.setLocation(600,450);
		this.setVisible(true);
		this.setResizable(false);     //设置窗口大小不可改变
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
}
	public static void main(String[] args) {
		Register app=new Register();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == Exit) {
			new Bay(this);
		}
		if(e.getSource()==Login)
		{
			new Login();
		}
		else if(e.getSource() == Enter)
		{
			Connection con;
			java.sql.Statement stmt;
			ResultSet rs;
			try{
				Class.forName("com.mysql.jdbc.Driver");
			}
			catch(ClassNotFoundException f){
				System.out.println("SQLException:"+f.getLocalizedMessage());
			}
			try{
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shangchang?useUnicode=true&characterEncoding=utf8","root","admin");
				stmt =con.createStatement();
				String sql="select * from person";
				rs=stmt.executeQuery(sql);
				while(rs.next())
				{
					String str1=rs.getString(1);
					String str2=rs.getString(2);
					String str3=psField2.getText();
					if((idField.getText().equals(str1))&&(psField1.getText().equals(str2))&&(str3.equals(str2)))
					{
						massage=1;
						new MainHome(str1);
						this.dispose();
					}
				}
				if(massage==0){
					JOptionPane.showMessageDialog(null, "您输入的账号或密码有误，请重新输入！", "系统提示", JOptionPane.ERROR_MESSAGE);
					idField.setText("");
					psField1.setText("");
					psField2.setText("");
				}
				rs.close();
				stmt.close();
				con.close();
			}
			catch(SQLException f){
				System.out.println(f);
				f.printStackTrace();
			}
		}
	}
}
