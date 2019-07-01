package demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

//import com.mysql.jdbc.Statement;

public class ShoppingRecord extends JPanel implements ActionListener{
	private JLabel l;
	private JButton b;
	private JTable table;
	private JTextField t;
	private Object data[][];
	private String [] colname={"账号","姓名","商品名称","数量","金额","购物时间"};
	public ShoppingRecord() {
		// TODO Auto-generated constructor stub
		this.setLayout(null);
		this.setBounds(0,0,780,620);
		l=new JLabel("请输入你要查看购物记录的VIP账号");
		l.setBounds(220,60,400,60);
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
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b){
			if(t.getText().isEmpty())
				JOptionPane.showMessageDialog(null, "VIP账号不能为空！"); 
			else try {
			Connection con;
			java.sql.Statement stmt;
			ResultSet rs;
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shangchang?useUnicode=true&characterEncoding=utf8","root","admin");
			stmt=con.createStatement();
			String sql="select * from shop  where id='"+t.getText()+"'";
			rs=stmt.executeQuery(sql);
			rs.last();
			int n=rs.getRow();
			rs.beforeFirst();
			data=new Object[n][8];
			int i=0;
			if(n==0)
				JOptionPane.showMessageDialog(null, "无记录！");
			else{
				while(rs.next())
			{
				data[i][0]=rs.getString(1);
				data[i][1]=rs.getString(2);
				data[i][2]=rs.getString(3);
				data[i][3]=rs.getString(4);
				data[i][4]=rs.getString(5);
				data[i][5]=rs.getString(6);
				i++;
			}
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
