package BookExample8;
/*���ܼ�飺ʹ�ÿ�ܺͱ�ǩ���һ��ͼ���û����棬���뿪��ʾ�ı���ͼƬ*/

import javax.swing.JFrame;        //�����
import java.awt.Container;        //������
import java.awt.FlowLayout;       //���ֹ�����
import javax.swing.ImageIcon;     //ͼƬ��
import javax.swing.JLabel;        //��ǩ��

public class JFrameLabel extends JFrame{
	public JFrameLabel(){
		super("��ܺͱ�ǩ��ʹ��");      
		/*������javax.swing.JLabel�Ĺ��췽�������ɱ���Ϊ"��ܺͱ�ǩ��ʹ��"�Ĵ��ڣ��������й��췽��JFrame(String title)*/
		Container c=getContentPane();  
		/*getContentPane()����javax.swing.JLabel�ĳ�Ա���������ڷŻص�ǰ����������
		һ�㲻ֱ��ʹ��JFrame���������ǻ�ȡ��ǰ���ڵ�����c����c��������*/
		c.setLayout(new FlowLayout(FlowLayout.LEFT)); 
		/*setLayout()����JFrame�ĳ�Ա�������������õ�ǰ���ڵĲ��ָ�ʽ��new FlowLayout(FlowLayout.LEFT)��ʹ����
		 * java.awt.FlowLayout�Ĺ��췽��ʵ����һ�������ֹ��������󣬲�ʹ����Զ������*/
		String[] s={"�ı���ǩ","������ͼ�����","������ͼ���·�"};       //�ַ����͵�����
		/*ʹ��ͼ���ഴ��һ�������������ImageIcon(getClass().getResource("image.jpg"))��������һ��ͼ�����
		 * getClass().getResource("image.jpg")���ڻ�ȡ��Ƭ */
		ImageIcon[] ic={null,new ImageIcon(getClass().getResource("image.jpg")),new ImageIcon(getClass().getResource("image1.jpg"))};
		//����JLabel.LEFT,JLabel.CENTER��JLabel.BOTTOM����ͬ�Ķ��뷽ʽ
		int[] ih={0,JLabel.LEFT,JLabel.CENTER};
		int[] iv={0,JLabel.CENTER,JLabel.BOTTOM};
		for(int i=0;i<3;i++){
			/*JLabel�Ĺ��췽��JLabel(String text,Icon icon,int horizontalAlignment)�ɴ�������ָ���ı���ͼ��
			 * ��ˮƽ�����JLabelʵ�����ñ�ǩ������ʾ���ڴ�ֱ���ж��롣�ı�λ��ͼ���β����Text�Ǳ�ǩ����ʾ���ı���icon��
			 * ��ǩ����ʾ��ͼ��horizontalAlignment����ȡLEFT��CENTER��RIGHT��LENADING��TRAILIN�ǵȳ���*/
			JLabel label=new JLabel(s[i],ic[i],JLabel.LEFT);
			if(i>0){
				/*���������ǩ��������ͼ��֮����ˮƽ�����ϵ����λ�ù�ϵ��ʹ���ֱַ�λ��ͼ�����ࡢ�Ҳ���м�*/
				label.setHorizontalTextPosition(ih[i]);
				label.setVerticalTextPosition(iv[i]);
				/*���������ǩ��ͼ���ڴ�ֱ�����ϵ����λ�ù�ϵ������JLabel.TOP��JLabel.Center��JLabel.BOTTOM 3�ַ�ʽ*/
			}
			label.setToolTipText("��"+(i+1)+"����ǩ");    //���õ�����ڱ�ǩ��ͣ��ʱ���ֵ���ʾ��Ϣ
			c.add(label);  //�������ӵ���ǰ������
			/*Container���add(Component comp)������������������������compָ����Ҫ��ӵ����*/
		}//forѭ������
		
	}
	public static void main(String args[]){
		JFrameLabel app=new JFrameLabel();
		app.setSize(600,300);  //���ô��ڵĴ�С��������Ⱥ͸߶�
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //���õ������ڡ��رա���ťʱ�ر�Ӧ�ó���
		app.setVisible(true);   //���ô����Ƿ�ɼ���Ϊtrueʱ�ɼ������򲻿ɼ�
	}
	

}
