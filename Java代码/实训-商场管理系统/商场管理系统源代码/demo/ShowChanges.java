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

public class ShowChanges extends JPanel implements ActionListener {
	private JLabel L;
	private String s;
	private static String id,nam,sex,zk,cal,zz;
	private JLabel Id,xm,xb,Zk,dh,Zz;
	private JButton esc,ok;
	private JTextField tzh,txm,txb,tzk,tdh,tzz;
	public ShowChanges(String s) {
		// TODO Auto-generated constructor stub
		this.s=s;
		this.setLayout(null);
		this.setBounds(0,0,780,620);
		//按钮
		esc=new JButton("重置");
		esc.setFont(new Font("宋体",Font.PLAIN,15));
		esc.setBounds(175,460,120,40);
		esc.addActionListener(this);
		this.add(esc);
		ok=new JButton("确定修改");
		ok.setFont(new Font("宋体",Font.PLAIN,15));
		ok.setBounds(400,460,120,40);
		ok.addActionListener(this);
		this.add(ok);
		//标签
				L=new JLabel("修改VIP用户信息");
				L.setFont(new Font("宋体",Font.PLAIN,20));
				L.setBounds(320,25,190,35);
				this.add(L);
				Id=new JLabel("账号 :");
				Id.setBounds(150,80,90,30);
				Id.setFont(new Font("宋体",Font.PLAIN,20));
				add(Id);
				xm=new JLabel("姓名 :");
				xm.setBounds(150,130,90,30);
				xm.setFont(new Font("宋体",Font.PLAIN,20));
				add(xm);
				xb=new JLabel("性别 :");
				xb.setBounds(150,180,90,30);
				xb.setFont(new Font("宋体",Font.PLAIN,20));
				add(xb);
				Zk=new JLabel("折扣 :");
				Zk.setBounds(150,230,90,30);
				Zk.setFont(new Font("宋体",Font.PLAIN,20));
				add(Zk);
				dh=new JLabel("电话 :");
				dh.setBounds(150,280,90,30);
				dh.setFont(new Font("宋体",Font.PLAIN,20));
				add(dh);
				Zz=new JLabel("住址 :");
				Zz.setBounds(150,330,90,30);
				Zz.setFont(new Font("宋体",Font.PLAIN,20));
				add(Zz);
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
				String sql1="select * from vip where  id='"+s+"'";
				rs=stmt.executeQuery(sql1);
				while(rs.next()){
					id=rs.getString(1);
					nam=rs.getString(2);
					sex=rs.getString(3);
					zk=rs.getString(4);
					cal=rs.getString(5);
					zz=rs.getString(6);
			}
				//文本框
				tzh=new JTextField(ShowChanges.id);
				tzh.setBounds(270,80,330,30);
				tzh.setEditable(false);
				add(tzh);
				txm=new JTextField(ShowChanges.nam);
				txm.setColumns(10);
				txm.setBounds(270,130,330,30);
				add(txm);
				txb=new JTextField(ShowChanges.sex);
				txb.setColumns(10);
				txb.setBounds(270,180,330,30);
				add(txb);
				tzk=new JTextField(ShowChanges.zk);
				tzk.setColumns(10);
				tzk.setBounds(270,230,330,30);
				add(tzk);
				tdh=new JTextField(ShowChanges.cal);
				tdh.setColumns(10);
				tdh.setBounds(270,280,330,30);
				add(tdh);
				tzz=new JTextField(ShowChanges.zz);
				tzz.setColumns(10);
				tzz.setBounds(270,330,330,30);
				add(tzz);
				stmt.close();
				con.close();
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
			tzk.setText("");
			tdh.setText("");
			tzz.setText("");
		}
		if(e.getSource()==ok){
			if((txm.getText().isEmpty())||(txb.getText().isEmpty())||(tzk.getText().isEmpty())||(tdh.getText().isEmpty())||(tzz.getText().isEmpty()))
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
				String sql="UPDATE vip SET nam=?,"+"sex=?,"+"zk=?,"+"cal=?,"+"zz=? "+"where id ='"+s+"'";
				preparedStatementstatement=con1.prepareStatement(sql);
				preparedStatementstatement.setString(1,txm.getText());
				preparedStatementstatement.setString(2,txb.getText());
				preparedStatementstatement.setString(3,tzk.getText());
				preparedStatementstatement.setString(4,tdh.getText());
				preparedStatementstatement.setString(5,tzz.getText());
				preparedStatementstatement.execute();
				JOptionPane.showMessageDialog(null, "修改VIP成功");
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
		}
		}
}


}
