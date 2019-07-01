package demo;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChangesWoker extends JPanel implements ActionListener {
	private JLabel L;
	private String s;
	private static String 工号,姓名,性别,年龄,部门,职务,电话,月薪,住址;
	private JLabel gh,xm,xb,nl,bm,zw,dh,yx,zz;
	private JButton esc,ok;
	private JTextField tgh,txm,txb,tnl,tbm,tzw,tdh,tyx,tzz;
	public ChangesWoker(String s) {
		// TODO Auto-generated constructor stub
		this.s=s;
		this.setLayout(null);
		this.setBounds(0,0,780,620);
		//按钮
		esc=new JButton("重置");
		esc.setFont(new Font("宋体",Font.PLAIN,15));
		esc.setBounds(195,530,120,40);
		esc.addActionListener(this);
		this.add(esc);
		ok=new JButton("确定修改");
		ok.setFont(new Font("宋体",Font.PLAIN,15));
		ok.setBounds(420,530,120,40);
		ok.addActionListener(this);
		this.add(ok);
		//标签
		L=new JLabel("修改员工信息");
		L.setFont(new Font("宋体",Font.PLAIN,20));
		L.setBounds(320,25,190,35);
		this.add(L);
		gh=new JLabel("工号 :");
		gh.setBounds(150,80,90,30);
		gh.setFont(new Font("宋体",Font.PLAIN,20));
		add(gh);
		xm=new JLabel("姓名 :");
		xm.setBounds(150,130,90,30);
		xm.setFont(new Font("宋体",Font.PLAIN,20));
		add(xm);
		xb=new JLabel("性别 :");
		xb.setBounds(150,180,90,30);
		xb.setFont(new Font("宋体",Font.PLAIN,20));
		add(xb);
		nl=new JLabel("年龄 :");
		nl.setBounds(150,230,90,30);
		nl.setFont(new Font("宋体",Font.PLAIN,20));
		add(nl);
		bm=new JLabel("部门 :");
		bm.setBounds(150,280,90,30);
		bm.setFont(new Font("宋体",Font.PLAIN,20));
		add(bm);
		zw=new JLabel("职务 :");
		zw.setBounds(150,330,90,30);
		zw.setFont(new Font("宋体",Font.PLAIN,20));
		add(zw);
		dh=new JLabel("电话 :");
		dh.setBounds(150,380,90,30);
		dh.setFont(new Font("宋体",Font.PLAIN,20));
		add(dh);
		yx=new JLabel("月薪 :");
		yx.setBounds(150,430,90,30);
		yx.setFont(new Font("宋体",Font.PLAIN,20));
		add(yx);
		zz=new JLabel("住址 :");
		zz.setBounds(150,480,90,30);
		zz.setFont(new Font("宋体",Font.PLAIN,20));
		add(zz);
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
				java.util.Date date=new java.util.Date();
				java.sql.Timestamp tt=new java.sql.Timestamp(date.getTime());
				String sql1="select * from employee where  id='"+s+"'";
				rs=stmt.executeQuery(sql1);
				while(rs.next()){
					工号=rs.getString(1);
					姓名=rs.getString(2);
					性别=rs.getString(3);
					年龄=rs.getString(4);
					部门=rs.getString(5);
					职务=rs.getString(6);
					电话=rs.getString(7);
					月薪=rs.getString(8);
					住址=rs.getString(9);
			}
		//文本框
		tgh=new JTextField(ChangesWoker.工号);
		tgh.setBounds(270,80,330,30);
		tgh.setEditable(false);
		add(tgh);
		txm=new JTextField(ChangesWoker.姓名);
		txm.setColumns(10);
		txm.setBounds(270,130,330,30);
		add(txm);
		txb=new JTextField(ChangesWoker.性别);
		txb.setColumns(10);
		txb.setBounds(270,180,330,30);
		add(txb);
		tnl=new JTextField(ChangesWoker.年龄);
		tnl.setColumns(10);
		tnl.setBounds(270,230,330,30);
		add(tnl);
		tbm=new JTextField(ChangesWoker.部门);
		tbm.setColumns(10);
		tbm.setBounds(270,280,330,30);
		add(tbm);
		tzw=new JTextField(ChangesWoker.职务);
		tzw.setColumns(10);
		tzw.setBounds(270,330,330,30);
		add(tzw);
		tdh=new JTextField(ChangesWoker.电话);
		tdh.setColumns(10);
		tdh.setBounds(270,380,330,30);
		add(tdh);
		tyx=new JTextField(ChangesWoker.月薪);
		tyx.setColumns(10);
		tyx.setBounds(270,430,330,30);
		add(tyx);
		tzz=new JTextField(ChangesWoker.住址);
		tzz.setColumns(10);
		tzz.setBounds(270,480,330,30);
		add(tzz);
//				JOptionPane.showMessageDialog(null, "修改员工成功");
				stmt.close();
				con.close();
//				this.setVisible(false);
//				this.removeAll();
				this.setVisible(true);
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println("浏览员工");
				e2.printStackTrace();
			}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==esc){
			txm.setText("");
			txb.setText("");
			tnl.setText("");
			tbm.setText("");
			tzw.setText("");
			tdh.setText("");
			tyx.setText("");
			tzz.setText("");
		}
		if(e.getSource()==ok){
			if((tgh.getText().isEmpty())||(txm.getText().isEmpty())||(txb.getText().isEmpty())||(tnl.getText().isEmpty())||(tbm.getText().isEmpty())||(tzw.getText().isEmpty())||(tdh.getText().isEmpty())||(tyx.getText().isEmpty())||(tzz.getText().isEmpty()))
				JOptionPane.showMessageDialog(null, "请填写完整信息！");
			else {
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException g) {
					// TODO: handle exception
					System.out.println("找不到驱动！");
				}
			try {
					Connection con1;
					Statement stmt;
					ResultSet rs;
					con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/shangchang?useUnicode=true&characterEncoding=utf8","root","admin");
					stmt=con1.createStatement();
				PreparedStatement preparedStatementstatement;
				String sql="UPDATE employee SET nam=?,"+"sex=?,"+"age=?,"+"bm=?,"+"zw=?,"+"cal=?,"+"money=?,"+"zz=? "+"WHERE id ='"+s+"'";
				preparedStatementstatement=con1.prepareStatement(sql);
				preparedStatementstatement.setString(1,txm.getText());
				preparedStatementstatement.setString(2,txb.getText());
				preparedStatementstatement.setString(3,tnl.getText());
				preparedStatementstatement.setString(4,tbm.getText());
				preparedStatementstatement.setString(5,tzw.getText());
				preparedStatementstatement.setString(6,tdh.getText());
				preparedStatementstatement.setString(7,tyx.getText());
				preparedStatementstatement.setString(8,tzz.getText());
				preparedStatementstatement.execute();
				JOptionPane.showMessageDialog(null, "修改员工成功");
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
		}
		}
}

}
