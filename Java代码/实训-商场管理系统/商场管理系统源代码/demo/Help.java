package demo;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Help extends JFrame{
	public Help(){
		super("ϵͳʹ��˵��");
		String [] s={"�� ��¼������ϵͳΪ�̳���Ϣ����ϵͳ������һ���ı����ԣ�������\n","�� ��¼����ʹ�ñ�ϵͳ����¼֮�����ϵͳ�������棬�����������ѡ\n" ,
	            "�� ���û���Ҫִ�еĹ���ģ�顣\n" ,
	            "�� ��Ʒ��Ϣ¼�룺��ά����ϵͳʱ��Ҫ���ϸ���ϵͳ�����ݡ�������Ʒ\n" ,
	            "�� ����Ϣ���ڲ������ӵģ����½���Ʒʱ��Ҫ��֤��Ʒ��Ϣ��ͬ������\n" ,
	            "�� ����ģ���¼�뱣���½���Ʒ����Ϣ��\n" ,
	            "�� ��Ʒ��Ϣ��ѯ�����Բ�ѯ��Ʒ����ϸ��Ϣ���Լ�����������������\n" ,
	            "�� �ȡ�\n" ,
	            "�� VIP��Ϣ����VIP�û���Ϣ�����������Ϣ��ѯ����\n" ,
	            "�� VIP����Ǽǣ���VIP����ʱ��Ҫ����������Ʒ���еǼǣ��Ա��Ժ��\n", 
	            "�� �����ͳ�ơ�\n" ,
	            "�� ���¹���ϵͳ����ģ�鸺������̳��е����й�����Ա��"};
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		JTextArea textArea=new JTextArea();
		for(int i=0;i<s.length;i++)       //ͨ��ѭ����˵����������ӵ��ı�����
			textArea.append(s[i]);
		textArea.setEditable(false);
		textArea.setFont(new Font("����",Font.PLAIN,25));
		JScrollPane sp=new JScrollPane(textArea);
		c.add(textArea);
		c.add(sp);
		this.setLocation(500,500);
		this.setSize(820, 420);
		this.setResizable(false);
		this.setVisible(true);
	}


}
