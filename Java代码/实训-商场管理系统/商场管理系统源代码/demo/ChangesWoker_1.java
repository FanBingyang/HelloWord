package demo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChangesWoker_1 extends JPanel implements ActionListener {
	private JLabel l;
	private JButton b;
	private JTextField t;
	private String s;
	public ChangesWoker_1() {
		// TODO Auto-generated constructor stub
		
		this.setLayout(null);
		this.setBounds(0,0,780,620);
		l=new JLabel("    请输入你要修改的员工工号");
		l.setBounds(230,60,300,60);
		l.setForeground(Color.blue);
		l.setFont(new Font("宋体",Font.PLAIN,20));
		this.add(l);
		b=new JButton("查询");
		b.setBounds(300,250,160,60);
		b.addActionListener(this);
		this.add(b);
		t=new JTextField();
		t.setBounds(180,170,400,40);
		this.add(t);
		this.setVisible(true);
//		this.add(table);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b){
			if(t.getText().isEmpty())
				JOptionPane.showMessageDialog(null, "员工工号不能为空！"); 
			else try {
			Connection con;
			java.sql.Statement stmt;
			ResultSet rs;
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shangchang?useUnicode=true&characterEncoding=utf8","root","admin");
			stmt=con.createStatement();
			String sql="select * from employee  where id='"+t.getText()+"'";
			rs=stmt.executeQuery(sql);
			if(rs.next())
			{
				s=rs.getString(1);
				this.setVisible(false);
				this.removeAll();
				this.add(new ChangesWoker(s));
				this.setVisible(true);
			}
			else
				JOptionPane.showMessageDialog(null, "无记录！");
			rs.close();
			con.close();			
		} catch (ClassNotFoundException e1) {
			// TODO: handle exception
			e1.printStackTrace();
		}catch (SQLException e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
		}
		
	}
	
	

}
