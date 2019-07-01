package BookExample8;
/*功能简介：组合框、列表框和文本区域的使用*/
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
		super("多行组件的使用");
		Container c=getContentPane();
		setLayout(new FlowLayout());
		String[] s={"选项1","选项2","选项3"};
		JComboBox cb=new JComboBox(s);    //创建一个组合框并把选项添加进去
		JList lt=new JList(s);            //创建一个列表并把列表项添加进去
		JTextArea ta=new JTextArea("1\n2\n3\n4\n5\n6",3,9);      //创建一个文本区域并初始化文本内容 .
		ta.setEditable(false);        //setEditable(boolean b)方法用于设置文本编辑框是否可以编辑。b为true时可编辑，否则不能编辑
		//JTextArea(String text,int rows,int columns)，text - 要显示的文本，或者为 null，rows - 行数 >= 0，columns - 列数 >= 0 
		JScrollPane sp=new JScrollPane(ta);        //创建一个滚动窗格将文本区域添加进去
		c.add(cb);
		c.add(lt);
		c.add(sp);
	}

	public static void main(String[] args) {
		JLineUse app=new JLineUse();
		app.setSize(300, 160);         //设置窗口大小
		app.setLocation(650, 400);     //设置窗口初始位置
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}

}
