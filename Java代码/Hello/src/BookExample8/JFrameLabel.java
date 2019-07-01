package BookExample8;
/*功能简介：使用框架和标签设计一个图像用户界面，用离开显示文本和图片*/

import javax.swing.JFrame;        //框架类
import java.awt.Container;        //容器类
import java.awt.FlowLayout;       //布局管理器
import javax.swing.ImageIcon;     //图片类
import javax.swing.JLabel;        //标签类

public class JFrameLabel extends JFrame{
	public JFrameLabel(){
		super("框架和标签的使用");      
		/*调用类javax.swing.JLabel的构造方法，生成标题为"框架和标签的使用"的窗口，该类中有构造方法JFrame(String title)*/
		Container c=getContentPane();  
		/*getContentPane()是类javax.swing.JLabel的成员方法，用于放回当前窗口容器，
		一般不直接使用JFrame容器，而是获取当前窗口的容器c，在c中添加组件*/
		c.setLayout(new FlowLayout(FlowLayout.LEFT)); 
		/*setLayout()是类JFrame的成员方法，用于设置当前窗口的布局格式，new FlowLayout(FlowLayout.LEFT)是使用类
		 * java.awt.FlowLayout的构造方法实例化一个流布局管理器对象，并使组件自动左对齐*/
		String[] s={"文本标签","文字在图形左边","文字在图形下方"};       //字符类型的数组
		/*使用图像类创建一个数组对象，其中ImageIcon(getClass().getResource("image.jpg"))用于生成一个图像对象，
		 * getClass().getResource("image.jpg")用于获取照片 */
		ImageIcon[] ic={null,new ImageIcon(getClass().getResource("image.jpg")),new ImageIcon(getClass().getResource("image1.jpg"))};
		//常量JLabel.LEFT,JLabel.CENTER和JLabel.BOTTOM代表不同的对齐方式
		int[] ih={0,JLabel.LEFT,JLabel.CENTER};
		int[] iv={0,JLabel.CENTER,JLabel.BOTTOM};
		for(int i=0;i<3;i++){
			/*JLabel的构造方法JLabel(String text,Icon icon,int horizontalAlignment)可创建具有指定文本、图像
			 * 和水平对齐的JLabel实例。该标签在其显示区内垂直居中对齐。文本位于图像的尾部。Text是标签中显示的文本，icon是
			 * 标签中显示的图像。horizontalAlignment可以取LEFT、CENTER、RIGHT、LENADING或TRAILINＧ等常量*/
			JLabel label=new JLabel(s[i],ic[i],JLabel.LEFT);
			if(i>0){
				/*设置组件标签的文字于图标之间在水平方向上的相对位置关系，使文字分别位于图标的左侧、右侧和中间*/
				label.setHorizontalTextPosition(ih[i]);
				label.setVerticalTextPosition(iv[i]);
				/*设置组件标签于图标在垂直方向上的相对位置关系，包括JLabel.TOP、JLabel.Center和JLabel.BOTTOM 3种方式*/
			}
			label.setToolTipText("第"+(i+1)+"个标签");    //设置当鼠标在标签上停留时出现的提示信息
			c.add(label);  //把组件添加到当前容器中
			/*Container类的add(Component comp)方法用于在容器中添加组件，comp指定需要添加的组件*/
		}//for循环结束
		
	}
	public static void main(String args[]){
		JFrameLabel app=new JFrameLabel();
		app.setSize(600,300);  //设置窗口的大小，包括宽度和高度
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //设置单机窗口“关闭”按钮时关闭应用程序
		app.setVisible(true);   //设置窗口是否可见，为true时可见，否则不可见
	}
	

}
