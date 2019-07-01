package BookExample8;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
/*功能简介：实现计算器功能*/

public class Calculator implements ActionListener{
	JFrame f;
	JButton bNumber;
	JButton bOperator;
	JButton bOther;
	JButton bM;
	JTextField tResult;
	int t;
	boolean firstDigit;
	String operator;
	boolean isDouble=false;      //是否为实数的标记变量
	double op1,op2;    //操作数
	StringBuffer buf=new StringBuffer(20);
	StringBuffer str=new StringBuffer();
	public Calculator(){
		f=new JFrame("计算器");
		Container contentPane=f.getContentPane();
		contentPane.setLayout(new BorderLayout());
		tResult=new JTextField("0.",20);
		tResult.setBackground(Color.white);
		tResult.setHorizontalAlignment(JTextField.RIGHT);
		tResult.setSize(1, 1);
		JPanel pTop=new JPanel();
		pTop.add(tResult);
		contentPane.add(pTop,BorderLayout.NORTH);
		JPanel pBottom=new JPanel();
		pBottom.setLayout(new BorderLayout());
		contentPane.add(pBottom,BorderLayout.CENTER);
		JPanel pRight=new JPanel();
		pRight.setLayout(new BorderLayout());
		JPanel pUp=new JPanel();
		pUp.setLayout(new GridLayout(1,1));
		bOther=new JButton("C");
		bOther.addActionListener(this);
		bOther.setForeground(Color.RED);
		pUp.add(bOther);
		JPanel pDown=new JPanel();
		pDown.setLayout(new GridLayout(3,5,3,2));
		bNumber=new JButton("7");
		bNumber.setForeground(Color.blue);
		bNumber.addActionListener(this);
		bNumber.setMargin(new Insets(3,3,3,3));
		pDown.add(bNumber);
		bNumber=new  JButton("8");
		bNumber.setForeground(Color.blue);
		bNumber.addActionListener(this);
		bNumber.setMargin(new Insets(3, 3, 3, 3));
		pDown.add(bNumber);
		bNumber=new  JButton("9");
		bNumber.setForeground(Color.blue);
		bNumber.addActionListener(this);
		bNumber.setMargin(new Insets(3, 3, 3, 3));
		pDown.add(bNumber);
		bOperator=new  JButton("/");
		bOperator.setForeground(Color.blue);
		bOperator.addActionListener(this);
		bOperator.setMargin(new Insets(3, 0, 3, 0));
		pDown.add(bOperator);
		bOperator=new  JButton("sqrt");
		bOperator.setForeground(Color.blue);
		bOperator.addActionListener(this);
		bOperator.setMargin(new Insets(3, 0, 3, 0));
		pDown.add(bOperator);
		bNumber=new  JButton("4");
		bNumber.setForeground(Color.blue);
		bNumber.addActionListener(this);
		bNumber.setMargin(new Insets(3, 3, 3, 3));
		pDown.add(bNumber);
		bNumber=new  JButton("5");
		bNumber.setForeground(Color.blue);
		bNumber.addActionListener(this);
		bNumber.setMargin(new Insets(3, 3, 3, 3));
		pDown.add(bNumber);
		bNumber=new  JButton("6");
		bNumber.setForeground(Color.blue);
		bNumber.addActionListener(this);
		bNumber.setMargin(new Insets(3, 3, 3, 3));
		pDown.add(bNumber);
		bOperator=new  JButton("*");
		bOperator.setForeground(Color.blue);
		bOperator.addActionListener(this);
		bOperator.setMargin(new Insets(3, 3, 3, 3));
		pDown.add(bOperator);
		bOperator=new  JButton("%");
		bOperator.setForeground(Color.blue);
		bOperator.addActionListener(this);
		bOperator.setMargin(new Insets(3, 3, 3, 3));
		pDown.add(bOperator);
		bNumber=new  JButton("1");
		bNumber.setForeground(Color.blue);
		bNumber.addActionListener(this);
		bNumber.setMargin(new Insets(3, 3, 3, 3));
		pDown.add(bNumber);
		bNumber=new  JButton("2");
		bNumber.setForeground(Color.blue);
		bNumber.addActionListener(this);
		bNumber.setMargin(new Insets(3, 3, 3, 3));
		pDown.add(bNumber);
		bNumber=new  JButton("3");
		bNumber.setForeground(Color.blue);
		bNumber.addActionListener(this);
		bNumber.setMargin(new Insets(3, 3, 3, 3));
		pDown.add(bNumber);
		bOperator=new  JButton("-");
		bOperator.setForeground(Color.blue);
		bOperator.addActionListener(this);
		bOperator.setMargin(new Insets(3, 3, 3, 3));
		pDown.add(bOperator);
		bOperator=new  JButton("1/x");
		bOperator.setForeground(Color.blue);
		bOperator.addActionListener(this);
		bOperator.setMargin(new Insets(3, 3, 3, 3));
		pDown.add(bOperator);
		JPanel pDown1=new JPanel();
		pDown1.setLayout(new GridLayout(1,3,2,2));
		bOperator=new  JButton("0");
		bOperator.setForeground(Color.blue);
		bOperator.addActionListener(this);
		bOperator.setMargin(new Insets(3, 3, 3, 3));
		pDown1.add(bOperator);
		bOperator=new  JButton(".");
		bOperator.setForeground(Color.blue);
		bOperator.addActionListener(this);
		bOperator.setMargin(new Insets(3, 3, 3, 3));
		pDown1.add(bOperator);
		bOperator=new  JButton("+");
		bOperator.setForeground(Color.blue);
		bOperator.addActionListener(this);
		bOperator.setMargin(new Insets(3, 3, 3, 3));
		pDown1.add(bOperator);
		bOperator=new  JButton("=");
		bOperator.setForeground(Color.blue);
		bOperator.addActionListener(this);
		bOperator.setMargin(new Insets(5,5,5,5));
		pDown1.add(bOperator);
		pRight.add(pUp,BorderLayout.NORTH);
		pRight.add(pDown,BorderLayout.CENTER);
		pRight.add(pDown1,BorderLayout.SOUTH);
		pBottom.add(pRight,BorderLayout.CENTER);
		//关闭程序时退出窗口
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt){
				System.exit(0);
			}
		});
		f.setSize(new Dimension(250,220));
		f.setResizable(false);
		f.setVisible(true);
	}
		@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s=e.getActionCommand();
		String temp1=tResult.getText();
		double dtemp1=Double.parseDouble(temp1);
		double op1=dtemp1;
		if(s.equals("C"))       //如果是C则将当前计算结果重置为0
		{
			tResult.setText("0.");
			str.replace(0, str.length(),"");
		}
		else if(s.equals("1/x"))
		{
			tResult.setText(""+1/dtemp1);
		}
		else if(s.equals("sqrt"))           //如果案件为sqrt，则将文本框中的内容求平方根
		{
			tResult.setText(""+Math.sqrt(dtemp1));
		}
		//执行加、减、乘、除、求余等运算
		else if(s.equals("+"))
		{
			t=1;
			str.setLength(0);
		}
		else if(s.equals("-"))
		{
			t=2;
			str.setLength(0);
		}
		else if(s.equals("*"))
		{
			t=3;
			str.setLength(0);
		}
		else if(s.equals("/"))
		{
			t=4;
			str.setLength(0);
		}
		else if(s.equals("%"))
		{
			t=5;
			str.setLength(0);
		}
		else if(s.equals("="))
		{
			if(t==1)
				tResult.setText(""+(op1+op2));
			else if(t==2)
				tResult.setText(""+(op1-op2));
			else if(t==3)
				tResult.setText(""+(op1*op2));
			else if(t==4)
				tResult.setText(""+(op1/op2));
			else if(t==5)
				tResult.setText(""+(op1%op2));
		}
		else if(s.equals("."))
		{
			isDouble=true;
			if(tResult.getText().trim().indexOf('.')!=-1);
			else{
				if(tResult.getText().trim().equals("0"))
				{
					str.setLength(0);
					tResult.setText((str.append("0"+s).toString()));
				}
				else if(tResult.getText().trim().equals(""))
				{
					//如果初始显示为空则不做任何操作
				}
				else {
					tResult.setText((str.append(s).toString()));
				}
			}
		}
		else if(s.equals("0"))   //如果选择的是0
		{
			if(tResult.getText().trim().equals("0.")){}
			else{
				tResult.setText(str.append(s).toString());
				op2=Double.parseDouble(tResult.getText().trim());
			}
		}
		else{
			tResult.setText(str.append(s).toString());
			op2=Double.parseDouble(tResult.getText().trim());
			op2=op1;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Calculator();
	}
}
