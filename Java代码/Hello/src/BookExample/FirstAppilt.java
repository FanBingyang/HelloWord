package BookExample;
/*功能简介：Applet小应用程序*/

import javax.swing.JApplet;
import java.awt.Color;
import java.awt.Graphics;
public class FirstAppilt extends JApplet
{
		//重载父类JApplet中的paint（）方法
		public void paint(Graphics g)
		{
			g.setColor(Color.red);        //设置字符串颜色
			g.drawString("Applet小应用程序",60,60);      //在页面上指定位置显示字符串
		}//paint方法结束
}//类FirstAppilt结束
