package BookExample8;
/*���ܼ�飺ʹ��������ʵ�ּ򵥵��¼�����*/
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;

public class EventHandingUse1 extends JFrame{
	public EventHandingUse1(){
		super("ʹ���������¼�����");
		Container c=getContentPane();
		JButton b=new JButton("����0��");
		b.addActionListener(new ActionListener() {
			int count=0;
			public void actionPerformed(ActionEvent e) {
				JButton b=(JButton)e.getSource();         //e.getSource()�õ��¼�Դ���ж�����һ����ť����һ���˵����һ����ѡ��
				b.setText("����"+(++count)+"��");         //��setText(String str)�������������¼�Դ������ı�
			}    //actionPerformed()��������
		}        //ʵ�ֽӿ�ActionListener()�������ඨ�����
		);       //addActionListener()��������
		/*JFrameĬ�ϵĲ��ֹ�������BorderLayout��δ����setLayout()�����ͱ�ʾʹ�õ���Ĭ�ϲ��ֹ�����*/
		c.add(b, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		EventHandingUse1 app=new EventHandingUse1();
		app.setSize(260, 100);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}

}
