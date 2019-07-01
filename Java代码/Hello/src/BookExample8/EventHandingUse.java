package BookExample8;
/*功能简介：事件处理的简单应用*/
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class EventHandingUse {
	public EventHandingUse(){
		JFrame app=new JFrame("事件处理");
		Container c=app.getContentPane();
		c.setLayout(new FlowLayout());
		JButton b=new JButton("单击");        //事件源
		b.addActionListener(new ButtonHandler());     //对事件源进行监听
		c.add(b);
		app.setSize(200,100);
		app.setVisible(true);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
    /*声明一个内部类ButtonHandler,实现监听器接口；该类用于监听获取相应的事件，并对事件进行处理。事件触发后需要执行的具体操作
     * 在actoionPerformed(ActionEvent e)方法中体现*/
	class ButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.println("您触发了事件源！");   //处理结果是：在控制台输出：您触发了事件源！
		}
	}
	public static void main(String[] args) {
		new EventHandingUse();
	}

}
