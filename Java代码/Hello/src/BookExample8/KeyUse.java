package BookExample8;
/*键盘事件监听器(KeyListener)接口的声明如下：
 * 	public interface KeyListener extends EventListener{
		public void keyTyped(KeyEvent e);
		//用于处理输入某个字符的事件
		public void keyPressed(KeyEvent e);
		//用于处理按下某个键盘键的事件
		public void keyReleased(KeyEvent e);
		//用于处理放开某个键盘键的事件
	}*/


/*功能简介：键盘事件处理的使用*/
import javax.swing.JFrame;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.EventListener;

public class KeyUse extends JFrame{
	public KeyUse(){
		super("键盘事件处理的使用");
		Container c=getContentPane();
		JTextArea ta=new JTextArea("", 6, 12);
		ta.addFocusListener(new  FocusListener() {
			public void focusLost(FocusEvent e) {
				System.out.println("失去焦点");
			}
			public void focusGained(FocusEvent e) {
				System.out.println("获得焦点");
			}
		}
		);
		ta.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e){
				System.out.println("键盘事件"+e.getKeyChar());      //getKeyChar()方法获取在键盘输入的字符。KeyEvent常用的还有另一个方法getSource()用于获取当前事件的事件源
			}
		}
		);
		c.add(ta,BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		KeyUse app=new KeyUse();
		app.setSize(260, 160);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}

}
