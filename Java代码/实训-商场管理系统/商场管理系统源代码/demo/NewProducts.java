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
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewProducts extends JPanel implements ActionListener {
	private JLabel L;
	private String tt;
	private JLabel bh,sp,cs,lb,jj,sl,sj,zj;
	private JButton esc,ok;
	private JTextField tbh,tsp,tcs,tlb,tjj,tsl,tsj,tzj;
	public NewProducts() {
		// TODO Auto-generated constructor stub
		this.setLayout(null);
		this.setBounds(0,0,780,620);
		//按钮
		esc=new JButton("重置");
		esc.setFont(new Font("宋体",Font.PLAIN,15));
		esc.setBounds(175,460,120,40);
		esc.addActionListener(this);
		this.add(esc);
		ok=new JButton("确定新进");
		ok.setFont(new Font("宋体",Font.PLAIN,15));
		ok.setBounds(400,460,120,40);
		ok.addActionListener(this);
		this.add(ok);
		//标签
		L=new JLabel("商场新进商品");
		L.setFont(new Font("宋体",Font.PLAIN,20));
		L.setBounds(320,25,190,35);
		this.add(L);
		bh=new JLabel("编号 :");
		bh.setBounds(150,80,90,30);
		bh.setFont(new Font("宋体",Font.PLAIN,20));
		add(bh);
		sp=new JLabel("商品 :");
		sp.setBounds(150,130,90,30);
		sp.setFont(new Font("宋体",Font.PLAIN,20));
		add(sp);
		cs=new JLabel("厂商 :");
		cs.setBounds(150,180,90,30);
		cs.setFont(new Font("宋体",Font.PLAIN,20));
		add(cs);
		lb=new JLabel("类别 :");
		lb.setBounds(150,230,90,30);
		lb.setFont(new Font("宋体",Font.PLAIN,20));
		add(lb);
		jj=new JLabel("进价 :");
		jj.setBounds(150,280,90,30);
		jj.setFont(new Font("宋体",Font.PLAIN,20));
		add(jj);
		sl=new JLabel("数量 :");
		sl.setBounds(150,330,90,30);
		sl.setFont(new Font("宋体",Font.PLAIN,20));
		add(sl);
		sj=new JLabel("售价 :");
		sj.setBounds(150,380,90,30);
		sj.setFont(new Font("宋体",Font.PLAIN,20));
		add(sj);
		//文本框
		tbh=new JTextField();
		tbh.setBounds(270,80,330,30);
		add(tbh);
		tsp=new JTextField();
		tsp.setColumns(10);
		tsp.setBounds(270,130,330,30);
		add(tsp);
		tcs=new JTextField();
		tcs.setColumns(10);
		tcs.setBounds(270,180,330,30);
		add(tcs);
		tlb=new JTextField();
		tlb.setColumns(10);
		tlb.setBounds(270,230,330,30);
		add(tlb);
		tjj=new JTextField();
		tjj.setColumns(10);
		tjj.setBounds(270,280,330,30);
		add(tjj);
		tsj=new JTextField();
		tsj.setColumns(10);
		tsj.setBounds(270,330,330,30);
		add(tsj);
		tsl=new JTextField();
		tsl.setColumns(10);
		tsl.setBounds(270,380,330,30);
		add(tsl);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==esc){
			tbh.setText("");
			tsp.setText("");
			tcs.setText("");
			tlb.setText("");
			tjj.setText("");
			tsj.setText("");
			tsl.setText("");
		}
		if(e.getSource()==ok){
			if((tbh.getText().isEmpty())||(tsp.getText().isEmpty())||(tcs.getText().isEmpty())||(tlb.getText().isEmpty())||(tjj.getText().isEmpty())||(tsj.getText().isEmpty())||(tsl.getText().isEmpty()))
				JOptionPane.showMessageDialog(null, "请填写商品完整信息！");
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
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shangchang?useUnicode=true&characterEncoding=utf8","root","admin");
				stmt=con.createStatement();
				Calendar calendar=Calendar.getInstance();
				SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd");
				tt=dateFormat.format(calendar.getTime());;
				String j,s;
				j=tjj.getText();
				s=tsl.getText();
				int z=Integer.valueOf(j)*Integer.valueOf(s);
				String sql="INSERT INTO 商品总表 (编号,商品,厂商,类别,进价,数量,售价,进货时间,总进货)"
						+"VALUES("+"'"+tbh.getText()+"',"+"'"+tsp.getText()+"',"+"'"+tcs.getText()+"',"+"'"+tlb.getText()+"',"+"'"+tjj.getText()+"',"+"'"+tsl.getText()+"',"+"'"+tsj.getText()+"',"+"'"+tt+"','"+z+"')";
				stmt.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "增加成功");
				stmt.close();
				con.close();
				tbh.setText("");
				tsp.setText("");
				tcs.setText("");
				tlb.setText("");
				tjj.setText("");
				tsj.setText("");
				tsl.setText("");
				this.setVisible(true);
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println("浏览商品");
				e2.printStackTrace();
			}
		}
		}	
	}

	
	
	
	//以下是新增商品的代码//不是更改
//	private JLabel jl1,jl2;
//	private JButton esc,ok;
//	private JTextField jt1,jt2;
//	public NewProducts() {
//		// TODO Auto-generated constructor stub
//		this.setLayout(null);
//		this.setBounds(0,0,780,620);
//		jl1=new JLabel("请输入商品名称:");
//		jl1.setFont(new Font("宋体",Font.PLAIN,16));
//		jl1.setBounds(90,80,190,40);
//		this.add(jl1);
//		jl2=new JLabel("请输入商品的数量:");
//		jl2.setFont(new Font("宋体",Font.PLAIN,16));
//		jl2.setBounds(90,160,190,40);
//		this.add(jl2);
//		jt1=new JTextField();
//		jt1.setBounds(280,80,300,40);
//		this.add(jt1);
//		jt2=new JTextField();
//		jt2.setBounds(280,160,300,40);
//		this.add(jt2);
//		ok=new JButton("确定");
//		ok.setFont(new Font("宋体",Font.PLAIN,16));
//		ok.setBounds(100,220,150,40);
//		ok.addActionListener(this);
//		this.add(ok);
//		esc=new JButton("取消");
//		esc.setFont(new Font("宋体",Font.PLAIN,16));
//		esc.setBounds(350,220,150,40);
//		esc.addActionListener(this);
//		this.add(esc);
//		this.setVisible(true);
//		
//	}
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		if(e.getSource()==ok){
//			try {
//				Class.forName("com.mysql.jdbc.Driver");
//			} catch (ClassNotFoundException g) {
//				// TODO: handle exception
//				System.out.println("找不到驱动！");
//			}
//			try {
//				Connection con;
//				Statement stmt;
//				ResultSet rs;
//				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shangchang?useUnicode=true&characterEncoding=utf8","root","admin");
//				stmt=con.createStatement();
//				java.util.Date date=new java.util.Date();
//				java.sql.Timestamp tt=new java.sql.Timestamp(date.getTime());
//				String sql="  INSERT INTO 商品总表  (商品,数量,进货时间) "+"VALUES ( "+" '"+jt2.getText()+"'," +"  '"+jt1.getText()+"' ,'"+tt+"')";
//				System.out.println(sql);
//				stmt.executeUpdate(sql);
//				JOptionPane.showMessageDialog(null,"添加成功！");
//				stmt.close();
//				con.close();
//				this.setVisible(false);
//				this.removeAll();
//				this.add(new NewProducts());
//				this.setVisible(true);
//			} catch (Exception e1) {
//				// TODO: handle exception
//				System.out.println("连接错误");
//				e1.printStackTrace();
//			}
//		}
//	}

}












//package demo;
//
//import java.awt.Component;
//import java.awt.Font;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.security.Timestamp;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.Date;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JTextField;
//
//public class NewProducts extends JPanel implements ActionListener {
//	private JLabel jl1,jl2;
//	private JButton esc,ok;
//	private JTextField jt1,jt2;
//	public NewProducts() {
//		// TODO Auto-generated constructor stub
//		this.setLayout(null);
//		this.setBounds(0,0,780,620);
//		jl1=new JLabel("请输入商品名称:");
//		jl1.setFont(new Font("宋体",Font.PLAIN,16));
//		jl1.setBounds(90,80,190,40);
//		this.add(jl1);
//		jl2=new JLabel("请输入商品的数量:");
//		jl2.setFont(new Font("宋体",Font.PLAIN,16));
//		jl2.setBounds(90,160,190,40);
//		this.add(jl2);
//		jt1=new JTextField();
//		jt1.setBounds(280,80,300,40);
//		this.add(jt1);
//		jt2=new JTextField();
//		jt2.setBounds(280,160,300,40);
//		this.add(jt2);
//		ok=new JButton("确定");
//		ok.setFont(new Font("宋体",Font.PLAIN,16));
//		ok.setBounds(100,220,150,40);
//		ok.addActionListener(this);
//		this.add(ok);
//		esc=new JButton("取消");
//		esc.setFont(new Font("宋体",Font.PLAIN,16));
//		esc.setBounds(350,220,150,40);
//		esc.addActionListener(this);
//		this.add(esc);
//		this.setVisible(true);
//		
//	}
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		if(e.getSource()==ok){
//			try {
//				Class.forName("com.mysql.jdbc.Driver");
//			} catch (ClassNotFoundException g) {
//				// TODO: handle exception
//				System.out.println("找不到驱动！");
//			}
//			try {
//				Connection con;
//				Statement stmt;
//				ResultSet rs;
//				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shangchang?useUnicode=true&characterEncoding=utf8","root","admin");
//				stmt=con.createStatement();
//				java.util.Date date=new java.util.Date();
//				java.sql.Timestamp tt=new java.sql.Timestamp(date.getTime());
//				String sql="  INSERT INTO 商品总表  (商品,数量,进货时间) "+"VALUES ( "+" '"+jt1.getText()+"'," +"  '"+jt2.getText()+"' ,'"+tt+"')";
//				System.out.println(sql);
//				stmt.executeUpdate(sql);
//				JOptionPane.showMessageDialog(null,"添加成功！");
//				stmt.close();
//				con.close();
//				this.setVisible(false);
//				this.removeAll();
//				this.add(new NewProducts());
//				this.setVisible(true);
//			} catch (Exception e1) {
//				// TODO: handle exception
//				System.out.println("连接错误");
//				e1.printStackTrace();
//			}
//		}
//	}
//
//}
