package BookExample8;
/*功能简介：高级组件常规菜单的使用*/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuUse extends JFrame{
	public MenuUse(){
		super("常规菜单的使用");
		JMenuBar mBar = new JMenuBar();      //创建菜单栏(JMenuBar)对象
		this.setJMenuBar(mBar);         //在JFrame容器中设置菜单栏对象，即将菜单栏添加到框架容器中
		JMenu[]  m={new JMenu("文件(F)"),new JMenu("编辑(E)")};       //创建菜单对象
		char[][] mC={{'F','E'},{'O','S'},{'C','V'}};    //保存助记符的数组
		JMenuItem[][] mI={{new JMenuItem("打开(O)"),new JMenuItem("保存(S)")},{new JMenuItem("复制(C)"),new JMenuItem("粘贴(V)")}};     //创建菜单选项
		for(int i=0;i<m.length;i++)
		{
			mBar.add(m[i]);          //将菜单添加到菜单栏中
			m[i].setMnemonic(mC[0][i]);   //设置菜单的助记符
			for(int j=0;j<mI[i].length;j++)
			{
				m[i].add(mI[i][j]);      //在菜单中添加菜单项
				mI[i][j].setMnemonic(mC[i+j][j]);     //为菜单项设置助记符
				mI[i][j].setAccelerator(KeyStroke.getKeyStroke("ctrl"+mC[i+1][j]));       //设置菜单项的快捷键，一般菜单项使用Ctrl，菜单使用Alt
				mI[i][j].addActionListener(new ActionListener() {       //为菜单项注册监听器      
					
					@Override
					public void actionPerformed(ActionEvent e) {
						JMenuItem mItem=(JMenuItem)e.getSource();
						System.out.println("运行菜单项"+mItem.getText());
					}//actionPerformed()方法结束
				}//实现接口ActionListener的匿名累结束
				);//addActionListener()结束
			}//内部for循环结束
		}//外部for循环结束
		m[0].insertSeparator(1);   //在菜单项或下拉式菜单之间插入菜单分隔条
	} //构造方法结束

	public static void main(String[] args) {
		MenuUse app=new MenuUse();
		app.setSize(260, 160);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}

}
