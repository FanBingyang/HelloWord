package BookExample8;
/*���ܼ�飺�¼�����ļ�Ӧ��*/
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class EventHandingUse {
	public EventHandingUse(){
		JFrame app=new JFrame("�¼�����");
		Container c=app.getContentPane();
		c.setLayout(new FlowLayout());
		JButton b=new JButton("����");        //�¼�Դ
		b.addActionListener(new ButtonHandler());     //���¼�Դ���м���
		c.add(b);
		app.setSize(200,100);
		app.setVisible(true);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
    /*����һ���ڲ���ButtonHandler,ʵ�ּ������ӿڣ��������ڼ�����ȡ��Ӧ���¼��������¼����д����¼���������Ҫִ�еľ������
     * ��actoionPerformed(ActionEvent e)����������*/
	class ButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.println("���������¼�Դ��");   //�������ǣ��ڿ���̨��������������¼�Դ��
		}
	}
	public static void main(String[] args) {
		new EventHandingUse();
	}

}
