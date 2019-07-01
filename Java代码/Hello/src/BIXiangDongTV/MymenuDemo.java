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
		f = new Frame("�˵���ʹ��");
		f.setBounds(300,100,500,600);
		f.setLayout(new FlowLayout());
		
		mb = new MenuBar();//����һ���˵���
		m = new Menu("�ļ�");//����һ���˲˵�
		subMenu = new Menu("�Ӳ˵�");
		
		subItem = new MenuItem("����Ŀ");//����һ���˵���
		closeItem = new MenuItem("�˳�");
		
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
		//�Բ˵�����˳����м���
		closeItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		//�Դ��ڽ��м���������رմ��ں��˳�����
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
