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
		JLabel m=new JLabel("��ȷ��Ҫ�˳���ϵͳ��");
		d=new JDialog(j,"ϵͳ��ʾ",false);
		d.getContentPane();
		d.setLayout(new FlowLayout());
		esc=new JButton("ȷ��");
		ent=new JButton("ȡ��");
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
			if(e.getActionCommand().equals("ȷ��"))       //�԰�ť�����ּ�����ʽ
				System.exit(0);
			else if(e.getSource()==ent)
				d.dispose();
		}
	//����������ʱ��
//	public static void main(String args[]){
//		JFrame a=new JFrame();
//		a.setSize(500, 500);
//		a.setLocation(500,500);
//		a.setVisible(true);
//		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		new Bay(a);
//	}
}
