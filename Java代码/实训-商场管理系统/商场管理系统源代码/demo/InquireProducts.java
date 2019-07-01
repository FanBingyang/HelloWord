package demo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class InquireProducts extends JPanel implements ActionListener{
	private JLabel l;
	private JButton b;
	private JTable table;
	private JTextField t;
	private Object data[][];
	private String [] colname={"编号","商品","厂商","类别","进价","数量","售价","进货时间","总进货",};
	public InquireProducts() {
		// TODO Auto-generated constructor stub
		
		this.setLayout(null);
		this.setBounds(0,0,780,620);
		l=new JLabel("    请输入你要查询的商品编号");
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
				JOptionPane.showMessageDialog(null, "商品编号不能为空！"); 
			else try {
			Connection con;
			java.sql.Statement stmt;
			ResultSet rs;
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shangchang?useUnicode=true&characterEncoding=utf8","root","admin");
			stmt=con.createStatement();
			String sql="select * from 商品总表  where 编号='"+t.getText()+"'";
			rs=stmt.executeQuery(sql);
			data=new Object[1][10];
			int i=0;
			if(rs.next())
			{
				data[i][0]=rs.getString(1);
				data[i][1]=rs.getString(2);
				data[i][2]=rs.getString(3);
				data[i][3]=rs.getString(4);
				data[i][4]=rs.getString(5);
				data[i][5]=rs.getString(6);
				data[i][6]=rs.getString(7);
				data[i][7]=rs.getString(8);
				data[i][8]=rs.getString(9);
				table=new JTable(data,colname);
				this.setVisible(false);
				this.removeAll();
				JScrollPane s=new JScrollPane(table);
				s.setSize(780,580);
				this.add(s);
				this.setVisible(true);
				rs.close();
				con.close();
			}
			else
				JOptionPane.showMessageDialog(null, "无记录！");
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
	
	
	
	
	
	
	
	
	
	
	
	

