package BookExample8;
/*���ܼ�飺�߽粼�ֹ�������ʹ��*/
import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JButton;

public class BorderLayoutUse {
	public static void main(String[] args) {
		JFrame app=new JFrame("�߽粼�ֹ�������ʹ��");
		Container c=app.getContentPane();
		c.setLayout(new BorderLayout());
		c.add(new JButton("��"),BorderLayout.EAST);
		c.add(new JButton("��"), BorderLayout.WEST);
		c.add(new JButton("��"), BorderLayout.SOUTH);
		c.add(new JButton("��"), BorderLayout.NORTH);
		c.add(new JButton("��"), BorderLayout.CENTER);
		app.setSize(300, 300);
		app.setLocation(1000, 200);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}

}
