package BookExample8;
/*功能简介：面板和滚动条的使用*/
import javax.swing.JFrame;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JPanel; 
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JSlider;

public class JSliderPanel extends JFrame{
	public JSliderPanel(){
		super("面板和滚动条组件的使用");
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		/*JSlider类的构造方法JSlider(int orientation, int min, int max, int value),其中，orientation参数指定滚动条的方向；min和max分别指定滚动条
		 * 所标示的数值范围的最小值和最大值；value参数指定滑动块再滚动条中的初始位置。orientation参数值只能为常量JSlider.HORIZONTAL或JSlider.VERTICAL.
		 * 当参数orientation为JSlider.HORIZONTAL时，滚动条在水平方向，当参数orientation为JSlider.VERTICAL时，滚动条在垂直方向。如果构造方法不含参数
		 * orientation，则滚动条的默认方向是水平方向*/
		JSlider s=new JSlider(JSlider.HORIZONTAL,0, 26, 6);
		JPanel p=new JPanel();
		/*JPanel类的方法setPreferredSize(Dimension preferredSize)用于设置面板的大小，Dimension类的构造方法Dimension(int width,int height)用于
		 * 设置面板的具体大小*/
		p.setPreferredSize(new Dimension(100, 60));
		//JPanel类的setBackground(Color bg)方法用于设置面板的背景颜色
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
