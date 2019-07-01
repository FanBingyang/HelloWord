package demo;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Help extends JFrame{
	public Help(){
		super("系统使用说明");
		String [] s={"① 登录管理：本系统为商场信息管理系统，具有一定的保密性，必须先\n","　 登录才能使用本系统。登录之后进入系统的主界面，在主界面可以选\n" ,
	            "　 择用户想要执行的功能模块。\n" ,
	            "② 商品信息录入：在维护本系统时，要不断更新系统的数据。其中商品\n" ,
	            "　 的信息是在不断增加的，当新进商品时，要保证商品信息的同步更新\n" ,
	            "　 。本模块可录入保存新进商品的信息。\n" ,
	            "③ 商品信息查询：可以查询商品的详细信息，以及库存情况、进货渠道\n" ,
	            "　 等。\n" ,
	            "④ VIP信息管理：VIP用户信息、消费情况信息查询管理。\n" ,
	            "⑤ VIP购物登记：当VIP购物时，要对其所购物品进行登记，以便以后对\n", 
	            "　 其进行统计。\n" ,
	            "⑥ 人事管理系统：本模块负责管理商场中的所有工作人员。"};
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		JTextArea textArea=new JTextArea();
		for(int i=0;i<s.length;i++)       //通过循环把说明书内容添加到文本框内
			textArea.append(s[i]);
		textArea.setEditable(false);
		textArea.setFont(new Font("宋体",Font.PLAIN,25));
		JScrollPane sp=new JScrollPane(textArea);
		c.add(textArea);
		c.add(sp);
		this.setLocation(500,500);
		this.setSize(820, 420);
		this.setResizable(false);
		this.setVisible(true);
	}


}
