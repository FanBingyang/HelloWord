package ShiYan_2;


import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class MyBrowser extends JFrame implements ActionListener,HyperlinkListener
{
   private JPanel jp = new JPanel();
   private JEditorPane editorpane = new JEditorPane();
   private JTextField textfield = new JTextField();
   private JButton button = new JButton("转到");
   private JScrollPane scrollpane = new JScrollPane(editorpane);
   public MyBrowser()
   {
   	editorpane.setEditable(false);
   	jp.setLayout(null);
   	textfield.setBounds(10, 10, 500, 26);
   	scrollpane.setBounds(5, 40, 1000, 800);
   	button.setBounds(520, 10,80, 26);
   	jp.add(textfield);
   	jp.add(button);
   	jp.add(scrollpane);
   	button.addActionListener(this);
   	textfield.addActionListener(this);
   	editorpane.addHyperlinkListener(this);
   	this.add(jp);
   	this.setTitle("简易浏览器");
   	this.setBounds(100, 100, 1000, 900);
   	this.setVisible(true);
   	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   public void actionPerformed(ActionEvent a)
   {
   	String url = textfield.getText().trim();
   	try
   	{
   		editorpane.setPage(url);
   	}
   	catch(IOException e)
   	{
//   		this.errorMsg();
   		e.printStackTrace();
   	}
   }
   public void hyperlinkUpdate(HyperlinkEvent e)
   {
   	try
   	{
   		if(e.getEventType()==HyperlinkEvent.EventType.ACTIVATED)
   		{
   			editorpane.setPage(e.getURL());
   		}
   	}
   	catch(IOException ioe)
   	{
//   		this.errorMsg();
   		ioe.printStackTrace();
   	}
   }
//   private void errorMsg()
//   {
//   	try
//   	{
   			//没有输入地址默认打开该文件
//   		File file = new File ("G:\\代码仓库\\HTML\\HelloHtml\\WebShiYan\\third_1.html");
//   		editorpane.setPage(file.toURI().toURL());
//   	}
//   	catch(IOException ioe)
//   	{
//   		ioe.printStackTrace();
//   	}
//   }
   public static void main(String args[])
   {
   	new MyBrowser();
   }
}
