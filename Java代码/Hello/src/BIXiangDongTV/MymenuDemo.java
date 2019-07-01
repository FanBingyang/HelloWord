package BIXiangDongTV;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MymenuDemo {

	private Frame f;
	private MenuBar mb;
	private Menu m,subMenu;
	private MenuItem closeItem,subItem;
	
	 MymenuDemo(){
		 init();
	 }
	public void init()
	{
		f = new Frame("菜单的使用");
		f.setBounds(300,100,500,600);
		f.setLayout(new FlowLayout());
		
		mb = new MenuBar();//创建一个菜单栏
		m = new Menu("文件");//创建一个菜菜单
		subMenu = new Menu("子菜单");
		
		subItem = new MenuItem("子条目");//创建一个菜单项
		closeItem = new MenuItem("退出");
		
		subMenu.add(subItem);
		
		m.add(subMenu);
//		m.add(subItem);
		m.add(closeItem);
		mb.add(m);
		
		f.setMenuBar(mb);
		
		myEvent();
		
		f.setVisible(true);
		
	}
	
	private void myEvent() 
	{
		//对菜单像的退出进行监听
		closeItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		//对窗口进行监听，点击关闭窗口后退出程序
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MymenuDemo();
	}
	

}
