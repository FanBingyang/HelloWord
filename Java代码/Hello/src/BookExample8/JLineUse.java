package BookExample8;
/*���ܼ�飺��Ͽ��б����ı������ʹ��*/
import javax.swing.JFrame;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JLineUse extends JFrame{
	public JLineUse(){
		super("���������ʹ��");
		Container c=getContentPane();
		setLayout(new FlowLayout());
		String[] s={"ѡ��1","ѡ��2","ѡ��3"};
		JComboBox cb=new JComboBox(s);    //����һ����Ͽ򲢰�ѡ����ӽ�ȥ
		JList lt=new JList(s);            //����һ���б����б�����ӽ�ȥ
		JTextArea ta=new JTextArea("1\n2\n3\n4\n5\n6",3,9);      //����һ���ı����򲢳�ʼ���ı����� .
		ta.setEditable(false);        //setEditable(boolean b)�������������ı��༭���Ƿ���Ա༭��bΪtrueʱ�ɱ༭�������ܱ༭
		//JTextArea(String text,int rows,int columns)��text - Ҫ��ʾ���ı�������Ϊ null��rows - ���� >= 0��columns - ���� >= 0 
		JScrollPane sp=new JScrollPane(ta);        //����һ�����������ı�������ӽ�ȥ
		c.add(cb);
		c.add(lt);
		c.add(sp);
	}

	public static void main(String[] args) {
		JLineUse app=new JLineUse();
		app.setSize(300, 160);         //���ô��ڴ�С
		app.setLocation(650, 400);     //���ô��ڳ�ʼλ��
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}

}
