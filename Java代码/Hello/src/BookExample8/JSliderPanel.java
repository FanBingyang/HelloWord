package BookExample8;
/*���ܼ�飺���͹�������ʹ��*/
import javax.swing.JFrame;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JPanel; 
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JSlider;

public class JSliderPanel extends JFrame{
	public JSliderPanel(){
		super("���͹����������ʹ��");
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		/*JSlider��Ĺ��췽��JSlider(int orientation, int min, int max, int value),���У�orientation����ָ���������ķ���min��max�ֱ�ָ��������
		 * ����ʾ����ֵ��Χ����Сֵ�����ֵ��value����ָ���������ٹ������еĳ�ʼλ�á�orientation����ֵֻ��Ϊ����JSlider.HORIZONTAL��JSlider.VERTICAL.
		 * ������orientationΪJSlider.HORIZONTALʱ����������ˮƽ���򣬵�����orientationΪJSlider.VERTICALʱ���������ڴ�ֱ����������췽����������
		 * orientation�����������Ĭ�Ϸ�����ˮƽ����*/
		JSlider s=new JSlider(JSlider.HORIZONTAL,0, 26, 6);
		JPanel p=new JPanel();
		/*JPanel��ķ���setPreferredSize(Dimension preferredSize)�����������Ĵ�С��Dimension��Ĺ��췽��Dimension(int width,int height)����
		 * �������ľ����С*/
		p.setPreferredSize(new Dimension(100, 60));
		//JPanel���setBackground(Color bg)���������������ı�����ɫ
		p.setBackground(Color.red);
		c.add(s);
		c.add(p);
	}
	public static void main(String[] args) {
		JSliderPanel app=new JSliderPanel();
		app.setSize(360, 160);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}

}
