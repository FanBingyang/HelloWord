package BookExample8;
/*功能简介：使用框架和对话框的模式实际一个图形用户界面，程序运行后将弹出一个对话框*/

import javax.swing.JFrame;  //框架类
import java.awt.Container;  //容器类
import java.awt.FlowLayout; //布局管理器
import javax.swing.JDialog; //对话框类

public class JDialogUse {
	public static void main(String agrs[]){
		JFrame app=new JFrame("对话框的使用");
		Container c=app.getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.LEFT));
		app.setSize(300,300);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
		/*使用javax.swing.JDialog类的构造方法JDialog(Frame owner,String title,boolean modal)。owner指定
		 * 对应的父窗口；title设置对话框的标题；modal表示对话框的模式，如果是true表示模态，否则是非模态。模态的对话框打开时
		 * 不允许访问应用中的其他窗口，直到该对话框关闭。非模态的对话框打开时，用户仍然可以访问其他窗口*/
		JDialog d=new JDialog(app,"对话框",false);
		d.setSize(200, 100);
		d.setVisible(true);
		}

}
