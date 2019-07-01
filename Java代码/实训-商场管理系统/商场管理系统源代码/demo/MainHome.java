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
	private JPanel a,b,c,d;    //����ѡ�������ĸ����
	private JButton cancel,exit,backups,person,help;   //����ע���û����˳�ϵͳ��ϵͳ���ݣ�������Ϣ��������������İ�ť
	//���涨��ѡ�������ĸ����������
	private JButton[] a_button={new JButton("�����Ʒ"),new JButton("��ѯ��Ʒ"),new JButton("�½���Ʒ"),new JButton("ɾ����Ʒ"),new JButton("������Ʒ")};
	private JButton[] b_button={new JButton("���VIP"),new JButton("�����¼"),new JButton("ע��VIP"),new JButton("�鿴�޸�"),new JButton("ע��VIP")};
	private JButton[] c_button={new JButton("���Ա��"),new JButton("��ѯԱ��"),new JButton("ע��Ա��"),new JButton("�޸�Ա��"),new JButton("ע��Ա��")};
	private JButton[] d_button={new JButton("���ղ�ѯ"),new JButton("���²�ѯ"),new JButton("��ݲ�ѯ"),new JButton("���ȫ��"),new JButton("�ܶ��ѯ")};
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
		super("�̳���Ϣ����ϵͳ");
		this.s=s;
		contentPanel=new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));/*EmptyBorder(int top,int left,int bottom,int right)��������ָ��insets�Ŀձ߿�top - �߿򶥲� inset��left - �߿��� inset
		bottom - �߿�ײ� inset��right - �߿��Ҳ� inset*/
		contentPanel.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(contentPanel);
		
		//��һ��ѡ��
		cancel=new JButton("ע���û�");
		cancel.addActionListener(this);
		cancel.setBounds(0, 0, 120, 20);//setBounds(int x,int y,int width,int height),�ƶ�������������С��x��yָ�����Ͻǵ���λ�ã�width��height�����µĴ�С
		contentPanel.add(cancel);
		exit=new JButton("�˳�ϵͳ");
		exit.addActionListener(this);
		exit.setBounds(120, 0, 120, 20);
		contentPanel.add(exit);
		backups=new JButton("ϵͳ����");
		backups.addActionListener(this);
		backups.setBounds(240,0,120,20);
		contentPanel.add(backups);
		help=new JButton("����");
		help.addActionListener(this);
		help.setBounds(360,0, 120,20);
		contentPanel.add(help);
		
		//�ڶ���ѡ��
		//�˺ź��ı���
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
		JLabel label=new JLabel("�˺� ");
		label.setFont(new Font("����",Font.PLAIN,13)); // setFont(String f)���ڴ������壬fΪһ���µ�Font(String name,int style,int size)����ָ�����ơ���ʽ�Ͱ�ֵ��С������һ���� Font
		label.setBounds(10, 20, 40, 25);
		contentPanel.add(label);
		TextField textField=new TextField(MainHome.id);
		textField.setEditable(false);
		textField.setBounds(55,20, 90,20);
		contentPanel.add(textField);
		//�������ı���
		JLabel label2=new JLabel("���� ");
		label2.setBounds(180, 20, 40, 25);
		label2.setFont(new Font("����", Font.PLAIN, 13));
		contentPanel.add(label2);
		TextField textField2=new TextField(MainHome.name);
		textField2.setEditable(false);
		textField2.setBounds(230, 20, 80, 25);
		contentPanel.add(textField2);
		//������Ϣ
		person=new JButton("������Ϣ");
		person.setBounds(320, 20, 90, 25);
		person.setFont(new Font("����", Font.PLAIN, 13));
		contentPanel.add(person);
		person.addActionListener(this);
		//���ʱ��ı�ǩ
		JTextField clock=new JTextField(18);
		JLabel label_t=new JLabel("ʱ�� ");
		label_t.setFont(new Font("����",Font.PLAIN,13));
		label_t.setBounds(440,20, 55, 20);
		TimerTask task=new TimerTask()
	    {
			public void run()
	        {
				String sdate;
	            sdate=(new SimpleDateFormat("yyyy��MM��dd��  EEEE HH:mm:ss")).format(new Date());
	            clock.setText(sdate);
	        }
	        };
	    Timer t=new Timer();
	    t.scheduleAtFixedRate(task, new Date(),1000);
	    clock.setEditable(false);
		contentPanel.add(label_t);
		clock.setBounds(470, 20, 200, 20);
		contentPanel.add(clock);
		
		tablePane=new JTabbedPane();  //����һ��ѡ���������ΪtablePane�����ڶ���
		tablePane.setBounds(0, 50, 900, 650);
		a=new JPanel(null);   //ʵ�������
		b=new JPanel(null);
		c=new JPanel(null);
		d=new JPanel(null);
		//�����Ϣ����˳�� 
		/*public void addTab(String title,Icon icon,Component component,String tip)������� title ��/�� icon ��ʾ�� component �� tip����������һ��������Ϊ null��insertTab �ĸ��Ƿ�����
		* title - ��ѡ���Ҫ��ʾ�ı��� ��icon - ��ѡ���Ҫ��ʾ��ͼ�꣬component - ������ѡ�ʱҪ��ʾ�������tip - ��ѡ�Ҫ��ʾ�Ĺ�����ʾ*/
		tablePane.addTab("��Ʒ��Ϣ����ģ��",null,a ,"��Ʒ��Ϣ����ģ��");
		tablePane.addTab("VIP��Ϣ����ģ��",null,b ,"VIP��Ϣ����ģ��");
		tablePane.addTab("�̳����¹���ģ��",null,c ,"�̳����¹���ģ��");
		tablePane.addTab("�̳����۹���ģ��",null,d ,"�̳����۹���ģ��");
		
		//��Ʒ��Ϣ����ģ��
		/*public FlowLayout(int align,int hgap,int vgap),����һ���µ������ֹ�������������ָ���Ķ��뷽ʽ�Լ�ָ����ˮƽ�ʹ�ֱ��϶�� 
		 * align ������ֵ����������ֵ֮һ��FlowLayout.LEFT��FlowLayout.RIGHT��FlowLayout.CENTER��FlowLayout.LEADING �� FlowLayout.TRAILING�� 
		 * align - ����ֵ, hgap - ���֮���Լ������ Container �ı�֮���ˮƽ��϶,vgap - ���֮���Լ������ Container �ı�֮��Ĵ�ֱ��϶*/
//		a1=new JPanel(new FlowLayout(FlowLayout.CENTER,0,50));
		JPanel pa_Top=new JPanel(new FlowLayout(FlowLayout.LEFT));
		pa_Top.setBounds(0, 0, 900, 30);
		JButton shangpin=new JButton("��Ʒ��Ϣ���");	
		shangpin.setBounds(0, 30, 110,620);
		shangpin.setFont(new Font("����", Font.PLAIN, 16));
		pa_Top.setSize(900, 30);
		pa_Top.add(shangpin);
		pa_Top.setBackground(Color.LIGHT_GRAY);
		for(int i=0;i<a_button.length;i++)
		{
			a1.add(a_button[i]);
			a_button[i].addActionListener(this);
			a_button[i].setFont(new Font("����",Font.PLAIN,16));
		}
		a1.setBounds(0, 30, 110, 620);
		a1.setBackground(Color.cyan);
		a.add(a1);
		a2.setLayout(null);
		a2.setBounds(110,30,780,620);
		a2.setBackground(Color.white);
		a.add(pa_Top);
		a.add(a2);
		
		//VIP��Ϣ����ģ��
		JPanel pb_Top=new JPanel(new FlowLayout(FlowLayout.LEFT));
		pb_Top.setBounds(0,0,900,30);
		JButton vip=new JButton("VIP��Ϣ���");
		vip.setBounds(0, 30, 110,620);
		vip.setFont(new Font("����", Font.PLAIN, 16));
		pb_Top.setSize(900, 30);
		pb_Top.add(vip);
		pb_Top.setBackground(Color.LIGHT_GRAY);
		for(int i=0;i<b_button.length;i++)
		{
			b1.add(b_button[i]);
			b_button[i].setFont(new Font("����",Font.PLAIN,16));
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
		
		//�̳����¹���ģ��
		JPanel pc_Top=new JPanel(new FlowLayout(FlowLayout.LEFT));
		pc_Top.setBounds(0,0,900,30);
		JButton shangchang=new JButton("�̳����¹������");
		shangchang.setBounds(0, 30, 110,620);
		shangchang.setFont(new Font("����", Font.PLAIN, 16));
		pc_Top.setSize(900, 30);
		pc_Top.add(shangchang);
		pc_Top.setBackground(Color.LIGHT_GRAY);
		for(int i=0;i<c_button.length;i++)
		{
			c1.add(c_button[i]);
			c_button[i].setFont(new Font("����",Font.PLAIN,16));
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
		
		//�̳����۹���ģ��
		JPanel pd_Top=new JPanel(new FlowLayout(FlowLayout.LEFT));
		pd_Top.setBounds(0,0,900,30);
		JButton xiaoshou=new JButton("�̳����۹������");
		xiaoshou.setBounds(0, 30, 110,620);
		xiaoshou.setFont(new Font("����", Font.PLAIN, 16));
		pd_Top.setSize(900, 30);
		pd_Top.add(xiaoshou);
		pd_Top.setBackground(Color.LIGHT_GRAY);
		for(int i=0;i<d_button.length;i++)
		{
			d1.add(d_button[i]);
			d_button[i].setFont(new Font("����",Font.PLAIN,16));
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
		//this.setResizable(false);  //���ô��ڴ�С���ɸı�
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
			JLabel jl=new JLabel("ϵͳ���ݳɹ���");
			jl.setFont(new Font("����",Font.PLAIN,15));
			JOptionPane j=new JOptionPane();
			JOptionPane.showMessageDialog(null, jl,"ϵͳ��ʾ",JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getSource()==help){
			new Help();
		}
		if (e.getSource()==cancel) {
			JLabel jl=new JLabel("�˻���ע����");
			jl.setFont(new Font("����",Font.PLAIN,15));
			JOptionPane J=new JOptionPane();
			JOptionPane.showMessageDialog(this, jl,"ϵͳ��ʾ",JOptionPane.INFORMATION_MESSAGE);
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
			a2.removeAll();//public void removeAll()�Ӵ��������Ƴ�����������˷�����֪ͨ���ֹ�������ͨ�� removeLayoutComponent �����Ӵ������Ĳ������Ƴ���Щ�����
			a2.add(new BrowseProducts());       //�����Ʒ
			a2.setVisible(true);
		}
		if(e.getSource()==a_button[1]){
			a2.setVisible(false);
			a2.removeAll();
			a2.add(new  InquireProducts());     //��ѯ��Ʒ
			a2.setVisible(true);
		}
		if(e.getSource()==a_button[2]){
			a2.setVisible(false);
			a2.removeAll();
			a2.add(new  NewProducts());        //�½���Ʒ
			a2.setVisible(true);
		}
		if(e.getSource()==a_button[3]){
			a2.setVisible(false);
			a2.removeAll();
			a2.add(new  DeleteProducts());     //ɾ����Ʒ
			a2.setVisible(true);
		}
		if(e.getSource()==a_button[4]){
			a2.setVisible(false);
			a2.removeAll();
			JOptionPane.showMessageDialog(null, "��Ʒ������ϣ�������������Ʒ��Ϣ��");
			a2.add(new  BrowseProducts());      //������Ʒ
			a2.setVisible(true);
		}
		if(e.getSource()==b_button[0]){
			b2.setVisible(false);
			b2.removeAll();
			b2.add(new  BrowseVIP());      // ���VIP
			b2.setVisible(true);
		}
		if(e.getSource()==b_button[1]){
			b2.setVisible(false);
			b2.removeAll();
			b2.add(new  ShoppingRecord());      //�����¼
			b2.setVisible(true);
		}
		if(e.getSource()==b_button[2]){
			b2.setVisible(false);
			b2.removeAll();
			b2.add(new  LoginVIP());      //ע��VIP
			b2.setVisible(true);
		}
		if(e.getSource()==b_button[3]){
			b2.setVisible(false);
			b2.removeAll();
			b2.add(new  ShowChanges_1());      //�鿴�޸�
			b2.setVisible(true);
		}
		if(e.getSource()==b_button[4]){
			b2.setVisible(false);
			b2.removeAll();
			b2.add(new  CancelVIP());      //ע��VIP
			b2.setVisible(true);
		}
		if(e.getSource()==c_button[0]){
			c2.setVisible(false);
			c2.removeAll();
			c2.add(new  BrowseWoker());      //���Ա��
			c2.setVisible(true);
		}
		if(e.getSource()==c_button[1]){
			c2.setVisible(false);
			c2.removeAll();
			c2.add(new  InquireWoker());      //��ѯԱ��
			c2.setVisible(true);
		}
		if(e.getSource()==c_button[2]){
			c2.setVisible(false);
			c2.removeAll();
			c2.add(new LoginWoker());      //ע��Ա��
			c2.setVisible(true);
		}
		if(e.getSource()==c_button[3]){
			c2.setVisible(false);
			c2.removeAll();
			c2.add(new  ChangesWoker_1());      //�޸�Ա��
			c2.setVisible(true);
		}
		if(e.getSource()==c_button[4]){
			c2.setVisible(false);
			c2.removeAll();
			c2.add(new  CancelWoker());      //ע��Ա��
			c2.setVisible(true);
		}
		else if(e.getSource()==d_button[0]){
			d2.setVisible(false);
			d2.removeAll();
			d2.add(new  DayInquire());      //���ղ�ѯ
			d2.setVisible(true);
		}
		else if(e.getSource()==d_button[1]){
			d2.setVisible(false);
			d2.removeAll();
			d2.add(new  MonthInquire());      //���²�ѯ
			d2.setVisible(true);
		}
		else if(e.getSource()==d_button[2]){
			d2.setVisible(false);
			d2.removeAll();
			d2.add(new  YearInquire());      //��ݲ�ѯ
			d2.setVisible(true);
		}
		else if(e.getSource()==d_button[3]){
			d2.setVisible(false);
			d2.removeAll();
			d2.add(new  ShowAll());      //���ȫ��
			d2.setVisible(true);
		}
		else if(e.getSource()==d_button[4]){
			d2.setVisible(false);
			d2.removeAll();
			d2.add(new  AllInquire());      //�ܶ��ѯ
			d2.setVisible(true);
		}
	}
}
