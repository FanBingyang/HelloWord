package BookExample8;
/*功能简介：边界布局管理器的使用*/
import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JButton;

public class BorderLayoutUse {
	public static void main(String[] args) {
		JFrame app=new JFrame("边界布局管理器的使用");
		Container c=app.getContentPane();
		c.setLayout(new BorderLayout());
		c.add(new JButton("东"),BorderLayout.EAST);
		c.add(new JButton("西"), BorderLayout.WEST);
		c.add(new JButton("南"), BorderLayout.SOUTH);
		c.add(new JButton("北"), BorderLayout.NORTH);
		c.add(new JButton("中"), BorderLayout.CENTER);
		app.setSize(300, 300);
		app.setLocation(1000, 200);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}

}
