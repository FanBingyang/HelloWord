package demo;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{
	private String tim;
	private JButton esc=new JButton("取消");
	private JButton ok=new JButton("确认注册");
	private JLabel [] jl={new JLabel("管理员注册"),new JLabel("账号"),new JLabel("姓名"),new JLabel("性别"),new JLabel("部门"),new JLabel("职务"),new JLabel("请输入密码 :"),new JLabel("请确认密码  :")}; 
	private JTextField [] t={new JTextField(),new JTextField(),new JTextField(),new JTextField(),new JTextField(), new JPasswordField(),new JPasswordField()};
	public Login(){
		super("管理员注册");
		Container c=getContentPane();
		c.setLayout(null);
		jl[0].setBounds(100,20,200,20);
		jl[1].setBounds(20,60,60,20);
		jl[2].setBounds(20,90,60,20);
		jl[3].setBounds(150,90,60,20);
		jl[4].setBounds(20,120,60,20);
		jl[5].setBounds(150,120,60,20);
		jl[6].setBounds(20,150,90,20);
		jl[7].setBounds(20,180,90,20);
		t[0].setBounds(60,60,80,20);
		t[1].setBounds(60,90,80,20);
		t[2].setBounds(190,90,80,20);
		t[3].setBounds(60,120,80,20);
		t[4].setBounds(190,120,80,20);
		t[5].setBounds(110,150,160,20);
		t[6].setBounds(110,180,160,20);
		for (int i = 0; i < jl.length; i++) 
		{
			if (i<t.length) {
				c.add(t[i]);
			}
			c.add(jl[i]);
		}
		esc.setBounds(30,250,100,30);
		ok.setBounds(150,250,100,30);
		esc.addActionListener(this);
		ok.addActionListener(this);
		c.add(esc);
		c.add(ok);
		this.setSize(300,350);
		this.setVisible(true);
		this.setLocation(100, 200);
		this.setResizable(false);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==esc)
			this.dispose();
		if(e.getSource()==ok)
			if(t[0].getText().isEmpty()||t[1].getText().isEmpty()||t[2].getText().isEmpty()||t[3].getText().isEmpty()||t[4].getText().isEmpty()||t[5].getText().isEmpty()||t[6].getText().isEmpty())
				JOptionPane.showMessageDialog(null, "请输入完整信息！");
			else if(!t[5].getText().equals(t[6].getText()))
				JOptionPane.showMessageDialog(null, "两次密码输入不一致！");
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
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shangchang?useUnicode=true&characterEncoding=utf8","root","admin");
					stmt=con.createStatement();
					Calendar calendar=Calendar.getInstance();
					SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd");
					tim=dateFormat.format(calendar.getTime());
					String sql="INSERT INTO person (id,pass,nam,sex,bm,zw,tim)"
							+"VALUES("+"'"+t[0].getText()+"',"+"'"+t[5].getText()+"',"+"'"+t[1].getText()+"',"+"'"+t[2].getText()+"',"+"'"+t[3].getText()+"',"+"'"+t[4].getText()+"',"+"'"+tim+"')";
					stmt.executeUpdate(sql);
					JOptionPane.showMessageDialog(null, "注册成功");
					stmt.close();
					con.close();
					this.setVisible(false);
				}
			catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
	}
			}

}}
