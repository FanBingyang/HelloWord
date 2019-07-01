package demo;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Bay implements ActionListener{
	private JButton esc,ent;
	private JDialog d;
	public Bay(JFrame j){
		JLabel m=new JLabel("您确定要退出本系统吗？");
		d=new JDialog(j,"系统提示",false);
		d.getContentPane();
		d.setLayout(new FlowLayout());
		esc=new JButton("确定");
		ent=new JButton("取消");
		d.add(m);
		d.add(esc);
		d.add(ent);
		d.setSize(200, 120);
		d.setLocation(900, 500);
		d.setVisible(true);
		esc.addActionListener(this); 
		ent.addActionListener(this);
		
		
	}
	@Override
		public void actionPerformed(ActionEvent e){
			if(e.getActionCommand().equals("确定"))       //对按钮的两种监听方式
				System.exit(0);
			else if(e.getSource()==ent)
				d.dispose();
		}
	//主方法测试时用
//	public static void main(String args[]){
//		JFrame a=new JFrame();
//		a.setSize(500, 500);
//		a.setLocation(500,500);
//		a.setVisible(true);
//		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		new Bay(a);
//	}
}
