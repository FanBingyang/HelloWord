package Other;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BMI extends JFrame{
	private JLabel l1,l2,l3,l4,l5;
	private  JTextField t1,t2,t3;
	private String s=null;
	private JButton ok;
	public BMI(){
		super("����BMI����");
		this.setLayout(null);
		this.setResizable(false);
		l1=new JLabel("������������:");
		l1.setBounds(10,50,150,30);
		this.add(l1);
		t1=new JTextField();
		t1.setBounds(150,50,70,30);
		this.add(t1);
		l5=new JLabel("m");
		l5.setBounds(230,50,30,30);
		this.add(l5);
		
		l2=new JLabel("�������������:");
		l2.setBounds(10,100,150,30);
		this.add(l2);
		t2=new JTextField();
		t2.setBounds(150,100,70,30);
		this.add(t2);
		l4=new JLabel("kg");
		l4.setBounds(230,100,30,30);
		this.add(l4);
		
		ok=new JButton("����");
		ok.setBounds(100,150,100,40);
		this.add(ok);
		l3=new JLabel("��Ĳ��Խ��Ϊ:");
		l3.setBounds(10,210,150,30);
		this.add(l3);
		t3=new JTextField(s);
		t3.setBounds(150,210,150,30);
		t3.setEnabled(false);
//		t3.setBackground(Color.black);
		this.add(t3);
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String kg,m;
				m=t1.getText();
				kg=t2.getText();
				double bmi=Double.parseDouble(kg)/(Double.parseDouble(m)*Double.parseDouble(m));
				System.out.printf("%.2f\n",bmi);
				if(e.getSource()==ok){
					if(bmi<=18.5)
						s="����";
					if(bmi>18.5&&bmi<=25)
						s="����";
					if(bmi>25&&bmi<=30)
						s="����";
					if(bmi>30&&bmi<=35)
						s="����";
					if(bmi>35)
						s="�ǳ�����";
				}
				t3.setText(s);
			}
		});
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(340, 320);
		this.setLocation(500, 300);
	}
	public static void main(String args[]){
		new BMI();
	}
}
