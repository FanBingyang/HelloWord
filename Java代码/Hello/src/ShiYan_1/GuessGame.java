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

/*功能简介：实现一个具有图形用户界面的猜数游戏*/
public class GuessGame extends JFrame implements ActionListener{
	public int game;
	public int guess;
	public int counter=0;
	public JLabel l1,l2,l3;
	public JButton ok;
	public JTextField t;
	public GuessGame(){
		super("猜数2.0");
		Container c=this.getContentPane();
		this.setLayout(null);
		this.setSize(500, 300);
		this.setLocation(500, 300);
		Random randomNumbers=new Random();
		//randomNumbers对象调用nextInt()方法生成的一个随机整数
		//randomNumbers.nextInt(100)表示生成一个1~99的任意整数
		game=1+randomNumbers.nextInt(100);
		l1=new JLabel("欢迎进入游戏！");
		l1.setFont(new Font("黑体", Font.PLAIN, 15));
		l1.setBounds(200,20,150,30);
		this.add(l1);
		l2=new JLabel("这里有一个1~100的整数，你猜是多少？");
		l2.setFont(new Font("黑体", Font.PLAIN, 15));
		l2.setBounds(120,50,480,30);
		this.add(l2);
		t=new JTextField();
		t.setBounds(100,90,300,30);
		this.add(t);
		ok=new JButton("猜猜看");
		ok.addActionListener(this);
		ok.setBounds(200,130,100,50);
		this.add(ok);
		l3=new JLabel("版权所有：范秉洋");
		l3.setFont(new Font("黑体", Font.PLAIN, 15));
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
				JOptionPane.showMessageDialog(null, "你猜的数字太大！");
			else if(guess<game)
				JOptionPane.showMessageDialog(null, "你猜的数字太小！");
			else if(guess==game){
				JOptionPane.showMessageDialog(null,"恭喜你，你猜了"+counter+"次，你猜对了！");
				System.exit(0);
			}
		}	
       public static void main(String args[]){
    	   new GuessGame();
       }
}
