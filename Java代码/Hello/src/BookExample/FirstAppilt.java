package BookExample;
/*���ܼ�飺AppletСӦ�ó���*/

import javax.swing.JApplet;
import java.awt.Color;
import java.awt.Graphics;
public class FirstAppilt extends JApplet
{
		//���ظ���JApplet�е�paint��������
		public void paint(Graphics g)
		{
			g.setColor(Color.red);        //�����ַ�����ɫ
			g.drawString("AppletСӦ�ó���",60,60);      //��ҳ����ָ��λ����ʾ�ַ���
		}//paint��������
}//��FirstAppilt����
