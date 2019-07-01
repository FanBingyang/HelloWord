package demo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginVIP extends JPanel implements ActionListener {
	private JLabel L;
	private String tt;
	private JLabel zh,xm,xb,zk,dh,zz;
	private JButton esc,ok;
	private JTextField tzh,txm,txb,tzk,tdh,tzz;
	public LoginVIP() {
		// TODO Auto-generated constructor stub
		this.setLayout(null);
		this.setBounds(0,0,780,620);
		//按钮
		esc=new JButton("重置");
		esc.setFont(new Font("宋体",Font.PLAIN,15));
		esc.setBounds(175,460,120,40);
		esc.addActionListener(this);
		this.add(esc);
		ok=new JButton("确定注册");
		ok.setFont(new Font("宋体",Font.PLAIN,15));
		ok.setBounds(400,460,120,40);
		ok.addActionListener(this);
		this.add(ok);
		//标签
		L=new JLabel("注册VIP用户");
		L.setFont(new Font("宋体",Font.PLAIN,20));
		L.setBounds(320,25,190,35);
		this.add(L);
		zh=new JLabel("账号 :");
		zh.setBounds(150,80,90,30);
		zh.setFont(new Font("宋体",Font.PLAIN,20));
		add(zh);
		xm=new JLabel("姓名 :");
		xm.setBounds(150,130,90,30);
		xm.setFont(new Font("宋体",Font.PLAIN,20));
		add(xm);
		xb=new JLabel("性别 :");
		xb.setBounds(150,180,90,30);
		xb.setFont(new Font("宋体",Font.PLAIN,20));
		add(xb);
		zk=new JLabel("折扣 :");
		zk.setBounds(150,230,90,30);
		zk.setFont(new Font("宋体",Font.PLAIN,20));
		add(zk);
		dh=new JLabel("电话 :");
		dh.setBounds(150,280,90,30);
		dh.setFont(new Font("宋体",Font.PLAIN,20));
		add(dh);
		zz=new JLabel("住址 :");
		zz.setBounds(150,330,90,30);
		zz.setFont(new Font("宋体",Font.PLAIN,20));
		add(zz);
		//文本框
		tzh=new JTextField();
		tzh.setBounds(270,80,330,30);
		add(tzh);
		txm=new JTextField();
		txm.setColumns(10);
		txm.setBounds(270,130,330,30);
		add(txm);
		txb=new JTextField();
		txb.setColumns(10);
		txb.setBounds(270,180,330,30);
		add(txb);
		tzk=new JTextField();
		tzk.setColumns(10);
		tzk.setBounds(270,230,330,30);
		add(tzk);
		tdh=new JTextField();
		tdh.setColumns(10);
		tdh.setBounds(270,280,330,30);
		add(tdh);
		tzz=new JTextField();
		tzz.setColumns(10);
		tzz.setBounds(270,330,330,30);
		add(tzz);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==esc){
			tzh.setText("");
			txm.setText("");
			txb.setText("");
			tzk.setText("");
			tdh.setText("");
			tzz.setText("");
		}
		if(e.getSource()==ok){
			if((tzh.getText().isEmpty())||(txm.getText().isEmpty())||(txb.getText().isEmpty())||(tzk.getText().isEmpty())||(tdh.getText().isEmpty())||(tzz.getText().isEmpty()))
				JOptionPane.showMessageDialog(null, "请填写完整信息！");
			else {
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
				tt=dateFormat.format(calendar.getTime());
				String sql="INSERT INTO VIP (id,nam,sex,zk,cal,zz,tim)"
						+"VALUES("+"'"+tzh.getText()+"',"+"'"+txm.getText()+"',"+"'"+txb.getText()+"',"+"'"+tzk.getText()+"',"+"'"+tdh.getText()+"',"+"'"+tzz.getText()+"',"+"'"+tt+"')";
				stmt.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "注册成功");
				stmt.close();
				con.close();
				tzh.setText("");
				txm.setText("");
				txb.setText("");
				tzk.setText("");
				tdh.setText("");
				tzz.setText("");
				this.setVisible(true);
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		}
}
}
