package BookExample8;
/*���ܼ�飺ʹ�ÿ�ܺͶԻ����ģʽʵ��һ��ͼ���û����棬�������к󽫵���һ���Ի���*/

import javax.swing.JFrame;  //�����
import java.awt.Container;  //������
import java.awt.FlowLayout; //���ֹ�����
import javax.swing.JDialog; //�Ի�����

public class JDialogUse {
	public static void main(String agrs[]){
		JFrame app=new JFrame("�Ի����ʹ��");
		Container c=app.getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.LEFT));
		app.setSize(300,300);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
		/*ʹ��javax.swing.JDialog��Ĺ��췽��JDialog(Frame owner,String title,boolean modal)��ownerָ��
		 * ��Ӧ�ĸ����ڣ�title���öԻ���ı��⣻modal��ʾ�Ի����ģʽ�������true��ʾģ̬�������Ƿ�ģ̬��ģ̬�ĶԻ����ʱ
		 * ���������Ӧ���е��������ڣ�ֱ���öԻ���رա���ģ̬�ĶԻ����ʱ���û���Ȼ���Է�����������*/
		JDialog d=new JDialog(app,"�Ի���",false);
		d.setSize(200, 100);
		d.setVisible(true);
		}

}
