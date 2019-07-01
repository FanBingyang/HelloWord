package BookExample8;
/*功能简介：流布局管理器的使用*/

import javax.swing.JFrame;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;

import java.awt.Image;
import javax.swing.ImageIcon;

public class FlowLayoutUse {
	public static void main(String[] args) {
		JFrame app=new JFrame("流布局管理器的使用");
		Container c=app.getContentPane();
		c.setLayout(new FlowLayout());
		JButton button1=new JButton("确定");
		JButton button2=new JButton("取消");
		JButton buttonn3=new JButton("关闭");
//		JButton b=new JButton("lalalalal");
//		b.setBounds(10, 10, 200, 200);		
//		ImageIcon ii = new ImageIcon("left.jpg");
//		Image temp = ii.getImage().getScaledInstance(b.getWidth(), b.getHeight(), ii.getImage().SCALE_DEFAULT);  
//		ii = new ImageIcon(temp);  
//		b.setIcon(ii);
//		c.add(b);
		c.add(button1);
		c.add(button2);
		c.add(buttonn3);
		app.setSize(300, 100);
		app.setLocation(650, 400);

		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}

}
