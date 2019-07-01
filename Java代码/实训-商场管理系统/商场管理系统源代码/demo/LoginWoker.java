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

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginWoker extends JPanel implements ActionListener {
	private JLabel L;
	private String tt;
	private JLabel gh,xm,xb,nl,bm,zw,dh,yx,zz;
	private JButton esc,ok;
	private JTextField tgh,txm,txb,tnl,tbm,tzw,tdh,tyx,tzz;
	public LoginWoker() {
		// TODO Auto-generated constructor stub
		this.setLayout(null);
		this.setBounds(0,0,780,620);
		//��ť
		esc=new JButton("����");
		esc.setFont(new Font("����",Font.PLAIN,15));
		esc.setBounds(195,530,120,40);
		esc.addActionListener(this);
		this.add(esc);
		ok=new JButton("ȷ��ע��");
		ok.setFont(new Font("����",Font.PLAIN,15));
		ok.setBounds(420,530,120,40);
		ok.addActionListener(this);
		this.add(ok);
		//��ǩ
		L=new JLabel("ע����Ա��");
		L.setFont(new Font("����",Font.PLAIN,20));
		L.setBounds(320,25,190,35);
		this.add(L);
		gh=new JLabel("���� :");
		gh.setBounds(150,80,90,30);
		gh.setFont(new Font("����",Font.PLAIN,20));
		add(gh);
		xm=new JLabel("���� :");
		xm.setBounds(150,130,90,30);
		xm.setFont(new Font("����",Font.PLAIN,20));
		add(xm);
		xb=new JLabel("�Ա� :");
		xb.setBounds(150,180,90,30);
		xb.setFont(new Font("����",Font.PLAIN,20));
		add(xb);
		nl=new JLabel("���� :");
		nl.setBounds(150,230,90,30);
		nl.setFont(new Font("����",Font.PLAIN,20));
		add(nl);
		bm=new JLabel("���� :");
		bm.setBounds(150,280,90,30);
		bm.setFont(new Font("����",Font.PLAIN,20));
		add(bm);
		zw=new JLabel("ְ�� :");
		zw.setBounds(150,330,90,30);
		zw.setFont(new Font("����",Font.PLAIN,20));
		add(zw);
		dh=new JLabel("�绰 :");
		dh.setBounds(150,380,90,30);
		dh.setFont(new Font("����",Font.PLAIN,20));
		add(dh);
		yx=new JLabel("��н :");
		yx.setBounds(150,430,90,30);
		yx.setFont(new Font("����",Font.PLAIN,20));
		add(yx);
		zz=new JLabel("סַ :");
		zz.setBounds(150,480,90,30);
		zz.setFont(new Font("����",Font.PLAIN,20));
		add(zz);
		//�ı���
		tgh=new JTextField();
		tgh.setBounds(270,80,330,30);
		add(tgh);
		txm=new JTextField();
		txm.setColumns(10);
		txm.setBounds(270,130,330,30);
		add(txm);
		txb=new JTextField();
		txb.setColumns(10);
		txb.setBounds(270,180,330,30);
		add(txb);
		tnl=new JTextField();
		tnl.setColumns(10);
		tnl.setBounds(270,230,330,30);
		add(tnl);
		tbm=new JTextField();
		tbm.setColumns(10);
		tbm.setBounds(270,280,330,30);
		add(tbm);
		tzw=new JTextField();
		tzw.setColumns(10);
		tzw.setBounds(270,330,330,30);
		add(tzw);
		tdh=new JTextField();
		tdh.setColumns(10);
		tdh.setBounds(270,380,330,30);
		add(tdh);
		tyx=new JTextField();
		tyx.setColumns(10);
		tyx.setBounds(270,430,330,30);
		add(tyx);
		tzz=new JTextField();
		tzz.setColumns(10);
		tzz.setBounds(270,480,330,30);
		add(tzz);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==esc){
			tgh.setText("");
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
				JOptionPane.showMessageDialog(null, "����д������Ϣ��");
			else {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException g) {
				// TODO: handle exception
				System.out.println("�Ҳ���������");
			}
			try {
				Connection con;
				Statement stmt;
				ResultSet rs;
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shangchang?useUnicode=true&characterEncoding=utf8","root","admin");
				stmt=con.createStatement();
				
				Calendar calendar=Calendar.getInstance();
				SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd");
				tt=dateFormat.format(calendar.getTime());
				String sql="INSERT INTO employee (id,nam,sex,age,bm,zw,cal,money,zz,tim)"
						+"VALUES("+"'"+tgh.getText()+"',"+"'"+txm.getText()+"',"+"'"+txb.getText()+"',"+"'"+tnl.getText()+"',"+"'"+tbm.getText()+"',"+"'"+tzw.getText()+"',"+"'"+tdh.getText()+"',"+"'"+tyx.getText()+"',"+"'"+tzz.getText()+"',"+"'"+tt+"')";
				stmt.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "ע��Ա���ɹ�");
				stmt.close();
				con.close();
				tgh.setText("");
				txm.setText("");
				txb.setText("");
				tnl.setText("");
				tbm.setText("");
				tzw.setText("");
				tdh.setText("");
				tyx.setText("");
				tzz.setText("");
				this.setVisible(true);
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println("���Ա��");
				e2.printStackTrace();
			}
		}
		}
}
}
