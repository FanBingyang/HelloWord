package demo;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class BrowseVIP extends JPanel {
	private Object data[][];  //表格
	private String [] colname={"账号","姓名","性别","折扣","电话","住址","注册时间"};    //边框
	//显示的面板
	public BrowseVIP(){
		data=this.loadData();  //调用下面方法
		JTable table=new JTable(data,colname);    //框  目的显示边框和表格
		JScrollPane Jsp=new JScrollPane(table); //面板
		this.add(Jsp,BorderLayout.CENTER);       //面板布局
		this.setBounds(0,0,785,580);       //面板位置和大小
		Jsp.setPreferredSize(new Dimension(780,580));
	}
	private Object[][] loadData() {
		try{
			Class.forName("com.mysql.jdbc.Driver");  //驱动
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/shangchang?useUnicode=true&characterEncoding=utf8","root","admin");
			java.sql.Statement stmt=conn.createStatement();
			String sql="select * from vip";   //调用表
			ResultSet rs=stmt.executeQuery(sql);
            rs.last();
            int n=rs.getRow();
			data=new Object[n][8];
			int i=0;
			rs.beforeFirst();
			while(rs.next()){
				data[i][0]=rs.getString(1);
				data[i][1]=rs.getString(2);
				data[i][2]=rs.getString(3);
				data[i][3]=rs.getString(4);
				data[i][4]=rs.getString(5);
				data[i][5]=rs.getString(6);
				data[i][6]=rs.getString(7);
				i++;
			}
			rs.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return data;
	}
}
