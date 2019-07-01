package Other;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MiLiGen extends JFrame{
private static double a;//半径
private static double n = 1.83e-5;//空气粘性系数
private static double p = 981;//油滴密度
private double g = 9.80;//重力加速度
private double d = 5e-3;//平行板间距
private static double l = 1.5e-3;//油滴下降距离
private double b = 8.22e-3;//修正系数
private static double P = 1.013e5;//大气压强
private double e = 1.602e-19;//元电荷电量
private double t;//运动时间
private double pi = Math.PI;//圆周率
private double q;//测量的总电荷量
private int m;//电荷个数
private double ee;//测量的单位电荷量
private double wc;//测量误差
private double u;//测量电压
private JLabel tLabel,uLabel,qLabel,mLabel,eeLabel,wcLabel;//定义属性标签
private JTextField tField,uField,qField,mField,eeField,wcField;//定义文本框
private JButton ok;
public MiLiGen(){
	super("密立根实验数据测量");
	this.setLayout(null);
	
	tLabel = new JLabel("输入时间：");
	tLabel.setBounds(60, 30, 70, 30);
	add(tLabel);
	tField = new JTextField();
	tField.setBounds(150, 30, 50, 30);
	add(tField);
	uLabel = new JLabel("输入电压："); 
	uLabel.setBounds(240, 30, 70, 30);
	add(uLabel);
	uField = new JTextField();
	uField.setBounds(330, 30, 50, 30);
	add(uField);
	
	ok = new JButton("计算结果");
	ok.setBounds(180, 80, 100, 30);
	add(ok);
	
	qLabel = new JLabel("总电荷量：");
	qLabel.setBounds(60, 130, 70, 30);
	add(qLabel);
	qField = new JTextField();
	qField.setBounds(150, 130, 150, 30);
	add(qField);
	mLabel = new JLabel("电荷个数：");
	mLabel.setBounds(60, 180, 70, 30);
	add(mLabel);
	mField = new JTextField();
	mField.setBounds(150, 180, 150, 30);
	add(mField);
	eeLabel = new JLabel("测量元电荷量：");
	eeLabel.setBounds(60, 230, 100, 30);
	add(eeLabel);
	eeField = new JTextField();
	eeField.setBounds(180, 230, 150, 30);
	add(eeField);
	wcLabel = new JLabel("测量误差：");
	wcLabel.setBounds(60, 280, 70, 30);
	add(wcLabel);
	wcField = new JTextField();
	wcField.setBounds(150, 280, 150, 30);
	add(wcField);
	
	ok.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent X) {
			// TODO Auto-generated method stub
			if(tField.getText().isEmpty() || uField.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "请完整输入时间和电压");
			}
			else {
				t = Double.parseDouble(tField.getText());//得到时间并转换成double类型
				u = Integer.valueOf(uField.getText());//得到时间并转换成int类型，atoi（String）将字符串转换成int
				a = Math.sqrt((9*n*l)/(2*p*g*t));//算出油滴半径
				q = ((18*pi)/(Math.sqrt(2*p*g)))*(Math.sqrt(Math.pow((n*l)/(t*(1+(b/(P*a)))), 3)))*d/u;//算出总电荷量
//				q = ((18*pi)/(Math.sqrt(2*p*g)))*(Math.pow(((n*l)/(t*(1+(b/(P*a))))), 1.5))*(d/u);

				m = (int)(q/e);//算出电荷个数
				ee = q/m;//算出测量的单位电荷量
				wc = (Math.abs((q/e)-1));//计算误差
				qField.setText(q+"");
				mField.setText(m+"");
				eeField.setText(ee+"");
				wcField.setText(wc+"");
				
				System.out.println("半径a="+a+"\n电荷量总数q="+q+"\n元电荷个数m="+m+"\n测量单位电荷ee="+ee+"\n误差="+wc);			
				}
		}
	});
	
	this.setSize(500,500);
	this.setVisible(true);
	this.setLocation(300, 200);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MiLiGen();
	}
	

}
