package ShiYan_1;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*���ܼ�飺ʵ��һ������ͼ���û�����Ĳ�����Ϸ*/
public class GuessGame extends JFrame implements ActionListener{
	public int game;
	public int guess;
	public int counter=0;
	public JLabel l1,l2,l3;
	public JButton ok;
	public JTextField t;
	public GuessGame(){
		super("����2.0");
		Container c=this.getContentPane();
		this.setLayout(null);
		this.setSize(500, 300);
		this.setLocation(500, 300);
		Random randomNumbers=new Random();
		//randomNumbers�������nextInt()�������ɵ�һ���������
		//randomNumbers.nextInt(100)��ʾ����һ��1~99����������
		game=1+randomNumbers.nextInt(100);
		l1=new JLabel("��ӭ������Ϸ��");
		l1.setFont(new Font("����", Font.PLAIN, 15));
		l1.setBounds(200,20,150,30);
		this.add(l1);
		l2=new JLabel("������һ��1~100������������Ƕ��٣�");
		l2.setFont(new Font("����", Font.PLAIN, 15));
		l2.setBounds(120,50,480,30);
		this.add(l2);
		t=new JTextField();
		t.setBounds(100,90,300,30);
		this.add(t);
		ok=new JButton("�²¿�");
		ok.addActionListener(this);
		ok.setBounds(200,130,100,50);
		this.add(ok);
		l3=new JLabel("��Ȩ���У�������");
		l3.setFont(new Font("����", Font.PLAIN, 15));
		l3.setBounds(340,200,150,40);
		this.add(l3);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		}
			
       @Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
    	   guess=Integer.valueOf(t.getText());
			counter++;
			if(guess>game)
				JOptionPane.showMessageDialog(null, "��µ�����̫��");
			else if(guess<game)
				JOptionPane.showMessageDialog(null, "��µ�����̫С��");
			else if(guess==game){
				JOptionPane.showMessageDialog(null,"��ϲ�㣬�����"+counter+"�Σ���¶��ˣ�");
				System.exit(0);
			}
		}	
       public static void main(String args[]){
    	   new GuessGame();
       }
}
