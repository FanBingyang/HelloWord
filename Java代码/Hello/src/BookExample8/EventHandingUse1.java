package BookExample8;
/*功能简介：使用匿名类实现简单的事件处理*/
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;

public class EventHandingUse1 extends JFrame{
	public EventHandingUse1(){
		super("使用匿名类事件处理");
		Container c=getContentPane();
		JButton b=new JButton("单击0次");
		b.addActionListener(new ActionListener() {
			int count=0;
			public void actionPerformed(ActionEvent e) {
				JButton b=(JButton)e.getSource();         //e.getSource()得到事件源，判断它是一个按钮还是一个菜单项或一个复选框。
				b.setText("单击"+(++count)+"次");         //用setText(String str)方法可以设置事件源上面的文本
			}    //actionPerformed()方法结束
		}        //实现接口ActionListener()的匿名类定义结束
		);       //addActionListener()方法结束
		/*JFrame默认的布局管理器是BorderLayout，未调用setLayout()方法就表示使用的是默认布局管理器*/
		c.add(b, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		EventHandingUse1 app=new EventHandingUse1();
		app.setSize(260, 100);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}

}
