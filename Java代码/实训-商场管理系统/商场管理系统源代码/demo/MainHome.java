package demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextField;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel; 
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MainHome extends JFrame implements ActionListener{
//	private static final long serialVersionUID = 1L;
	private static String s,id,name;
	private static JPanel contentPanel;
	private JPanel a,b,c,d;    //定义选项卡窗格的四个面板
	private JButton cancel,exit,backups,person,help;   //定义注销用户，退出系统，系统备份，个人信息，帮助等五个面板的按钮
	//下面定义选项卡窗格的四个面板的子面板
	private JButton[] a_button={new JButton("浏览商品"),new JButton("查询商品"),new JButton("新进商品"),new JButton("删除商品"),new JButton("更新商品")};
	private JButton[] b_button={new JButton("浏览VIP"),new JButton("购物记录"),new JButton("注册VIP"),new JButton("查看修改"),new JButton("注销VIP")};
	private JButton[] c_button={new JButton("浏览员工"),new JButton("查询员工"),new JButton("注册员工"),new JButton("修改员工"),new JButton("注销员工")};
	private JButton[] d_button={new JButton("单日查询"),new JButton("单月查询"),new JButton("年份查询"),new JButton("浏览全部"),new JButton("总额查询")};
	JPanel a1=new JPanel(new FlowLayout(FlowLayout.CENTER,0,50));
	JPanel a2=new JPanel();
	JPanel b1=new JPanel(new FlowLayout(FlowLayout.CENTER,0,50));
	JPanel b2=new JPanel();
	JPanel c1=new JPanel(new FlowLayout(FlowLayout.CENTER,0,50));
	JPanel c2=new JPanel();
	JPanel d1=new JPanel(new FlowLayout(FlowLayout.CENTER,0,50));
	JPanel d2=new JPanel();
	private JTabbedPane tablePane;
	public MainHome(String s){
		super("商场信息管理系统");
		this.s=s;
		contentPanel=new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));/*EmptyBorder(int top,int left,int bottom,int right)创建具有指定insets的空边框，top - 边框顶部 inset，left - 边框左部 inset
		bottom - 边框底部 inset，right - 边框右部 inset*/
		contentPanel.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(contentPanel);
		
		//第一行选项
		cancel=new JButton("注销用户");
		cancel.addActionListener(this);
		cancel.setBounds(0, 0, 120, 20);//setBounds(int x,int y,int width,int height),移动组件并调整其大小。x和y指定左上角的新位置，width和height设置新的大小
		contentPanel.add(cancel);
		exit=new JButton("退出系统");
		exit.addActionListener(this);
		exit.setBounds(120, 0, 120, 20);
		contentPanel.add(exit);
		backups=new JButton("系统备份");
		backups.addActionListener(this);
		backups.setBounds(240,0,120,20);
		contentPanel.add(backups);
		help=new JButton("帮助");
		help.addActionListener(this);
		help.setBounds(360,0, 120,20);
		contentPanel.add(help);
		
		//第二行选项
		//账号和文本框
		try {
			Connection con;
			java.sql.Statement stmt;
			ResultSet rs;
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shangchang?useUnicode=true&characterEncoding=utf8","root","admin");
			stmt=con.createStatement();
			String sql="select * from person  where id='"+s+"'";
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				id=rs.getString("id");
				name=rs.getString("nam");
			}
			con.close();
			rs.close();
			stmt.close();
		} catch (ClassNotFoundException e1) {
			// TODO: handle exception
			e1.printStackTrace();
		}catch (SQLException e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}	
		JLabel label=new JLabel("账号 ");
		label.setFont(new Font("宋体",Font.PLAIN,13)); // setFont(String f)用于创建字体，f为一个新的Font(String name,int style,int size)根据指定名称、样式和磅值大小，创建一个新 Font
		label.setBounds(10, 20, 40, 25);
		contentPanel.add(label);
		TextField textField=new TextField(MainHome.id);
		textField.setEditable(false);
		textField.setBounds(55,20, 90,20);
		contentPanel.add(textField);
		//姓名和文本框
		JLabel label2=new JLabel("姓名 ");
		label2.setBounds(180, 20, 40, 25);
		label2.setFont(new Font("宋体", Font.PLAIN, 13));
		contentPanel.add(label2);
		TextField textField2=new TextField(MainHome.name);
		textField2.setEditable(false);
		textField2.setBounds(230, 20, 80, 25);
		contentPanel.add(textField2);
		//个人信息
		person=new JButton("个人信息");
		person.setBounds(320, 20, 90, 25);
		person.setFont(new Font("宋体", Font.PLAIN, 13));
		contentPanel.add(person);
		person.addActionListener(this);
		//存放时间的标签
		JTextField clock=new JTextField(18);
		JLabel label_t=new JLabel("时间 ");
		label_t.setFont(new Font("宋体",Font.PLAIN,13));
		label_t.setBounds(440,20, 55, 20);
		TimerTask task=new TimerTask()
	    {
			public void run()
	        {
				String sdate;
	            sdate=(new SimpleDateFormat("yyyy年MM月dd日  EEEE HH:mm:ss")).format(new Date());
	            clock.setText(sdate);
	        }
	        };
	    Timer t=new Timer();
	    t.scheduleAtFixedRate(task, new Date(),1000);
	    clock.setEditable(false);
		contentPanel.add(label_t);
		clock.setBounds(470, 20, 200, 20);
		contentPanel.add(clock);
		
		tablePane=new JTabbedPane();  //定义一个选项卡窗格并命名为tablePane并置于顶层
		tablePane.setBounds(0, 50, 900, 650);
		a=new JPanel(null);   //实例化面板
		b=new JPanel(null);
		c=new JPanel(null);
		d=new JPanel(null);
		//面板信息及其顺序 
		/*public void addTab(String title,Icon icon,Component component,String tip)，添加由 title 和/或 icon 表示的 component 和 tip，其中任意一个都可以为 null。insertTab 的覆盖方法。
		* title - 此选项卡中要显示的标题 ，icon - 此选项卡中要显示的图标，component - 单击此选项卡时要显示的组件，tip - 此选项卡要显示的工具提示*/
		tablePane.addTab("商品信息管理模块",null,a ,"商品信息管理模块");
		tablePane.addTab("VIP信息管理模块",null,b ,"VIP信息管理模块");
		tablePane.addTab("商场人事管理模块",null,c ,"商场人事管理模块");
		tablePane.addTab("商场销售管理模块",null,d ,"商场销售管理模块");
		
		//商品信息管理模块
		/*public FlowLayout(int align,int hgap,int vgap),创建一个新的流布局管理器，它具有指定的对齐方式以及指定的水平和垂直间隙。 
		 * align 参数的值必须是以下值之一：FlowLayout.LEFT、FlowLayout.RIGHT、FlowLayout.CENTER、FlowLayout.LEADING 或 FlowLayout.TRAILING。 
		 * align - 对齐值, hgap - 组件之间以及组件与 Container 的边之间的水平间隙,vgap - 组件之间以及组件与 Container 的边之间的垂直间隙*/
//		a1=new JPanel(new FlowLayout(FlowLayout.CENTER,0,50));
		JPanel pa_Top=new JPanel(new FlowLayout(FlowLayout.LEFT));
		pa_Top.setBounds(0, 0, 900, 30);
		JButton shangpin=new JButton("商品信息面板");	
		shangpin.setBounds(0, 30, 110,620);
		shangpin.setFont(new Font("宋体", Font.PLAIN, 16));
		pa_Top.setSize(900, 30);
		pa_Top.add(shangpin);
		pa_Top.setBackground(Color.LIGHT_GRAY);
		for(int i=0;i<a_button.length;i++)
		{
			a1.add(a_button[i]);
			a_button[i].addActionListener(this);
			a_button[i].setFont(new Font("楷体",Font.PLAIN,16));
		}
		a1.setBounds(0, 30, 110, 620);
		a1.setBackground(Color.cyan);
		a.add(a1);
		a2.setLayout(null);
		a2.setBounds(110,30,780,620);
		a2.setBackground(Color.white);
		a.add(pa_Top);
		a.add(a2);
		
		//VIP信息管理模块
		JPanel pb_Top=new JPanel(new FlowLayout(FlowLayout.LEFT));
		pb_Top.setBounds(0,0,900,30);
		JButton vip=new JButton("VIP信息面板");
		vip.setBounds(0, 30, 110,620);
		vip.setFont(new Font("宋体", Font.PLAIN, 16));
		pb_Top.setSize(900, 30);
		pb_Top.add(vip);
		pb_Top.setBackground(Color.LIGHT_GRAY);
		for(int i=0;i<b_button.length;i++)
		{
			b1.add(b_button[i]);
			b_button[i].setFont(new Font("楷体",Font.PLAIN,16));
			b_button[i].addActionListener(this);
		}
		b1.setBounds(0,30,110,620);
		b1.setBackground(Color.cyan);
		b.add(b1);
		b2.setLayout(null);
		b2.setBackground(Color.white);
		b2.setBounds(110,30,780,620);
		b.add(b2);
		b.add(pb_Top);
		
		//商场人事管理模块
		JPanel pc_Top=new JPanel(new FlowLayout(FlowLayout.LEFT));
		pc_Top.setBounds(0,0,900,30);
		JButton shangchang=new JButton("商场人事管理面板");
		shangchang.setBounds(0, 30, 110,620);
		shangchang.setFont(new Font("宋体", Font.PLAIN, 16));
		pc_Top.setSize(900, 30);
		pc_Top.add(shangchang);
		pc_Top.setBackground(Color.LIGHT_GRAY);
		for(int i=0;i<c_button.length;i++)
		{
			c1.add(c_button[i]);
			c_button[i].setFont(new Font("楷体",Font.PLAIN,16));
			c_button[i].addActionListener(this);
		}
		c1.setBounds(0,30,110,620);
		c1.setBackground(Color.cyan);
		c.add(c1);
		c2.setLayout(null);
		c2.setBackground(Color.white);
		c2.setBounds(110,30,780,620);
		c.add(c2);
		c.add(pc_Top);
		
		//商场销售管理模块
		JPanel pd_Top=new JPanel(new FlowLayout(FlowLayout.LEFT));
		pd_Top.setBounds(0,0,900,30);
		JButton xiaoshou=new JButton("商场销售管理面板");
		xiaoshou.setBounds(0, 30, 110,620);
		xiaoshou.setFont(new Font("宋体", Font.PLAIN, 16));
		pd_Top.setSize(900, 30);
		pd_Top.add(xiaoshou);
		pd_Top.setBackground(Color.LIGHT_GRAY);
		for(int i=0;i<d_button.length;i++)
		{
			d1.add(d_button[i]);
			d_button[i].setFont(new Font("楷体",Font.PLAIN,16));
			d_button[i].addActionListener(this);
		}
		d1.setBounds(0,30,110,620);
		d1.setBackground(Color.cyan);
		d.add(d1);
		d2.setLayout(null);
		d2.setBackground(Color.white);
		d2.setBounds(110,30,780,620);
		d.add(d2);
		d.add(pd_Top);
		

		
		this.setBounds(100,60,900,730);
		this.add(tablePane);
		this.setSize(900, 730);
		this.setVisible(true);
		//this.setResizable(false);  //设置窗口大小不可改变
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(contentPanel);
	}	
//	public static void main(String[] args) {
//		MainHome app=new MainHome();
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==backups){
			JLabel jl=new JLabel("系统备份成功！");
			jl.setFont(new Font("宋体",Font.PLAIN,15));
			JOptionPane j=new JOptionPane();
			JOptionPane.showMessageDialog(null, jl,"系统提示",JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getSource()==help){
			new Help();
		}
		if (e.getSource()==cancel) {
			JLabel jl=new JLabel("账户已注销！");
			jl.setFont(new Font("宋体",Font.PLAIN,15));
			JOptionPane J=new JOptionPane();
			JOptionPane.showMessageDialog(this, jl,"系统提示",JOptionPane.INFORMATION_MESSAGE);
			new Register();
			this.dispose();			
		}
		if (e.getSource()==exit) {
			new Bay(this);
		}
		if(e.getSource()==person){
			PersonalInformation app=new PersonalInformation(s);
		}
		if(e.getSource()==a_button[0]){    
			a2.setVisible(false);
			a2.removeAll();//public void removeAll()从此容器中移除所有组件。此方法还通知布局管理器，通过 removeLayoutComponent 方法从此容器的布局中移除这些组件。
			a2.add(new BrowseProducts());       //浏览商品
			a2.setVisible(true);
		}
		if(e.getSource()==a_button[1]){
			a2.setVisible(false);
			a2.removeAll();
			a2.add(new  InquireProducts());     //查询商品
			a2.setVisible(true);
		}
		if(e.getSource()==a_button[2]){
			a2.setVisible(false);
			a2.removeAll();
			a2.add(new  NewProducts());        //新进商品
			a2.setVisible(true);
		}
		if(e.getSource()==a_button[3]){
			a2.setVisible(false);
			a2.removeAll();
			a2.add(new  DeleteProducts());     //删除商品
			a2.setVisible(true);
		}
		if(e.getSource()==a_button[4]){
			a2.setVisible(false);
			a2.removeAll();
			JOptionPane.showMessageDialog(null, "商品更新完毕，以下是最新商品信息！");
			a2.add(new  BrowseProducts());      //更新商品
			a2.setVisible(true);
		}
		if(e.getSource()==b_button[0]){
			b2.setVisible(false);
			b2.removeAll();
			b2.add(new  BrowseVIP());      // 浏览VIP
			b2.setVisible(true);
		}
		if(e.getSource()==b_button[1]){
			b2.setVisible(false);
			b2.removeAll();
			b2.add(new  ShoppingRecord());      //购物记录
			b2.setVisible(true);
		}
		if(e.getSource()==b_button[2]){
			b2.setVisible(false);
			b2.removeAll();
			b2.add(new  LoginVIP());      //注册VIP
			b2.setVisible(true);
		}
		if(e.getSource()==b_button[3]){
			b2.setVisible(false);
			b2.removeAll();
			b2.add(new  ShowChanges_1());      //查看修改
			b2.setVisible(true);
		}
		if(e.getSource()==b_button[4]){
			b2.setVisible(false);
			b2.removeAll();
			b2.add(new  CancelVIP());      //注销VIP
			b2.setVisible(true);
		}
		if(e.getSource()==c_button[0]){
			c2.setVisible(false);
			c2.removeAll();
			c2.add(new  BrowseWoker());      //浏览员工
			c2.setVisible(true);
		}
		if(e.getSource()==c_button[1]){
			c2.setVisible(false);
			c2.removeAll();
			c2.add(new  InquireWoker());      //查询员工
			c2.setVisible(true);
		}
		if(e.getSource()==c_button[2]){
			c2.setVisible(false);
			c2.removeAll();
			c2.add(new LoginWoker());      //注册员工
			c2.setVisible(true);
		}
		if(e.getSource()==c_button[3]){
			c2.setVisible(false);
			c2.removeAll();
			c2.add(new  ChangesWoker_1());      //修改员工
			c2.setVisible(true);
		}
		if(e.getSource()==c_button[4]){
			c2.setVisible(false);
			c2.removeAll();
			c2.add(new  CancelWoker());      //注销员工
			c2.setVisible(true);
		}
		else if(e.getSource()==d_button[0]){
			d2.setVisible(false);
			d2.removeAll();
			d2.add(new  DayInquire());      //单日查询
			d2.setVisible(true);
		}
		else if(e.getSource()==d_button[1]){
			d2.setVisible(false);
			d2.removeAll();
			d2.add(new  MonthInquire());      //单月查询
			d2.setVisible(true);
		}
		else if(e.getSource()==d_button[2]){
			d2.setVisible(false);
			d2.removeAll();
			d2.add(new  YearInquire());      //年份查询
			d2.setVisible(true);
		}
		else if(e.getSource()==d_button[3]){
			d2.setVisible(false);
			d2.removeAll();
			d2.add(new  ShowAll());      //浏览全部
			d2.setVisible(true);
		}
		else if(e.getSource()==d_button[4]){
			d2.setVisible(false);
			d2.removeAll();
			d2.add(new  AllInquire());      //总额查询
			d2.setVisible(true);
		}
	}
}
