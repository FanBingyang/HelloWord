package BookExample8;
/*�����¼�������(KeyListener)�ӿڵ��������£�
 * 	public interface KeyListener extends EventListener{
		public void keyTyped(KeyEvent e);
		//���ڴ�������ĳ���ַ����¼�
		public void keyPressed(KeyEvent e);
		//���ڴ�����ĳ�����̼����¼�
		public void keyReleased(KeyEvent e);
		//���ڴ���ſ�ĳ�����̼����¼�
	}*/


/*���ܼ�飺�����¼������ʹ��*/
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
		super("�����¼������ʹ��");
		Container c=getContentPane();
		JTextArea ta=new JTextArea("", 6, 12);
		ta.addFocusListener(new  FocusListener() {
			public void focusLost(FocusEvent e) {
				System.out.println("ʧȥ����");
			}
			public void focusGained(FocusEvent e) {
				System.out.println("��ý���");
			}
		}
		);
		ta.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e){
				System.out.println("�����¼�"+e.getKeyChar());      //getKeyChar()������ȡ�ڼ���������ַ���KeyEvent���õĻ�����һ������getSource()���ڻ�ȡ��ǰ�¼����¼�Դ
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
