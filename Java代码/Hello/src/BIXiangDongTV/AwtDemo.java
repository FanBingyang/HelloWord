package BIXiangDongTV;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

public class AwtDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame f = new Frame("my awt");
		f.setVisible(true);
		f.setSize(300, 500);
		f.setLocation(200, 200);
		f.setLayout(new FlowLayout());
		
		Button b =new Button("°´Å¥");
		f.add(b);
		
		System.out.println("Hello World!");
	}

}
