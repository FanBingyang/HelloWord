package demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PersonalInformation extends JFrame implements ActionListener{
	private static String id;
	private static String name;
	private static String sex;
	private static String ����;
	
	private static String ְ��;
	private String s;
	private static String time=null;
	private JPasswordField a,b;
	private JButton esc=new JButton("�˳�");
	private JButton change=new JButton("�޸�����");
	JLabel [] jl={new JLabel("����Ա��������"),new JLabel("�˺�"),new JLabel("����"),new JLabel("�Ա�"),new JLabel("����"),new JLabel("ְ��"),new JLabel("ע��ʱ��"),new JLabel("������������ :"),new JLabel("��ȷ������  :")};  
	public PersonalInformation(String s){
		super("��������");
		this.s=s;
		Container c=getContentPane();
		c.setLayout(null);
		try {
			Connection con;
			java.sql.Statement stmt;
			ResultSet rs;
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shangchang?useUnicode=true&characterEncoding=utf8","root","admin");
			stmt=con.createStatement();
			String sql="select * from person where id='"+s+"'";
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				id=rs.getString(1);
				name=rs.getString(3);
				sex=rs.getString(4);
				����=rs.getString(5);
				ְ��=rs.getString(6);
				time=rs.getString(7);
			}
			rs.close();
			stmt.close();
		} catch (ClassNotFoundException e1) {
			// TODO: handle exception
			e1.printStackTrace();
		}catch (SQLException e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
		a=new JPasswordField();
		b=new JPasswordField();
		JTextField [] t={new JTextField(PersonalInformation.id),new JTextField(PersonalInformation.name),new JTextField(PersonalInformation.sex),new JTextField(PersonalInformation.����),new JTextField(PersonalInformation.ְ��), new JTextField(PersonalInformation.time)};
		jl[0].setBounds(100,20,200,20);
		jl[1].setBounds(20,60,60,20);
		jl[2].setBounds(20,90,60,20);
		jl[3].setBounds(150,90,60,20);
		jl[4].setBounds(20,120,60,20);
		jl[5].setBounds(150,120,60,20);
		jl[6].setBounds(20,150,60,20);
		jl[7].setBounds(20,180,90,20);
		jl[8].setBounds(20,210,90,20);
		t[0].setBounds(60,60,80,20);
		t[1].setBounds(60,90,80,20);
		t[2].setBounds(190,90,80,20);
		t[3].setBounds(60,120,80,20);
		t[4].setBounds(190,120,80,20);
		t[5].setBounds(80,150,190,20);
		a.setBounds(110,180,160,20);
		b.setBounds(110,210,160,20);
		c.add(a);
		c.add(b);
		for (int i = 0; i < jl.length; i++) {
			if (i<t.length) {
				c.add(t[i]);
				t[i].setEditable(false);
			}
			c.add(jl[i]);
		}
		esc.setBounds(30,250,100,30);
		change.setBounds(150,250,100,30);
		esc.addActionListener(this);
		change.addActionListener(this);
		c.add(esc);
		c.add(change);
		this.setSize(300,350);
		this.setVisible(true);
		this.setLocation(100, 200);
		this.setResizable(false);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==esc)
			this.dispose();
		if (e.getSource()==change) {
			if((a.getText().isEmpty())||(b.getText().isEmpty()))
				JOptionPane.showMessageDialog(null, "�뽫��������ȫ�����룡");
			else if(!a.getText().equals(b.getText()))
				JOptionPane.showMessageDialog(null, "�����������벻һ�£�");
			else {
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException g) {
					// TODO: handle exception
					System.out.println("�Ҳ���������");
				}
			try {
					Connection con1;
					java.sql.Statement stmt;
					ResultSet rs;
					con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/shangchang?useUnicode=true&characterEncoding=utf8","root","admin");
					stmt=con1.createStatement();
				PreparedStatement preparedStatementstatement;
				String sql="UPDATE person SET pass=? "+"where id ='"+s+"'";
				preparedStatementstatement=con1.prepareStatement(sql);
				preparedStatementstatement.setString(1,a.getText());
				preparedStatementstatement.execute();
				JOptionPane.showMessageDialog(null, "�޸�����ɹ�");
				this.dispose();
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
			}
			
		}
	}
}

